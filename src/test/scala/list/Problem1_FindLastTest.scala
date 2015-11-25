package list

import list.Problem1_Last.last
import org.scalatest.FlatSpec
import traits.{ListIntTestTrait, ListStringTestTrait}

/**
  * Created by owie on 11/19/15.
  */
class Problem1_FindLastTest extends FlatSpec with ListIntTestTrait with ListStringTestTrait{
  override def fnInt = last[Int]
  override def fnString = last[String]

  "Find Second Last Element" should "get second to the last of Int List" in {
    assertTrueInt(8)
  }

  it should "get second last String in List" in {
    assertTrueString("Fourth")
  }
}
