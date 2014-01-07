import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;



object Server {

  def main (args: Array[String]) {

    /* XXX : Not sure if val or var should be passed in Java */
    var serverHandler = new ProfileServiceImpl ()
    var processor = new ProfileService.Processor (serverHandler)

    var serverTransport = new TServerSocket (9090);
    var server = new TSimpleServer (new Args (serverTransport).processor (processor))

    println ("Starting simple server on port 9090");

    server.serve ()
  }
}
