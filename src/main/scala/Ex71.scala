/*  / sfujimoto: 2017/07/03 22:18 */
import com.atomicscala.AtomicTest._
object Ex71 extends App {
  def convert(s:String) = {
    require(s.forall(_.isLetter), "Only letters are allowed")
    val converted = s.toLowerCase.map(_.asDigit - 'a'.asDigit + 1).reduce(_ + _)
    val lowerBound = s.length * 1
    assume(converted >= lowerBound, "Result should be >= " + lowerBound)
    val upperBound = s.length * ('z'.asDigit + 1)
    assume(converted <= upperBound, "Result should be <= " + upperBound)
    println(converted)
  }
  for(arg <- args)
    try {
      convert(arg)
    } catch {
      case e:Throwable => println(e.getMessage)
    }

  def mul(i:Int) = {
    require((i * 3) % 2 == 0, "The result must be odd")
    val result = i * 3
    val isOdd = result % 2 != 0
    assume(isOdd, "the number must be odd")
    result
  }

  def test(num:Int) = {
    try {
      mul(num)
    } catch {
      case e:Throwable => println(e.getMessage)
    }
  }

  test(3) is 9
  test(2) is "The result must be odd"

}
