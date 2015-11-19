/**
  * Created by owie on 11/19/15.
  */
object LastElementOfList {

  /*
    P01 (*) Find the last element of a list.
    Example:
    scala> last(List(1, 1, 2, 3, 5, 8))
    res0: Int = 8
     */
  def main(args: Array[String]) {
    val list = List(1,2,3,5,8)
    println(s"Get last element of list $list")

    val last = getLast(list)
    println(s"Last element of list is $last")
  }

  def getLast[A](list: List[A]): A = list match {
    case x :: Nil => x
    case _ :: tail => getLast(tail)
    case _ => throw new NoSuchElementException
  }

}
