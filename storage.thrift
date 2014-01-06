include "user.thrift"

/* Using Thrift file io as a rudimentary db */
service UserStorage {
  void store (1: user.Profile user),
  user.Profile retrieve (1: string uid),
  bool exists (1: string uid)
}
