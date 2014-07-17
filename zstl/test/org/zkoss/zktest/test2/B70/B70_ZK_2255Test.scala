package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.openqa.selenium.Dimension

@Tags(tags = "B70-ZK-2255.zul")
class B70_ZK_2255Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2255.zul

	Purpose:
		
	Description:
		
	History:
		Thu, Apr 17, 2014  9:19:47 AM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<zscript><![CDATA[
	Object[] col = new Object[25];
	]]></zscript>
	<window hflex="1" id="w1">
	<label multiline="true">
Test steps:
1. Shrink browser width to make sure the horizontal scrollbar showed at first loading.
2. Extend or shrink browser width
3. Horizontal scrollbar did not work correctly (if true, that's a bug)
	</label>
		<listbox height="300px" emptyMessage="no items">
			<custom-attributes org.zkoss.zul.listbox.rod="true" />
    		<custom-attributes org.zkoss.zul.nativebar="true" />
			<listhead>
				<listheader forEach="${col}" label="col ${forEachStatus.index + 1}" hflex="min" />
			</listhead>
		</listbox>
	</window>
      
    <window hflex="1" id="w2">
	<label>fake scrollbar</label>
		<listbox height="300px" emptyMessage="no items">
			<custom-attributes org.zkoss.zul.listbox.rod="true" />
    		<custom-attributes org.zkoss.zul.nativebar="false" />
			<listhead>
				<listheader forEach="${col}" label="col ${forEachStatus.index + 1}" hflex="min" />
			</listhead>
		</listbox>
	</window>
</zk>
"""
    runZTL(zscript,
      () => {
//        val window = driver.manage().window();
//        val originW = window.getSize().width;
//        val originH = window.getSize().height;
//        window.setSize(new Dimension(500, originH));
//        sleep(500);
//        
//        val w1 = jq("$w1");
//        val w2 = jq("$w2");
//        
//        val bar = jq(".z-scrollbar-horizontal");
//        println(hasHScrollbar(w1.find("@listbox")));
//        println(hasHScrollbar(w2.find("@listbox")));
//        
//        window.setSize(new Dimension(originW, originH));
//    	  window.maximize();
      })
  }
}