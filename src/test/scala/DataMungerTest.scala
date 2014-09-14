import org.scalatest.{Matchers, FlatSpec, FunSuite}

/**
 * Created by dave on 08/09/14.
 */
class DataMungerTest extends FlatSpec with Matchers {

  "A DataMunger" should "return nothing when no file" in {
    new DataMunger().readData("weather.dat")
  }

  "A DataMunger" should "return the day with the smallest range" in {
    val dayWithSmallestRange = new DataMunger().readData("weather.dat")
    assert(dayWithSmallestRange === 14)
  }
}
