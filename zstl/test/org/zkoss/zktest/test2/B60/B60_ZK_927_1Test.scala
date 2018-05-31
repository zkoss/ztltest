/* B60_ZK_927_1Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 30 16:35:41 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import java.lang._

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{JQuery, Tags, Widget}

/**
  * A test class for bug ZK-927-1
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-927-1.zul,")
class B60_ZK_927_1Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
			<zk>
				<window >
				<label multiline="true">
				1.listbox1 is single selection and listbox2 is multiple selection
				2. do single selection on listbox1, multiple selection on listbox2.
				3. click reload. both listbox1 and listbox2 should keep the selection.
				</label>
				<zscript><![CDATA[
					List list = new ArrayList();
					
					for (int i = 0; i < 10; i++) {
						list.add("item " + i);
					}
					
				]]></zscript>
				<hbox>
				<listbox id="listbox1" width="150px" model="@{list, load-when='reload.onClick'}" multiple="false" checkmark="true" >
					<listhead>
						<listheader label="col"/>
					</listhead>
					<listitem self="@{each=item}" label="@{item}"/>
				</listbox>
				
				<listbox id="listbox2" width="150px" model="@{list, load-when='reload.onClick'}" checkmark="true" multiple="true" >
					<listhead>
						<listheader label="col"/>
					</listhead>
					<listitem self="@{each=item}" label="@{item}"/>
				</listbox>
				 
				</hbox>
				<button id="reload" label="reload" />
				</window>
			</zk>

    """

    runZTL(zscript,
      () => {
        var listbox1: Widget = engine.$f("listbox1");
        var listbox2: Widget = engine.$f("listbox2");
        var reload: Widget = engine.$f("reload");

        def select(lb: Widget, items: Array[Int]) {
          for (i <- 0 until items.length) {
            click(jq(lb).find(".z-listitem:contains(item " + items(i) + ")"));
            waitResponse();
          }
          check(lb, items);
        }

        def check(lb: Widget, items: Array[Int]) {
          var listitems: JQuery = jq(lb).find(".z-listitem");
          var selected: Boolean = null;
          for (i <- 0 until listitems.length()) {
            selected = items.contains(i);
            verifyTrue("Item " + i + " should "
              + (if (selected) "" else "not ") + "be selected",
              jq(lb).find(".z-listitem-selected:contains(item " + i + ")")
                .exists() == selected);
          }
        }

        select(listbox1, Array(1));
        select(listbox2, Array(2, 5));

        click(reload);
        waitResponse();

        check(listbox1, Array(1));
        check(listbox2, Array(2, 5));
      }
    );
  }
}