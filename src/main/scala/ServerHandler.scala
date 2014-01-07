class ProfileServiceImpl extends ProfileService.Iface {

  def createUser (user: Profile): Boolean = true

  def login (uid: String, password: String): Profile = {

     new Profile
  }

  def modify (user: Profile): Boolean = true
  
  def remove (user: Profile): Boolean = true
}
