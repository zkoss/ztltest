/* F30_1656278Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class F30_1656278Test extends ZTL4ScalaTestCase {
  @Test
  def testDisable() = {
    var zscript =
      """
		<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<n:h2>[ 1656278 ] Menuitem enabled/disabled support</n:h2>
			<n:ol>
				<n:li>click "File" then you will see the "Open" item to be disabled and cannot be clicked</n:li>
		                <n:li>Try to enable it and click on it, it should show alert message</n:li>
			</n:ol>
			<menubar id="menubar">
				<menu id="menu" label="File">
					<menupopup>
						<menuitem label="New" autocheck="true" />
						<menuitem id="menuitem" label="Open" autocheck="true"
							onClick="alert(self.label)" disabled="true" />
						<menuitem label="Save" />
						<menuseparator />
		                                <menuitem id="menuitem1" label="Disable Open" onClick="open.disabled=true"/>
		                                <menuitem label="Enable Open" onClick="open.disabled=false"/>
						<menuitem label="Exit" />
					</menupopup>
				</menu>
				<menu id="menu2" label="Help">
					<menupopup>
						<menuitem label="Index" />
						<menu id="menu3" label="About">
							<menupopup>
								<menuitem id="menuitem2" disabled="true" label="About ZK"
									onClick="alert(self.label)" />
								<menuitem label="About Potix" onClick="alert(self.label)" />
							</menupopup>
						</menu>
					</menupopup>
				</menu>
			</menubar>
		</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val menubar = ztl$engine.$f("menubar")
    val menu = ztl$engine.$f("menu")
    val menuitem = ztl$engine.$f("menuitem")
    val menuitem1 = ztl$engine.$f("menuitem1")
    val menu2 = ztl$engine.$f("menu2")
    val menu3 = ztl$engine.$f("menu3")
    val menuitem2 = ztl$engine.$f("menuitem2")
    runZTL(zscript, () => {
      verifyFalse(jq("@window").exists())
      click(menu)
      click(menuitem)
      waitResponse()
      verifyFalse(jq("@window").exists())
      click(menuitem1)
      click(menu2)
      click(menu3)
      click(menuitem2)
      waitResponse()
      verifyFalse(jq("@window").exists())
      click(menuitem2.nextSibling())
      waitResponse()
      verifyTrue(jq("@window").exists())
    })
  }
}



