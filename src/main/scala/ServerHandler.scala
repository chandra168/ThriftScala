import org.apache.thrift.TSerializer
import org.apache.thrift.TDeserializer

import java.io.FileNotFoundException
import java.io.IOException
import java.io.File
import java.io.FileOutputStream


class ProfileServiceImpl extends ProfileService.Iface {

  private val prefix = "ProfileDB/"

  private def userExists (uid: String): Boolean = (new File (prefix + uid).exists ())

  private def getUser (uid: String) : Option[Profile] = {
    try {
       val source = scala.io.Source.fromFile (uid)
       val bytearray = source.map (_.toByte).toArray
       source.close ()

       // by default uses a binary protocol
       var deserializer = new TDeserializer ()
       var user = new Profile
       deserializer.deserialize (user, bytearray)
       Some (user)
    }
    catch {
       case ex: FileNotFoundException => None
       case ex: IOException => None
    }
  }

  private def deleteUser (uid: String) : Boolean = {
    try {
      val file = new File (prefix + uid)
      file.delete ()
      true
    }
    catch {
       case ex: FileNotFoundException => false
       case ex: IOException => false
    }
  }

  private def putUser (user: Profile) : Boolean = {

      var sbarr = (new TSerializer ()).serialize (user)

      // Write out to a file
      val out = new FileOutputStream (new File (prefix + user.uid))
      out.getChannel ().truncate (0)
      out.getChannel ().force (true)
      out.write (sbarr)
      out.close ()
      true
  }


  def createUser (user: Profile): Boolean = {
    println ("CreateUser")

    /* Check if file exists, otherwise serialize and create it ATOMICALLY */
    if ((new File (prefix + user.uid)).createNewFile ()) {
      // File creation successfull, user does not exist yet
      this.putUser (user)
    }
    else {
      // File already exists
      false
    }
  }

  /* TODO : Change return type for failure */
  def login (uid: String, password: String): Profile = {
     println ("Login")

     getUser (uid) match {
       case Some (user) => user
       case None => new Profile
     }
  }


  def modify (user: Profile): Boolean = {
    println ("Modify")

    getUser (user.uid) match {
      case Some (userdb) => putUser (user)
      case None => false
    }
  }
  
  def remove (user: Profile): Boolean = {
    println ("Remove")

    getUser (user.uid) match {
      case Some(userdb) if userdb.password == user.password => deleteUser (user.uid)
      case None => false
    }
  }
}
