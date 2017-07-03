/*  / sfujimoto: 2017/07/03 17:43 */
import util.Try
object PigInt extends App {
  val result = Try("pig".toInt)

  assert(result.toString.startsWith("Failure"))
  assert((try {
    result.get
  } catch {
    case _:Throwable => "Yep, an exception"
  }) == "Yep, an exception")
}
