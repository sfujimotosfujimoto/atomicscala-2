/*  / sfujimoto: 2017/07/03 17:48 */
import com.atomicscala.AtomicTest._
import util.{Try, Success}


object ContainerOfOne extends App {
  Try("1".toInt).map(_ + 1) is Success(2)
  Try("1".toInt).map(_ + 1).foreach(println)
  Try("x".toInt).map(_ + 1).foreach(println)

}
