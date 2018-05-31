/* B60_ZK_927_3Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 30 17:14:11 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import java.lang._

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Element, JQuery, Tags, Widget}

/**
  * A test class for bug ZK-927-3
  *
  * @author benbai
  *
  */
@Tags(tags = "B60-ZK-927-3.zul,")
class B60_ZK_927_3Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
			<zk>
				<window >
				<label multiline="true">
				1.listbox1 is multiple selection, it select 3rd item after loaded.
				2.listbox2 is signle selection, it select 3rd item after loaded.
				3.do multiple selection on listbox1, you will see  selectedItem1 change to your selection
				4.do single selection on listbox2, you will see  selectedItem2 change to your selection
				5.click clear, the selection of listbox was clear
				5.click reload, selectedItem1 and selectedItem2 was clear. 
				</label>
				<zscript><![CDATA[
					List list = new ArrayList();
					
					for (int i = 0; i < 10; i++) {
						list.add("item " + i);
					}
					
					ListModelList model = new ListModelList(list);
					model.addSelection(model.getElementAt(2));
					model.setMultiple(true);
					
					
					Set set = new HashSet();
					
					for (int i = 0; i < 10; i++) {
						set.add("item " + i);
					}
					
					ListModelSet model2 = new ListModelSet(set);
					model2.setMultiple(false);
					model2.addSelection(model2.getElementAt(2));
				]]></zscript>
				<hbox>
				<listbox id="listbox1" width="150px" model="@{model, load-when='reload.onClick'}" checkmark="true">
					<listhead>
						<listheader label="col"/>
					</listhead>
					<listitem self="@{each=item}" label="@{item}"/>
				</listbox>
				<listbox id="listbox2" width="150px" model="@{model2, load-when='reload.onClick'}" checkmark="true">
					<listhead>
						<listheader label="col"/>
					</listhead>
					<listitem self="@{each=item}" label="@{item}"/>
				</listbox>
				</hbox>
				<vbox>
					<hbox>
						selectedItem1 : <label id="lbl1" value="@{listbox1.model.selection, load-when='listbox1.onSelect,reload.onClick'}" />
					</hbox>
					<hbox>
						selectedItem2 : <label id="lbl2" value="@{listbox2.model.selection, load-when='listbox2.onSelect,reload.onClick'}" />
					</hbox>
				</vbox>
				<button id="clear" label="clear" onClick="model.clearSelection();model2.clearSelection();" />	
				<button id="reload" label="reload" />
				</window>
			</zk>

    """

    runZTL(zscript,
      () => {
        var listbox1: Widget = engine.$f("listbox1");
        var listbox2: Widget = engine.$f("listbox2");
        var lbl1: Widget = engine.$f("lbl1");
        var lbl2: Widget = engine.$f("lbl2");
        var clear: Widget = engine.$f("clear");
        var reload: Widget = engine.$f("reload");

        def select(lb: Widget, lbl: Widget, items: Array[Int]) {
          for (i <- 0 until items.length) {
            click(jq(lb).find(".z-listitem").get(items(i)));
            waitResponse();
          }
        }

        def check(lb: Widget, lbl: Widget, items: Array[Int]) {
          var listitems: JQuery = jq(lb).find(".z-listitem");
          var item: Element = null;
          var cnt: String = null;
          var selected: Boolean = null;
          for (i <- 0 until listitems.length()) {
            selected = items.contains(i);
            item = jq(lb).find(".z-listitem").get(i);

            cnt = jq(item).find(".z-listcell").eq(0).text();
            cnt = cnt.substring(cnt.length() - 5, cnt.length());

            verifyTrue("Item " + i + " should "
              + (if (selected) "" else "not ") + "be selected",
              jq(item).hasClass("z-listitem-selected") == selected
                && (lbl == null || lbl.$n().get("innerHTML").contains(cnt) == selected));

          }
        }

        check(listbox1, lbl1, Array(2));
        check(listbox2, lbl2, Array(2));

        select(listbox1, lbl1, Array(3, 5));
        select(listbox2, lbl2, Array(5));
        check(listbox1, lbl1, Array(2, 3, 5));
        check(listbox2, lbl2, Array(5));

        click(clear);
        waitResponse();
        check(listbox1, null, Array());
        check(listbox2, null, Array());

        click(reload);
        waitResponse();
        check(listbox1, lbl1, Array());
        check(listbox2, lbl2, Array());
      }
    );
  }
}