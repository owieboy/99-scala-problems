package traits

import org.junit.Assert

/**
  * Created by owie on 11/19/15.
  */
trait ListStringTestTrait {
  val stringList = List("First","Second","Third","Fourth")
  def fnString: (List[String] => String)

  def assertTrueString(expected: String) = {
    Assert.assertEquals(s"fnInt($stringList) = ${fnString(stringList)} is not equal to $expected", expected, fnString(stringList))
  }
}
