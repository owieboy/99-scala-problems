package list

import java.util.NoSuchElementException

import org.scalatest._
import prop._

/**
 * Created by owie on 11/19/15.
 */
class Problem2and3Test //extends FlatSpec with Checkers with PropertyChecks with ShouldMatchers{
  extends FlatSpec with PropertyChecks with Matchers {

  "penultimate" should "check all " in {
    forAll {
      (a: List[Int]) => whenever(a.size > 1) {
        a(a.size - 2) should be(Problem2and3_FindPenultimateAndKth.penultimate(a))
      }
    }

    forAll {
      (a: List[Int]) => whenever(a.size > 1) {
        a(a.size - 2) should be(Problem2and3_FindPenultimateAndKth.penultimate(a))
      }
    }
  }

  "nth" should "check element 0 " in {
    Problem3_kthElement.nth(0, List(1, 2, 3)) should be(1)
    Problem3_kthElement.nthRecursive(0, List(1, 2, 3)) should be(1)
  }

  it should "check 5th element" in {
    Problem3_kthElement.nth(4, List(1, 2, 3, 4, 5)) should be(5)
    Problem3_kthElement.nthRecursive(4, List(1, 2, 3, 4, 5)) should be(5)
  }

  it should "throw NoSuchElementException if index is greater than size" in {
    a[NoSuchElementException] should be thrownBy {
      Problem3_kthElement.nthRecursive(4, List(1, 2, 3))
    }
    a[UnsupportedOperationException] should be thrownBy {
      Problem3_kthElement.nth(4, List(1, 2, 3))
    }
  }
}
