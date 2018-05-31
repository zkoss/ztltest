package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B80-ZK-3016.zul")
class B80_ZK_3016Test extends ZTL4ScalaTestCase {
  @Test
  def testBtn1() = {
    testResult(1)
  }

  @Test
  def testBtn2() = {
    testResult(2)
  }

  @Test
  def testBtn3() = {
    testResult(3)
  }

  def testResult(num: Integer) = {
    runZTL(
      () => {
        val $btn = jq("$btn" + num)
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

