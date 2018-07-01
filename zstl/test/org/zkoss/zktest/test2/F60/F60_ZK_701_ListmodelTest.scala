/* F60_ZK_701_ListmodelTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Feb 20 18:57:44 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import java.lang._

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{ClientWidget, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
  * A test class for bug ZK-701-Listmodel
  *
  * @author benbai
  *
  */
@Tags(tags = "F60-ZK-701-Listmodel.zul,F60,A,E,Cloneable,Listbox,ListModel")
class F60_ZK_701_ListmodelTest extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
				<vbox id="vb">
					1. Please select one item on the list.
					<separator />
					2. Press the "Clone" button (it should not show any exception)
					<separator />
					3. Please select another item on the top list and then click the top head to sort it.
					<separator />
					4. The sorting and the selection cannot apply to the bottom list. (That is the feature)
					<button id="btn" label="Clone">
						<attribute name="onClick">{
							Object l = grid.clone();
							l.setId("dst" + ++cnt);
							vb.insertBefore(l, self);
							}</attribute>
					</button>
					<zscript><![CDATA[
			import org.zkoss.zk.ui.util.ComponentCloneListener;
			  int cnt = 0;
			String[] data = new String[10];
			for (int i = 0; i < data.length; i++)
				data[i] = "option " + i;
			
			public class CloneableModel extends ListModelList implements ComponentCloneListener, Cloneable {
				public CloneableModel(String[] d) {
					super(d);
				}
				public Object willClone(Component comp) {
					return clone();
				}
			}
			CloneableModel model = new CloneableModel(data);
			    ]]></zscript>
					<listbox id="grid" model="${model}" onSelect="">
						<listhead>
							<listheader label="column" sort="auto" />
						</listhead>
					</listbox>
				</vbox>
			</zk>

    """
    runZTL(zscript,
      () => {
        var btn: Widget = engine.$f("btn");
        var grid: Widget = engine.$f("grid");
        var clonedGrid: Widget = null;

        def clickAndWait(wgt: ClientWidget) {
          click(wgt);
          waitResponse();
        }

        def selectItem(wgt: Widget, content: String) {
          clickAndWait(jq(wgt).find(".z-listitem:contains(" + content + ")"));
        }

        def isSelected(wgt: Widget, content: String, selected: Boolean) {
          if (selected)
            verifyTrue("The item contains " + content + " should be selected",
              jq(wgt.$n()).find(".z-listitem-selected:contains(" + content + ")").exists());
          else
            verifyFalse("The item contains " + content + " should not be selected",
              jq(wgt.$n()).find(".z-listitem-selected:contains(" + content + ")").exists());
        }

        def verifyOrder(wgt: Widget, content: String, order: Int) {
          verifyContains("The " + order + " th element should contains " + content,
            jq(wgt).find(".z-listitem").get(order).get("innerHTML"), content)
        }

        selectItem(grid, "option 3");
        clickAndWait(btn);
        clonedGrid = widget(jq(jq(".z-listbox").get(0)));

        isSelected(grid, "option 3", true);
        isSelected(clonedGrid, "option 3", true);

        selectItem(clonedGrid, "option 0");
        clickAndWait(jq(clonedGrid).find(".z-listheader:contains(column)").get(0));
        clickAndWait(jq(clonedGrid).find(".z-listheader:contains(column)").get(0));
        isSelected(grid, "option 0", false);
        isSelected(clonedGrid, "option 0", true);
        verifyOrder(grid, "option 0", 0);
        verifyOrder(clonedGrid, "option 0", 9);

      }
    );
  }
}