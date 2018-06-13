/* B50_2873478Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2873478Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
			<?page title="" contentType="text/html;charset=UTF-8" zscript-language="javascript" ?>
			<window title="ZK5 RC Test - 01" border="normal" width="80%">
			<html><![CDATA[
			<ol>
				<li>If you can see this page and the under Grid, it is OK</li>
				<li>Done</li>
			</ol>
			]]></html>
			  <grid>
			      <columns sizable="true">
			        <column label="Fields" align="right" width="80px" />
			        <column label="" />
			      </columns>
			 
			      <rows>
			        <row>
			          <label value="NO1:" />
			          <textbox id="no1" constraint="no empty"/>
			        </row>
			        <row visible="false">
			          <label value="NO2:" />
			          <textbox id="no2" constraint="no empty"/>
			        </row>
			      </rows>
			  </grid>
			</window>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val no1 = ztl$engine.$f("no1")
    val no2 = ztl$engine.$f("no2")
    runZTL(zscript, () => {
      verifyTrue(jq("div.z-grid").exists())
    })
  }
}



