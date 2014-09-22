import org.scalatest.{FlatSpec, Matchers}

/**
 * Home - Created by dave on 21/09/14.
 */
class DryFusionMungerV2Test extends FlatSpec with Matchers {

  "DryFusionManagerV2" should "find min result" in {
    assert( DryFusionMungerV2.munge("football.dat")._1 === "Leicester")
  }

}
