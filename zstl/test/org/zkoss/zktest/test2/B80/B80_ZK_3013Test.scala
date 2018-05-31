package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B80-ZK-3013.zul")
class B80_ZK_3013Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        val cbs = jq("@combobox")
        verifyEquals(2, cbs.length)
        val cb1 = cbs.eq(0)
        click(cb1.toWidget.$n("btn"))
        waitResponse(true)
        click(jq(".z-comboitem").eq(1))
        waitResponse(true)
        verifyEquals(0, jq("#zk_log").length)
        val cb2 = cbs.eq(1)
        click(cb2.toWidget.$n("btn"))
        waitResponse(true)
        click(jq(".z-comboitem").eq(1))
        waitResponse(true)
        verifyEquals(0, jq("#zk_log").length)
      })
  }
}

