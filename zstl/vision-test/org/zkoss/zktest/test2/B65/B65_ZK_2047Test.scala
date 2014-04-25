package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-2047.zul")
class B65_ZK_2047Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<window>
<div>
1. run the attached example
2. open the calendar widget above the pdf (left side)
3. click the year or month to change the view in the calendar popup
-> the calendar popup gets hidden below the pdf in the iframe
</div>
	<hlayout>
		<vlayout>
			<datebox></datebox>
			<textbox></textbox>
			<iframe height="500px" width="500px" src="test2/B1896797.pdf"></iframe>
		</vlayout>
		<vlayout>
			<datebox></datebox>
			<textbox></textbox>
			<iframe height="500px" width="500px" src=".">
			</iframe>
		</vlayout>
	</hlayout>
</window>"""
    runZTL(zscript,
      () => {
        0 to 1 foreach { i =>
          verifyImage()
          var db = jq(".z-datebox").eq(i).toWidget()
          click(db.$n("btn"))
          waitResponse
          verifyImage()

          val cal = jq(db.$n("pp")).find(".z-calendar:eq(0)")
          click(cal.find(".z-calendar-title .z-calendar-ctrler:eq(1)"))
          waitResponse()
          verifyImage()
          click(cal.find(".z-calendar-calyear td:contains(2013)"))
          waitResponse()
          verifyImage()
          click(cal.find(".z-calendar-calmon td:eq(9)"))
          waitResponse()
          verifyImage()
          click(cal.find(".z-calendar-calday td:contains(20)"))
          waitResponse()
          verifyImage()
        }
      })

  }
}