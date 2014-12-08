package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2460.zul")
class B70_ZK_2460Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<!--
	B70-ZK-2460.zul
	
	Purpose:
	
	Description:
	
	History:
	Thu, Sep 24, 2014  10:30:22 AM, Created by jameschu
	
	Copyright (C)  Potix Corporation. All Rights Reserved.
-->
<zk>
	<label multiline="true">
		1. Move children quickly and several times, there are no exceptions will be rised.
	</label>
	<window id="demoWindow"
		apply="org.zkoss.zktest.test2.B70_ZK_2460_DemoComposer">
		<style>
			.h-inline-block { display: inline-block; _display: inline; }
		</style>
		<tree id="tree" width="300px" mold="paging" pageSize="4">
			<custom-attributes org.zkoss.zul.tree.maxRodPageSize="1" />
			<treecols>
				<treecol label="My Contact List" />
			</treecols>
		</tree>
	</window>
</zk>



"""  
  runZTL(zscript,
    () => {
      val tree = jq("@tree").toWidget();
      val a = tree.$n("a"); //button can be focused and sendKey
      var fernando = jq(".z-hlayout").first();
      var stanley = jq(".z-hlayout").last();
      var startL = stanley.positionLeft();
      var startT = stanley.positionTop();
      var endT = fernando.positionTop();
      
      mouseOver(stanley);
      waitResponse();
      for (i <- 0 to 10) {
        dragdropToObject(stanley, fernando, startL + "," + startT, startL + "," + (endT));
        waitResponse();
        verifyTrue(jq(".z-messagebox-error").length() < 1);
      }
    })
    
  }
}