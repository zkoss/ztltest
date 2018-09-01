/* B50_ZK_440Test.java

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


class B50_ZK_440Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk>
				<div>Click on "Add Item". There should be no javascript error.</div>
				<button id="btn" label="Add Item">
					<attribute name="onClick"><![CDATA[
						Listitem item = new Listitem("item");
						lb.appendChild(item);
						item.setSelected(true);
					]]></attribute>
				</button>
				<bandbox>
					<bandpopup>
						<listbox id="lb" />
					</bandpopup>
				</bandbox>
			</zk>

		"""
    val ztl$engine = engine()
    val btn = ztl$engine.$f("btn")
    val lb = ztl$engine.$f("lb")
    runZTL(zscript, () => {
      click(btn)
      waitResponse();
      verifyFalse(jq(".z-error").exists())
    })
  }
}



