package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2325.zul")
class B70_ZK_2325Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2325.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jun 18, 2014  9:55:12 PM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<div>
		if the separators still occupy 1 or 2px even if spacing="0px", that's a bug.
	</div>
    <label value='1. hbox spacing="0"'/>
    <hbox spacing="0" width="500px" height="55px" style="background:yellow">
        <vbox width="100px" height="50px" style="background:blue" />
        <vbox width="100px" height="50px" style="background:blue" />
        <vbox width="100px" height="50px" style="background:blue" />
        <vbox width="100px" height="50px" style="background:blue" />
        <vbox width="100px" height="50px" style="background:blue" />
    </hbox>
    
    <label value='2. hbox spacing="0px"'/>
    <hbox spacing="0px" width="500px" height="55px" style="background:yellow">
        <vbox width="100px" height="50px" style="background:blue" />
        <vbox width="100px" height="50px" style="background:blue" />
        <vbox width="100px" height="50px" style="background:blue" />
        <vbox width="100px" height="50px" style="background:blue" />
        <vbox width="100px" height="50px" style="background:blue" />
    </hbox>
    
    <label value='3. vbox spacing="0"'/>
    <vbox spacing="0" width="105px" height="250px" style="background:yellow">
        <hbox width="100px" height="50px" style="background:blue" />
        <hbox width="100px" height="50px" style="background:blue" />
        <hbox width="100px" height="50px" style="background:blue" />
        <hbox width="100px" height="50px" style="background:blue" />
        <hbox width="100px" height="50px" style="background:blue" />
    </vbox>

    <label value='4. vbox spacing="0px"'/>
    <vbox spacing="0px" width="105px" height="250px" style="background:yellow">
        <hbox width="100px" height="50px" style="background:blue" />
        <hbox width="100px" height="50px" style="background:blue" />
        <hbox width="100px" height="50px" style="background:blue" />
        <hbox width="100px" height="50px" style="background:blue" />
        <hbox width="100px" height="50px" style="background:blue" />
    </vbox>
</zk>


"""
    runZTL(zscript,
      () => {
        val iter = jq(".z-hbox-separator").iterator();
        while (iter.hasNext()) {
          val s = iter.next();
          verifyTrue("seperator shouldn't occupy 1 or 2px", s.width() == 0 || s.css("display") == "none");
        }

      })

  }
}