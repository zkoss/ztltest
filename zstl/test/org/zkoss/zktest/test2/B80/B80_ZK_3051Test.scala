package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.openqa.selenium.Dimension
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B80-ZK-3051-2.zul")
class B80_ZK_3051Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
   <include src="/test2/B80-ZK-3051-2.zul"/>
  """
    runZTL(zscript,
      () => {
        setWindowSize(250, 200)
        sleep(500);

        val item = jq(".z-combobox-button");
        click(item);

        waitResponse(true);

        val input = jq(".z-combobox");
        val popup = jq(".z-combobox-popup");

        val ppLeft = popup.offsetLeft();
        val ppTop = popup.offsetTop();
        val ppHeight = popup.outerHeight();
        val ppWidth = popup.outerWidth();
        val inpLeft = input.offsetLeft();
        val inpTop = input.offsetTop();
        val inpHeight = input.outerHeight();
        val inpWidth = input.outerWidth();

        verifyFalse((ppLeft > inpLeft - ppWidth && ppLeft < inpLeft + inpWidth) && (ppTop > inpTop - ppHeight && ppTop < inpTop + inpHeight));
      })

  }
}