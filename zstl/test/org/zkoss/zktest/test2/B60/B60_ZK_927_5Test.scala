/* B60_ZK_927_5Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 30 18:15:59 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import java.lang._

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-927-5
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-927-5.zul,")
class B60_ZK_927_5Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
			<zk>
				<window >
				<label multiline="true">
				1.select select1,
				2.select select1, the selectedIndex should change to the selection
				3.click set,then reload, the selection of select1 should not change, the  selectedIndex should change to 0.
				4.however the select2 , selection will not change to 0 because of it doesn't imple a selectedIndex converter yet.
				</label>
					
				<zscript><![CDATA[
					List list = new ArrayList();
					
					for (int i = 0; i < 10; i++) {
						list.add("item " + i);
					}
					
					java.util.Map selections = new java.util.HashMap();
					
					
				]]></zscript>
				<hbox>
				<selectbox id="sel1" width="150px" model="@{list, load-when='reload.onClick'}" >
					<template name="model">${each}</template>
				</selectbox>
			
				<selectbox id="sel2" width="150px" model="@{list, load-when='reload.onClick'}" selectedIndex="@{selections.selectedIndex, load-when='reload.onClick'}">
					<template name="model">${each}</template>
				</selectbox>
				
				</hbox>
				<vbox>
					<hbox>
						selectedIndex : <label id="lbl" value="@{selections.selectedIndex, load-when='sel2.onChange,reload.onClick'}" />
    					<label id="outArea" value="outArea" />
					</hbox>
				</vbox>
				<button id="set" label="set" onClick='selections.put("selectedIndex",0);' />
				<button id="reload" label="reload" />
				</window>
			</zk>

    """

    runZTL(zscript,
      () => {
        var sel1: Widget = engine.$f("sel1");
        var sel2: Widget = engine.$f("sel2");
        var lbl: Widget = engine.$f("lbl");
        var outArea: Widget = engine.$f("outArea");
        var set: Widget = engine.$f("set");
        var reload: Widget = engine.$f("reload");

        def select(sbx: Widget, num: Int) {
          focus(sbx);
          sbx.$n().eval("selectedIndex = " + num);
          blur(sbx);
          waitResponse();
        }

        def check(sbx: Widget, num: Int, checkLbl: Boolean) {
          verifyContains(sbx.$n().get("selectedIndex"), num + "")
          if (checkLbl)
            verifyContains(lbl.$n().get("innerHTML"), num + "")
        }

        select(sel1, 2);
        select(sel2, 2);
        check(sel1, 2, false);
        check(sel2, 2, true);

        click(set);
        waitResponse();
        click(reload);
        waitResponse();
        verifyContains(lbl.$n().get("innerHTML"), 0 + "")

        check(sel1, 2, false);
        check(sel2, 2, false);
      }
    );
  }
}