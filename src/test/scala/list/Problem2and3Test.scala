package list

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
        a(a.size - 2) should be(Problem2and3.penultimate(a))
      }
    }

    forAll {
      (a: List[Int]) => whenever(a.size > 1) {
        a(a.size - 2) should be(Problem2and3.penultimate(a))
      }
    }
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = List.empty[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.head
    }
  }

  "kth" should "find kth element" in {
    Problem2and3.kth(0, List(1,2,3)) should be(1)
    Problem2and3.kthRecursive(0, List(1,2,3)) should be(1)
  }

  it should "get 5th element" in {
    Problem2and3.kth(4, List(1,2,3,4,5)) should be(5)
    Problem2and3.kthRecursive(4, List(1,2,3,4,5)) should be(5)
  }

  it should "throw error when index is out of bounds" in {
    a[Exception] should be thrownBy {
      Problem2and3.kth(4, List(1,2,3))
    }

    a[NoSuchElementException] should be thrownBy {
      Problem2and3.kthRecursive(4, List(1,2,3))
    }
  }

}
