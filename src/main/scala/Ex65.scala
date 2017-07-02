/*  / sfujimoto: 2017/07/02 23:40 */
import com.atomicscala.AtomicTest._
object Ex65 extends App {
  def solution1 =
    try {
      throw new Exception("solution1")
    } catch {
      case err:Exception => s"Error is : ${err.getMessage}"
    }
  solution1 is "Error is : solution1"

 class Exercise2 {
   def f(i:Int):String = s"The String is $i"
 }

  var ex2:Exercise2 = null

  def solution2 =
    try {
      ex2.f(12)

    } catch {
      case err:NullPointerException => "Throws null pointer exception"
    }

  println(solution2)

  //// 3
  val vec = Vector(1, 4, 12, 99, 23)

  val solution3 =
    try {
      vec(9)
    } catch {
      case e:Exception => s"${e}"
    }
  println(solution3)


  /// 4
  class ExceptionSub(s:String) extends Exception(s)

  val solution4 =
    try {
      throw new ExceptionSub("Out of bounds!!!")
    } catch {
      case e:ExceptionSub => s"${e.getMessage}"
    }
  println(solution4)

  /// 5
  class Ex1(msg:String) extends Exception(msg)
  class Ex2(msg:String) extends Exception(msg)
  class Ex3(msg:String) extends Exception(msg)

  def throwall(n:Int) = n match {
    case 1 => throw new Ex1("number 1")
    case 2 => throw new Ex2("number 2")
    case 3 => throw new Ex3("number 3")
    case _ => "nothing"
  }

  def catchall(n:Int) =
    try {
      throwall(n)
    } catch {
      case e:Ex1 => "Ex1"
      case e:Ex2 => "Ex2"
      case e:Ex3 => "Ex3"
    }
  catchall(0) is "nothing"
  catchall(1) is "Ex1"
  catchall(2) is "Ex2"
  catchall(3) is "Ex3"






}
