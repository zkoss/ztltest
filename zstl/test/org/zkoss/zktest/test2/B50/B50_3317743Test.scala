/* B50_3317743Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Oct 12 15:00:55 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
  * A test class for bug 3317743
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3317743.zul,A,E,Listbox,Tree")
class B50_3317743Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
				<div>1. Click on item 3.</div>
				<div>2. Go to next page.</div>
				<div>3. Click on item 8, but on the blank, NOT on the checkmark.</div>
				<div>4. Go back to page 1. If item 3 is deselected, it is a bug.</div>
				<zscript><![CDATA[
					ListModelList m = new ListModelList();
					for(int i = 0; i < 20; i++)
						m.add(i);
    				m.setMultiple(true);
				]]></zscript>
				<listbox id="listbox" onClick="tb.setValue(event.getPageX().toString())" multiple="true" model="${m}" checkmark="true"
					mold="paging" onCreate="self.setPageSize(5)" />
    			<textbox id="tb" />
			</zk>
    """

    def executor = () => {
      var listbox: Widget = engine.$f("listbox");
      var tb: Widget = engine.$f("tb");
      waitResponse();

      clickAt(jq(listbox.$n("rows")).find(".z-listitem").get(3), "200,5");
      waitResponse();
      click(jq("[name=" + jq(".z-paging").attr("id") + "-next]"));
      waitResponse();
      clickAt(jq(listbox.$n("rows")).find(".z-listitem").get(3), "200,5");
      waitResponse();
      println(Integer.parseInt(tb.$n().get("value")));

      verifyTrue(Integer.parseInt(tb.$n().get("value")) > 200);

      click(jq("[name=" + jq(jq(".z-paging")).attr("id") + "-prev]"));
      waitResponse();
      verifyTrue(jq(".z-listitem:eq(3)").hasClass("z-listitem-selected"));
    }
    runZTL(zscript, executor);
  }
}