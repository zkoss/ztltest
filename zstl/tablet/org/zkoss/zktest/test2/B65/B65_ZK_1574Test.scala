package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "Touch,Android")
class B65_ZK_1574Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
	<label multiline="true">
	iPad/Android Only
	Should see the two window in the same height.
	</label>
	<hlayout>
		<window vflex="min" hflex="min" title="window" border="normal">
			<div width="200px" height="100px" />
		</window>
		<window hflex="min" title="window" border="normal">
			<div width="200px" height="100px" />
		</window>
	</hlayout>
</zk>
    """

    runZTL(zscript,
      () => {
        verifyTrue("Should see the two window in the same height.", jq(".z-window-embedded:eq(0)").height() == jq(".z-window-embedded:eq(1)").height())
      })

  }
}
