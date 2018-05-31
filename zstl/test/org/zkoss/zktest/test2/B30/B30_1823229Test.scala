/* B30_1823229Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1823229Test extends ZTL4ScalaTestCase {
  @Test
  def testStyle() = {
    var zscript =
      """
			<zk>
				Splitter- The image of bar isn't updated, when dynamically call setCollapse method.
				<window border="normal" width="800px" title="Case 1: hbox and splitter">
						<hbox height="100px" width="100%">
						cdacdacdacdacdaca
						<splitter id="hsplitter" collapse="none"/>
						cdacdacdacdacacsdc
						</hbox>
						<label id="d" />
						<radiogroup>
							<attribute name="onCheck">
								hsplitter.setCollapse(self.selectedItem.label);
								d.setValue("Collapse: "+self.selectedItem.label);
							</attribute>
							<radio id="r1" selected="true" label="none"/>
							<radio id="r2" label="before"/>
							<radio id="r3" label="after"/>
						</radiogroup>
				</window>
			</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val hsplitter = ztl$engine.$f("hsplitter")
    val d = ztl$engine.$f("d")
    val r1 = ztl$engine.$f("r1")
    val r2 = ztl$engine.$f("r2")
    val r3 = ztl$engine.$f("r3")
    runZTL(zscript, () => {
      verifyFalse(isVisible(hsplitter.$n("icon")))
      click(r2.$n("real"))
      waitResponse()
      verifyTrue(isVisible(hsplitter.$n("icon")))
      verifyTrue(jq(hsplitter.$n("icon")).hasClass("z-icon-caret-left"))
      click(r3.$n("real"))
      waitResponse()
      verifyTrue(isVisible(hsplitter.$n("icon")))
      verifyFalse(jq(hsplitter.$n("icon")).hasClass("z-icon-caret-left"))
      verifyTrue(jq(hsplitter.$n("icon")).hasClass("z-icon-caret-right"))
      click(r1.$n("real"))
      waitResponse()
      verifyFalse(isVisible(hsplitter.$n("icon")))
    })
  }
}



