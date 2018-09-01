/* B50_3284663Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3284663Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	<html><![CDATA[
		<ol>
			<li>Click on the Radio. The messagebox should NOT be shown. Otherwise it is a bug.</li>
			<li>Click on the Button. A messagebox should popup. Otherwise it is a bug.</li>
		</ol>
	]]></html>
	<zscript><![CDATA[
		import org.zkoss.zk.au.*;
		AuService as = new AuService() {
			public boolean service(AuRequest request, boolean everError) {
				if("onCheck".equals(request.getCommand()))
					Messagebox.show("AuService: onCheck");
				return false;
			}
		};
	]]></zscript>
	<radiogroup>
		<radio id="r1" label="A" checked="false" auService="${as}" />
	</radiogroup>
	<button label="Save" onClick="" />
</zk>

		"""
    val ztl$engine = engine()
    val r1 = ztl$engine.$f("r1")
    runZTL(zscript, () => {
      click(r1.$n("real"))
      waitResponse()
      verifyFalse(jq("@window[title=\"ZK Test\"]").exists())
      click(jq("@button"))
      waitResponse()
      verifyEquals("AuService: onCheck", getAlertMessage())
    })
  }
}



