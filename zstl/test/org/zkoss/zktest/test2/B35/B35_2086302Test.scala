/* B35_2086302Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Nov 08 22:51:02 GFT 2011 , Created by ldnigro
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget
import org.zkoss.ztl.Element
import org.junit.Test


/**
  * A test class for bug 2086302
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B35-2086302.zul,C,E,Groupbox,Borderlayout")
class B35_2086302Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        //click open button
        if (isSafari)
          clickAt(jq("@button"), "8,8");
        else
          click(jq("$bt1"));
        waitResponse(true);

        var bl1 = jq("$bl1");
        verifyTrue(bl1.isVisible());
        var bl1h = bl1.height();
        var bl1w = bl1.width();
        verifyTrue(bl1h == 500);

        var bl2 = jq("$bl2");
        var bl2w = bl2.width();

        //Verify dimensions 25%, 25%, 50%
        var w2w = jq("$w2").width().intValue();
        verifyEquals((bl2w * .25).intValue(), w2w);

        var c2w = jq("$c2").width().intValue() + 8;
        verifyEquals((bl2w * .25).intValue(), c2w);

        var e2w = jq(jq("$bl2").find("@east").toWidget().$n("cave")).width().intValue();
        verifyEquals((bl2w * .5).intValue(), e2w);

        //Verify no border
        var bl2east = jq("$bl2").find("@east");
        verifyEquals(bl2east.css("border-top-width"), "0px");
        verifyEquals(bl2east.css("border-left-width"), "0px");
        verifyEquals(bl2east.css("border-right-width"), "0px");
        verifyEquals(bl2east.css("border-bottom-width"), "0px");

        var bl3 = jq("$bl3");
        var bl3w = bl3.width();

        //Verify dimensions 30%, 40%, 30%
        var w3w = jq("$w3").width().intValue();
        verifyEquals((bl3w * .3).intValue(), w3w);

        var c3w = jq(jq("$bl3").find("@center").toWidget().$n("cave")).width().intValue() + 8;
        verifyTolerant((bl3w * .4).intValue(), c3w + 1, 1);

        var bl3center = jq("$bl3").find(".z-center");

        //Verify border
        verifyEquals(bl3center.css("border-top-width"), "1px");
        verifyEquals(bl3center.css("border-left-width"), "1px");
        verifyEquals(bl3center.css("border-right-width"), "1px");
        verifyEquals(bl3center.css("border-bottom-width"), "1px");

        var e3w = jq("$e3").width().intValue();
        verifyTolerant((bl3w * .3).intValue(), e3w, 1);

        //Vertical dimensions

        var bl2h = bl2.height().intValue();
        var bl3h = bl3.height().intValue() + 8;

        verifyEquals(bl2h, (bl1h / 2).intValue());
        verifyEquals(bl3h, (bl1h / 2).intValue());

      }
    );
  }
}
