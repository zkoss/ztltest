/* B36_2813877Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B36_2813877Test extends ZTL4ScalaTestCase {
  @Test
  def testresizer() = {
    runZTL(() => {
      click(jq("@button[label=\"Overlap\"]"))
      waitResponse()
      dragdropTo(jq("$win"), "341,292", "619,298")
      waitResponse()
      dragdropTo(jq("@caption"), "174,19", "176,66")
      waitResponse()
      click(jq("@button[label=\"Embed\"]"))
      waitResponse()
      click(jq("@button[label=\"Popup\"]"))
      waitResponse()
      dragdropTo(jq("$win").toWidget().$n("cave"), "349,222", "654,218")
      waitResponse()
    })
  }
}