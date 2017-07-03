/*  / sfujimoto: 2017/07/03 13:18 */
import codelisting.codelistingtester.CodeListingTester
import codelistingeither._
object ShowListingEither extends App {
  def listing(name:String) = {
    CodeListingEither(name) match {
      case Right(lines) => lines
      case Left(error) => Vector(error)
    }
  }
  new CodeListingTester(listing)
}
