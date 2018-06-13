/* B36_2814460Test.java

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


class B36_2814460Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
    In opera, you should not see any error.
    <listbox id="box" multiple="true" checkmark="true">
        <listhead>
            <listheader label="Name"/>
            <listheader label="Gender"/>
            <listheader label="Age"/>
            <listheader label="Description"/>
        </listhead>
        <listgroup label="abc" checkable="false"/>
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
        <listitem>
            <listcell label="Henry"/>
            <listcell label="MALE"/>
            <listcell label="29"/>
            <listcell label="A graduate."/>
        </listitem>
    </listbox>
</zk>


		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val box = ztl$engine.$f("box")
    runZTL(zscript, () => {
      verifyFalse(jq(".z-error").exists())
    })
  }
}



