import spray.json._
import DefaultJsonProtocol._

def showBasics =
  val source = """{ "some": "JSON source" }"""

  val jsonAst = source.parseJson
  println(jsonAst)

  val json = jsonAst.prettyPrint
  println(json)

  println(List(1, 2, 3).toJson)

def showJsonFormat =
  case class Color(name: String, red: Int, green: Int, blue: Int)
  object MyJsonProtocol extends DefaultJsonProtocol {
    implicit val colorFormat: JsonFormat[Color] = jsonFormat4(Color.apply)
  }
  
  import MyJsonProtocol._
  import spray.json._
  
  val json = Color("CadetBlue", 95, 158, 160).toJson
  val color = json.convertTo[Color]
  println(color)

@main
def main =
  showBasics
  showJsonFormat
