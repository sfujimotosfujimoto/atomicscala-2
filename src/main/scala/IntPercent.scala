/*  / sfujimoto: 2017/07/03 18:29 */

import com.atomicscala.AtomicTest._
import util.Try

object IntPercent extends App {
  def intPercent(amount:Int, total:Int) =
    Try(amount * 100 / total).getOrElse(100)

  intPercent(49, 100) is 49
  intPercent(49, 1000) is 4
  intPercent(49, 0) is 100

}
