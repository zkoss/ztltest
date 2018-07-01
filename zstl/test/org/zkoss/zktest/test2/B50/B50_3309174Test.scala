/* B50_3309174Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Oct 13 16:37:39 CST 2011 , Created by benbai
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
  * A test class for bug 3309174
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3309174.zul,A,E,Grid,Model")
class B50_3309174Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """

			<zk>
				<html><![CDATA[
					<ol>
						<li>Click "remove 20" button.</li>
						<li>The first of item shall be "item 20"</li>
					</ol>
				]]></html>
				<window>
					<custom-attributes org.zkoss.zul.grid.rod="false" />
					<zscript><![CDATA[
						import java.util.*;
						import org.zkoss.zul.*;
						import org.zkoss.zk.ui.event.*;
						import org.zkoss.zk.ui.event.EventListener;
						List list = new ArrayList();
						for (int i = 0; i < 200; i++)
							list.add("item " + i);
						ListModelList model = new ListModelList(list);
					]]></zscript>
					<button id="btn" label="remove 20">
						<attribute name="onClick"><![CDATA[
							for (int i = 0; i < 20; i++)
								model.remove(0);
						]]></attribute>
					</button>
					<grid id="grid" model="${model}" width="100px" height="250px" />
				</window>
			</zk>

    """

    def executor = () => {
      var (btn: Widget,
      grid: Widget) = (
        engine.$f("btn"),
        engine.$f("grid")
      );
      waitResponse();

      click(btn);
      waitResponse();
      verifyContains(jq(grid.$n("body")).find(".z-row").eq(0).text(), "20")
    }

    runZTL(zscript, executor);

  }
}