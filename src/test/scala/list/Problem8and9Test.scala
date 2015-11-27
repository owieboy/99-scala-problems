package list

import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}

import list.Problem8and9.{compress, compress2}

/*
* @author owie 11/27/15
*
*/
class Problem8and9Test extends FlatSpec with PropertyChecks with Matchers {

  "compress" should "compress" in {
    val ls = compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    ls should be ( List('a, 'b, 'c, 'a, 'd, 'e))
  }

  "compress2" should "compress" in {
    val ls = compress2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    ls should be ( List('a, 'b, 'c, 'a, 'd, 'e))
  }
}
