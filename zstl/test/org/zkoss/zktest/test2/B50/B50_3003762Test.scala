/* B50_3003762Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3003762Test extends ZTL4ScalaTestCase {
  @Test
  def testonCheck() = {
    var zscript =
      """
<vbox width="100%" align="stretch"> 
ZK Online Survey 
<textbox value="Jerry" id="tb" width="150px" onBlur="text.value = self.value; Thread.sleep(200);"/> 
<radiogroup id="radio1" onCheck="choice.value = self.selectedItem.label"> 
<grid> 
<rows> 
<row>
 <cell colspan="5">
Which one area would you like ZK to improve upon?
</cell></row>
<row> 
<radio id="r1" label="IDE Support" /> 
<radio label="Bug Fixing" /> 
<radio label="Performance" /> 
<radio label="Backward Compatibility" /> 
<radio label="Offline Functionality" /> 
</row> 
</rows> 
</grid> 
</radiogroup> 
<hbox> 
You have selected : 
<label id="text" /> 
<label id="choice" /> 
</hbox> 
</vbox> 

		"""
    val ztl$engine = engine()
    val tb = ztl$engine.$f("tb")
    val radio1 = ztl$engine.$f("radio1")
    val r1 = ztl$engine.$f("r1")
    val text = ztl$engine.$f("text")
    val choice = ztl$engine.$f("choice")
    runZTL(zscript, () => {
      focus(tb)
      blur(tb)
      click(r1.$n("real"))
      waitResponse()
      verifyEquals("Jerry", jq("$text").text())
      verifyEquals("IDE Support", jq("$choice").text())
    })
  }
}



