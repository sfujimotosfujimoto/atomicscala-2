/*  / sfujimoto: 2017/07/03 14:45 */
import com.atomicscala.AtomicTest._

object Ex67 extends App {
//  def f(i:Int):Either[String,Int] =
//    if(i == 0)
//      Left("Divide by zero")
//    else
//      Right(24/i)
//
//  def test(n:Int) =
//    f(n) match {
//      case Left(why) => s"Failed: $why"
//      case Right(result) => result
//    }
//
//  test(4) is 6
//  test(5) is 4
//  test(6) is 4
//  test(0) is "Failed: Divide by zero"
//  test(24) is 1
//  test(25) is 0


  //// 2
  class Cell {
    var entry = ' '
    def set(e:Char) = {
      if(entry==' ' && (e=='X' || e=='O')) {
        entry = e
        Right("successful move")
      } else
        Left("invalid move")
    }
  }

  class Grid {
    val cells = Vector(
      Vector(new Cell, new Cell, new Cell),
      Vector(new Cell, new Cell, new Cell),
      Vector(new Cell, new Cell, new Cell)
    )
    def play(e:Char, x:Int, y:Int) = {
      if(x < 0 || x > 2 || y < 0 || y > 2)
        Left("invalid move")
      else
        cells(x)(y).set(e)
    }
  }

  val grid = new Grid
  grid.play('X', 1, 1) is Right("successful move")
  grid.play('X', 1, 1) is Left("invalid move")
  grid.play('O', 1, 3) is Left("invalid move")


  //// 3
  val letters = 'a' to 'z' map {
    case 'a' => Left('a')
    case 'e' => Left('e')
    case 'i' => Left('i')
    case 'o' => Left('o')
    case 'u' => Left('u')
    case x => Right(x)
  }


  letters is "Vector(Left(a), Right(b), " +
    "Right(c), Right(d), Left(e), Right(f), " +
    "Right(g), Right(h), Left(i), Right(j), " +
    "Right(k), Right(l), Right(m), Right(n), " +
    "Left(o), Right(p), Right(q), Right(r), " +
    "Right(s), Right(t), Left(u), Right(v), " +
    "Right(w), Right(x), Right(y), Right(z))"

  //// 4

  val ls = letters map {
    case Right(x) => s"Consonant: $x"
    case Left(x) => s"Vowel: $x"
  }

  def testLetters(i: Int) = ls(i)


  testLetters(0) is "Vowel: a"
  testLetters(4) is "Vowel: e"
  testLetters(13) is "Consonant: n"
}

