/*  / sfujimoto: 2017/07/03 17:27 */
import com.atomicscala.AtomicTest._
import util.{Try, Success, Failure}
import errors.Errors._
object Tri extends App {
  def f(n:Int) = Try(toss(n)) match {
    case Success(r) => r
    case Failure(e) => e match {
      case Except1(why) => s"Except1 $why"
      case Except2(n) => s"Except2 $n"
      case Except3(msg, d) => s"Except3 $msg $d"
    }
  }
  f(0) is "OK"
  f(1) is "Except1 Reason"
  f(2) is "Except2 11"
  f(3) is "Except3 Wanted: 1.618"

}
