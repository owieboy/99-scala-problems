package list

import scala.annotation.tailrec
import scala.util.Random

/*
* @author owie 12/2/15
*
*/
object Problem24and25and26and27 {

  /**
   * P24 (*) Lotto: Draw N different random numbers from the set 1..M.
    Example:

    scala> lotto(6, 49)
    res0: List[Int] = List(23, 1, 17, 33, 21, 37)
   */
  def lotto(num: Int, limit: Int): List[Int] = {
    if (num < 0 || limit < 0 || num > limit) throw new IllegalArgumentException
    val rand = new Random()
    @tailrec
    def lottoRec(acc: List[Int]): List[Int] = {
      if (acc.length == num) acc
      else lottoRec((rand.nextInt(limit) :: acc).distinct)
    }
    lottoRec(List())
  }

  /**
   * P25 (*) Generate a random permutation of the elements of a list.
    Hint: Use the solution of problem P23.

    Example:

    scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
    res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)
   */
  def randomPermute[A](ls: List[A]): List[A] = Problem20and21and22and23.randomSelect(ls.length, ls)

  /**
   * P26 (**) Generate the combinations of K distinct objects chosen from the N elements of a list.
    In how many ways can a committee of 3 be chosen from a group of 12 people? We all know that there are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficient). For pure mathematicians, this result may be great. But we want to really generate all the possibilities.

    Example:

    scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
    res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...
   */
  // Solution to this problem is based from http://laura.lambda.lt/2014/03/06/Functional-Programming-is-beautiful/
  def combinations[A](k: Int, ls: List[A]): List[List[A]] = {
    def combinationsRec(lis: List[A], comb: List[A]): List[List[A]] = {
      (comb, lis) match {
        case (c, _) if c.length == k => List(c.reverse)
        case (c, Nil) if c.length < k => List()
        case (c, l) => combinationsRec(lis.tail, lis.head :: comb) ::: combinationsRec(lis.tail, comb)
      }
    }
    combinationsRec(ls, Nil)
  }

  // Solution from 99-scala problems
  def flatMapSublists[A, B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
    ls match {
      case Nil => Nil
      case sublist@(_ :: tail) => f(sublist) ::: flatMapSublists(tail)(f)
    }

  def combinations2[A](n: Int, ls: List[A]): List[List[A]] =
    if (n == 0) List(Nil)
    else flatMapSublists(ls) { sl =>
      combinations2(n - 1, sl.tail) map {
        sl.head :: _
      }
    }
}
