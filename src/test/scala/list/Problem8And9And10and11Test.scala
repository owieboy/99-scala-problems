package list

import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}

import list.Problem8and9and10and11._

/*
* @author owie 11/27/15
*
*/
class Problem8And9And10and11Test extends FlatSpec with PropertyChecks with Matchers {

  "compress" should "compress" in {
    val ls = compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    ls should be(List('a, 'b, 'c, 'a, 'd, 'e))
  }

  "compress2" should "compress" in {
    val ls = compress2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    ls should be(List('a, 'b, 'c, 'a, 'd, 'e))
  }

  "pack " should "pack" in {
    val ls = Problem8and9and10and11.pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    ls should be(List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  }

  "encode" should "encode" in {
    val ls = encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    ls should be(List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }

  "encodeUsingPack" should "encode" in {
    val ls = encodeUsingPack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    ls should be(List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }

  "encodeModified" should "encodeModified" in {
    val ls = encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    ls should be(List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))
  }

  "encodeModifiedEither" should "encodeModified" in {
    val ls = encodeModifiedEither(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    ls should be(List(Right((4,'a)), Left('b), Right((2,'c)), Right((2,'a)), Left('d), Right((4,'e))))
  }
}
