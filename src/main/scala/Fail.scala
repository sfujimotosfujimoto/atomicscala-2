/*  / sfujimoto: 2017/07/03 19:16 */
import com.atomicscala.reporterr.FailMsg

object Faill extends App {
  try {
    throw new FailMsg("Caught in try block")
  } catch {
    case e:FailMsg => println(e.msg)
  }

  throw new FailMsg("Uncaught")
  println("Beyond uncaught")
}
