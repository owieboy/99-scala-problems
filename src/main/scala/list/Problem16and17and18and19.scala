package list

import scala.annotation.tailrec

/*
* @author owie 12/1/15
*
*/
object Problem16and17and18and19 {
  /**
   * P16 (**) Drop every Nth element from a list.
    Example:

    scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
   */
  def drop[A](everyIndex: Int, ls: List[A]): List[A] = {
    @tailrec
    def dropRecur(lis: List[A], acc: List[A], index: Int): List[A] = (index, lis) match {
      case (_, Nil) => acc
      case (1, _ :: tail) => dropRecur(tail, acc, everyIndex)
      case (_, x :: tail) => dropRecur(tail, acc :+ x, index - 1)
    }
    dropRecur(ls, List(), everyIndex)
  }

  /**
   * P17 (*) Split a list into two parts.
    The length of the first part is given. Use a Tuple for your result.

    Example:

    scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
   */
  def split[A](length1: Int, ls: List[A]): (List[A], List[A]) = {
    @tailrec
    def splitRecur(curLength: Int, lis: List[A], acc: List[A]): (List[A], List[A]) = (curLength, lis) match {
      case (0, x) => (acc, x)
      case (_, Nil) => throw new IllegalArgumentException(s"List is shorter than $length1")
      case (_, y :: tail) => splitRecur(curLength - 1, tail, acc :+ y)
    }

    splitRecur(length1, ls, List.empty[A])
  }

  /**
   * P18 (**) Extract a slice from a list.
    Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.

    Example:

    scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    res0: List[Symbol] = List('d, 'e, 'f, 'g)
   */
  def slice[A](from: Int, to: Int, ls: List[A]): List[A] = {
    if (to > ls.length || from > ls.length || from > to || from < 0) throw new IllegalArgumentException(s"incorrect arguments from=$from, to=$to")
    def sliceRec(curIndex: Int, ls: List[A], acc: List[A]): List[A] = (curIndex, ls) match {
      case (x, y :: tail) if (from <= x) && (x < to) => sliceRec(curIndex + 1, tail, acc :+ y)
      case (x, _) if x == to => acc
      case (x, y :: tail) => sliceRec(curIndex + 1, tail, acc)
      case (x, Nil) if x != to => throw new IllegalArgumentException("Nil tail")
    }

    sliceRec(0, ls, List())
  }

  /**
   * P19 (**) Rotate a list N places to the left.
    Examples:

    scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)

    scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
   */
  def rotate[A](rotateIndex: Int, ls: List[A]): List[A] = {
    val nBounded = if (ls.isEmpty) 0 else rotateIndex % ls.length
    if (nBounded < 0) rotate(nBounded + ls.length, ls)
    else {
      val (head, tail) = split(nBounded, ls)
      tail ::: head
    }
  }
}
