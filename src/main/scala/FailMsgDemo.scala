/*  / sfujimoto: 2017/07/03 21:32 */
import com.atomicscala.reporterr.FailMsg

object FailMsgDemo extends App {
  try {
    throw new FailMsg("Caught in try block")
  } catch {
    case e:FailMsg => println(e.msg)
  }

  throw new FailMsg("Uncaught")
  println("Beyond uncaught")
}
