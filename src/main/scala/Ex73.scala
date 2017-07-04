/*  / sfujimoto: 2017/07/04 22:00 */
import com.atomicscala.AtomicTest._



object BookExtension2 {
  implicit class Ops(val book:Book) extends AnyVal {
    def categorize(category:String) =
      s"$book, category: $category"
  }

}

import BookExtension2._

object Test4 extends App {
  Book("Dracula") categorize "Vampire" is "Book(Dracula), category: Vampire"

}