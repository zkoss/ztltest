package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1920.zul")
class B65_ZK_1920Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1920.zul

	Purpose:
		
	Description:
		
	History:
		Thu, Sep 05, 2013 12:54:49 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
<label multiline="true">
1.Select the "handler"
2.Some listitems added to the Listbox, itemTypesLbx, and 5 items were selected.
3.Select the "handler" again to run the same code.
4.The top 5 items of the listbox should be selected.
</label>
<listbox id="handlerLbx" multiple="true" checkmark="true">
	<attribute name="onSelect"><![CDATA[
        		itemTypesLbx.getItems().clear();
        		for (int i = 0; i < 10; i++) {
        			Listitem item = new Listitem("newItem"+i);
        			if (i < 5 )
        				item.setSelected(true);
        			itemTypesLbx.appendChild(item);
        		}
	]]></attribute>
	<listitem label="handler" />
</listbox>
<listbox id="itemTypesLbx" multiple="true" checkmark="true"/>
</zk>
"""
    runZTL(zscript,
      () => {
        val handler = jq(".z-listitem:contains(handler)")
        1 to 2 foreach { n =>
          click(handler)
          waitResponse()
          verifyTrue("5 items were selected",
            jq(".z-listbox:eq(1) .z-listitem-selected").length() == 5)

        }

      })

  }
}