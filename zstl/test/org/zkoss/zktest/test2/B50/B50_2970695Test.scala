/* B50_2970695Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2970695Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<zk>
	Check only one error box appear
	<window>
		<zscript><![CDATA[
			import org.zkoss.zul.*;
			Constraint cons = new Constraint() {
				public void validate(Component comp, Object value) throws WrongValueException {
					throw new WrongValueException(comp, "You must upload an essence file");
				}
			};
			void doValidation() {
				cons.validate(button, null);
			}
		]]></zscript>
		<button id="button" label="Button" onClick="doValidation();" />
	</window>
</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val button = ztl$engine.$f("button")
    runZTL(zscript, () => {
      click(jq("$button"))
      waitResponse()
      verifyTrue(jq(".z-errorbox").length() == 1)
    })
  }
}



