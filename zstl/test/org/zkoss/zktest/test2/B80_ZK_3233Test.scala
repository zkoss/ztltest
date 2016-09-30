/* B80_ZK_3233Test.scala

	Purpose:
		
	Description:
		
	History:
		Thu, Sep 29, 2016 12:26:45 PM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 * 
 * @author Sefi
 */
@Tags(tags = "")
class B80_ZK_3233Test extends ZTL4ScalaTestCase {
	@Test
	def test() = {
		val zscript =
			"""
<zk>
	<window id="mainWindow" >
		<label multiline="true">
			1.Type "a" in datebox and textbox, you should see errorbox appear.
            2.Click second tab and switch back, you should see errorbox appear.
		</label>
		<tabbox vflex="1">
			<tabs>
				<tab label="tabHeader 1" />
				<tab label="tabHeader 2" />
			</tabs>
			<tabpanels>
				<tabpanel>
						<window apply="org.zkoss.bind.BindComposer" viewModel="@id('vm')@init('org.zkoss.zktest.test2.B80_ZK_3233VM')" validationMessages="@id('vmsgs')">
						<vlayout >
							<hlayout>
								FieldWithFrontValidation
								<datebox />
							</hlayout>
							<hlayout>
								FieldWithBackValidation
								<textbox value="@bind(vm.name) @validator(vm.validator)" errorMessage="@load(vmsgs['name'])"  />
							</hlayout>
							<button label="Validate" onClick="@command('validate')"/>
						</vlayout>
					</window>
				</tabpanel>
				<tabpanel>
					<label>Second tab panel</label>
				</tabpanel>
			</tabpanels>
		</tabbox>
	</window>
</zk>
"""
		runZTL(zscript, () => {
			val inp1 = jq(".z-datebox-input:eq(0)");
			val inp2 = jq(".z-textbox:eq(0)");
			focus(inp1);
			`type`(inp1, "a");
			`type`(inp2, "a");
			blur(inp2);
			waitResponse();
			verifyEquals(2, jq(".z-errorbox:visible").length());
			click(jq(".z-tab:eq(1)"));
			waitResponse();
			verifyEquals(0, jq(".z-errorbox:visible").length());
			click(jq(".z-tab:eq(0)"));
			waitResponse();
			verifyEquals(2, jq(".z-errorbox:visible").length());
		})
	}
}
