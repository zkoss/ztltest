/* B30_1882323Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Nov 15, 2011 12:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B30-1882323.zul,B,E,Window,Button")
class B30_1882323Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTL(() => {
      // Selects the intbox
      click(jq(".z-intbox").get(0));
      waitResponse();

      // Press the HOME key
      sendKeys(jq(".z-intbox").toElement(), Keys.HOME);
      waitResponse();
      // The cursor must be in the first position
      verifyTrue(zk(jq("@intbox")).eval("getSelectionRange()[0]").toInt == 0);

      // Press the RIGHT key
      sendKeys(jq(".z-intbox").toElement(), Keys.RIGHT);
      waitResponse();

      // The cursor must be in the second position
      verifyTrue(zk(jq("@intbox")).eval("getSelectionRange()[0]").toInt.toInt == 1);

      // Press the RIGHT key
      sendKeys(jq(".z-intbox").toElement(), Keys.RIGHT);
      waitResponse();

      // The cursor must be in the third position
      verifyTrue(zk(jq("@intbox")).eval("getSelectionRange()[0]").toInt == 2);

      // Press the LEFT key
      sendKeys(jq(".z-intbox").toElement(), Keys.LEFT);
      waitResponse();

      // The cursor must be in the second position
      verifyTrue(zk(jq("@intbox")).eval("getSelectionRange()[0]").toInt == 1);

      // Press the HOME key
      sendKeys(jq(".z-intbox").toElement(), Keys.HOME);
      waitResponse();
      // The cursor must be in the first position
      verifyTrue(zk(jq("@intbox")).eval("getSelectionRange()[0]").toInt == 0);

      // Press the RIGHT key
      sendKeys(jq(".z-intbox").toElement(), Keys.RIGHT);
      waitResponse();
      // Press the RIGHT key
      sendKeys(jq(".z-intbox").toElement(), Keys.RIGHT);
      waitResponse();
      // Press the DEL key
      sendKeys(jq(".z-intbox").toElement(), Keys.DELETE);
      waitResponse();
      // The cursor must be in the first position
      verifyTrue(zk(jq("@intbox")).eval("getSelectionRange()[0]").toInt == 2);

      // Press the END key
      sendKeys(jq(".z-intbox").toElement(), Keys.END);
      waitResponse();
      // The cursor must be in the last position (5-1 deleted)
      verifyTrue(zk(jq("@intbox")).eval("getSelectionRange()[0]").toInt == 4);

    })
  }
}