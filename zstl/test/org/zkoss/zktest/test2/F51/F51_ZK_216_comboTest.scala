/* F51_ZK_216_comboTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Mar 15 16:54:35 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F51

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.unit.Widget

/**
  * A test class for bug ZK-216-combo
  *
  * @author benbai
  *
  */
@Tags(tags = "F51-ZK-216-combo.zul,F60,A,E,template,combobox")
class F51_ZK_216_comboTest extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<window>
				<html><![CDATA[
				<ul><li>Click the dropdown, you shall three items: "Apple: 10kg", "Orange: 20kg" and "Mango: 12kg"</li></ul>
				]]></html>
				<zscript>
				ListModel infos = new ListModelArray(
					new String[][] {
						{"Apple", "10kg"},
						{"Orange", "20kg"},
						{"Mango", "12kg"}
					});
				</zscript>			
				<combobox id="cbx" model="${infos}">
					<template name="model">
						<comboitem label="${each[0]}: ${each[1]}"/>
					</template>
				</combobox>
			</window>

    """

    runZTL(zscript,
      () => {
        var cbx: Widget = engine.$f("cbx");

        click(cbx.$n("btn"));
        waitResponse();
        verifyTrue("Has item Apple: 10kg",
          jq(".z-comboitem:contains(Apple)").exists()
            && jq(".z-comboitem:contains(Apple)").find(".z-comboitem-text:contains(10kg)").exists());
        verifyTrue("Has item Orange: 20kg",
          jq(".z-comboitem:contains(Orange)").exists()
            && jq(".z-comboitem:contains(Orange)").find(".z-comboitem-text:contains(20kg)").exists());
        verifyTrue("Has item Mango: 12kg",
          jq(".z-comboitem:contains(Mango)").exists()
            && jq(".z-comboitem:contains(Mango)").find(".z-comboitem-text:contains(12kg)").exists());
      }
    );
  }
}