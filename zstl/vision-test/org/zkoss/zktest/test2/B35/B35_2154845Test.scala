/* B35_2154845Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 12:27:59 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 *
 * @author jumperchen
 */
@Tags(tags = "B35-2154845.zul,A,E,Tabbox,VisionTest")
class B35_2154845Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = """
			<window id="wnd1" border="normal" height="100%">
				1.After Click the button , the background of tabs (long and blue) is
	OK (not seperate into two)
				<button label="Click me" onClick='onClick$step2_btn()'/>
				<tabbox id="tbx">
					<tabs id="tbs">
						<tab id="tab0" label="a"/>
						<tab id="tab1" label="b"/>
					</tabs>
					<tabpanels>
						<tabpanel>this is a</tabpanel>
						<tabpanel>this is b</tabpanel>
					</tabpanels>
				</tabbox>
				<zscript><![CDATA[//@DECLARATION       
		public void onClick$step2_btn(){
			Tabbox loTabbox = (Tabbox) wnd1.getFellow("tbx");
			
			Tab loTab2 = (Tab) wnd1.getFellow("tab1");
			loTab2.setImage("/test2/img/corner.gif");
			Tab loTab1 = (Tab) wnd1.getFellow("tab0");
			loTabbox.setSelectedTab(loTab2);
			loTabbox.setSelectedPanel(loTab2.getLinkedPanel());
		}
		
]]></zscript>
			</window>
		"""
runZTL(zscript, () => {
			click(jq("@button"))
			waitResponse
			verifyImage()
		})
	}
}
