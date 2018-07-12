/* B60_ZK_927_2Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 30 16:59:54 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import java.lang._

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{JQuery, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-927-2
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-927-2.zul,")
class B60_ZK_927_2Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
			<zk>
				<window >
				<label multiline="true">
				1.listbox1 is single selection, it select 1st item after loaded.
				2.do single selection on listbox1, you will see  selectedItem change to your selection
				3.click set,then reload, selection should back to 1st item
				</label>
					
				<zscript><![CDATA[
					List list = new ArrayList();
					
					for (int i = 0; i < 10; i++) {
						list.add("item " + i);
					}
					
					java.util.Map selections = new java.util.HashMap();
					
					selections.put("selectedItem",list.get(0));
				]]></zscript>
				<hbox>
				<listbox id="listbox1" width="150px" model="@{list, load-when='reload.onClick'}" multiple="false" selectedItem="@{selections.selectedItem, load-when='reload.onClick'}" checkmark="true" >
					<listhead>
						<listheader label="col"/>
					</listhead>
					<listitem self="@{each=item}" label="@{item}"/>
				</listbox>
				</hbox>
				<vbox>
					<hbox>
						selectedItem : <label id="lb" value="@{selections.selectedItem, load-when='listbox1.onSelect,reload.onClick'}" />
					</hbox>
				</vbox>
				<button id="set" label="set" onClick='selections.put("selectedItem",list.get(0));' />
				<button id="reload" label="reload" />
				</window>
			</zk>

    """

    runZTL(zscript,
      () => {
        var lbx: Widget = engine.$f("listbox1");
        var lb: Widget = engine.$f("lb");
        var set: Widget = engine.$f("set");
        var reload: Widget = engine.$f("reload");

        def select(item: Int) {
          click(jq(lbx).find(".z-listitem:contains(item " + item + ")"));
          waitResponse();
          check(item);
        }

        def check(item: Int) {
          var listitems: JQuery = jq(lbx).find(".z-listitem");
          var selected: Boolean = null;
          for (i <- 0 until 10) {
            selected = (item == i);
            verifyTrue(jq(lbx).find(".z-listitem-selected:contains(item " + i + ")").exists() == selected);
          }
          verifyContains("item " + item + " should be selected",
            lb.$n().attr("innerHTML"), "item " + item)
        }

        check(0);
        select(2);

        click(set);
        waitResponse();
        click(reload);
        waitResponse();

        check(0);
      }
    );
  }
}