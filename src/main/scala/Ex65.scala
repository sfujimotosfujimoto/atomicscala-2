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

  /// 6

  class ExceptionSub2 extends Exception
  class ExceptionSub3 extends Exception
  class Ex6 {
    def f = {
      try {
        g
      } catch {
        case e:ExceptionSub2 => throw new ExceptionSub3
      }
    }
    def g = throw new ExceptionSub2

    def t1 = try {
      (new Ex6).g
    } catch {
      case e:ExceptionSub2 => "Ex2"
    }
    def t2 = try {
      (new Ex6).f
    } catch {
      case e:ExceptionSub3 => "Ex3"
    }
  }
  val ex6 = new Ex6
  ex6.t1 is "Ex2"
  ex6.t2 is "Ex3"


  //// 7
  class Ex7 extends Exception

  class Base1 {
    println("Base1 constructor")
    throw new Ex7
  }

  class Derived1 extends Base1 {
    // Base 1 constructor is called first, so the following never runs
    // no opportunity to catch the base-constructor exception
    try {
      println("Where do you put the try block?")
    } catch {
      case e:Ex7 => println("Caught Ex7")
    }

  }

  def t3 = try {
    new Derived1
  } catch {
    case e:Ex7 => "Ex7 caught in t3"
  }

  t3 is "Ex7 caught in t3"


  //// 8
  class FailingConstructor(fail:Boolean = false) {
    var result = "uninitialized"
    if(fail) throw new IllegalStateException else result = "success"
  }

  def test8(fail:Boolean) = (new FailingConstructor(fail)).result

  def f8(fail:Boolean) = try {
    test8(fail)
  } catch {
    case e:IllegalStateException => "failed"
  }

  f8(true) is "failed"
  f8(false) is "success"

  def test8_2(fail:Boolean) = try {
    val fc = new FailingConstructor(fail)
    fc.result
  } catch {
    case e:IllegalStateException => "fail"
  }

  test8_2(true) is "fail"
  test8_2(false) is "success"

//  def test8_3(fail:Boolean) = {
//    val fc = try {
//      new FailingConstructor(fail)
//    } catch {
//      case e:IllegalStateException => new FailingConstructor(false)
//    }
//  }
//
//  test8_3(false) is "success"
//  test8_3(true) is "success"
  class Ex9_1 extends Exception
  class Ex9_2 extends Ex9_1
  class Ex9_3 extends Ex9_2

  class A {
    def f = throw new Ex9_1
  }
  class B extends A {
    override def f = throw new Ex9_2
  }

  class C extends B {
    override def f = throw new Ex9_3

  }

  def test9_1 = try {
    val a:A = new C
    a.f
  } catch {
    case e:Exception => e.getClass().getSimpleName()
  }

  test9_1 is "Ex9_3"


  //// 10
  def thrower(throwing:Boolean) = if(throwing) throw new Exception

  def withCatch(throwing:Boolean) = {
    println("+++++++++++++++++")
    println("throwing: " + throwing)
    try {
      thrower(throwing)
    } catch {
      case e:Exception => println("caught Exception")
    } finally {
      println("Inside withCatch finally")
    }
  }

  withCatch(false)
  withCatch(true)

  def withoutCatch(throwing:Boolean) = {
    println("--------------------")
    println("throwing: " + throwing)
    try {
      thrower(throwing)
    } finally {
      println("Inside withoutCatch finally")
    }
  }

  withoutCatch(false)
  try {
    withoutCatch(true)
  } catch {
    case e:Exception => println("withoutCatch exception caught")
  }






}
