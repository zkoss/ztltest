/* B30_1876198Test.java

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


class B30_1876198Test extends ZTL4ScalaTestCase {
  @Test
  def testValidation() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?> 
			<window>
			<html><![CDATA[
			<p>1. If you see a textbox and no any input error message appears ,that means this case works . </p>
			<p>2. When you click the textbox and click outside of textbox ,it will shows the input is not corret.</p>
			]]></html>
			<zscript>
			public class MyConstraint extends SimpleConstraint implements CustomConstraint {
				public MyConstraint() {
					super(NO_EMPTY);
				}
				public void showCustomError(Component comp, WrongValueException ex) {
					comp.getFellow("errlb").setValue(ex.getMessage());
				}
			}
			MyConstraint ms = new MyConstraint();
			</zscript>
			<textbox id="txtbox" value="@{val}" constraint="${ms}"/>
			<label id="errlb"/>
			</window> 
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val txtbox = ztl$engine.$f("txtbox")
    val errlb = ztl$engine.$f("errlb")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      focus(txtbox)
      blur(txtbox)
      waitResponse()
      verifyTrue(jq(errlb).text().length() > 0)
    })
  }
}



