/*  / sfujimoto: 2017/07/03 22:18 */

object Ex71 {
  def f(i:Int, d:Double) = {
    require(i > 5 && i < 100, "i must be within 5 and 100")
    val result = d * i
    result

  }

  def g(i:Int, d:Double) = {
    val result = d * i
    assume(result < 1000, "result must be less than 1000")
    result
  }

}
