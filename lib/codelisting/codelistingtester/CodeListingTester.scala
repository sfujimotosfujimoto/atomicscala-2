package codelisting.codelistingtester

/* codelisting.codelistingtester / sfujimoto: 2017/07/03 12:50 */

import com.atomicscala.AtomicTest._

class CodeListingTester(
                         makeList:String => IndexedSeq[String]) {

  makeList("CodeListingTester.scala")(4) is
    "class CodeListingTester("

  makeList("NotAFile.scala")(0) is
    "File Not Found: NotAFile.scala"

  makeList("NotAScalaFile.txt")(0) is
    "NotAScalaFile.txt " +
      "doesn't end with '.scala'"

  makeList(null)(0) is
    "Error: Null file name"

}
