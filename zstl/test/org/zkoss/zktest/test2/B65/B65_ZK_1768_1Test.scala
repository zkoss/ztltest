package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1768.zul")
class B65_ZK_1768_1Test extends ZTL4ScalaTestCase {
  @Test
  def test2() = {
    val zscript = """
     <include src="/test2/B65-ZK-1768.zul"/>
    """
    runZTL(zscript,
      () => {
        val item2 = jq(".z-row:contains(Item 2) input")
        val show = jq(".z-button:contains(Show Index)")
        check(item2)
        waitResponse()
        click(show)
        waitResponse()
        verifyTrue(jq(".z-label:contains(index: 1)").exists())

        click(jq(".z-button:contains(Update Model)"))
        waitResponse()
        click(show)
        waitResponse()
        verifyTrue(jq(".z-label:contains(index: 0)").exists())

        check(jq(".z-row:contains(Item 3) input"))
        waitResponse()
        click(show)
        waitResponse()
        verifyTrue(jq(".z-label:contains(index: 1)").exists())
      })

  }
}