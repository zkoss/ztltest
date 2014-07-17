package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys

@Tags(tags = "B70-ZK-2264.zul")
class B70_ZK_2264Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2264.zul

	Purpose:
		
	Description:
		
	History:
		Fri, Apr 25, 2014  2:48:54 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
1. Please scroll the scrollbar to the right.
<separator/>
2. Click to the next button in the paging bar
<separator/>
3. Please scroll the scrollbar to the right or left, the content of the grid should be scrolled as well.
	<zscript>
		List rowData = Collections.nCopies(46, "row");
		List data = Collections.nCopies(20, "column");
	</zscript>
<grid mold="paging" pageSize="15">
	<custom-attributes org.zkoss.zul.nativebar="false"/>
	<frozen columns="1"/>
	<columns >
		<column label="first" width="400px"/>
		<column forEach="${data}" label="${each} ${forEachStatus.index + 1}" width="200px"/>
	</columns>
	<rows>
		<row forEach="${rowData}" >
			<label value="${each} ${forEachStatus.index + 1}"></label>
			<cell forEach="${data}" width="200px">
				<label value="${each} ${forEachStatus.index + 1}"/> 
			</cell>
		</row>
	</rows>
</grid>

</zk>
"""
    runZTL(zscript,
      () => {
        // don't support ie9
        val grid = jq("@grid");
        if (!hasNativeScroll(grid.toWidget())) { // ie8 only has native scrollbar
          // for fake scrollbar, we need to do some special steps to make it scroll like manually.
          // simulate mouse over that then we can do mouseDown()
          grid.toWidget().eval("_scrollbar._mouseEnter()");
          val indicator = jq(".z-scrollbar-indicator");
          // move to right side
          mouseDownAt(indicator, "100,2");
          waitResponse();
          mouseMoveAt(indicator, indicator.width() + ",2");
          waitResponse();

          click(jq(".z-paging-next"));
          waitResponse();

          // move to left side
          grid.toWidget().eval("_scrollbar._mouseEnter()");
          mouseDownAt(indicator, "2,2");
          waitResponse();
          mouseMoveAt(indicator, "2,2");
          waitResponse();

          // move to right side
          mouseMoveAt(indicator, indicator.width() + ",2");
          waitResponse();

          println(jq("@column").eq(1).width());
          verifyTrue("The width of column eqauls -1 means grid can be scrolled.", jq("@column").eq(1).width() < 1);
        }
      })

  }
}