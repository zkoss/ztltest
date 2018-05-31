/* B36_2783767Test.java

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
import org.zkoss.ztl.Widget


class B36_2783767Test extends ZTL4ScalaTestCase {
  @Test
  def testBeanShell() = {
    var zscript =
      """
			<?page title="new page title" contentType="text/html;charset=UTF-8"?>
			<zk>
			<window id="win" title="new page title" border="normal">
			If you see "false", it is correct; otherwise, it is not correct:
			<label id="lbl" value="false"/>
			
			<zscript>
				win.setAttribute("abc", "Hello", false); //abc inside the win's namespace
				for(final Iterator it = win.getPage().getLoadedInterpreters().iterator(); it.hasNext();) {
					final org.zkoss.zk.scripting.Interpreter ip = (org.zkoss.zk.scripting.Interpreter) it.next();
					if (ip instanceof org.zkoss.zk.scripting.HierachicalAware) {
						final org.zkoss.zk.scripting.HierachicalAware ha = (org.zkoss.zk.scripting.HierachicalAware)ip;
						if (ha.containsVariable(win, "abc")) {
							lbl.setValue("true");
							break;
						}
					}
				}
			</zscript>
			
			</window>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    val lbl = ztl$engine.$f("lbl")
    runZTL(zscript, () => {
      verifyEquals("false", jq("@label:last").html())
    })
  }
}



