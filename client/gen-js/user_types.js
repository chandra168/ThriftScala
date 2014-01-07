//
// Autogenerated by Thrift Compiler (0.8.0)
//
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
//

Profile = function(args) {
  this.uid = null;
  this.name = null;
  this.password = null;
  this.email = null;
  if (args) {
    if (args.uid !== undefined) {
      this.uid = args.uid;
    }
    if (args.name !== undefined) {
      this.name = args.name;
    }
    if (args.password !== undefined) {
      this.password = args.password;
    }
    if (args.email !== undefined) {
      this.email = args.email;
    }
  }
};
Profile.prototype = {};
Profile.prototype.read = function(input) {
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
        this.uid = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.STRING) {
        this.name = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 3:
      if (ftype == Thrift.Type.STRING) {
        this.password = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 4:
      if (ftype == Thrift.Type.STRING) {
        this.email = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

Profile.prototype.write = function(output) {
  output.writeStructBegin('Profile');
  if (this.uid) {
    output.writeFieldBegin('uid', Thrift.Type.STRING, 1);
    output.writeString(this.uid);
    output.writeFieldEnd();
  }
  if (this.name) {
    output.writeFieldBegin('name', Thrift.Type.STRING, 2);
    output.writeString(this.name);
    output.writeFieldEnd();
  }
  if (this.password) {
    output.writeFieldBegin('password', Thrift.Type.STRING, 3);
    output.writeString(this.password);
    output.writeFieldEnd();
  }
  if (this.email) {
    output.writeFieldBegin('email', Thrift.Type.STRING, 4);
    output.writeString(this.email);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

