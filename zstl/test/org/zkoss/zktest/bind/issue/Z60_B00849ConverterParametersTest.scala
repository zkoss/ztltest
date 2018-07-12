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
package org.zkoss.zktest.bind.issue
import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00849ConverterParametersTest extends ZTL4ScalaTestCase {

  @Test
  def testArg() = {
    val zul = """
      <include src="/bind/issue/B00849ConverterParameters.zul"/>
"""

    runZTL(zul, () => {

      var l11 = jq("$l11");
      var l12 = jq("$l12");
      var tb1 = jq("$tb1");

      var l21 = jq("$l21");
      var l22 = jq("$l22");
      var tb2 = jq("$tb2");

      var l31 = jq("$l31");
      var l32 = jq("$l32");
      var tb3 = jq("$tb3");

      var cmd1 = jq("$btn1");
      var cmd2 = jq("$btn2");
      var cmd3 = jq("$btn3");

      tb1.toElement().set("value", "")
      sendKeys(tb1.toWidget(), "A" + Keys.TAB);
      waitResponse();
      click(cmd1.toWidget());
      waitResponse();
      verifyEquals("", l11.toWidget().attr("value"));
      verifyEquals("", l12.toWidget().attr("value"));
      verifyEquals("A:value1", tb1.toWidget().attr("value"));

      tb2.toElement().set("value", "")
      sendKeys(tb2.toWidget(), "B" + Keys.TAB);
      waitResponse();
      click(cmd2.toWidget());
      waitResponse();
      verifyEquals("", l21.toWidget().attr("value"));
      verifyEquals("", l22.toWidget().attr("value"));
      verifyEquals("B:value2", tb2.toWidget().attr("value"));

      tb3.toElement().set("value", "")
      sendKeys(tb3.toWidget(), "C" + Keys.TAB);
      waitResponse();
      click(cmd3.toWidget());
      waitResponse();
      verifyEquals("", l31.toWidget().attr("value"));
      verifyEquals("", l32.toWidget().attr("value"));
      verifyEquals("C:value3", tb3.toWidget().attr("value"));

    })
  }
}