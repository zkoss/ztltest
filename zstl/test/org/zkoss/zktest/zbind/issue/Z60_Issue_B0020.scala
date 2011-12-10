/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.zbind.issue

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;
import org.openqa.selenium.Keys

/**
 * @author Hawk
 *
 */
@Tags(tags = "zbind")
class Z60_Issue_B0020 extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = {
	<vbox apply="org.zkoss.bind.BindComposer" viewModel="@bind(vm='org.zkoss.zktest.zbind.issue.B0020')">
		<label multiline="true">
		c2.
		delete row entry with button
		</label>
	
		<listbox model="@bind(vm.fruitList)">
			<template name="model" var="f">
				<listitem >
					<listcell label="@bind(f)"></listcell>
					<listcell><button label="Delete" onClick="@bind('delete', index=self.parent.parent.index)" /></listcell>
				</listitem>
			</template>
		</listbox>
	</vbox>
    }
    runZTL(zul, () => {
		//test property init
    	waitResponse()
    	verifyEquals(5,jq("@button").length())
    	click(jq("@button").first())
//		Assert.assertEquals(5,findWidgets("@button").size());
//		Widget b = findWidget("@button");
//		b.click();
		
    	waitResponse()
    	verifyEquals(4,jq("@button").length())
    	click(jq("@button").first())
//		Assert.assertEquals(4,findWidgets("@button").size());
//		b = findWidget("@button");
//		b.click();
		
    	waitResponse()
    	verifyEquals(3,jq("@button").length())
    	click(jq("@button").first())
//		Assert.assertEquals(3,findWidgets("@button").size());
//		b = findWidget("@button");
//		b.click();
		
    	waitResponse()
    	verifyEquals(2,jq("@button").length())
    	click(jq("@button").first())
//		Assert.assertEquals(2,findWidgets("@button").size());
//		b = findWidget("@button");
//		b.click();
		
    	waitResponse()
    	verifyEquals(1,jq("@button").length())
    	click(jq("@button").first())
//		Assert.assertEquals(1,findWidgets("@button").size());
//		b = findWidget("@button");
//		b.click();
		
    	waitResponse()
    	verifyEquals(0,jq("@button").length())
    	verifyEquals(null, jq("@button").first())
//		Assert.assertEquals(0,findWidgets("@button").size());
//		b = findWidget("@button");
//		Assert.assertNull(b);
    })
  }
}
