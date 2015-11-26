package list

/**
  * Created by owie on 11/19/15.
  */
object Problem2and3 {
  /**
    * P02 (*) Find the last but one element of a list.
      Example:
      scala> penultimate(List(1, 1, 2, 3, 5, 8))
      res0: Int = 5
    */

  def penultimate[A](ls: List[A]): A = ls match {
    case x :: y :: Nil => x
    case x :: tail => penultimate(tail)
    case _ => throw new NoSuchElementException
  }

  /**
  P03 (*) Find the Kth element of a list.
  By convention, the first element in the list is element 0.
  Example:

  scala> nth(2, List(1, 1, 2, 3, 5, 8))
  res0: Int = 2
  */

  def kth[A](index: Int, ls: List[A]): A = {
    def kthIndex(index: Int, acc: Int, ls: List[A]): A = {
      if(index == acc) ls.head
      else kthIndex(index, acc + 1, ls.tail)
    }

    kthIndex(index, 0, ls)
  }

  def kthRecursive[A](index: Int, ls: List[A]):A = (index, ls) match {
    case (0, x :: tail) => x
    case (n, y :: tail) => kthRecursive(index -1, tail)
    case _ => throw new NoSuchElementException
  }

}