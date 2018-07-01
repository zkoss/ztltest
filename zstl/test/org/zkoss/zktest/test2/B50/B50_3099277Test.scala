/* B50_3099277Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Oct 13 14:10:07 CST 2011 , Created by benbai
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
  * A test class for bug 3099277
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3099277.zul,A,E,Listbox")
class B50_3099277Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """

			<zk>
				You shall see "value 1" on the right bottom corner after click the button.
				<separator/>
				<listbox name="listbox" mold="select">
					<listitem label="item1" value="value 1"/>
				</listbox>
				<button id="btn" label="click" xmlns:w="client">
					<attribute w:name="onClick"><![CDATA[
						zk.log(this.previousSibling.firstChild.$n().value);
					
					]]></attribute>
				</button>
			</zk>

    """

    def executor = () => {
      var btn: Widget = engine.$f("btn");
      click(btn);
      sleep(500)
      verifyContains(jq(".z-log").find("textarea").get(0).get("value"), "value 1")
    }

    runZTL(zscript, executor);

  }
}