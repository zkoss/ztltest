package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2390.zul")
class B70_ZK_2390Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2390.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Aug 06, 2014 12:19:26 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk xmlns:n="native">
	<div style="border: 1px solid blue;" height="105px">navbar</div>
	<hlayout id="main" width="100%">
		<div style="border: 1px solid green;" width="100px" height="300px">sidebar</div>
		<vlayout hflex="1">		
			<hbox hflex="1">
		  		<window border="normal" hflex="1" title="You should see the width of the window is extended to right edge, not the same as red color div" sizable="true">
					<div width="300px" height="300px" style="border: 1px solid red;"></div>
				</window>
		  	</hbox>
			<!-- using hlayout instead of hbox works -->
<!-- 			<hlayout self="@insert(detail)" hflex="1"/> -->
		</vlayout>
	</hlayout>
</zk>

"""
    runZTL(zscript,
      () => {
        val hlayout = jq("@hlayout");
        val win = jq("@window");
        println(hlayout.offsetLeft() + hlayout.width(), " ", win.offsetLeft() + win.outerWidth());
        verifyEquals("window should be extended to right edge.",
          hlayout.offsetLeft() + hlayout.width(), win.offsetLeft() + win.outerWidth());
      })

  }
}
