package codelistingcustom

/* codelistingcustom / sfujimoto: 2017/07/03 21:54 */
import codelisting._
import java.io.FileNotFoundException
import util.Success
import com.atomicscala.reporterr.Fail

object CodeListingCustom extends App {
  def apply(name:String) =
    try {
      Success(new CodeListing(name))
    } catch {
      case _:FileNotFoundException => Fail(s"File Not Found: $name")
      case _:NullPointerException => Fail("Error: Null file name")
      case e:ExtensionException => Fail(e.getMessage)
    }
}
