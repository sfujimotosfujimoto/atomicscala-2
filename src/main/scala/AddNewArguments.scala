/*  / sfujimoto: 2017/07/03 17:11 */

object AddNewArguments {
  case class Art(title:String, artist:String, style:Option[String] = None)
  val oldCall = Art("Guernica", "Picasso")
  val newCall = Art("Soup Cans", "Warhol", Option("Pop"))
}
