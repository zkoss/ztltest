/* B50_3183691Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Oct 13 11:35:28 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.unit.Widget

/**
  * A test class for bug 3183691
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3183691.zul,B,E,Listbox,onSelect")
class B50_3183691Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
			<html><![CDATA[
			<ul>
			  <li>Click the click button and you shall see a listbox being open and dropped</li>
			</ul>
			]]></html>
			
			<button id="btn" label="click" xmlns:w="client" w:onClick="var lb = zk.Widget.$(jq('@listbox'));lb.fire('onSelect');lb.fire('onSelect');"/>
			<listbox width="200px">
			<attribute name="onSelect"><![CDATA[
			div.getChildren().clear();
			Executions.createComponentsDirectly(
			"<combobox id=\"cb\" open=\"true\"><comboitem label=\"item\" forEach=\"1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1\"/></combobox>",
			"zul",div,null);
			]]></attribute>
			<listitem label="item"/>
			<listitem label="item"/>
			</listbox>
			<div id="div" />
			</zk>

    """

    def executor = () => {
      var btn: Widget = engine.$f("btn");
      waitResponse();

      click(btn);
      waitResponse();
      var cb: Widget = engine.$f("cb");
      verifyTrue(cb != null);
      verifyNotEquals("none", cb.$n("pp").get("style.display"))
    }

    runZTL(zscript, executor);

  }
}