package list

import org.scalatest._
import org.scalatest.prop._

/**
  * Created by owie on 11/19/15.
  */
class Problem4and5Test //extends FlatSpec with Checkers with PropertyChecks with ShouldMatchers{
  extends FlatSpec with PropertyChecks with Matchers {

  "length" should "check all" in {
    forAll {
      (a: List[Int]) => a.size should be(Problem4and5.length(a))
    }
  }

  "reverse" should "check all" in {
    forAll {
      (a: List[Int]) => {
        a.reverse should be (Problem4and5.reverse(a))
        a.reverse should be (Problem4and5.reverseFold(a))
      }
    }
  }
}
