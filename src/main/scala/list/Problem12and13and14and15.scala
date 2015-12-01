package list

import scala.annotation.tailrec

/*
* @author owie 12/1/15
*
*/
object Problem12and13and14and15 {
  def make[A](num: Int, elem: A): List[A] = {
    @tailrec
    def multiplyRec[A](num: Int, elem: A, acc: List[A]): List[A] = num match {
      case 0 => acc
      case x => multiplyRec(num - 1, elem, elem :: acc)
    }
    multiplyRec(num, elem, List.empty[A])
  }

  /**
   * P12 Decode a run-length encoded list.
    Given a run-length code list generated as specified in problem P10, construct its uncompressed version.

    Example:

    scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
    res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
   */
  def decode[A](ls: List[(Int, A)]): List[A] = {
    @tailrec
    def decodeRec(lis: List[(Int, A)], acc: List[A]): List[A] = lis match {
      case (num, elem) :: tail => decodeRec(tail, acc ::: make(num, elem))
      case Nil => acc
    }
    decodeRec(ls, List.empty[A])
  }

  def decodeFoldLeft[A](ls: List[(Int, A)]): List[A] = ls.foldLeft(List.empty[A])((acc, elemPair) => acc ::: make(elemPair._1, elemPair._2))

  def decodeFlatMap[A](ls: List[(Int, A)]): List[A] = ls flatMap { e => make(e._1, e._2) }

  /**
   * P13 (**) Run-length encoding of a list (direct solution).
    Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly.

    Example:

    scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
   */
  def encodeDirect[A](ls: List[A]): List[(Int, A)] = {
    @tailrec
    def encodeDirectRec(ls: List[A], acc: List[(Int, A)]): List[(Int, A)] = ls match {
      case x :: tail => encodeDirectRec(tail.dropWhile(_ == x), acc :+(ls.takeWhile(_ == x).length, x))
      case Nil => acc
    }

    encodeDirectRec(ls, List.empty[(Int, A)])
  }

  /**
   * P14 (*) Duplicate the elements of a list.
    Example:

    scala> duplicate(List('a, 'b, 'c, 'c, 'd))
    res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
   */
  def duplicate[A](ls: List[A]): List[A] = ls flatMap { elem => make(2, elem) }

  /**
   * P15 (**) Duplicate the elements of a list a given number of times.
    Example:

    scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
    res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
   */
  def duplicateN[A](num: Int, ls: List[A]): List[A] = ls flatMap { elem => make(num, elem) }
}
