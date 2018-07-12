/* B35_2078163Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B35_2078163Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>c
<vbox>
<label value='1.click "set spinner constraint" button'/>
<label value="2.click button of spinner"/>
<label value="3.the number will be increased or decreased by 2 or it is not correct!"/>
</vbox>
<window title="Spinner test" border="normal">
<spinner id="sp"/>
<separator />
<button label="set spinner constraint">
<attribute name="onClick">
sp.setValue(new Integer(1));
sp.setStep(2);
sp.setConstraint("min -10 max 10");
</attribute>
</button>
</window>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val sp = ztl$engine.$f("sp")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      click(jq(".z-spinner").toWidget().$n("btn-up"))
      waitResponse()
      verifyEquals(3, jq(".z-spinner").toWidget().$n("real").attr("value"))
    })
  }
}



