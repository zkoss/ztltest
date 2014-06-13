package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.openqa.selenium.Dimension

@Tags(tags = "B70-ZK-2307.zul")
class B70_ZK_2307Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2307.zul

	Purpose:
		
	Description:
		
	History:
		Wed, May 28, 2014 11:43:30 AM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<style>
		.z-listcell{ border: 1px solid black;}
	
	</style>
	resize a browser window width, the column borders should not become mis-aligned to listbox header's border.
		<custom-attributes org.zkoss.zul.nativebar="true"/>
		<listbox id="listbox" width="100%" rows="3" >
			<custom-attributes org.zkoss.zul.nativebar="true"/>
			<listhead>
				<listheader width="100px">1111</listheader>
				<listheader width="100px">2222</listheader>
				<listheader width="100px">3333</listheader>
				<listheader width="300px">4444</listheader>
				<listheader width="300px">555</listheader>
				<listheader width="300px">666</listheader>
			</listhead>

			<listitem >
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />
				<listcell label="6666" />
			</listitem>
			<listitem >
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />
				<listcell label="6666" />
			</listitem>
			<listitem >
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />
				<listcell label="6666" />
			</listitem>
			<listitem >
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />
				<listcell label="6666" />
			</listitem>						
		</listbox>
		<listbox id="listbox2" width="100%" rows="3" >
			<custom-attributes org.zkoss.zul.nativebar="false"/>
			<listhead>
				<listheader width="100px">1111</listheader>
				<listheader width="100px">2222</listheader>
				<listheader width="100px">3333</listheader>
				<listheader width="300px">4444</listheader>
				<listheader id="h5" width="300px">555</listheader>
				<listheader width="300px">666</listheader>
			</listhead>

			<listitem>
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell id="i5" label="555" />
				<listcell label="6666" />
			</listitem>
			<listitem >
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />
				<listcell label="6666" />
			</listitem>
			<listitem >
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />
				<listcell label="6666" />
			</listitem>
			<listitem >
				<listcell label="1111-1" />
				<listcell label="2222-2" />
				<listcell label="3333-3" />
				<listcell label="4444-4" />
				<listcell label="555" />
				<listcell label="6666" />
			</listitem>						
		</listbox>
</zk>
"""
    runZTL(zscript,
      () => {
    	// don't support opera
        val window = driver.manage().window();
        val originW = window.getSize().width;
        val originH = window.getSize().height;
        window.setSize(new Dimension(500, originH));
        
        sleep(500);
        
        val h5l = jq("$h5").offsetLeft();
        val i5l = jq("$i5").offsetLeft();
        
        verifyTrue("list head and cell must align to same vertial line.", h5l == i5l);

        window.setSize(new Dimension(originW, originH));
        window.maximize();
      })

  }
}