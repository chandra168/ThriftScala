import scala.concurrent.duration._
import akka.pattern.ask
import akka.util.Timeout
import akka.actor._
import spray.can.Http
import spray.util._
import spray.http._
import HttpMethods._

import org.apache.thrift.transport.TMemoryBuffer
import org.apache.thrift.protocol.TJSONProtocol


class ThriftService extends Actor {

  implicit val timeout: Timeout = 1.second // for the actor 'asks'
  import context.dispatcher // ExecutionContext for the futures and scheduler

  private def thriftRequest (input: Array[Byte]): String = { 
    try {

      //Input
      var inbuffer = new TMemoryBuffer (input.length)
      inbuffer.write (input)
      var inprotocol = new TJSONProtocol (inbuffer)

      //Output
      var outbuffer = new TMemoryBuffer (100);
      var outprotocol = new TJSONProtocol (outbuffer);

      var processor = new ProfileService.Processor(new ProfileServiceImpl ())
      processor.process (inprotocol, outprotocol)

      val output = new Array[Byte] (outbuffer.length)
      outbuffer.readAll (output, 0, output.length)

      new String (output, "UTF-8")

    } catch {
        case ex: Exception  => "Error:"+ ex.getMessage ()
      }
  }

  def receive = {

    // When a new connection comes in we register ourselves as the connection handler
    case _:Http.Connected => sender ! Http.Register (self)

    case HttpRequest (POST, Uri.Path ("/"), headers, entity: HttpEntity.NonEmpty, protocol) =>
      val ip = entity.asString
      sender ! HttpResponse (entity = thriftRequest (ip.getBytes))

      
  

    case _:HttpRequest => sender ! HttpResponse (status = 404, entity = "Unknonw resource!")
  }
}
