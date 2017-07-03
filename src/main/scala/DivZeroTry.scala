/*  / sfujimoto: 2017/07/03 17:23 */
import com.atomicscala.AtomicTest._
import util.{Try, Success, Failure}

object DivZeroTry extends App {
  def f(i:Int) = Try( 24 / i )

  f(24) is Success(1)
  f(0) is "Failure(java.lang.ArithmeticException: / by zero)"

  def test(n:Int) =
    f(n) match {
      case Success(r) => r
      case Failure(e) => s"Failed: ${e.getMessage}"
    }

  test(4) is 6
  test(0) is "Failed: / by zero"

}
