/* B70_ZK_2704Test.scala

	Purpose:
		
	Description:
		
	History:
		Fri Oct 16 14:37:47 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B70

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 * 
 * @author chunfu
 */
@Tags(tags = "B70-ZK-2704.zul")
class B70_ZK_2704Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2704.zul

	Purpose:

	Description:

	History:
		Tue, Jun 9, 2015 14:30:29 PM, Created by Jameschu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<zscript><![CDATA[
		ListModelList locales = new ListModelList();

		public void loadOnDemand(OpenEvent event) {
			if(event.isOpen()) {
				List allLocales = new ArrayList(Arrays.asList(Locale.getAvailableLocales()));
				allLocales.removeAll(locales.getSelection());
				locales.addAll(allLocales);
			} else {
				//onOpen false is never called
				locales.retainAll(locales.getSelection());
			}
		}
	]]></zscript>
	<label multiline="true">
    	1. click button to open combobox and the combobox won't immediately close
	</label>
	<combobox model="${locales}" onOpen='loadOnDemand(event)'/>
</zk>


		"""
runZTL(zscript, () => {
			click(jq(".z-combobox-button"))
			waitResponse()
			sleep(500)
			var pp = jq(".z-combobox-popup")
			verifyTrue(pp.exists() && pp.height() > 10)
		})
	}
}
