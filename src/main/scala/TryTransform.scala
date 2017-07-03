/*  / sfujimoto: 2017/07/03 18:25 */
import com.atomicscala.AtomicTest._
import util.Try
import errors.Errors._

object TryTransform extends App {
  def f(n:Int) = Try(toss(n)).transform(
    i => Try(s"$i Bob"), // for Success
    e => e match { // for Failure
      case Except1(why) => Try(why)
      case Except2(n) => Try(n)
      case Except3(msg, d) => Try(d)
    }
  ).get
}
