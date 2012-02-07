/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.basic
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZKSeleneseTestCase
import org.openqa.selenium.Keys
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_LoadSaveFormTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { // 
      <include src="/bind/basic/load-save-form.zul"/>
    }

    runZTL(zul, () => {
      `type`(jq("$t21").toWidget(), "X");
      waitResponse();
      verifyEquals("A", jq("$l11").toWidget().get("value"));
      verifyEquals("B", jq("$l12").toWidget().get("value"));
      verifyEquals("C", jq("$l13").toWidget().get("value"));
      verifyEquals("A", jq("$l14").toWidget().get("value"));
      verifyEquals("B", jq("$l15").toWidget().get("value"));
      verifyEquals("C", jq("$l16").toWidget().get("value"));
      click(jq("$btn1").toWidget());
      waitResponse();
      verifyEquals("A", jq("$l11").toWidget().get("value"));
      verifyEquals("X", jq("$l12").toWidget().get("value"));
      verifyEquals("C", jq("$l13").toWidget().get("value"));
      verifyEquals("A", jq("$l14").toWidget().get("value"));
      verifyEquals("X", jq("$l15").toWidget().get("value"));
      verifyEquals("X", jq("$l16").toWidget().get("value"));
      `type`(jq("$t21").toWidget(), "Y");
      waitResponse();
      verifyEquals("A", jq("$l11").toWidget().get("value"));
      verifyEquals("X", jq("$l12").toWidget().get("value"));
      verifyEquals("C", jq("$l13").toWidget().get("value"));
      verifyEquals("A", jq("$l14").toWidget().get("value"));
      verifyEquals("X", jq("$l15").toWidget().get("value"));
      verifyEquals("X", jq("$l16").toWidget().get("value"));
      click(jq("$btn2").toWidget());
      waitResponse();
      verifyEquals("A", jq("$l11").toWidget().get("value"));
      verifyEquals("X", jq("$l12").toWidget().get("value"));
      verifyEquals("Y", jq("$l13").toWidget().get("value"));
      verifyEquals("A", jq("$l14").toWidget().get("value"));
      verifyEquals("X", jq("$l15").toWidget().get("value"));
      verifyEquals("Y", jq("$l16").toWidget().get("value"));
      `type`(jq("$t21").toWidget(), "Z");
      waitResponse();
      verifyEquals("A", jq("$l11").toWidget().get("value"));
      verifyEquals("X", jq("$l12").toWidget().get("value"));
      verifyEquals("Y", jq("$l13").toWidget().get("value"));
      verifyEquals("A", jq("$l14").toWidget().get("value"));
      verifyEquals("X", jq("$l15").toWidget().get("value"));
      verifyEquals("Y", jq("$l16").toWidget().get("value"));
      click(jq("$btn3"));
      waitResponse();
      verifyEquals("A", jq("$l11").toWidget().get("value"));
      verifyEquals("X", jq("$l12").toWidget().get("value"));
      verifyEquals("Z", jq("$l13").toWidget().get("value"));
      verifyEquals("A", jq("$l14").toWidget().get("value"));
      verifyEquals("X", jq("$l15").toWidget().get("value"));
      verifyEquals("Z", jq("$l16").toWidget().get("value"));
    })
  }
}

