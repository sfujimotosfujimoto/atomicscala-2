/*  / sfujimoto: 2017/07/04 21:54 */
import com.atomicscala.AtomicTest._

case class Book(title:String)



object BookExtension {
  implicit class Ops(book:Book) {
    def categorize(category:String) =
      s"$book, category: $category"
  }
}

import BookExtension._

object Test3 extends App {
  Book("Dracula") categorize "Vampire" is "Book(Dracula), category: Vampire"
}
