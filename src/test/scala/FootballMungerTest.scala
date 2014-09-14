import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by dave on 08/09/14.
 */
class FootballMungerTest extends FlatSpec with Matchers {

  "A FootballMunger" should "return nothing when no file" in {
    new FootballMunger().readData("football.dat")
  }

  "A DataMunger" should "return the team with the smallest range" in {
    val teamWithSmallestRange = new FootballMunger().readData("football.dat")
    assert(teamWithSmallestRange === "manu")
  }

}
