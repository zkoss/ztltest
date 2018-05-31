/* B50_2870663Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2870663Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
			<vbox>
			<html><![CDATA[
			<p>No value doublebox/decimalbox shall show empty; NOT 'null'.
			<ol>
			<li>You shall see two input box. 1st is a doublebox. 2nd is a decimalbox.</li>
			<li>If you see nothing inside the two input boxes, then it is OK. Otherwise, it is a bug.</li>
			</ol>
			]]></html>
			<hbox>doublebox: <doublebox/></hbox>
			<hbox>decimalbox: <decimalbox/></hbox>
			</vbox>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyEquals("", getValue(jq("@doublebox")))
      verifyEquals("", getValue(jq("@decimalbox")))
    })
  }
}



