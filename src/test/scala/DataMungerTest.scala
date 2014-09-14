import org.scalatest.{Matchers, FlatSpec, FunSuite}

/**
 * Created by dave on 08/09/14.
 */
class DataMungerTest extends FlatSpec with Matchers {

  "A DataMunger" should "return nothing when no file" in {
    new DataMunger().readData("weather.dat")
  }

 /* "A DataMunger" should "return daily average temperatures" in {
    val dailyAverages = new DataMunger().readData("weather.dat")
    assert(dailyAverages(0) === 14.5)
    assert(dailyAverages(8) === 27)
    assert(dailyAverages(25) === 16.5)
    assert(dailyAverages(29) === 22.5)
  }

  "A DataMunger" should "fold" in {
    val l = List((1,2), (2,3))
    (0 /: l) {(a, i) => i._1 + a}
    val largest = List(1,3,5,2).fold(0)((a,b) => if(a > b) a else b )
    assert(largest === 5)
  }*/

  "A DataMunger" should "return the day with the smallest range" in {
    val dayWithSmallestRange = new DataMunger().readData("weather.dat")
    assert(dayWithSmallestRange === 14)
  }
}
