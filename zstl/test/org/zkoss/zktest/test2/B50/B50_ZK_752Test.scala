/* B50_ZK_752Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 14 12:07:43 CST 2012 , Created by benbai
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
 * A test class for bug ZK-752
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-752.zul,A,E,Widget,Tooltiptext")
class B50_ZK_752Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
			<zk>
				<h:pre xmlns:h="html"><![CDATA[
					1.Mouse over the abc , it should show up [abc"><script></script><!--] .
					2.Click the test button 
					3.mouse over the abc , it should show up 
						[abc"><script></script><!--abc"><script></script><!--abc"><script></script><!--]
				]]></h:pre>
				<zscript><![CDATA[
					String str = "abc\"><script></script><!--";
				]]></zscript>
				<div id="div" style="color: #009900" tooltiptext="@{str}">abc</div>
				
				<button id="btn" label="Test" onClick="div.setTooltiptext(str+str+str);" /> 
				<div id="div2" style="color: #009900" tooltiptext="@{str}">def</div>
				<div id="div3" style="color: #009900" tooltiptext="@{str}">ghi</div>
				<label id="lb" />
			</zk>

    """

    def executor() = {
    	
    }
   runZTL(zscript,
        () => {
        var div: Widget = engine.$f("div");
        var btn: Widget = engine.$f("btn");
 
        verifyTrue("Title is correct",
            "abc\"><script></script><!--".equals(div.$n().get("title")));
        click(btn);
        waitResponse();
        verifyTrue("Changed title is correct",
            "abc\"><script></script><!--abc\"><script></script><!--abc\"><script></script><!--".equals(div.$n().get("title")));
    }
   );
  }
}