package list

/**
  * Created by owie on 11/19/15.
  */
object Problem1_Last {

  /*
    P01 (*) Find the last element of a list.
    Example:
    scala> last(List(1, 1, 2, 3, 5, 8))
    res0: Int = 8
     */

  def last[A](list: List[A]): A = list match {
    case x :: Nil => x
    case _ :: tail => last(tail)
    case _ => throw new NoSuchElementException
  }

}

