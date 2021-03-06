/* B30_1822727Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1822727Test extends ZTL4ScalaTestCase {
  @Test
  def testSelection() = {
    var zscript =
      """
<window title="listbox checkmark demo" border="normal">
<html><![CDATA[
The selection of listbox is not correct when use toggle multiple.<br/>
reproducible step.<br/>
1.select Henry and Dennis<br/>
2.click toogle multiple ,<br/>
3.click toogle multiple again.<br/>
4.Disselect Henry.<br/>
5.Click invalidate.<br/>
<br/>
Henry should <b>NOT</b> be selected.<br/>
<br/>
]]></html>
	<button id="btn1" label="Toggle multiple" onClick="box.multiple = !box.multiple"/>
	<button id="btn2" label="Invalidate" onClick="box.invalidate()"/>
	<separator bar="true"/>
	<listbox id="box" width="460px" multiple="true" checkmark="true">
		<listhead>
			<listheader label="Name"/>
			<listheader label="Gender"/>
			<listheader label="Age"/>
			<listheader label="Description"/>
		</listhead>
		<listitem>
			<listcell label="Mary"/>
			<listcell label="FEMALE"/>
			<listcell label="18"/>
			<listcell label="A young lady."/>
		</listitem>
		<listitem>
			<listcell label="John"/>
			<listcell label="MALE"/>
			<listcell label="20"/>
			<listcell label="A college student."/>
		</listitem>
		<listitem>
			<listcell label="Jane"/>
			<listcell label="FEMALE"/>
			<listcell label="32"/>
			<listcell label="A remarkable artist."/>
		</listitem>
		<listitem id="li1">
			<listcell label="Henry"/>
			<listcell label="MALE"/>
			<listcell label="29"/>
			<listcell label="A graduate."/>
		</listitem>
		<listitem id="li2">
			<listcell label="Dennis"/>
			<listcell label="MALE"/>
			<listcell label="30"/>
			<listcell label="A developer"/>
		</listitem>
	</listbox>		
</window>
		 """
    val ztl$engine = engine()
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    val box = ztl$engine.$f("box")
    val li1 = ztl$engine.$f("li1")
    val li2 = ztl$engine.$f("li2")
    runZTL(zscript, () => {
      click(li1.$n("cm"))
      waitResponse()
      click(li2.$n("cm"))
      waitResponse()
      click(btn1)
      waitResponse()
      verifyTrue(li1.is("selected"))
      verifyFalse(li2.is("selected"))
      click(btn1)
      waitResponse()
      click(li1.$n("cm"))
      waitResponse()
      verifyFalse(li1.is("selected"))
      click(btn2)
      waitResponse()
      verifyFalse(li1.is("selected"))
      verifyFalse(li2.is("selected"))
    })
  }
}



