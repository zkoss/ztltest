package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-2091.zul")
class B65_ZK_2091Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
  	<label multiline="true">
  		1. Copy the following number to the doublebox: 100000000000000000000
  		2. Unfocus the doublebox.
  		3. Should see any js error.
  	</label>
    <doublebox width="200px">
      <attribute name="onChange"><![CDATA[
      self.getValue();
      ]]></attribute>
    </doublebox>
</zk>"""
    runZTL(zscript,
      () => {

        sendKeys(jq(".z-doublebox"), "100000000000000000000")
        waitResponse(true)
        verifyFalse("should see no javascript error", jq(".z-error").exists())
      })

  }
}