var transport = new Thrift.Transport("http://localhost:9090/");
var protocol  = new Thrift.Protocol(transport);
var client    = new ThriftTest.ThriftTestClient(protocol);



function create_user (/* TODO: Args */) {

  var user = new Profile ();
  user.uid      = "nimishgupta";
  user.name     = "Nimish";
  user.password = "Nimish";
  user.email    = "nimish@cs.umass.edu";

  try {
    result = client.createUser (user);

    if (result) {
      alert ("User Created");
    }
  } catch (e) {
    alert (e.why);
  }
}
