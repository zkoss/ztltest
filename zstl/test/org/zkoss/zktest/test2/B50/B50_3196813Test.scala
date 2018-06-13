/* B50_3196813Test.java

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
import org.zkoss.ztl.unit.Widget


class B50_3196813Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
You shouldn't see any Javascript error after the page is ready.
<separator/>
<zscript><![CDATA[
Constraint YearCons = new Constraint() {
public void validate(Component comp, Object value)throws WrongValueException {
}
};
]]></zscript>
<spinner constraint="${YearCons}"/>
<doublespinner constraint="${YearCons}"/>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyFalse(jq(".z-error").exists())
    })
  }
}



