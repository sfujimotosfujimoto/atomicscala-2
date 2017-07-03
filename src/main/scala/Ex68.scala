/*  / sfujimoto: 2017/07/03 17:14 */
import com.atomicscala.AtomicTest._

object Ex68 extends App {
  def f(i:Int):Option[Int] =
    if(i == 0)
      None
    else
      Some(24/i)

  def test(n:Int) =
    f(n) match {
      case None => "Failed"
      case Some(result) => result
    }




  f(4) is Some(6)
  f(5) is Some(4)
  f(6) is Some(4)
  f(0) is None
  f(24) is Some(1)
  f(25) is Some(0)


  //// 3
  class Cell {
    var entry = ' '
    def set(e:Char):Option[String] = {
      if(entry==' ' && (e=='X' || e=='O')) {
        entry = e
        Some("successful move")
      } else
        None
    }
  }

  class Grid {
    val cells = Vector(
      Vector(new Cell, new Cell, new Cell),
      Vector(new Cell, new Cell, new Cell),
      Vector(new Cell, new Cell, new Cell)
    )
    def play(e:Char, x:Int, y:Int):Option[String] = {
      if(x < 0 || x > 2 || y < 0 || y > 2)
        None
      else
        cells(x)(y).set(e)
    }
  }

  //// 4
  def alphanumeric(a:Any):Option[Any] =
    a match {
      case c:Char if(c >= 'a' && c <= 'z') => Some(c)
      case c:Char if(c >= 'A' && c <= 'Z') => Some(c)
      case i:Int => Some(i)
      case _ => None
    }


  alphanumeric(0) is Some(0)
  alphanumeric('a') is Some('a')
  alphanumeric('m') is Some('m')
  alphanumeric('$') is None
  alphanumeric('Z') is Some('Z')




}
