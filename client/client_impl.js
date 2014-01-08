var transport = new Thrift.Transport("/");
var protocol  = new Thrift.Protocol(transport);
var client    = new ProfileServiceClient(protocol);


function login_user () {

  var username = document.getElementById ("login_username").value;
  var password = document.getElementById ("login_password").value;

  try {
    var result = client.login (username.trim (), password.trim());
    alert ("Login call completed successfully");
  } catch (e) {
    alert ("Problem completing login call");
  }

  return false;
}

    
function create_user () {

  var user = new Profile ();
  user.uid      = "nimishgupta";
  user.name     = "Nimish";
  user.password = "Nimish";
  user.email    = "nimish@cs.umass.edu";

  try {
    var result = client.createUser (user);

    if (result) {
      alert ("User Created");
    }
  } catch (e) {
    alert (e.why);
  }

  return false;
}
