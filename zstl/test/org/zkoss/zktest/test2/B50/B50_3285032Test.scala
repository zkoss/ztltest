/* B50_3285032Test.java

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


class B50_3285032Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	<html><![CDATA[
		<ol>
			<li>Press the button, if an error is shown, it is a bug.</li>
		</ol>
	]]></html>
	<grid>
		<frozen id="f" columns="3" />
		<columns>
			<column label="1" />
			<column label="2" />
			<column label="3" />
			<column label="4" />
			<column label="5" />
		</columns>
		<rows>
			<row>
				<div>1</div>
				<div>2</div>
				<div>3</div>
				<div>4</div>
				<div>5</div>
			</row>
		</rows>
	</grid>
	<button label="Go" onClick='lb.value = "" + f.start' />
	<label id="lb" />
</zk>

		"""
    val ztl$engine = engine()
    val f = ztl$engine.$f("f")
    val lb = ztl$engine.$f("lb")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyFalse(jq("@window").exists())
      verifyFalse(jq(".z-error").exists())
    })
  }
}



