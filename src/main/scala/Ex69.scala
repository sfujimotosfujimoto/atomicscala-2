/*  / sfujimoto: 2017/07/03 18:59 */
import com.atomicscala.AtomicTest._
import errors.Errors.{Except1, Except2, Except3, toss}

import scala.util.{Try, Success, Failure}

object Ex69 extends App {
  def f(n:Int) = Try(toss(n)).transform(
    i => Try(s"$i Bob"), // for Success
    e => e match { // for Failure
      case Except1(why) => Try(why)
      case Except2(n) => Try(n)
      case Except3(msg, d) => Try(d)
    }
  )

  f(0) is Success("OK Bob")
  f(1) is Success("Reason")
  f(2) is Success(11)
  f(3) is Success(1.618)
}
