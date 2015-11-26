package list

/**
  * Created by owie on 11/19/15.
  */
object Problem2and3_FindPenultimateAndKth {

  def penultimate[A](ls: List[A]): A = ls match {
    case x :: y :: Nil => x
    case x :: tail => penultimate(tail)
    case _ => throw new NoSuchElementException
  }

}


/*
* @author owie 11/26/15
*
*/
object Problem3_kthElement {

  def nth[A](index: Int, ls: List[A]): A = {
    def nth(index: Int, acc: Int, ls: List[A]): A = {
      if(index == acc) ls.head
      else nth(index, acc + 1, ls.tail)
    }

    nth(index, 0, ls)
  }

  def nthRecursive[A](n: Int, ls: List[A]): A = (n, ls) match {
    case (0, h :: _   ) => h
    case (n, _ :: tail) => nthRecursive(n - 1, tail)
    case (_, Nil      ) => throw new NoSuchElementException
  }

}
