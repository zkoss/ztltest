package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1998.zul")
class B65_ZK_1998Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	Should see checkbox in Header is checked.
	<window apply="org.zkoss.zktest.test2.B65_ZK_1998Composer">
		<listbox id="listbox">
			<listhead>
				<listheader label="Category" />
				<listheader label="Name" />
				<listheader label="Top Nutrients" />
			</listhead>
		</listbox>
	</window>
</zk>"""
    runZTL(zscript,
      () => {

        verifyTrue("Should see checkbox in Header is checked.", jq(".z-listheader-checkable.z-listheader-checked").exists)
      })

  }
}