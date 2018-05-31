package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2065.zul")
class B70_ZK_2065Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?page title="Macro Demo" ?>
<?component name="test-ma"   macroURI="test2/B70-ZK-2065-1.zul" ?>
<window border="normal" width="400px">
	<label multiline="true">
		1. The below should show 11111111 in the same line.
		2. The page should not be cached.
	</label>
		3. Paste the HTML code to <a href="http://validator.w3.org/">validator</a> should not show any error.
	<separator/>
	<test-ma/>
	<test-ma/>
</window>

"""
    runZTL(zscript,
      () => {
        verifyTrue("The below should show 11111111 in the same line.", jq("@macro .z-label:contains(1111)").length() == 2)
      })

  }
}