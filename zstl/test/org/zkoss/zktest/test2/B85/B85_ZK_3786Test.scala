/* B85_ZK_3786Test.scala

	Purpose:

	Description:

	History:
		Wed, Nov 1, 2017 12:33:17 PM, Created by bobpeng

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{JQuery, Tags, Widget};

/**
  *
  * @author bobpeng
  */
@Tags(tags = "")
class B85_ZK_3786Test extends ZTL4ScalaTestCase {
  @Test
  def test1() = {
    runZTL(() => {
      var tree = engine.$f("tree");
      var body = jq(tree.$n("body"));
      var table = body.find("table");
      click(jq("@button[label=\"add under bottom\"]"));
      waitResponse();
      var scrollTop = getScrollTop(tree);
      verifyTolerant(215, scrollTop, 10);
      click(jq("@button[label=\"add under bottom\"]"));
      waitResponse();
      scrollTop = getScrollTop(tree);
      verifyTolerant(260, scrollTop, 10);
      click(jq("@button[label=\"add upon top\"]"));
      waitResponse();
      click(jq("@button[label=\"add upon top\"]"));
      waitResponse();
      verifyEquals(0, getScrollTop(tree));
    })
  }
}
