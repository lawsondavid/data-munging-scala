import scala.io.Source

class DryFusionMunger(keyColumn: Int, highColumn: Int, lowColumn: Int, validRowMatch: String) {
  private val COLUMN_SEPARATOR = "\\s+"

  def readData(path: String): String = {
    val lines = Source.fromURL(getClass.getResource(path)).getLines().toList
    val splitLines = lines.filter(_.matches(validRowMatch)).map(_.split(COLUMN_SEPARATOR))
    val averages = splitLines.map(x => (x(keyColumn), x(highColumn).replace("*", "").toDouble - x(lowColumn).replace("*", "").toDouble))
    averages.fold(("no key", Double.MaxValue))((a, b) => if (a._2 < b._2) a else b)._1
  }
}
