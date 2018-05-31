/* B30_1852304Test.java

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
import org.zkoss.ztl.Widget


class B30_1852304Test extends ZTL4ScalaTestCase {
  @Test
  def testPopup() = {
    var zscript =
      """
				<zk xmlns="http://www.zkoss.org/2005/zul"
					xmlns:n="http://www.zkoss.org/2005/zk/native">
					<n:h5>When you click the menu x and y, the listbox should be shown.</n:h5>
					<window>
						<checkbox label="autodrop" checked="true" onCheck="menubar.autodrop = !menubar.autodrop"/>
						<menubar id="menubar" autodrop="true">
							<menu label="x">
								<menupopup>
									<menuitem label="y" popup="z" />
								</menupopup>
							</menu>
						</menubar>
						<popup id="z">
							<listbox width="250px">
								<listhead sizable="true">
									<listheader label="name" sort="auto" />
									<listheader label="gender" sort="auto" />
								</listhead>
								<listitem>
									<listcell label="Mary" />
									<listcell label="FEMALE" />
								</listitem>
								<listitem>
									<listcell label="John" />
									<listcell label="MALE" />
								</listitem>
								<listitem>
									<listcell label="Jane" />
									<listcell label="FEMALE" />
								</listitem>
								<listitem>
									<listcell label="Henry" />
									<listcell label="MALE" />
								</listitem>
							</listbox>
						</popup>
					</window>
				</zk>
			 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val menubar = ztl$engine.$f("menubar")
    val z = ztl$engine.$f("z")
    runZTL(zscript, () => {
      mouseOver(jq(".z-menu").toWidget().$n("a"))
      waitResponse(true)
      sleep(1000)
      click(jq(".z-menuitem"))
      waitResponse(true)
      sleep(1000)
      verifyTrue(jq(".z-popup .z-listbox").exists())
    })
  }
}



