/* B35_2073409Test.scala

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
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 1911129
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B35-2073409.zul,A,E,Grid,Groupfoot")
class B35_2073409Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {

      waitResponse();

      //1. Add group button
      val b1 = jq("$addgroup");
      click(b1);

      waitResponse();

      val gr1 = jq("$group1");
      val txt = getText(gr1);

      //Group1 exists
      verifyContains(txt, "Group1");

      //Click group to open
      val cl = jq("$group1").find("span");
      click(cl);

      waitResponse();

      //Verify if new rows exists in group
      val row0 = jq("$row1");
      val row1 = jq("$row2");

      verifyTrue(row0.exists());
      verifyTrue(row1.exists());

      //Verify if group open works well (rows are visible)
      verifyTrue(row0.isVisible());
      verifyTrue(row1.isVisible());

      //2. Add foot button
      val b2 = jq("$addfoot");
      click(b2);

      waitResponse();

      val foot1 = jq("$foot1");
      val txt1 = getText(foot1);

      //Foot1 exists
      verifyEquals(txt1, "footer");

    }
    );
  }
}
