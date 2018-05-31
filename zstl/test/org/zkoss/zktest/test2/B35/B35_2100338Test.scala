/* B35_2100338Test.scala

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

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * A test class for bug 2100338
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B35-2100338.zul")
class B35_2100338Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(
      () => {
        waitResponse();
        val lm1 = jq("$lm1");
        val lm2 = jq("$lm2");
        val gm1 = jq("$gm1");
        val gm2 = jq("$gm2");

        val lm_last = jq("[name=" + jq("$lb1").find(".z-paging").attr("id") + "-last]");
        val gm_last = jq("[name=" + jq("$gd1").find(".z-paging").attr("id") + "-last]");

        //1 - click List Model 1
        click(lm1);
        waitResponse();

        //click List Model 2
        click(lm2);
        waitResponse();

        //Verify no error
        verifyFalse(jq(".z-messagebox-error").exists());
        verifyFalse(jq(".z-error").exists());

        //Label change
        var a = jq(".z-listcell");
        for (i <- 0 until a.length()) {
          var vl = a.eq(i).text();
          // should see the first 10 elements of model 2
          verifyEquals(vl, "B option " + i);
        }

        //2 - goto last page
        click(lm_last);
        waitResponse();

        //click List Model 1 button
        click(lm1);
        waitResponse();

        //Verify no error
        verifyFalse(jq(".z-messagebox-error").exists());
        verifyFalse(jq(".z-error").exists());

        //Label change 
        a = jq(".z-listcell");
        for (i <- 0 until a.length()) {
          var vl = a.eq(i).text();
          // should see the element 0 ~ 9 of model 2
          verifyEquals(vl, "A option " + i);
        }

        //click List Model 2 button
        click(lm2);
        waitResponse();

        //Verify no error
        verifyFalse(jq(".z-messagebox-error").exists());
        verifyFalse(jq(".z-error").exists());

        //Label change
        a = jq(".z-listcell");
        for (i <- 0 until a.length()) {
          var i1 = i + 60;
          var vl = a.eq(i).text();
          // should see the element 60 ~ 64 of model 2
          verifyEquals(vl, "B option " + i1);
        }

        //3 - click Grid Model 1
        click(gm1);
        waitResponse();

        //click Grid Model 2
        click(gm2);
        waitResponse();

        //Verify no error
        verifyFalse(jq(".z-messagebox-error").exists());
        verifyFalse(jq(".z-error").exists());

        //Label change
        var b = jq(".z-row .z-label");
        for (i <- 0 until b.length()) {
          var i1 = i + 60;
          var vl = getText(b.eq(i));
          var v1 = ("B option " + i1);
          // should see element 60 ~ 64 of model 2
          verifyEquals(vl, v1);
        }

        //4 - goto last page
        click(gm_last);
        waitResponse();

        //click Grid Model 1 button
        click(gm1);
        waitResponse();

        //Verify no error
        verifyFalse(jq(".z-messagebox-error").exists());
        verifyFalse(jq(".z-error").exists());

        //Label change 
        b = jq(".z-row .z-label");
        for (i <- 0 until b.length()) {
          var vl = getText(b.eq(i));
          // should see element 0 ~ 9 of model 1
          verifyEquals(vl, "A option " + i);
        }

        //click Grid Model 2 button
        click(gm2);
        waitResponse();

        //Verify no error
        verifyFalse(jq(".z-messagebox-error").exists());
        verifyFalse(jq(".z-error").exists());

        //Label change
        b = jq(".z-row .z-label");
        for (i <- 0 until b.length()) {
          var i1 = i + 60;
          var vl = getText(b.eq(i));
          // should see element 60 ~ 64 of model 2
          verifyEquals(vl, "B option " + i1);
        }
      });
  }
}
