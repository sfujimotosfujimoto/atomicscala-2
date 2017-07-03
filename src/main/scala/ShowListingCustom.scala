/*  / sfujimoto: 2017/07/03 21:57 */
import codelistingcustom._
import codelistingtester._


object ShowListingCustom extends App {
  def listing(name:String) =
    CodeListingCustom(name).recover {
      case e => Vector(e.toString)
    }.get

  new CodeListingTester(listing)
}
