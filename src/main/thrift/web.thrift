include "user.thrift"

service ProfileService {
  bool createUser (1: user.Profile user),
  user.Profile login (1: string uid, 2: string password),
  bool modify (1: user.Profile user),
  bool remove (1: user.Profile user)
}



