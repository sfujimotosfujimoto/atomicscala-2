/*  / sfujimoto: 2017/07/04 21:42 */
import com.atomicscala.AtomicTest._

object Quoting {
  implicit class AnyName(s:String) {
    def singleQuote = s"'$s'"
    def doubleQuote = s"""$s"""

  }
}
import Quoting._

object Test2 extends App {
  "Hi".singleQuote is "'Hi'"
  "Hi".doubleQuote is "\"Hi\""
}
