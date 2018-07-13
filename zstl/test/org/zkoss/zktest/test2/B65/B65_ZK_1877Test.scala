package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.Element

@Tags(tags = "B65-ZK-1877.zul")
class B65_ZK_1877Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1877.zul

	Purpose:
		
	Description:
		
	History:
		Thu, Aug 01, 2013  9:40:21 AM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
<label multiline="true">
1. Please drag the slider to the right-most.
2. Please drag the slider to the left-most.
3. You should see the curpos stays in 0, not 1.
</label>
<grid>
	<rows>                                                                 
		<row>
			<cell width="70px">
				<label value="curpos:" />
				<label id="lblAlpha" />
			</cell>
			<cell>
				<slider id="slider" onScroll="lblAlpha.setValue(String.valueOf(self.getCurpos()))" />
			</cell>
		</row>
	</rows>
</grid>
</zk>"""
    runZTL(zscript,
      () => {
        val slider = jq(".z-slider-horizontal").toWidget()
        val btn = slider.$n("btn")
        val rail = slider.$n("inner")
        dragAndDrop(btn, "220,0")
        waitResponse()
        dragAndDrop(btn, "-220,0")
        waitResponse()

        verifyContains("You should see the curpos stays in 0",
          jq(".z-label:contains(curpos:) + .z-label").text(), "0")
      })

  }
}