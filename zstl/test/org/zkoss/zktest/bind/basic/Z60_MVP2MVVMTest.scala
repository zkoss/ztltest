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

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_MVP2MVVMTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { //mvp2mvvm_mvp.zul
      <window title="Test" apply="org.zkoss.zktest.bind.basic.MVP2MVVMComposer" border="normal">
        <button id="outerToggle1" label="toggle outside 1"/>
        <button id="outerToggle2" label="toggle outside 2"/>
        <vbox id="mVbox"/>
      </window>
    }

    runZTL(zul, () => {
      verifyEquals("true", jq("$textA").toWidget().get("disabled"))
      click(jq("$outerToggle1").toWidget())
      waitResponse()
      verifyEquals("false", jq("$textA").toWidget().get("disabled"))
      click(jq("$outerToggle2").toWidget())
      waitResponse()
      verifyEquals("true", jq("$textA").toWidget().get("disabled"))
      click(jq("$innerToggle").toWidget())
      waitResponse()
      verifyEquals("false", jq("$textA").toWidget().get("disabled"))
    })
  }
}