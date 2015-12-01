package list

import scala.annotation.tailrec

/*
* @author owie 11/27/15
*
*/
object Problem8and9and10and11 {
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
    @tailrec
    def packRec(ls: List[A], acc: List[List[A]]): List[List[A]] = ls match {
      case x :: tail => packRec(tail.dropWhile(_ == x), acc :+ ls.takeWhile(_ == x))
      case Nil => acc
    }

    packRec(ls, List())
  }

  /**
   *  Run-length encoding of a list.
    Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.

    Example:

    scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
   */
  def encode[A](ls: List[A]): List[(Int, A)] = {
    @tailrec
    def encodeRec(ls: List[A], acc: List[(Int, A)]): List[(Int, A)] = ls match {
      case x :: tail => encodeRec(tail.dropWhile(_ == x), acc :+ (ls.takeWhile(_ == x).length, x))
      case Nil => acc
    }

    encodeRec(ls, List.empty[(Int, A)])
  }

  def encodeUsingPack[A](ls: List[A]): List[(Int, A)] = {
    pack(ls) map { l =>
      (l.length, l.head)
    }
  }

  /**
   * Modified run-length encoding.
    Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.

    Example:

    scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
   */
  def encodeModified[A](ls: List[A]): List[Any] = {
    encodeUsingPack(ls) map {
      case (1, x) => x
      case y => y
    }
  }

  def encodeModifiedEither[A](ls: List[A]): List[Either[A, (Int, A)]] = {
    encodeUsingPack(ls) map {
      case (1, x) => Left(x)
      case y => Right(y)
    }
  }
}
