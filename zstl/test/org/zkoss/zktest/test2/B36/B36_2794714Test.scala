/* B36_2794714Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2794714Test extends ZTL4ScalaTestCase {
  @Test
  def testvisible() = {
    var zscript =
      """
			<zk>
				<html><![CDATA[      
					<ul>		
						<li>Click "HIDE ALL" button</li>
						<li>You sould not see any exception</li>
					</ul>
				]]></html>
				<zscript>
				import java.util.*;
				
				List items = new org.zkoss.zktest.test2.BigList(100);	//a big list of Integer
				</zscript>
				<listbox id="listbox" mold="paging">
					<listitem forEach="&#36;{items}">
						<listcell label="&#36;{each}-1" />
						<listcell label="&#36;{each}-2" />
						<listcell label="&#36;{each}-3" />
						<listcell label="&#36;{each}-4" />
					</listitem>
				</listbox>
				<button id="btn" label="HIDE ALL">
					<attribute name="onClick"><![CDATA[
						import java.util.*;
						for (Component c: listbox.getItems()){
							c.setVisible(false);
						}
						listbox.invalidate();
					new Label("hi").setPage(page);
					]]></attribute>
				</button>
			</zk>
		"""
    val ztl$engine = engine()
    val listbox = ztl$engine.$f("listbox")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      verifyFalse(jq(".z-window-highlighted").exists())
    })
  }
}



