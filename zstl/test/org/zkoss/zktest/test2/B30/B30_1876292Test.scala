/* B30_1876292Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1876292Test extends ZTL4ScalaTestCase {
  @Test
  def testConstraint1() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>If I try to type wrong value and then click reset button, the first time
			it reset wrong value, but after typing wrong value the second time,
			cb1.value = null refuses to reset wrong value.
			
			Or after loading the page and resetting blank combobox or with right value,
			and then type a wrong value, it refuses to reset.</n:p>
				<vbox>
				<combobox id="cb1" constraint="strict"/>
				<zscript>
				cb1.appendItem("aaa").value = "111";
				cb1.appendItem("ccc").value = "333";
				</zscript>
				<button id="reset" label="reset" onClick="cb1.value = null;"/>
				</vbox>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cb1 = ztl$engine.$f("cb1")
    val reset = ztl$engine.$f("reset")
    runZTL(zscript, () => {
      /** set speed depended on test case setting */
      setSpeed("200")
      var combobox = jq(jq(".z-combobox").toWidget().$n("real"))
      focus(combobox)
      sendKeys(combobox, "aaa")
      blur(combobox)
      click(reset)
      waitResponse()
      verifyTrue(combobox.`val`().isEmpty())

      /** reset */
      setSpeed("200")
    })
  }

  @Test
  def testConstraint2() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>If I try to type wrong value and then click reset button, the first time
			it reset wrong value, but after typing wrong value the second time,
			cb1.value = null refuses to reset wrong value.
			
			Or after loading the page and resetting blank combobox or with right value,
			and then type a wrong value, it refuses to reset.</n:p>
				<vbox>
				<combobox id="cb1" constraint="strict"/>
				<zscript>
				cb1.appendItem("aaa").value = "111";
				cb1.appendItem("ccc").value = "333";
				</zscript>
				<button id="reset" label="reset" onClick="cb1.value = null;"/>
				</vbox>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cb1 = ztl$engine.$f("cb1")
    val reset = ztl$engine.$f("reset")
    runZTL(zscript, () => {
      var combobox = jq(jq(".z-combobox").toWidget().$n("real"))
      focus(combobox)
      click(reset)
      waitResponse()
      verifyTrue(combobox.`val`().isEmpty())
    })
  }

  @Test
  def testConstraint3() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>If I try to type wrong value and then click reset button, the first time
			it reset wrong value, but after typing wrong value the second time,
			cb1.value = null refuses to reset wrong value.
			
			Or after loading the page and resetting blank combobox or with right value,
			and then type a wrong value, it refuses to reset.</n:p>
				<vbox>
				<combobox id="cb1" constraint="strict"/>
				<zscript>
				cb1.appendItem("aaa").value = "111";
				cb1.appendItem("ccc").value = "333";
				</zscript>
				<button id="reset" label="reset" onClick="cb1.value = null;"/>
				</vbox>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cb1 = ztl$engine.$f("cb1")
    val reset = ztl$engine.$f("reset")
    runZTL(zscript, () => {
      /** set speed depended on test case setting */
      setSpeed("200")
      var combobox = jq(jq(".z-combobox").toWidget().$n("real"))
      focus(combobox)
      sendKeys(combobox, "ttt")
      blur(combobox)
      click(reset)
      waitResponse()
      verifyTrue(combobox.`val`().isEmpty())

      /** reset */
      setSpeed("200")
    })
  }
}



