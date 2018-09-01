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

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_VmInitTest extends ZTL4ScalaTestCase {
  def testBasic() = {
    val zul = """
      <include src="/bind/basic/vm-init.zul"/>
"""

    runZTL(zul, () => {
      val vm1_l1 = engine.$f("vm1_l1")
      val vm1_t1 = engine.$f("vm1_t1")
      val vm1_l2 = engine.$f("vm1_l2")
      val vm1_l3 = engine.$f("vm1_l3")

      verifyEquals("AA", getText(vm1_l1));
      verifyEquals("V1-AA", getValue(vm1_t1));
      verifyEquals("V1-AA", getText(vm1_l2));
      verifyEquals("V2", getText(vm1_l3));

      `type`(vm1_t1, "OO")
      sendKeys(vm1_t1, Keys.TAB)
      waitResponse()
      verifyEquals("OO-AA", getValue(vm1_t1));
      verifyEquals("OO-AA", getText(vm1_l2));
      verifyEquals("V2", getText(vm1_l3));


      click(engine.$f("vm1_btn"))
      waitResponse()
      verifyEquals("OO-AA", getValue(vm1_t1));
      verifyEquals("OO-AA", getText(vm1_l2));
      verifyEquals("do command1 AA", getText(vm1_l3));

      val vm2_l1 = engine.$f("vm2_l1")
      val vm2_t1 = engine.$f("vm2_t1")
      val vm2_l2 = engine.$f("vm2_l2")
      val vm2_l3 = engine.$f("vm2_l3")
      verifyEquals("BB", getText(vm2_l1));
      verifyEquals("V1-BB", getValue(vm2_t1));
      verifyEquals("V1-BB", getText(vm2_l2));
      verifyEquals("V2", getText(vm2_l3));

      `type`(vm2_t1, "OO")
      sendKeys(vm2_t1, Keys.TAB)
      waitResponse()
      verifyEquals("OO-BB", getValue(vm2_t1));
      verifyEquals("OO-BB", getText(vm2_l2));
      verifyEquals("V2", getText(vm2_l3));

      click(engine.$f("vm2_btn"))
      waitResponse()
      verifyEquals("OO-BB", getValue(vm2_t1));
      verifyEquals("OO-BB", getText(vm2_l2));
      verifyEquals("do command1 BB", getText(vm2_l3));

      val vm3_l1 = engine.$f("vm3_l1")
      val vm3_t1 = engine.$f("vm3_t1")
      val vm3_l2 = engine.$f("vm3_l2")
      val vm3_l3 = engine.$f("vm3_l3")
      verifyEquals("CC", getText(vm3_l1));
      verifyEquals("V1-CC", getValue(vm3_t1));
      verifyEquals("V1-CC", getText(vm3_l2));
      verifyEquals("V2", getText(vm3_l3));

      `type`(vm3_t1, "OO")
      sendKeys(vm3_t1, Keys.TAB)
      waitResponse()
      verifyEquals("OO-CC", getValue(vm3_t1));
      verifyEquals("OO-CC", getText(vm3_l2));
      verifyEquals("V2", getText(vm3_l3));

      click(engine.$f("vm3_btn"))
      waitResponse()
      verifyEquals("OO-CC", getValue(vm3_t1));
      verifyEquals("OO-CC", getText(vm3_l2));
      verifyEquals("do command1 CC", getText(vm3_l3));

      val vm4_l1 = engine.$f("vm4_l1")
      val vm4_t1 = engine.$f("vm4_t1")
      val vm4_l2 = engine.$f("vm4_l2")
      val vm4_l3 = engine.$f("vm4_l3")
      verifyEquals("XX", getText(vm4_l1));
      verifyEquals("V1-XX", getValue(vm4_t1));
      verifyEquals("V1-XX", getText(vm4_l2));
      verifyEquals("V2", getText(vm4_l3));

      `type`(vm4_t1, "OO")
      sendKeys(vm4_t1, Keys.TAB)
      waitResponse()
      verifyEquals("OO-XX", getValue(vm4_t1));
      verifyEquals("OO-XX", getText(vm4_l2));
      verifyEquals("V2", getText(vm4_l3));

      click(engine.$f("vm4_btn"))
      waitResponse()
      verifyEquals("OO-XX", getValue(vm4_t1));
      verifyEquals("OO-XX", getText(vm4_l2));
      verifyEquals("do command1 XX", getText(vm4_l3));
    })
  }
}
