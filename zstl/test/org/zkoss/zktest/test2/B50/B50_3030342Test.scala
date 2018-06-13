/* B50_3030342Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Oct 13 14:36:27 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
  * A test class for bug 3030342
  *
  * @author benbai
  *
  */
@Tags(tags = "##Out of Date##B50-3030342.zul,A,E,Listbox,ROD")
class B50_3030342Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
			<html>
			<![CDATA[
			<ol>
				<li>Check "David", "Thomas" and "Steven" in the listbox</li>
			</ol>
			]]>
			</html>
				<listbox id="listbox" width="100px">
					<attribute name="onCreate"><![CDATA[
						List list = new ArrayList();
						list.add("David");
						list.add("Thomas");
						list.add("Steven");
						
						listbox.setModel(new ListModelList(list));
					]]></attribute>
				</listbox>
			</zk>

    """

    def executor = () => {
      var listbox: Widget = engine.$f("listbox");
      waitResponse();

      verifyTrue(jq(listbox.$n("rows")).find(".z-listcell").eq(0).text().contains("David"));
      verifyTrue(jq(listbox.$n("rows")).find(".z-listcell").eq(1).text().contains("Thomas"));
      verifyTrue(jq(listbox.$n("rows")).find(".z-listcell").eq(2).text().contains("Steven"));
    }

    runZTL(zscript, executor);
  }
}