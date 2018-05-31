package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B50_2976323Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      var one = jq("$one")
      var two = jq("$two")
      var mb = jq("$mb")
      dragdropToObject(two, one, "0,10", "0,10")
      waitResponse()
      verifyEquals("two", mb.first.toWidget.firstChild().get("id"))
      verifyEquals(two.parent().get(0).firstChild().get("id"), two.get(0).get("id"))


      dragdropToObject(one, two, "0,10", "0,10")
      waitResponse()
      verifyEquals("one", mb.first.toWidget.firstChild().get("id"))
      verifyEquals(two.parent().get(0).firstChild().nextSibling().get("id"), two.get(0).get("id"))
    })
  }
}
