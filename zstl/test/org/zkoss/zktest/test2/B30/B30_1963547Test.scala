/* B30_1963547Test.java

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


class B30_1963547Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
It is true, if don't have any JS error after you go through the following steps
<vbox>
<listbox width="250px" id="list">
<listhead/>
</listbox>
<button label="Click Me Three Times" onClick='new Listitem("WithListhead").parent=list;'/>

<listbox width="250px" id="list1">
<listfoot/>
</listbox>
<button label="Click Me Three Times"  onClick='new Listitem("WithListfoot").parent=list1;'/>
<listbox width="250px" id="list2" mold="paging"/>
<button label="Click Me Three Times"  onClick='new Listitem("OnlyPaging").parent=list2;'/>
</vbox>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val list = ztl$engine.$f("list")
    val list1 = ztl$engine.$f("list1")
    val list2 = ztl$engine.$f("list2")
    runZTL(zscript, () => {
      click(jq("@button:eq(0)"));
      waitResponse()
      verifyFalse(jq(".z-error").exists())
      click(jq("@button:eq(1)"));
      waitResponse()
      verifyFalse(jq(".z-error").exists())
      click(jq("@button:eq(2)"));
      waitResponse()
      verifyFalse(jq(".z-error").exists())
    })
  }
}



