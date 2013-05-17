/* B50_3306149Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Oct 12 17:08:16 CST 2011 , Created by benbai
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
 * A test class for bug 3306149
 * @author benbai
 *
 */
@Tags(tags = "B50-3306149.zul,A,E,Grid,Listbox,Model,ROD")
class B50_3306149Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<html><![CDATA[
					<ol>
						<li>Scroll to the end of grid.</li>
						<li>Click "delete" button of the latest row.</li>
						<li>The latest row shall be remove.</li>
					</ol>
				]]></html>
				<zscript><![CDATA[
					import java.util.*;
					import org.zkoss.zul.*;
					import org.zkoss.zk.ui.event.*;
					import org.zkoss.zk.ui.event.EventListener;
					List list = new ArrayList();
					for (int i = 0; i < 200; i++)
						list.add("remove " + i);
					ListModelList model = new ListModelList(list);
					RowRenderer renderer = new RowRenderer() {
						public void render(Row row, Object data, int index) throws Exception {
							Button btn = new Button(String.valueOf(data));
							btn.addEventListener(Events.ON_CLICK, new EventListener() {
								public void onEvent(Event arg0) throws Exception {
									((ListModelList) row.getGrid().getModel()).remove(data);
								}
							});
							row.appendChild(btn);
						}
					};
				]]></zscript>
				<grid id="grid" rowRenderer="${renderer}" model="${model}" width="300px"
					height="250px" />
			</zk>

    }

    def executor = () => {
    	var grid: Widget = engine.$f("grid");
		waitResponse();
		jq(grid.$n("body")).get(0).eval("scrollTop = 7550");
		waitResponse();
		if (ZK.is("ie9")) {
			jq(grid.$n("body")).get(0).eval("scrollTop = 7550");
			waitResponse();
		}
		var st1: Int = Integer.parseInt(jq(grid.$n("body")).get(0).get("scrollTop"));
		var btns = jq(grid.$n("body")).find(".z-button");
		var lastBtn = btns.last();
		waitResponse();
		click(lastBtn);
		waitResponse();
		var st2: Int = Integer.parseInt(jq(grid.$n("body")).get(0).get("scrollTop"));
		verifyTrue(st2 < st1);
		btns = jq(grid.$n("body")).find(".z-button");
		lastBtn = btns.last();
		verifyTrue(lastBtn.get(0).get("innerHTML").contains("remove 198"))
    }
   // Run syntax 1 
   runZTL(zscript, executor);
  }
}