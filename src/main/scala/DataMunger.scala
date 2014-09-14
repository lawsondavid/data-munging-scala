import scala.io.Source

class DataMunger {
  def readData(path: String): String = {
    val lines = Source.fromURL(getClass.getResource(path)).getLines().toList.drop(2).reverse.drop(1).reverse
    val dailyAverages = lines.map((line: String) => average(line.split("\\s+").slice(1, 4)))
    dailyAverages.fold(("-1", Double.MaxValue))((a, b) => if (a._2 < b._2) a else b)._1
  }

  private def average(highAndLow: Array[String]): (String, Double) = {
    val day = highAndLow(0)
    val highValue = highAndLow(1).replaceAll("\\*", "").toInt
    val lowValue = highAndLow(2).replaceAll("\\*", "").toInt
    Tuple2(day, highValue - lowValue)
  }
}