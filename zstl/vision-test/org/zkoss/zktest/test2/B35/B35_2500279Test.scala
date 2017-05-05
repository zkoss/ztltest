/* B35_2500279Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 12:46:26 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;
import org.junit.Test

/**
 *
 * @author jumperchen
 */
@Tags(tags = "B35-2500279.zul,B,E,Listbox,Menu,Combobox,Datebox,Calendar,IE6,VisionTest")
class B35_2500279Test extends ZTL4ScalaTestCase {
	
  @Test
  def testCase() = {
		val zscript = """
			<zk>
				Please test the popup of each drop-down component, menu, datebox, and combobox, should cover the drop-down list(IE6 only)
				<vbox>
					<menubar>
						<menu id="menu" label="test">
							<menupopup>
								<menu label="test"/>
								<menu label="test"/>
								<menu label="test"/>
								<menu label="test"/>
								<menu label="test"/>
							</menupopup>
						</menu>
					</menubar>
					<listbox mold="select">
						<listitem label="Should cover me!"/>
					</listbox>
				</vbox>
				<vbox>
					<datebox id="db" width="150px" format="MM/dd/yyyy" text="12/14/2011" />
					<listbox mold="select">
						<listitem label="Should cover me!"/>
					</listbox>
				</vbox>
				<vbox>
					<combobox id="cb">
						<comboitem label="Simple and Rich"/>
						<comboitem label="Cool!"/>
						<comboitem label="Thumbs Up!"/>
					</combobox>
					<listbox mold="select">
						<listitem label="Should cover me!"/>
					</listbox>
				</vbox>
			</zk>
		"""
runZTL(zscript, () => {
			click(engine.$f("menu").$n("a"))
			waitResponse
			verifyImage()
			
			click(engine.$f("db").$n("btn"))
			waitResponse
			verifyImage()
			
			click(engine.$f("cb").$n("btn"))
			waitResponse
			verifyImage()
		})
	}
}
