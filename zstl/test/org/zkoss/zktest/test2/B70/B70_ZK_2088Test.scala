package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import org.zkoss.ztl.ZK

@Tags(tags = "B70-ZK-2088.zul")
class B70_ZK_2088Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?page title="zk.safari Chrome" contentType="text/html;charset=UTF-8"?>
<zk>
	<window title="zk.safari Chrome" border="normal">
		<label>
			Nothing will show up under this line on Chrome, but version number will be displayed on Safari.
		</label>
		<label>
			${zk.safari}
		</label>
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        val isEmpty = jq(".z-label:eq(1)").text().trim() == ""
        verifyTrue("Nothing will show up under this line on Chrome",
          if (!ZK.is("safari")) isEmpty else !isEmpty)
      })

  }
}