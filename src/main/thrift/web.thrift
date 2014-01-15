include "user.thrift"

exception LoginError {
  1: string msg;
}

service ProfileService {
  bool createUser (1: user.Profile user),
  user.Profile login (1: string uid, 2: string password) throws (1: LoginError lerr),
  bool modify (1: user.Profile user),
  bool remove (1: user.Profile user)
}

service CalcService {
  i32 add (1: i32 arg1, 2: i32 arg2)
}
