package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1758.zul")
class B65_ZK_1758Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1758.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Sep 17, 2013 12:20:55 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<window id="win" width="600px" border="normal">
You should see '#lb listitem 2' and '#lb > listitem 2' below, not '#lb > listitem 5' 
	<listbox id="lb">
		<listhead>
			<listheader label="row0" />
		</listhead>
		<listitem>
			<listcell label="item0" />
		</listitem>
		<listitem>
			<listcell label="item1" />
		</listitem>
	</listbox>
	<separator />
	<listbox id="nohead">
		<listitem>
			<listcell label="i0" />
		</listitem>
		<listitem>
			<listcell label="i1" />
		</listitem>
		<listitem>
			<listcell label="i2" />
		</listitem>
	</listbox>
	<separator />
	<hbox>#lb listitem <label id="msg" /></hbox>
	<hbox>#lb > listitem <label id="msg2" /></hbox>
	<zscript><![CDATA[
       	     List comps = org.zkoss.zk.ui.select.Selectors.find(page, "#lb listitem");
      	     msg.setValue("" + comps.size());
      	     comps = org.zkoss.zk.ui.select.Selectors.find(page, "#lb > listitem");
      	     msg2.setValue("" + comps.size());
	]]></zscript>

</window>
"""
    runZTL(zscript,
      () => {
        verifyTrue("You should see '#lb listitem 2' and '#lb > listitem 2' below, not '#lb > listitem 5'",
          jq(".z-hbox .z-label:contains(2)").length() == 2)
      })

  }
}