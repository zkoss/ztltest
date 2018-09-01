/* B50_2997034Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2997034Test extends ZTL4ScalaTestCase {
  @Test
  def testScroll() = {
    var zscript =
      """
<zk>
<div id="div" height="300px" style="overflow:auto;position:relative">
	(This is a ztl-based test case.)
	This problem is that when you scoll down the listbox to bottom,
	and click a  list item that near bottoms , the list item that clicked
	should not change the scroll top .

        <listbox id="box"  multiple="true" checkmark="true">
                <listhead>
                        <listheader label="Name"/>
                        <listheader label="Gender"/>
                        <listheader label="Age"/>
                        <listheader label="Description"/>
                </listhead>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem id="li1"> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>
                <listitem> <listcell label="Mary"/><listcell label="FEMALE"/><listcell label="18"/><listcell label="A young lady."/></listitem>

        </listbox>
</div>
</zk>
		"""
    val ztl$engine = engine()
    val div = ztl$engine.$f("div")
    val box = ztl$engine.$f("box")
    val li1 = ztl$engine.$f("li1")
    runZTL(zscript, () => {
      /**
        * for breeze compatible , we change the specify the value ,
        * we just use the li1's position top for scroll value.
        */
      div.$n().eval("scrollTop = " + jq(li1).positionTop())
      var curScrollTop = parseInt(div.$n().eval("scrollTop"))
      curScrollTop -= 10
      div.$n().eval("scrollTop = " + curScrollTop)
      click(li1.$n("cm"))
      waitResponse()
      verifyTolerant(curScrollTop, parseInt(div.$n().eval("scrollTop")), 10)
    })
  }
}



