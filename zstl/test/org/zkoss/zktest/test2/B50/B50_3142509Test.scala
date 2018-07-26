/* B50_3142509Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Oct 13 12:22:25 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl.annotation.Tags
/**
  * A test class for bug 3142509
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3142509.zul,A,E,Listbox,Select")
class B50_3142509Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """

			<zk>
				<listbox mold="select" id="list">
					<listhead/>
					<listitem label="item1"/>
					<listitem label="item2" selected="true"/>
					<listitem label="item3"/>
					<listitem label="item4"/>
				</listbox>
				<button id="btn" label="Please click to select item 4, if item 3 that's bug" onClick="list.selectedIndex=3"/>
			</zk>
			

    """

    def executor = () => {
      var btn: Widget = engine.$f("btn")
      var list: Widget = engine.$f("list")
      waitResponse();
      click(btn);
      waitResponse();
      verifyEquals("item4", list.$n().attr("value"))
    }

    runZTL(zscript, executor);

  }
}