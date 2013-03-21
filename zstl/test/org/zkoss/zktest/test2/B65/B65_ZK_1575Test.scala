package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1575.zul")
class B65_ZK_1575Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<groupbox title="groupbox" mold="3d" vflex="min" open="false">
		<div height="100px">test</div>
	</groupbox>
</zk>
    """

    runZTL(zscript,
      () => {
        verifyFalse("should see no javascript error", jq(".z-error").exists())
      })
  }
}
