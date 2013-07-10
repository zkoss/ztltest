/* B60_ZK_927_4Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 30 17:48:01 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
 * A test class for bug ZK-927-4
 * @author benbai
 *
 */
@Tags(tags = "B60-ZK-927-4.zul,")
class B60_ZK_927_4Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
			<zk>
				<window >
				<label multiline="true">
				1.select combobox1,
				2.select combobox2, the selectedItem should change to the selection
				3.click set,then reload, the selection of comboxbox1 should not change, the selection of combobox2 should back to 1st item
				</label>
					
				<zscript><![CDATA[
					List list = new ArrayList();
					
					for (int i = 0; i < 10; i++) {
						list.add("item " + i);
					}
					
					java.util.Map selections = new java.util.HashMap();
					
					
				]]></zscript>
				<hbox>
				<combobox id="combo1" width="150px" model="@{list, load-when='reload.onClick'}" >
					<comboitem self="@{each=item}" label="@{item}"/>
				</combobox>
				
				<combobox id="combo2" width="150px" model="@{list, load-when='reload.onClick'}" selectedItem="@{selections.selectedItem, load-when='reload.onClick'}">
					<comboitem self="@{each=item}" label="@{item}"/>
				</combobox>
				</hbox>
				<vbox>
					<hbox>
						selectedItem : <label id="lbl" value="@{selections.selectedItem, load-when='combo2.onChange,reload.onClick'}" />
					</hbox>
				</vbox>
				<button id="set" label="set" onClick='selections.put("selectedItem",list.get(0));' />
				<button id="reload" label="reload" />
				</window>
			</zk>

    """

    runZTL(zscript,
        () => {
        var combo1: Widget = engine.$f("combo1");
        var combo2: Widget = engine.$f("combo2");
        var lbl: Widget = engine.$f("lbl");
        var set: Widget = engine.$f("set");
        var reload: Widget = engine.$f("reload");

        def open(combo: Widget) {
          click(combo.$n("btn"));
          waitResponse();
        }
        def select (combo: Widget, item: Int) {
          open(combo);
          click(jq(combo.$n("pp")).find(".z-comboitem").get(item));
          waitResponse();
        }
        def check (combo: Widget, item: Int) {
          var cnt: String = lbl.$n().get("innerHTML");
          var ci: Element = jq(combo.$n("pp")).find(".z-comboitem").get(item);
          
          var itemCnt: String = jq(ci).find(":contains(item)").get(0).get("innerHTML");
          verifyTrue("Item "+item+" should be selected",
              itemCnt.contains(cnt.split(" ")(0))
              && itemCnt.contains(cnt.split(" ")(1)));
        }
        def checkByString (combo: Widget, item: Int, cnt: String) {
          var ci: Element = jq(combo.$n("pp")).find(".z-comboitem").get(item);
          
          var itemCnt: String = jq(ci).find(":contains(item)").get(0).get("innerHTML");
          verifyTrue("Item "+item+" should be selected",
              itemCnt.contains(cnt.split(" ")(0))
              && itemCnt.contains(cnt.split(" ")(1)));
        }
        select(combo1, 2);
        select(combo2, 2);
        check(combo2, 2);

        click(set); waitResponse();
        click(reload); waitResponse();

        check(combo2, 0);
        checkByString(combo1, 2, "item 2");
    }
   );

  }
}