package traits

/**
  * Created by owie on 11/19/15.
  */
trait ListTraitInt {

  val list = List(1,2,3,5,8)
  def fnInt: (List[Int] => Int)

  def assertEqualsInt(expected: Int) = {
    assert(expected == fnInt(list), s"fnInt($list)  should be equal to ${fnInt(list)}, not $expected")
    println("Success assertEqualsInt ")
  }
}
