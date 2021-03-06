//
// Autogenerated by Thrift Compiler (0.8.0)
//
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
//

LoginError = function(args) {
  this.msg = null;
  if (args) {
    if (args.msg !== undefined) {
      this.msg = args.msg;
    }
  }
};
Thrift.inherits(LoginError, Thrift.TException);
LoginError.prototype.name = 'LoginError';
LoginError.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.STRING) {
        this.msg = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 0:
        input.skip(ftype);
        break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

LoginError.prototype.write = function(output) {
  output.writeStructBegin('LoginError');
  if (this.msg) {
    output.writeFieldBegin('msg', Thrift.Type.STRING, 1);
    output.writeString(this.msg);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

