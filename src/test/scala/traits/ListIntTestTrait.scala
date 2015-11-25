package traits

import org.junit.Assert

/**
  * Created by owie on 11/19/15.
  */
trait ListIntTestTrait {
  val intList = List(1,2,3,5,8)
  def fnInt: (List[Int] => Int)

  def assertTrueInt(expected: Int) = {
    Assert.assertEquals(s"fnInt($intList) = ${fnInt(intList)} is not equal to $expected", expected, fnInt(intList))
  }
}
