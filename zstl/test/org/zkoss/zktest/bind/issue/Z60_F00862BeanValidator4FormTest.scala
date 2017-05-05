
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
import org.zkoss.ztl.Widget

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F00862BeanValidator4FormTest extends ZTL4ScalaTestCase {

  def testArg() = {
    // zktest environment doesn't provide bean validator
//    val zul = """
//      <include src="/bind/issue/F00862BeanValidator4Form.zul"/>
//    }
//
//    runZTL(zul, () => {
//
//      var tb1 = jq("$tb1")
//      var tb2 = jq("$tb2")
//      var tb3 = jq("$tb3")
//
//      var msg1 = jq("$msg1")
//      var msg2 = jq("$msg2")
//      var msg3 = jq("$msg3")
//
//      var l1 = jq("$l1")
//      var l2 = jq("$l2")
//      var l3 = jq("$l3")
//
//      var save = jq("$save")
//
//      `type`(tb1.toWidget(), "")
//      waitResponse()
//      verifyEquals("name can not be null", msg1.toWidget().get("value"))
//
//      `type`(tb1.toWidget(), "Alex")
//      waitResponse()
//      verifyEquals("", msg1.toWidget().get("value"))
//
//      `type`(tb2.toWidget(), "")
//      waitResponse()
//      verifyEquals("Last name can not be null", msg2.toWidget().get("value"))
//
//      `type`(tb2, "Wu")
//      waitResponse()
//      verifyEquals("", msg1.toWidget().get("value"))
//
//      `type`(tb3, "a@b")
//      waitResponse()
//      verifyEquals("email lenght must large than 8", msg3.toWidget().get("value"))
//
//      verifyEquals("Dennis", l1.toWidget().get("value"))
//      verifyEquals("Chen", l2.toWidget().get("value"))
//      verifyEquals("", l3.toWidget().get("value"))
//
//      click(save.toWidget())
//      waitResponse()
//
//      verifyEquals("email lenght must large than 8", msg3.toWidget().get("value"))
//      verifyEquals("Dennis", l1.toWidget().get("value"))
//      verifyEquals("Chen", l2.toWidget().get("value"))
//      verifyEquals("", l3.toWidget().get("value"))
//
//      `type`(tb3.toWidget(), "a@b.cdefg")
//      waitResponse()
//      verifyEquals("", msg3.toWidget().get("value"))
//
//      click(save.toWidget())
//      waitResponse()
//
//      verifyEquals("", msg3.toWidget().get("value"))
//      verifyEquals("Alex", l1.toWidget().get("value"))
//      verifyEquals("Wu", l2.toWidget().get("value"))
//      verifyEquals("a@b.cdefg", l3.toWidget().get("value"))
//
//    })
  }
}

