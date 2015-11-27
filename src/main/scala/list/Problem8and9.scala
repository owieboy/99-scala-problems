package list

import scala.annotation.tailrec

/*
* @author owie 11/27/15
*
*/
object Problem8and9 {
  /**
   * P08 (**) Eliminate consecutive duplicates of list elements.
    If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.

    Example:

    scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
   */
  def compress[A](ls: List[A]): List[A] = {
    @tailrec
    def compressRec(prev: Option[A], ls: List[A], acc: List[A]): List[A] = ls match {
      case x :: tail => {
        if (prev.isEmpty || !ls.head.equals(prev.get)) compressRec(Option(ls.head), tail, acc :+ x)
        else compressRec(Option(ls.head), tail, acc)
      }
      case Nil => acc
    }

    compressRec(None, ls, List())
  }

  def compress2[A](ls: List[A]): List[A] = {
    @tailrec
    def compressRec(ls: List[A], acc: List[A]): List[A] = ls match {
      case x :: tail => compressRec(tail.dropWhile(_ == x), acc :+ x)
      case Nil => acc
    }

    compressRec(ls, List())
  }

  /**
  P09 (**) Pack consecutive duplicates of list elements into sublists.
    If a list contains repeated elements they should be placed in separate sublists.

    Example:

    scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
    */

  def pack[A](ls: List[A]): List[List[A]] = {
    def packRec(ls: List[A], acc: List[List[A]]): List[List[A]] = ls match {
      case x :: tail => packRec(tail.dropWhile(_ == x), ls.takeWhile(_ == x) :: acc)
      case Nil => acc
    }

    packRec(ls, List())
  }
}
