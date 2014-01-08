import org.apache.thrift.TSerializer
import org.apache.thrift.TDeserializer

import java.io.FileNotFoundException
import java.io.IOException
import java.io.File
import java.io.FileOutputStream


class ProfileServiceImpl extends ProfileService.Iface {

  private val prefix = "ProfileDB/"

  private def userExists (uid: String): Boolean = false

  def createUser (user: Profile): Boolean = {
    println ("CreateUser")

    /* Check if file exists, otherwise serialize and create it */
    if ((new File (prefix + user.uid)).createNewFile ()) {
      // File creation successfull, user does not exist yet

      var sbarr = (new TSerializer ()).serialize (user)

      // Write out to a file
      val fos = new FileOutputStream (new File (prefix + user.uid))
      // IOUtils.write (sbarr, fos)
      fos.write (sbarr)
      fos.close ()

      true
    }
    else {
      // File already exists
      false
    }
  }

  /* TODO : Change return type for failure */
  def login (uid: String, password: String): Profile = {
     println ("Login")

     try {
       val source = scala.io.Source.fromFile (uid)
       val bytearray = source.map (_.toByte).toArray
       source.close ()

       // by default uses a binary protocol
       var deserializer = new TDeserializer ()
       var user = new Profile
       deserializer.deserialize (user, bytearray)
       user
     } catch {
       case ex: FileNotFoundException => new Profile
       case ex: IOException => new Profile
     }
  }


  def modify (user: Profile): Boolean = {
    println ("Modify")
    try
    {
      scala.io.Source.fromFile (user.uid)

      true
    }
    catch
    {
      case ex:FileNotFoundException => 
        false
    }
  }
  
  def remove (user: Profile): Boolean = {
    println ("Remove")
    true
  }
}
