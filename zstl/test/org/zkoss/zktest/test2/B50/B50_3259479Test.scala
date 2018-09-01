/* B50_3259479Test.java

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


class B50_3259479Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	<html><![CDATA[
	<ul>
		<li>You shall see HelloZK below.</li>
	</ul>
	]]></html>
	<zscript>
	List list = new ArrayList();
	list.add("Hello");
	list.add("ZK");
	</zscript>
	<div>
		<label forEach="${list}">
			<zscript>
			self.setValue(each);
			</zscript>
		</label>
	</div>
</zk>

		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      verifyEquals("HelloZK", jq("@label").text())
    })
  }
}



