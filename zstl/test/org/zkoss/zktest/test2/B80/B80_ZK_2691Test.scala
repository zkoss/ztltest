package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.ConfigHelper

@Tags(tags = "B80-ZK-2691.zul")
class B80_ZK_2691Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B80-ZK-2691.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Jun 9, 2015  10:30:29 AM, Created by Jameschu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
		1. click chosenbox and select few options, you should see the options and selecions rendered correctly.
		2. click button 'invalidate', and the previously selected items should not be lost.
	</label>
	<zscript><![CDATA[
		ItemRenderer chosenBoxRenderer = new ItemRenderer() {
			public String render(Component owner, Object data, int index)
					throws Exception {
				Locale locale = (Locale)data;
				return "<div><i class=\"z-icon z-icon-globe\"/>"+locale.getDisplayLanguage()+"-"+locale.getDisplayCountry()+"</div>";
			}
		};
		ListModelList choices = new ListModelList(Locale.getAvailableLocales());
	]]></zscript>

	<chosenbox id="mychosenbox" width="350px" model="${choices}" creatable="true" itemRenderer="${chosenBoxRenderer}" />

	<zscript><![CDATA[
		choices.addToSelection(choices.get(0));
		choices.addToSelection(choices.get(121));
		choices.addToSelection(choices.get(10));
	]]></zscript>

	<button label="invalidate">
		<attribute name="onClick"><![CDATA[
			mychosenbox.invalidate();                        
		]]></attribute>
	</button>
</zk>

""" 
  runZTL(zscript,
    () => {
      //open the chosenbox menu
      click(jq(".z-chosenbox"))
      waitResponse()
      //select "Arabic-Jordan"
      click(jq(".z-chosenbox-option:visible").eq(1))
      waitResponse()
      //open the chosenbox menu again
      click(jq(".z-chosenbox"))
      waitResponse()
      //select "Italian-"
      click(jq(".z-chosenbox-option:visible").eq(8))
      waitResponse()
      //open the chosenbox menu again
      click(jq(".z-chosenbox"))
      waitResponse()
      //select "English-Singapore"
      click(jq(".z-chosenbox-option:visible").eq(18))
      waitResponse()
      //make sure selected options are rendered correctly
      val expected = Array[String]("-", "Vietnamese-", "Chinese-Taiwan", "Arabic-Jordan", "Italian-", "English-Singapore")
      for (i <- 0 to 5) {
        verifyEquals(expected(i), jq(".z-chosenbox-item .z-icon").eq(i).text())
      }
      //click the invalidate button
      click(jq("button"))
      waitResponse()
      //check again
      for (i <- 0 to 5) {
        verifyEquals(expected(i), jq(".z-chosenbox-item .z-icon").eq(i).text())
      }
    })
  }
}