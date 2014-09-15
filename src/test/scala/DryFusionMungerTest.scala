import org.scalatest.{Matchers, FlatSpec}

class DryFusionMungerTest extends FlatSpec with Matchers {

  "DryFusionMunger" should "throw exception when invalid file" in {
    intercept[NullPointerException] {
      new DryFusionMunger(2, 7, 9, "^\\+s-*").readData("rubbish.txt")
    }
  }

  "A DryFusionMunger" should "return the day with the smallest range" in {
    val dayWithSmallestRange = new DryFusionMunger(1,2,3, "^\\s+\\d+.*").readData("weather.dat")
    assert(dayWithSmallestRange === "14")
  }

  "A DryFusionMunger" should "return the team with least goals" in {
    val teamWithLeastGoals = new DryFusionMunger(2,7,9, "^\\s+\\d+.*").readData("football.dat")
    assert(teamWithLeastGoals === "Leciscter")
  }
}