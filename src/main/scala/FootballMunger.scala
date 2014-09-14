import scala.io.Source

/**
 * Created by dave on 11/09/14.
 */
class FootballMunger {
  def readData(path: String): String = {
    val lines = Source.fromURL(getClass.getResource(path)).getLines().toList.drop(1)
    val splitLines = lines.filter(!_.matches("^\\s+-*")).map(_.split("\\s+"))
    val averages = splitLines.map(x => average(Array(x(2), x(7), x(9))))
    averages.fold(("no team", Double.MaxValue))((a, b) => if (a._2 < b._2) a else b)._1
  }

  private def average(highAndLow: Array[String]): (String, Double) = {
    val key = highAndLow(0)
    val highValue = highAndLow(1).toInt
    val lowValue = highAndLow(2).toInt
    Tuple2(key, highValue - lowValue)
  }
}
