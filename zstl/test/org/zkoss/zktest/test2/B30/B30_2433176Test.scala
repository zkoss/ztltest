/* B30_2433176Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_2433176Test extends ZTL4ScalaTestCase {
  @Test
  def testBinding() = {
    var zscript =
      """
			<window id="window">
				Please click the "Bind" button, and then check a radio box, you should see a dialog as its label
			    <radiogroup id="rb" onCheck='alert(self.selectedItem.label);'/>
			    <button id="save" label="Bind" width="70px" >
			    	<attribute name="onClick"><![CDATA[ 
			    		Vbox vb = new Vbox();
			    		for (int i =0; i < 5; i++) {
			    			new Radio("Radio " + i).setParent(vb);
			    		}
			    		vb.setParent(rb);
			    		 ]]></attribute>
			    </button>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val window = ztl$engine.$f("window")
    val rb = ztl$engine.$f("rb")
    val save = ztl$engine.$f("save")
    runZTL(zscript, () => {
      click(save)
      waitResponse()
      for (i <- 0 until 5) {
        click(jq(".z-radio input:eq(" + i + ")"))
        waitResponse()
        verifyEquals("Radio " + i, jq(".z-messagebox > span.z-label:eq(0)").text())
        click(jq("@button.z-button:eq(1)"))
        waitResponse()
      }
    })
  }
}



