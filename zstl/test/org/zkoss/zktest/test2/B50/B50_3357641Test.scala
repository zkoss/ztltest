/* B50_3357641Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Oct 12 11:35:49 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
  * A test class for bug 3357641
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3357641.zul,A,E,ROD,Listbox,Model")
class B50_3357641Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk xmlns:w="http://www.zkoss.org/2005/zk/client">
			Please scroll to the middle of the list, and click the buttom "Run Bug (make a..."
			<separator/>
			You should see there lists "Second items0" ~ "Second items4" only
			<zscript><![CDATA[
			import java.util.ArrayList;
			import java.util.List;
			
			import org.zkoss.zk.ui.Component;
			import org.zkoss.zk.ui.util.GenericForwardComposer;
			import org.zkoss.zul.ListModelList;
			import org.zkoss.zul.Listbox;
			import org.zkoss.zul.Listcell;
			import org.zkoss.zul.Listitem;
			import org.zkoss.zul.ListitemRenderer;
			
			public class ListboxControl extends GenericForwardComposer {
			
			Listbox testListbox;
			public void doAfterCompose(Component comp) throws Exception {
			super.doAfterCompose(comp);
			
			testListbox.setItemRenderer(new ListitemRenderer() {
			
			
			public void render(Listitem arg0, Object arg1, int index) throws Exception {
			arg0.setValue(arg1);
			
			DummyItem di = (DummyItem) arg1;
			
			Listcell lc = new Listcell();
			
			lc.setLabel(di.getTest());
			
			lc.setParent(arg0);
			}
			});
			
			List ditems = generateDummyItems("First items", 500);
			
			ListModelList lstModelList = new ListModelList(ditems);
			
			testListbox.setModel(lstModelList);
			
			}
			
			public void onClick$btnNewModel() {
			List ditems = generateDummyItems("Second items", 5);
			
			ListModelList lstModelList = new ListModelList(ditems);
			
			testListbox.setModel(lstModelList);
			}
			
			public static List generateDummyItems(String prefix, int size) {
			
			List newList = new ArrayList();
			
			for (int i = 0; i < size; i++) {
			newList.add(new DummyItem(prefix + i));
			}
			return newList;
			}
			
			public static class DummyItem {
			protected String test;
			
			public DummyItem() {
			
			}
			
			public DummyItem(String test) {
			setTest(test);
			}
			
			public String getTest() {
			return test;
			}
			
			public void setTest(String test) {
			this.test = test;
			}
			
			}
			
			}               
			]]></zscript>
			<window id="win" border="none" apply="ListboxControl">
			<custom-attributes org.zkoss.zul.listbox.rod="true"/>
			<listbox checkmark="true" multiple="true" id="testListbox" height="400px" width="800px">
			<listhead sizable="true">
			<listheader label="Test"/>
			</listhead>
			</listbox>
			
			<button id="btnNewModel" label="Run Bug (make a scroll to the middle first)"/>
			</window>
			</zk>

    """

    runZTL(zscript, () => {
      var testListbox: Widget = engine.$f("testListbox");
      var btnNewModel: Widget = engine.$f("btnNewModel");
      waitResponse();

      verScroll(testListbox, 0.5)
      waitResponse();
      click(btnNewModel)
      waitResponse();

      for (i <- 0 until 5) {
        verifyContains(jq(testListbox.$n("rows")).find(".z-listcell").eq(i).text(), "items" + i)
      }
      verifyFalse(jq(testListbox.$n("rows")).find(".z-listcell").get(5).exists());
    })
  }
}