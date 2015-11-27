package list

import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.prop.PropertyChecks

/*
* @author owie 11/27/15
*
*/
class Problem6and7Test extends FlatSpec with PropertyChecks with Matchers {
  "palindromeRec" should "check palindrome" in {
    forAll {
      (a: List[Int]) => {
        if (a.reverse.sameElements(a)) Problem6and7.isPalindromeRec(a) should be(true)
        else Problem6and7.isPalindromeRec(a) should be(false)
      }
    }
  }

  it should "check normal palindrome" in {
    Problem6and7.isPalindromeRec(List(1, 2, 1)) should be(true)
    Problem6and7.isPalindromeRec(List(1, 2)) should be(false)
    Problem6and7.isPalindromeRec(List()) should be(true)
  }

  "palindrome" should "check palindrome" in {
    forAll {
      (a: List[Int]) => {
        if (a.reverse.sameElements(a)) Problem6and7.isPalindrome(a) should be(true)
        else Problem6and7.isPalindrome(a) should be(false)
      }
    }
  }

  it should "check normal palindrome" in {
    Problem6and7.isPalindrome(List(1, 2, 1)) should be(true)
    Problem6and7.isPalindrome(List(1, 2)) should be(false)
    Problem6and7.isPalindrome(List()) should be(true)
  }

  "flatten" should "flatten list" in {
    val ls = Problem6and7.flatten(List(1, List(2)))
    ls equals List(1,2) should be(true)
  }

  it should "flatten nested list" in {
    val ls = Problem6and7.flatten(List(List(1, 1), 2, List(3, List(5, 8))))
    ls equals List(1, 1, 2, 3, 5, 8) should be(true)
  }
}
