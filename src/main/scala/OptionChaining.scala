/*  / sfujimoto: 2017/07/03 15:32 */
import com.atomicscala.AtomicTest._


object OptionChaining extends App {
  def f(n:Int, div:Int) =
    if(n < div || div == 0)
      None
    else
      Some (n/div)

  f(0,0) is None
  f(0,0).foreach(println)
  f(11,5) is Some(2)
  f(11,5).foreach(println)

  def g(n:Int,div:Int) = f(n, div).map(_ + 2)

  g(5,11) is None
  g(11,5) is Some(4)
}
