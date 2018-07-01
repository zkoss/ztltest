package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2181.zul")
class B70_ZK_2181Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<div>the radio should be checked</div>
	<radiogroup id="rg" hflex="1">
		<radio checked="true" label="radio" />
	</radiogroup>
	<span hflex="1">
		<radio checked="true" label="radio" />
	</span>
</zk>"""
    runZTL(zscript,
      () => {
        verifyTrue("the radio should be checked", jq("input[checked=checked]").length() == 2)
      })

  }
}