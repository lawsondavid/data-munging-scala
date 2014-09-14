import scala.io.Source

/**
 * Created by dave on 11/09/14.
 */
class FootballMunger {
  def readData(path: String): String = {
    val lines = Source.fromURL(getClass.getResource(path)).getLines().toList.drop(1)
    val teamResults = lines.collect {case (line) if line.startsWith("") => line.split("\\s+")}
    teamResults.collect {case (x: String) if  => x.split()}
    ""
    //val teamResults = lines.map((line: String) => average( line.split("\\s+").collect {case (x: String, i: Int) if i == 2 || i == 7 || i == 9 => x} ) )
    //teamResults.fold(("-1", Double.MaxValue))((a, b) => if (a._2 < b._2) a else b)._1
  }

  private def average(highAndLow: Array[String]): (String, Double) = {
    val key = highAndLow(0)
    val highValue = highAndLow(1).toInt
    val lowValue = highAndLow(2).toInt
    Tuple2(key, highValue - lowValue)
  }
}
