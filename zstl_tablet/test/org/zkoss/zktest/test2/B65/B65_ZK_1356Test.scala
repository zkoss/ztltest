package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "Touch,Android")
class B65_ZK_1356Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<vlayout>
	<label multiline="true">
	iPad/Android Only
	1. click spinner's button to increase value.
	2. click doublespinner's button to increase value.
	3. click on "get spinner value" button, you should see a alert which shows the last the value of spinner and doublespinner.
	</label>
	<spinner id="s"/>
	<doublespinner id="d"/>
	<button label="get spinner value" onClick='alert("Spinner value : "+ s.getValue() + "\nDoublespinner value: " + d.getValue())'/>
</vlayout>
    """

    runZTL(zscript,
      () => {
        singleTap(jq(".z-spinner").toWidget().$n("btn-up"))
        waitResponse()
        singleTap(jq(".z-doublespinner").toWidget().$n("btn-up"))
        waitResponse()
        singleTap(jq(".z-button:contains(get spinner value)"))
		waitResponse()
		
        verifyTrue("you should see a alert which shows the last the value of spinner and doublespinner", jq(".z-label:contains(Spinner value : 1)").exists())
        verifyTrue("you should see a alert which shows the last the value of spinner and doublespinner", jq(".z-label:contains(Doublespinner value: 1.0)").exists())
      })

  }
}
