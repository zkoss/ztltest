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
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.{ClientWidget, Element, Widget}

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
    runZTL(() => {
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
      verScroll(pp, parseInt(jq(lastItem).get(0).attr("offsetTop")));
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