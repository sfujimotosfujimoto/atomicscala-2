/*  / sfujimoto: 2017/07/03 15:30 */
import com.atomicscala.AtomicTest._

object OptionOperation extends App {
  def p(s:Option[String]) = s.foreach(println)
  p(Some("Hi"))
  p(Option("Hi"))
  p(None)

  def f(s:Option[String]) = s.map(_ * 2)

  f(Some("Hi")) is Some("HiHi")
  f(None) is None

  Option(null) is None
}
