package list

import org.scalatest._
import prop._

/**
  * Created by owie on 11/19/15.
  */
class Problem2_FindPenultimateTest //extends FlatSpec with Checkers with PropertyChecks with ShouldMatchers{
  extends FlatSpec with PropertyChecks with Matchers {

  it should "check all " in {
    forAll {
      (a: List[Int]) => whenever(a.size > 1) {
        a(a.size - 2) should be(Problem2_FindPenultimate.penultimate(a))
      }
    }

    forAll {
      (a: List[Int]) => whenever(a.size > 1) {
        a(a.size - 2) should be(Problem2_FindPenultimate.penultimate(a))
      }
    }
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = List.empty[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.head
    }
  }

}
