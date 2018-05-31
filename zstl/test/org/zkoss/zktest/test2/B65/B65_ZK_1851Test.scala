package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1851.zul")
class B65_ZK_1851Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>
<zk>
	<vlayout>
		<span>the Spinner translated a value to NAN, this should not happen after fix</span>
		<span>1. input a value</span>
		<span>2. blur the widget (-> it will format to e.g. $1)</span>
		<span>3. increase the value again using the spinner button</span>
		<hlayout>
			Spinner <spinner format="$#,##0.##"/>
		</hlayout>
		<hlayout>
			DoubleSpinner <doublespinner step="0.5" format="$#,##0.##"/>
		</hlayout>
	</vlayout>
</zk>"""
    runZTL(zscript,
      () => {

        val doVerify = (comp: String) => {
          val spinner = jq(".z-" + comp).toWidget()
          val inp = spinner.$n("real")
          sendKeys(inp, "1")
          waitResponse()
          blur(inp)
          verifyTrue(inp.get("value") != "NaN")
          click(spinner.$n("btn-up"))
          waitResponse()
          verifyTrue(inp.get("value") != "NaN")
        }

        List("spinner", "doublespinner") foreach doVerify

      })

  }
}