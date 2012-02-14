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
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00849ConverterParametersTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = {
      <include src="/bind/issue/B00849ConverterParameters.zul"/>
    }

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

      `type`(tb1.toWidget(), "A");
      waitResponse();
      click(cmd1.toWidget());
      waitResponse();
      verifyEquals("", l11.toWidget().get("value"));
      verifyEquals("", l12.toWidget().get("value"));
      verifyEquals("A:value1", tb1.toWidget().get("value"));

      `type`(tb2.toWidget(), "B");
      waitResponse();
      click(cmd2.toWidget());
      waitResponse();
      verifyEquals("", l21.toWidget().get("value"));
      verifyEquals("", l22.toWidget().get("value"));
      verifyEquals("B:value2", tb2.toWidget().get("value"));

      `type`(tb3.toWidget(), "C");
      waitResponse();
      click(cmd3.toWidget());
      waitResponse();
      verifyEquals("", l31.toWidget().get("value"));
      verifyEquals("", l32.toWidget().get("value"));
      verifyEquals("C:value3", tb3.toWidget().get("value"));

    })
  }
}