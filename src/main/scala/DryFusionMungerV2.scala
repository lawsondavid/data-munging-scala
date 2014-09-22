import scala.io.Source

/**
 * Home - Created by dave on 21/09/14.
 */
private case class Result(key: String, low: Double, high: Double)

object DryFusionMungerV2 {

  def munge(path: String): (String, Double) = {

    def minResult(lines: List[String]): (String, Double) = {
      val min = lines.filter(_.matches("^\\s+\\d+.*$"))
        .map(processLine)
        .minBy(result => result.high - result.low)
      (min.key, min.high - min.low)
    }

    processLines(path, minResult)
  }

  def processLines(filePath: String, operation: (List[String]) => (String, Double)): (String, Double) = {
    val lines = Source.fromURL(getClass.getResource(filePath)).getLines().toList
    operation(lines)
  }

  def processLine(line: String): Result = {
    val splitLine = line.split("\\s+")
    Result(splitLine(2), splitLine(9).toDouble, splitLine(7).toDouble)
  }
}
