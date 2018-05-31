/* B36_2784736Test.java

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


class B36_2784736Test extends ZTL4ScalaTestCase {
  @Test
  def testmenupopup() = {
    var zscript =
      """
			<zk>
				Please click the "Help" menu, and then the popup menu should display well (IE 7 only).
			  <zscript>
				void createMenu(Menupopup popup) {
				  popup.appendChild(new Menuitem("Index"));

				  Menu about = new Menu("About");
				  Menupopup p = new Menupopup();
				  about.appendChild(p);
				  popup.appendChild(new Menuseparator());
				  popup.appendChild(about);

				  p.addEventListener("onOpen", new EventListener() {
				    public void onEvent(Event event) {
				      event.getTarget().appendChild(new Menuitem("About ZK"));
				      event.getTarget().appendChild(new Menuitem("About Potix"));
				    }
				  });
				}
			  </zscript>

			  <menubar>
			    <menu label="File">
			      <menupopup>
				<menuitem label="New"/>
				<menuitem label="Open"/>
				<menuseparator/>
				<menuitem label="Exit"/>
			      </menupopup>
			    </menu>
			    <menu label="Help">
			      <menupopup onOpen="createMenu(self)"/>
			    </menu>
			  </menubar>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      click(jq("@menu[label=\"Help\"]"))
      waitResponse()
      verifyTrue(jq("div.z-menupopup").outerWidth() > jq("@menu:eq(1)").outerWidth())
    })
  }
}



