package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Touch,Android")
class B65_ZK_1458Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<label multiline="true">
	iPad/Andorid Only
	1. Click on the Listbox, should see "clicked!" message showed.
	2. Double Click on the Listbox, should see "double clicked!" message showed.
	3. Tap Hold around 1 second on the Listbox, should see "right clicked!" message showed.
	4. Swipe on the Listbox, should see "swiped!" message showed.
	</label>
	<listbox onClick='c.value="clicked!"' onDoubleClick='dc.value="double clicked!"' onRightClick='rc.value="right clicked!"' onSwipe='sw.value="swiped!"'>
		<listhead>
			<listheader label="Item" />
		</listhead>
		<listitem label="item 0" />
		<listitem label="item 1" />
		<listitem label="item 2" />
		<listitem label="item 3" />
	</listbox>
	<label id="c" /><separator />
	<label id="dc" /><separator />
	<label id="rc" /><separator />
	<label id="sw" />
</zk>

    """

    runZTL(zscript,
      () => {
        val header = jq(".z-listbox")
        singleTap(header)
        waitResponse()
        verifyTrue("should see 'clicked!' message showed.", jq(".z-label:contains(clicked)").length() == 2)
        
        doubleTap(header)
        waitResponse()
        verifyTrue("should see 'double clicked!' message showed.", jq(".z-label:contains(double clicked)").length() == 2)
        
        longPress(header)
        waitResponse()
        verifyTrue("should see 'right clicked!' message showed.", jq(".z-label:contains(right clicked)").length() == 2)
        
        swipeUp(header.find(".z-listbox-header"), 5)
        waitResponse()
        verifyTrue("should see 'swiped!' message showed.", jq(".z-label:contains(swiped)").length() == 2)
        
      })

  }
}
