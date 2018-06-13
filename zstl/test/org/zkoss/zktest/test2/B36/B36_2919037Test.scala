/* B36_2919037Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2919037Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?> 
<?page title="Auto Generated index.zul"?>
<window id="main" title="Hello World!!" border="normal" width="100%" apply="org.zkoss.zktest.test2.B2919037">
<html><![CDATA[
<ol>
<li>Click the combobox to drop down and select "Bruce Lee".</li>
<li>Click the "unselect" button, and the combobox shall be empty.</li>
<li>Done.</li>
</ol>
]]></html>
	<combobox id="cbx" model="@{main$composer.personen}" selectedItem="@{main$composer.person}" constraint="no empty">
		<comboitem self="@{each=person}" label="@{person.fullName}"/>
	</combobox>
	<button label="unselect" onClick="cbx.setSelectedIndex(-1)"/>
</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val main = ztl$engine.$f("main")
    val cbx = ztl$engine.$f("cbx")
    runZTL(zscript, () => {
      click(jq(jq(".z-combobox").toWidget().$n("btn")))
      waitResponse()
      click(jq(".z-comboitem:eq(0)"))
      waitResponse()
      click(jq("@button"))
      waitResponse()
      verifyEquals("", jq(jq(".z-combobox").toWidget().$n("real")).text())
    })
  }
}



