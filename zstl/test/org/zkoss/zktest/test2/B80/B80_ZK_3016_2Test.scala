package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B80-ZK-3016.zul")
class B80_ZK_3016_2Test extends ZTL4ScalaTestCase {
  @Test
  def testBtn3() = {
    val zscript = """
     <include src="/test2/B80-ZK-3016.zul"/>
    """
    runZTL(zscript, () => {
        val $btn = jq("$btn3")
        verifyTrue($btn.exists())
        click($btn)
        waitResponse(true)
        val $tab1 = jq("$tab1")
        val $tab2 = jq("$tab2")
        val $tab3 = jq("$tab3")
        val $tab4 = jq("$tab4")
        verifyEquals($tab1.offsetTop, $tab2.offsetTop)
        verifyEquals($tab2.offsetTop, $tab3.offsetTop)
        verifyEquals($tab3.offsetTop, $tab4.offsetTop)
      })
  }
}

