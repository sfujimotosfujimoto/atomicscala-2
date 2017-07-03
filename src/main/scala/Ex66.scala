/*  / sfujimoto: 2017/07/03 12:57 */
import com.atomicscala.AtomicTest._
import codelisting._


object Ex66 extends App {
  class CodeListingTester1(makeList:String => IndexedSeq[String]) {
    val l = makeList("CodeListingTester.scala")
    for(i <- l)
      println(i)
  }

  new CodeListingTester1(CodeListing.apply)
}

