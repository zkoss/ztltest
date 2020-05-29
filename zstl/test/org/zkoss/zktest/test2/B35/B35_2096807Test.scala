/* B35_2096807Test.scala

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
import org.zkoss.ztl.annotation.Tags


/**
  * A test class for bug 2096807
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B35-2096807.zul,A,E,Borderlayout,Paging")
class B35_2096807Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
        waitResponse();
        var next = jq("@paging").find(".z-paging-next")
        //Previous disabled in first page
        var first = jq("@paging").find(".z-paging-first")
        var last = jq("@paging").find(".z-paging-last")
        var prev = jq("@paging").find(".z-paging-previous")

        //Verify disabled and enabled pagging buttons
        var n = next.exists();
        verifyTrue(n);
        verifyContains("undefined", next.attr("disabled"))

        var l = last.exists();
        verifyTrue(l);
        verifyContains("undefined", last.attr("disabled"))

        //first & prev are disabled
        verifyNotEquals("", first.attr("disabled"))

        verifyNotEquals("", prev.attr("disabled"))

        //click next button
        click(next);
        waitResponse();

        //Verify all pagging enabled
        verifyContains("undefined", next.attr("disabled"))
        verifyTrue(next.exists());

        verifyContains("undefined", last.attr("disabled"))
        verifyTrue(last.exists());

        verifyContains("undefined", first.attr("disabled"))
        verifyTrue(first.exists());

        verifyContains("undefined", prev.attr("disabled"))
        verifyTrue(prev.exists());

        click(last);
        waitResponse();

        //Verify last & next disabled
        verifyNotEquals("", next.attr("disabled"))
        verifyNotEquals("", last.attr("disabled"))

        verifyContains("undefined", first.attr("disabled"))
        verifyTrue(first.exists());

        verifyContains("undefined", prev.attr("disabled"))
        verifyTrue(prev.exists());

      }
    );
  }
}
