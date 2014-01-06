struct UserProfile {
  1: string uid;
  2: string name;
  3: string password;
  4: string email;
}
  

service ProfileService {
  bool createUser (1: UserProfile user),
  UserProfile login (1: string uid, 2: string password),
  bool modify (1: UserProfile user),
  bool remove (1: UserProfile user)
}



  
