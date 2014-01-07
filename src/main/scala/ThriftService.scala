import scala.concurrent.duration._
import akka.pattern.ask
import akka.util.Timeout
import akka.actor._
import spray.can.Http
import spray.util._
import spray.http._
import HttpMethods._


class ThriftService extends Actor {

  implicit val timeout: Timeout = 1.second // for the actor 'asks'
  import context.dispatcher // ExecutionContext for the futures and scheduler

  def receive = {

    // When a new connection comes in we register ourselves as the connection handler
    case _:Http.Connected => sender ! Http.Register (self)

    case HttpRequest (POST, Uri.Path ("/"), headers, entity: HttpEntity.NonEmpty, protocol) =>
    /* Do Something */
  

    case _:HttpRequest => sender ! HttpResponse (status = 404, entity = "Unknonw resource!")
  }
}
