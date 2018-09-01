/* B30_1876988Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1876988Test extends ZTL4ScalaTestCase {
  @Test
  def testBtnPosition() = {
    var zscript =
      """
			<zk>
			[ 1876988 ] Messagebox's button with wrong style in Opera. The confirm button in messagebox has wrong position
			in Opera.
			<button label="Question" width="100px">
				<attribute name="onClick">{
					Messagebox.show("Question is pressed. Are you sure?", "Question", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION);
				}</attribute>
			</button>
			</zk>
		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      click(jq(".z-button"))
      waitResponse()
      verifyEquals("OK", jq(".z-messagebox-button:eq(0)").text())
    })
  }
}



