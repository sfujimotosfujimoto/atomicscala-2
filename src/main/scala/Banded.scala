/*  / sfujimoto: 2017/07/03 15:17 */
import com.atomicscala.AtomicTest._

object Banded extends App {
  def banded(input:Double) =
    if(input > 1.0 || input < 0.0)
      Left("Nothing")
    else
      Right(math.round(input * 100.0))

  banded(0.555) is Right(56)
  banded(-0.1) is Left("Nothing")
  banded(1.1) is Left("Nothing")


}
