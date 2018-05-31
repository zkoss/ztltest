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
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{ClientWidget, Tags}

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00605Test extends ZTL4ScalaTestCase {
  @Test
  def testIssue() = {
    val zul = """
      <include src="/bind/issue/B00605.zul"/>
"""

    runZTL(zul, () => {
      def `type` = (n: ClientWidget, input: String) => {
    	n.toElement().set("value", "")
        sendKeys(n, input)
    	waitResponse()
    	blur(n)
      }
      
      verifyEquals("A", engine.$f("tb1").get("value"));
      verifyEquals("A", engine.$f("lb1").get("value"));
      verifyEquals("A", engine.$f("tb2").get("value"));
      verifyEquals("A", engine.$f("lb2").get("value"));
      verifyTrue(!engine.$f("tb3").exists()); // no need to wait it is not exist in init
      verifyTrue(!engine.$f("lb3").exists()); // no need to wait it is not exist in init

      `type`(engine.$f("tb1"), "JJ");
      waitResponse();
      verifyEquals("JJ", engine.$f("tb1").get("value"));
      verifyEquals("JJ", engine.$f("lb1").get("value"));
      verifyEquals("A", engine.$f("tb2").get("value"));
      verifyEquals("A", engine.$f("lb2").get("value"));

      `type`(engine.$f("tb2"), "KK");
      waitResponse();
      verifyEquals("JJ", engine.$f("tb1").get("value"));
      verifyEquals("JJ", engine.$f("lb1").get("value"));
      verifyEquals("KK", engine.$f("tb2").get("value"));
      verifyEquals("KK", engine.$f("lb2").get("value"));

      click(engine.$f("btn1"));
      waitResponse();
      verifyEquals("A", engine.$f("tb3").get("value"));
      verifyEquals("A", engine.$f("lb3").get("value"));

      `type`(engine.$f("tb3"), "LL");
      waitResponse();
      verifyEquals("JJ", engine.$f("tb1").get("value"));
      verifyEquals("JJ", engine.$f("lb1").get("value"));
      verifyEquals("KK", engine.$f("tb2").get("value"));
      verifyEquals("KK", engine.$f("lb2").get("value"));
      verifyEquals("LL", engine.$f("tb3").get("value"));
      verifyEquals("LL", engine.$f("lb3").get("value"));

      // test again since inc2 is here
      `type`(engine.$f("tb1"), "X");
      waitResponse();
      verifyEquals("X", engine.$f("tb1").get("value"));
      verifyEquals("X", engine.$f("lb1").get("value"));
      verifyEquals("KK", engine.$f("tb2").get("value"));
      verifyEquals("KK", engine.$f("lb2").get("value"));
      verifyEquals("LL", engine.$f("tb3").get("value"));
      verifyEquals("LL", engine.$f("lb3").get("value"));

      `type`(engine.$f("tb2"), "Y");
      waitResponse();
      verifyEquals("X", engine.$f("tb1").get("value"));
      verifyEquals("X", engine.$f("lb1").get("value"));
      verifyEquals("Y", engine.$f("tb2").get("value"));
      verifyEquals("Y", engine.$f("lb2").get("value"));
      verifyEquals("LL", engine.$f("tb3").get("value"));
      verifyEquals("LL", engine.$f("lb3").get("value"));

      `type`(engine.$f("tb3"), "Z");
      waitResponse();
      verifyEquals("X", engine.$f("tb1").get("value"));
      verifyEquals("X", engine.$f("lb1").get("value"));
      verifyEquals("Y", engine.$f("tb2").get("value"));
      verifyEquals("Y", engine.$f("lb2").get("value"));
      verifyEquals("Z", engine.$f("tb3").get("value"));
      verifyEquals("Z", engine.$f("lb3").get("value"));
    })
  }
}
