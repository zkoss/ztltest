package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3678.zul")
class F85_ZK_3678Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val elems = List(jq("@window"), jq("@panel"), jq("@tabbox"), jq("@groupbox"))
      for (e <- elems)
        verifyTrue("shouldn't be iScroll by default", hasNativeScroll(e))
    })
  }
}
