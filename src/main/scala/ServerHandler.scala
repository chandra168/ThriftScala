class ProfileServiceImpl extends ProfileService.Iface {

  def createUser (user: Profile): Boolean = {
    println ("CreateUser")
    true
  }

  def login (uid: String, password: String): Profile = {
     println ("Login")
     new Profile
  }

  def modify (user: Profile): Boolean = {
    println ("Modify")
    true
  }
  
  def remove (user: Profile): Boolean = {
    println ("Remove")
    true
  }
}
