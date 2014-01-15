
class CalcServiceImpl extends CalcService.Iface {

  def add (arg1: Int, arg2: Int): Int = {
    println ("CalcServiceImpl")
    arg1 + arg2
  }
}
