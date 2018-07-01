/* B70_ZK_2768Test.scala

	Purpose:
		
	Description:
		
	History:
		Thu Oct  8 17:47:47 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B70

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags;

/**
  *
  * @author chunfu
  */
@Tags(tags = "B70-ZK-2768.zul")
class B70_ZK_2768Test extends ZTL4ScalaTestCase {
  def testCase() = {
    val zscript =
      """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2768.zul

	Purpose:

	Description:

	History:
		Thu Jun  4 13:48:44 CST 2015, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<?component name="infoPopup" macroURI="test2/B70-ZK-2768_pop.zul" inline="true"?>
<zk>
	<window vflex="1" border="normal" id="win">
	 	<!-- disabling client render on demand will avoid the JS error,
	 	     but the popup will remain invisible because it is a child of an invisible include component -->
		<!-- <custom-attributes org.zkoss.zul.client.rod="false"/>  -->
		<caption>
			<toolbar>
				<toolbarbutton label="pop1" onClick='inc1.getFellow("pop1").open(win, "middle_center")'/>
				<toolbarbutton label="pop2" onClick='inc2.getFellow("pop2").open(win, "middle_center")'/>
				<toolbarbutton label="pop3" onClick='inc3.getFellow("pop3").open(win, "middle_center")'/>
				<toolbarbutton label="pop4" onClick='pop4.open(win, "middle_center")'/>
			</toolbar>
		</caption>
		You should not see any JS error when clieck the bottons "pop1~4"
		<include src="test2/B70-ZK-2768_expl.zul"/>
		<include src="test2/B70-ZK-2768_pop.zul" popParam="POP1" popId="pop1" id="inc1" visible="false"/><!-- reproduces the JS error message, when client ROD is enabled (default) -->
		<!-- 2 css workarounds -->
		<include src="test2/B70-ZK-2768_pop.zul" popParam="POP2" popId="pop2" id="inc2" style="display:none"/>
		<include src="test2/B70-ZK-2768_pop.zul" popParam="POP3" popId="pop3" id="inc3" style="position: absolute; height: 0px; width 0px;"/>
		<!-- using an inline macro to avoid the unnecessary include - the popup is initially invisible -->
		<infoPopup popParam="POP4" popId="pop4"/>
	</window>
</zk>


		"""
    runZTL(zscript, () => {
      var toolbarBtns = jq(".z-toolbarbutton");
      for (i <- 0 to toolbarBtns.length() - 1) {
        click(toolbarBtns.eq(i))
        waitResponse()
        verifyFalse(hasError);
      }

    })
  }
}
