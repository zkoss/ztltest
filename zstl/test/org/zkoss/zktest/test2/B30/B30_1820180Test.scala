/* B30_1820180Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1820180Test extends ZTL4ScalaTestCase {
  @Test
  def testSizing() = {
    var zscript =
      """
<?xml version="1.0" encoding="UTF-8"?>
<window id="root" border="normal" >
<html><![CDATA[

1. When resizing the page by dragging the right bottom corner of browser window or by
clicking the maximum/minimum buttons, the "display area" ( enclosed by the
border) of the panels should resize to fit the browser window size. <br/>
2. Instead the area resizes in a random pattern, by clicking the maximum/minimum buttons a few times, the
left pane should not occupy the whole page, leaving no space to the right pane. <br/>
]]></html>

<hbox width="600px" sizedByContent="false">

<tabbox id="tabbox" style="width:100%">

<tabs>
<tab label="Tab 1" />
<tab label="Tab 2" />
</tabs>

<tabpanels>

<tabpanel>
<tree id="ncstree" vflex="true" >

<treechildren>
<treeitem label="group 1" open="false" />
<treeitem label="group 2" open="false" />
<treeitem label="group 3" open="false" />
<treeitem label="group 4" open="false" />
<treeitem label="group 5" open="false" />
<treeitem label="group 6" open="false" />
<treeitem label="group 7" open="false" />
<treeitem label="group 8" open="false" />
<treeitem label="group 9" open="false" />
<treeitem label="group 10" open="false" />
</treechildren>

</tree>
</tabpanel>

<tabpanel>
</tabpanel>

</tabpanels>

</tabbox>

<splitter id="split"/>

<window id="contents" width="100%" height="100%" border="none" >
</window>


</hbox>
</window>

		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val root = ztl$engine.$f("root")
    val tabbox = ztl$engine.$f("tabbox")
    val ncstree = ztl$engine.$f("ncstree")
    val split = ztl$engine.$f("split")
    val contents = ztl$engine.$f("contents")
    runZTL(zscript, () => {
      var width = jq(tabbox).outerWidth()
      windowResizeTo(500, 500)
      verifyTrue(width - jq(tabbox).outerWidth() < 2)
      windowMaximize()
      verifyTrue(width - jq(tabbox).outerWidth() < 2)
      width = jq(tabbox).outerWidth()
      dragdropTo(split, "0,0", "-20,0")
      verifyEquals(width - 20, jq(tabbox).outerWidth())
    })
  }
}



