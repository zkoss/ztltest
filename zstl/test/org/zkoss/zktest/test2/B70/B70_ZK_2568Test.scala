package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.{ZK, Tags, ZKSeleneseTestBase}
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys

@Tags(tags = "B70-ZK-2568.zul")
class B70_ZK_2568Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2568.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Feb 04, 2015  8:32:32 PM, Created by Chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
<label multiline="true">
1. click the button
2. zk.log should not be '2' (two undefined instead)
</label>
<script type="text/javascript"><![CDATA[
 	function getColSpan() {
		var colspan = jq('.z-group-inner')[0].colSpan;
		zk.log(colspan);
		colspan = jq('.z-listgroup-inner')[0].colSpan;
		zk.log(colspan);
 	}
]]></script>
	<button label="button" onClick='Clients.evalJavaScript("getColSpan()")' />
	<grid width="100%">
	    <rows>
	        <group>
		        <label value="Group1: (gp1)"/>
            </group>
	        <row>
	            <cell><label value="abc" /></cell>
	        </row>
	    </rows>
	</grid>
	<listbox width="100%">
        <listgroup label="Listgroup" />
        <listitem>
            <listcell><label value="abc" /></listcell>
        </listitem>
	</listbox>
</zk>
    
"""  
  runZTL(zscript,
    () => {
      click(jq("@button"));
			if (ZK.is("ie8"))
				sleep(100)
      waitResponse();
      var result = "1\n1";
      verifyTrue(jq("#zk_log").eval("val()").trim() == result);
    })
    
  }
}