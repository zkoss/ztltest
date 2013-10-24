package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1708.zul")
class B65_ZK_1708Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
	<window hflex="1" vflex="1" border="normal" title="window">
		Click "append" button, should see notification showed.
		<button label="append" onClick="append()">
			<attribute name="onClick"><![CDATA[
				include2.setSrc("/test2/B65-ZK-1708_1.zul?a=b");
			]]></attribute>
		</button>
		<include id="include2" hflex="1" vflex="1" src="" />
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-button"))
        waitResponse()
        verifyTrue("should see notification showed.", jq(".z-notification").exists)
      })

  }
}