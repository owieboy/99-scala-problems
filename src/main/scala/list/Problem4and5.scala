package list

/**
  * Created by owie on 11/26/15.
  */
object Problem4and5 {
  /**
    * P04 (*) Find the number of elements of a list.
Example:
scala> length(List(1, 1, 2, 3, 5, 8))
res0: Int = 6
    */
  def length[A](ls: List[A]): Int = {
    def length(ls: List[A], acc: Int): Int = ls match {
      case Nil => acc
      case x :: tail => length(tail, acc + 1)
    }

    length(ls, 0)
  }

  /**
    * P05 (*) Reverse a list.
Example:
scala> reverse(List(1, 1, 2, 3, 5, 8))
res0: List[Int] = List(8, 5, 3, 2, 1, 1)
    */
  def reverse[A](ls: List[A]): List[A] = {
    def reverse(ls: List[A], revList: List[A]): List[A] = ls match {
      case x :: tail => reverse(tail, revList.+:(x))
      case Nil => revList
    }

    reverse(ls, List.empty[A])
  }

  def reverseFold[A](ls: List[A]): List[A] = {
    ls.foldLeft(List[A]())((acc, i) => i :: acc)
  }
}
