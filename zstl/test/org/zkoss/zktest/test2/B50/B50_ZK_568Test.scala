/* B50_ZK_568Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Nov 30 16:49:26 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{ClientWidget, Element, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-568
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-568.zul,B,E,Combobox,Select")
class B50_ZK_568Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
			<div>1. Open combobox then select item50.</div>
			<div>2. Open combobox again, you should see item50 in drop down list without scroll.</div>
			<div>3. Click 'select item15' button.</div>
			<div>4. Open combobox, you should see item15 in drop down list without scroll.</div>
			<div></div>
				<zscript>
					<![CDATA[
						String[] name = new String[50];
						for(int i=0, len=name.length; i<len; i++) {
							name[i] = "name" + (i+1);
						}
						ListModelList lm = new ListModelList(name);
					]]>
				</zscript>
				<combobox id="box" width="150px" mold="rounded" model="${lm}" />
			
				<button id="btn" label="select item15">
					<attribute name="onClick">
						box.setSelectedIndex(14);
					</attribute>
				</button>
			</zk>

    """
    runZTL(zscript, () => {
      var box: Widget = engine.$f("box");
      var boxBtn: Element = box.$n("btn");
      var btn: Widget = engine.$f("btn");
      var pp: Element = box.$n("pp");
      var item15: Element = jq(pp).find(".z-comboitem").get(14);
      var lastItem: Element = jq(pp).find(".z-comboitem").get(49);

      def clickAndWait = (target: ClientWidget) => {
        clickAt(target, "5,5");
        waitResponse();
      }

      clickAndWait(boxBtn);
      verScroll(pp, jq(lastItem).get(0).attr("offsetTop"));
      clickAndWait(lastItem);
      clickAndWait(boxBtn);

      var top: Integer = parseInt(pp.attr("scrollTop"));
      var offset: Integer = parseInt(jq(lastItem).get(0).attr("offsetTop"));
      var bottom: Integer = parseInt(pp.attr("scrollTop")) + jq(pp).height();

      verifyTrue("the last item should in view of drop down list",
        (offset >= top && offset <= bottom));
      clickAndWait(btn);
      clickAndWait(boxBtn);

      top = parseInt(pp.attr("scrollTop"));
      offset = parseInt(jq(item15).get(0).attr("offsetTop")) + 4;
      bottom = parseInt(pp.attr("scrollTop")) + jq(pp).height();

      verifyTrue("item 15 should in view of drop down list",
        (offset >= top && offset <= bottom));
    })
  }
}