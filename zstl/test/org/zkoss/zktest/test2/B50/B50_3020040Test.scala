/* B50_3020040Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Oct 13 14:49:57 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{Element, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 3020040
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3020040.zul,A,E,Listbox")
class B50_3020040Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
			<html><![CDATA[
			<ul>
			<li>Click "Unselect first", and then "item 2" and "item 3" shall remain selected</li>
			</ul>
			]]></html>
			
			<listbox id="box" multiple="true" checkmark="true">
			<listhead>
			<listheader label="Index"/>
			</listhead>
			<listitem label="item 1" selected="true"/>
			<listitem label="item 2" selected="true"/>
			<listitem label="item 3" selected="true"/>
			</listbox>
			<button id="btn" label="Unselect first" onClick="box.removeItemFromSelection(box.getItemAtIndex(0))"/>
			</zk>

    """
    runZTL(zscript, () => {
      var (btn: Widget,
      box: Widget) = (
        engine.$f("btn"),
        engine.$f("box")
      );
      waitResponse();

      click(btn);
      waitResponse();
      verifyContains(jq(box.$n("rows")).find(".z-listitem").get(1).get("className"), "z-listitem-selected")
      verifyContains(jq(box.$n("rows")).find(".z-listitem").get(2).get("className"), "z-listitem-selected")
    })
  }
}