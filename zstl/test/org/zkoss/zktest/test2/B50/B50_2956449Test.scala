/* B50_2956449Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2956449Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
				    <zscript>
				        <![CDATA[
				            import org.zkoss.zk.ui.ext.*;
						public class TestWin extends Window implements AfterCompose {
						public void afterCompose() {
						Components.wireVariables(this, this);
						Components.addForwards(this, this);
						}
						
						public void onCtrlKey$bd(Event e) {
						ForwardEvent fe = (ForwardEvent)e;
						l.setValue(((KeyEvent)fe.getOrigin()).getKeyCode() + "");
						}
						public void onCtrlKey$tb(Event e) {
						ForwardEvent fe = (ForwardEvent)e;
						l.setValue(((KeyEvent)fe.getOrigin()).getKeyCode() + "");
						}
						}
				        ]]>
				    </zscript>
				        1.Please press UP/Down into the two textbox, you should see the UP with 38 and Down with 40.
				<separator/>
				 <label id="l"/>
				    <window title="Hello World!!" border="normal" width="200px"
				use="TestWin">
				        <textbox id="tb" ctrlKeys="^d@q#up#down"/>
				        <bandbox id="bd" autodrop="true" ctrlKeys="^d@q#up#down">
				            <bandpopup>
				                <listbox width="200px" onSelect="bd.value=self.selectedItem.label;
				bd.close();">
				                    <listitem>
				                        <listcell label="John" />
				                    </listitem>
				                    <listitem>
				                        <listcell label="Joe" />
				                    </listitem>
				                    <listitem>
				                        <listcell label="Mary" />
				                    </listitem>
				                </listbox>
				            </bandpopup>
				        </bandbox>
				    </window>
				       
				</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val l = ztl$engine.$f("l")
    val tb = ztl$engine.$f("tb")
    val bd = ztl$engine.$f("bd")
    runZTL(zscript, () => {
      focus(jq("$tb"))
      sendKeys(jq("$tb"), Keys.UP)
      waitResponse()
      verifyEquals("38", jq("$l").text())
      focus(jq("$tb"))
      sendKeys(jq("$tb"), Keys.DOWN)
      waitResponse()
      verifyEquals("40", jq("$l").text())
    })
  }
}



