/*  / sfujimoto: 2017/07/03 18:32 */
import com.atomicscala.AtomicTest._
import util.control.Exception.catching
import errors.Errors._


object Catching extends App {
  val ct2 = catching(classOf[Except2])

  val ct13 = catching(classOf[Except1], classOf[Except3])

  ct2.toTry(toss(0)) is "OK"
  ct13.toTry(toss(0)) is "OK"
  ct13.toTry(toss(1)) is "Failure(errors.Errors$Except1: Reason)"
  ct13.toTry(toss(3)) is "Failure(errors.Errors$Except3: Wanted: 1.618)"

  (try {
    ct13.toTry(toss(2))
  } catch {
    case e:Throwable => "Except2"
  }) is "Except2"
}
