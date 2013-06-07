package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.openqa.selenium.Keys

@Tags(tags = "B65-ZK-1654.zul")
class B65_ZK_1654Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<label multiline="true">
		1. Click on color input and try to enter character 'A' or 'a', should see 'A' or 'a' showed.
		2. Change to colorpicker and try again.
	</label>
	<colorbox width="30px" height="25px" />
</zk>
    """

    runZTL(zscript,
      () => {
        click(jq(".z-colorbox"))
        waitResponse()
        val colorpaletteInp = jq(".z-colorpalette-input")
        sendKeys(colorpaletteInp, "A")
        waitResponse()
        verifyEquals("should see 'A' or 'a' showed", colorpaletteInp.`val`(), "A")

        click(jq(".z-colorbox-picker-button"))
        waitResponse()

        val colorpickerInp = jq(".z-colorpicker-input")
        sendKeys(colorpickerInp, Keys.END + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "" + Keys.BACK_SPACE + "A")
        waitResponse()
        verifyEquals("should see 'A' or 'a' showed", colorpickerInp.`val`(), "A")

      })

  }
}
