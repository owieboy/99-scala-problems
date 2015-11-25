package list

/**
  * Created by owie on 11/19/15.
  */
object Problem2_FindPenultimate {

  def penultimate[A](ls: List[A]): A = ls match {
    case x :: y :: Nil => x
    case x :: tail => penultimate(tail)
    case _ => throw new NoSuchElementException
  }

}