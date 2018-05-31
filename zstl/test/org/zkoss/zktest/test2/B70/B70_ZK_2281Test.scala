package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2306.zul")
class B70_ZK_2281Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2281.zul

	Purpose:
		
	Description:
		
	History:
		Wed, May 07, 2014 11:37:46 AM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<?taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" ?>
<!-- MVC example -->
<vlayout apply="org.zkoss.zktest.test2.B70_ZK_2281_Composer">
Please scroll to right, and click the next page. (you should not see any JS error)
	<grid id="gridSaldiGiornalieri" emptyMessage="empty" width="100%">
		<custom-attributes org.zkoss.zul.nativebar="false"/>
		<frozen columns="1" />

		<columns sizable="true" width="100%">
			<column label="labels.stampings.employee" width="200px" />
			<column style="text-align:right;" width="90px" forEach="${$composer.columns}"
				label="${each}" />
		</columns>

		<template name="model">
			<row width="100%">
				<cell>
					<label width="55px" value="${each}" />
				</cell>
				<cell popup="tooltipPopup" context="contextMenu">
					<label width="55px" value="${forEachStatus.index}" />
				</cell>
			</row>
		</template>
	</grid>

	<paging detailed="true" autohide="false" mold="default" id="paging"></paging>
</vlayout>
"""
    runZTL(zscript,
      () => {
        val grid = jq("@grid");
        if (!hasNativeScroll(grid.toWidget())) { // ie8 only has native scrollbar
          val indicator = jq(".z-scrollbar-indicator");
          mouseDownAt(indicator, "100,2");
          waitResponse();
          mouseMoveAt(indicator, indicator.width() + ",2");
          waitResponse();
          click(jq(".z-paging-next"));
          waitResponse();
          verifyFalse(jq(".z-error").exists());
        }
      })

  }
}