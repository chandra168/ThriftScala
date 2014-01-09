var transport = new Thrift.Transport("/");
var protocol  = new Thrift.Protocol(transport);
var client    = new ProfileServiceClient(protocol);

function clear_user () {
  document.getElementById ("detail_username").value = "";
  document.getElementById ("detail_name").value     = "";
  document.getElementById ("detail_password").value = "";
  document.getElementById ("detail_email").value    = "";

}


function get_user () {

  var user = new Profile ();
  user.uid      = document.getElementById ("detail_username").value;
  user.name     = document.getElementById ("detail_name").value;
  user.password = document.getElementById ("detail_password").value;
  user.email    = document.getElementById ("detail_email").value;

  return user;
}


function put_user (user) {
  document.getElementById ("detail_username").value = user.uid;
  document.getElementById ("detail_name").value     = user.name;
  document.getElementById ("detail_password").value = user.password;
  document.getElementById ("detail_email").value    = user.email;
}


function logout_view () {
  clear_user ();

  document.getElementById ("login_prompt_radio").disabled = false;
  document.getElementById ("new_user_radio").disabled = false;

  document.getElementById ("create_button").disabled = false;
  document.getElementById ("modify_button").disabled = true;
  document.getElementById ("delete_button").disabled = true;
  document.getElementById ("logout_button").disabled = true;
}


function login_view () {

  document.getElementById ("login_prompt_radio").disabled = true;
  document.getElementById ("new_user_radio").disabled = true;

  document.getElementById ("create_button").disabled = true;
  document.getElementById ("modify_button").disabled = false;
  document.getElementById ("delete_button").disabled = false;
  document.getElementById ("logout_button").disabled = false;
}


function login_prompt () {
  document.getElementById ("user_div").style.display  = 'none';
  document.getElementById ("login_div").style.display = 'block';
}


function user_prompt () {
  document.getElementById ("login_div").style.display = 'none';
  document.getElementById ("user_div").style.display  = 'block';
}



function login_user () {

  var username = document.getElementById ("login_username").value;
  var password = document.getElementById ("login_password").value;

  try {
    var result = client.login (username.trim (), password.trim());
    put_user (result);
    login_view ();
    user_prompt ();
  } catch (e) {
    alert (e.msg);
  }

  return false;
}


function create_user () {
  try {
    var user = get_user ();
    var result = client.createUser (user);

    if (result) {
      login_view ();
    }
    else {
      alert ("problem creating user");
    }
  } catch (e) {
    alert (e.message);
  }

  return false;
}


function modify_user () {
  try {
    var user = get_user ();
    var result = client.modify (user);
    if (result) {
      alert ("Modify succeeded");
    }
    else {
      alert ("Modify failed");
    }
  }
  catch (e) {
    alert (e.message);
  }
}


function delete_user () {
  try {
    var user = get_user ();
    var result = client.remove (user);
    if (result) {
      logout_view ();
    }
    else {
      alert ("delete failed");
    }
  }
  catch (e) {
    alert (e.message);
  }
}

function logout_user () {
  logout_view ();
  login_prompt ();
}



