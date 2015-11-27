package list

/*
* @author owie 11/27/15
*
*/
object Problem6and7 {
  /**
   * P06 (*) Find out whether a list is a palindrome.
    Example:

    scala> isPalindrome(List(1, 2, 3, 2, 1))
    res0: Boolean = true
   */
  def isPalindrome[A](ls: List[A]): Boolean = ls == ls.reverse

  def isPalindromeRec[A](ls: List[A]): Boolean = {
    val reversed = Problem4and5.reverse(ls)
    def isPalindrome(ls: List[A], rev: List[A]): Boolean = (ls, rev) match {
      case (x :: tail1, y :: tail2) => {
        if (x.equals(y)) isPalindrome(tail1, tail2) else false
      }
      case (List(_), Nil) => false
      case (Nil, List(_)) => false
      case (Nil, Nil) => true
    }
    isPalindrome(ls, reversed)
  }

  /**
   * P07 (**) Flatten a nested list structure.
    Example:

    scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
    res0: List[Any] = List(1, 1, 2, 3, 5, 8)
   */
  def flatten(lis: List[Any]): List[Any] = {
    def flattenRec(ls: List[Any], acc: List[Any]): List[Any] = ls match {
      case x :: tail => x match {
        case a :: Nil => {
          flattenRec(tail, acc :+ a)
        }
        case z: List[Any] => {
          flattenRec(tail, flattenRec(z, acc))
        }
        case y => {
          flattenRec(tail, acc :+ y)
        }
      }
      case Nil => acc
    }

    flattenRec(lis, List.empty[Any])
  }
}
