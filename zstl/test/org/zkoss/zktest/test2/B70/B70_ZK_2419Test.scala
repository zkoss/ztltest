package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2419.zul")
class B70_ZK_2419Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2419.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Sep 03, 2014  1:54:33 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
Please drag the silder to 3.5 value, and it should stay at 3.5 value and its tooltip should be 3.5 as well
<zscript>
public class SliderDoubleVM {
	double potentialRisk = 2.0;
	public void setPotentialRisk(double potentialRisk) {
		this.potentialRisk = potentialRisk; 
	}
	public double getPotentialRisk() {
		return potentialRisk;
	}
}
</zscript>
<div apply="org.zkoss.bind.BindComposer"
	viewModel="@id('vm')@init('SliderDoubleVM')">
	<slider mode="decimal" maxpos="5.0" step="0.5"
		curpos="@bind(vm.potentialRisk)" />
	<label value="@load(vm.potentialRisk)"></label>
</div>
</zk>


"""
    runZTL(zscript,
      () => {
        val sliderBtn = jq(".z-slider-button");

        mouseOver(sliderBtn);
        waitResponse();
        dragdropTo(sliderBtn, "0,0", "55,0");
        waitResponse();
        verifyEquals("3.5", jq(".z-label").last().text())
        verifyEquals("3.5", sliderBtn.attr("title"))
      })

  }
}