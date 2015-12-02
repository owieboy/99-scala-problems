package list

import scala.annotation.tailrec
import scala.util.Random

/*
* @author owie 12/2/15
*
*/
object Problem20and21and22and23 {
  /**
   * P20 (*) Remove the Kth element from a list.
    Return the list and the removed element in a Tuple. Elements are numbered from 0.

    Example:

    scala> removeAt(1, List('a, 'b, 'c, 'd))
    res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
   */
  def removeAt[A](index: Int, ls: List[A]): (List[A], A) = {
    if (index > ls.length - 1 || index < 0) throw new IllegalArgumentException(s"incorrect argument $index")
    @tailrec
    def removeAtRec(ind: Int, ls: List[A], acc: List[A], elem: Option[A]): (List[A], A) = (ind, ls, elem) match {
      case (x, y :: tail, _) if x == index => removeAtRec(ind + 1, tail, acc, Some(y))
      case (x, y :: tail, _) => removeAtRec(ind + 1, tail, acc :+ y, elem)
      case (_, Nil, Some(z)) => (acc, z)
      case (_, Nil, None) => throw new NoSuchElementException(s"Elem at $index not found!")
    }

    removeAtRec(0, ls, List(), None)
  }

  /**
   * P21 (*) Insert an element at a given position into a list.
    Example:

    scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
    res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
   */
  def insertAt[A](insertElem: A, index: Int, ls: List[A]): List[A] = {
    if (index > ls.length - 1 || index < 0) throw new IllegalArgumentException(s"incorrect argument $index")
    @tailrec
    def insertAtRec(ind: Int, ls: List[A], acc: List[A]): List[A] = (ind, ls) match {
      case (x, y :: tail) if x == index => insertAtRec(ind + 1, tail, acc :+ insertElem :+ y)
      case (x, y :: tail) => insertAtRec(ind + 1, tail, acc :+ y)
      case (_, Nil) => acc
    }
    insertAtRec(0, ls, List.empty[A])
  }

  /**
   * P22 (*) Create a list containing all integers within a given range.
    Example:

    scala> range(4, 9)
    res0: List[Int] = List(4, 5, 6, 7, 8, 9)
   */
  def range(from: Int, to: Int): List[Int] = {
    if (from > to) throw new IllegalArgumentException
    def rangeRec(index: Int, acc: List[Int]): List[Int] = {
      if (index == to) acc :+ index
      else rangeRec(index + 1, acc :+ index)
    }
    rangeRec(from, List())
  }

  /**
   * P23 (**) Extract a given number of randomly selected elements from a list.
    Example:

    scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
    res0: List[Symbol] = List('e, 'd, 'a)

    Hint: Use the solution to problem P20
   */
  def randomSelect[A](num: Int, ls: List[A]): List[A] = {
    if(num < 0) throw new IllegalArgumentException
    def randomSelectRec(curNum: Int, ls: List[A], acc: List[A], rand: Random): List[A] = {
      if (curNum == 0) acc
      else {
        val (listMinusElem, elem) = removeAt(rand.nextInt(ls.length), ls)
        randomSelectRec(curNum - 1, listMinusElem, elem :: acc, rand)
      }
    }
    randomSelectRec(num, ls, List(), new Random())
  }
}
