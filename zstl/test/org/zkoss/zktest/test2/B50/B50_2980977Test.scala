/* B50_2980977Test.java

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
import org.zkoss.ztl.unit.Widget


class B50_2980977Test extends ZTL4ScalaTestCase {
  @Test
  def testSetspan() = {
    var zscript =
      """
			<zk>
			<grid>
			<rows>
			<row>
			<label value="File:"/>
			<textbox width="98%"/>
			</row>
			<row id="row">
			<label value="File:"/>
			<textbox width="98%"/>
			</row>
			<row>
			<label value="Options:"/>
			<textbox rows="3" width="98%"/>
			</row>
			</rows>
			</grid>
			<button id="btn" label="Click Me you should see the stripe still exists."
			onClick='row.setSpans("1,1")'/>
			<button id="btn2" label="Click Me you should see the stripe still exists."
			onClick='row.setClass("abc")'/>
			</zk>
		 """
    val ztl$engine = engine()
    val row = ztl$engine.$f("row")
    val btn = ztl$engine.$f("btn")
    val btn2 = ztl$engine.$f("btn2")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      verifyTrue(jq(row).hasClass("z-row z-grid-odd"))
      click(btn2)
      waitResponse()
      verifyTrue(jq(row).hasClass("z-row z-grid-odd"))
    })
  }
}



