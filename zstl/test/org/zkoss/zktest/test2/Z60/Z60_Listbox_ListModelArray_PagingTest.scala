/* Z60_Listbox_ListModelArray_PagingTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Jan 16 15:54:32 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.Z60

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
 * A test class for bug Listbox-ListModelArray-Paging
 * @author benbai
 *
 */
@Tags(tags = "Z60-Listbox-ListModelArray-Paging.zul,Z60,A,E,Listbox,Paging,ListModelArray")
class Z60_Listbox_ListModelArray_PagingTest extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
				<zscript>
					<![CDATA[
					import org.zkoss.zktest.test2.select.models.*;
					
					ListModelArray model = ListModelArrays.getModel(ListModelArrays.DEFAULT);
					ListModelArray model2 = ListModelArrays.getModel(ListModelArrays.CLONEABLE);
			
					int cnt = 0;
					int elemcnt = 0;
			
					public void checkEqualSelection (String idOne, String idTwo, Label msg) {
						Listbox lbOne = msg.getPage().getFellow(idOne);
						Listbox lbTwo = msg.getPage().getFellow(idTwo);
						Set s1 = lbOne.getModel().getSelection();
						Set s2 = lbTwo.getModel().getSelection();
						boolean matched = false;
						for (Object o : s1) {
							for (Object o2 : s2) {
								if (o.equals(o2)) {
									matched = true;
									break;
								}
							}
							if (!matched) {
								msg.setValue("false");
								return;
							}
							matched = false;
						}
						msg.setValue("true");
					}
					public void showSelection (String idOne, Label msg) {
						Listbox lbOne = msg.getPage().getFellow(idOne);
						Set s1 = lbOne.getModel().getSelection();
						StringBuilder sb = new StringBuilder("");
						boolean matched = false;
						for (Object o : s1) {
							sb.append(o);
						}
						msg.setValue(sb.toString());
					}
					public void changePage(String id, String itemNumber, Page page) {
						Listbox lbx = page.getFellow(id);
						int inm = Integer.parseInt(itemNumber);
						lbx.setActivePage(inm/lbx.getPageSize());
					}
				]]></zscript>
				<div>
					<div>1. There are 3 Listbox below.</div>
					<div>2. For first two Listbox, their select status will sync automatically after you select item.</div>
					<div>3. Select data 10 of third Listbox.</div>
					<div>4. Click clone and 'clone by serialization', then two Listboxes should be created and also select data 10.</div>
					<div>5. Select data 212 of third Listbox, data 213 of fourth and data 214 of fifth, the select status of last three listbox should not sync.</div>
					<div>6. Click clone and 'clone by serialization', you should see two Listboxes created and each Listbox after fifth Listbox select data 212.</div>
				</div>
    			<label id="outer" value="outer" />
				<hbox>
					<listbox id="lbxOne" height="150px" width="310px" mold="paging" pageSize="10" model="${model}" onSelect="" checkmark="true" />
					<listbox id="lbxTwo" height="150px" width="310px" mold="paging" pageSize="10" model="${model}" onSelect="" checkmark="true" />
					<listbox id="lbxThree" height="150px" width="310px" mold="paging" pageSize="10" model="${model2}" onSelect="" checkmark="true" />
				</hbox>
				<hbox>
					<textbox id="tbOne" value="box one" onChange="" />
					<textbox id="tbTwo" value="box two" onChange="" />
					<button id="btnOne" label="check equal selection" onClick='checkEqualSelection(tbOne.getValue(), tbTwo.getValue(), msg);' />
					<button id="btnFour" label="show selection" onClick='showSelection(tbOne.getValue(), msg);' />
					<button id="pagingBtn" label="go to page" onClick='changePage(tbOne.getValue(), tbTwo.getValue(), self.getPage());' />
					<label id="msg" />
				</hbox>
				<div height="10px"></div>
				<button id="btnTwo" label="clone">
					<attribute name="onClick">
						Listbox lbx = lbxThree.clone();
						lbx.setId("lbxThree_clone" + cnt++);
						lbx.setParent(cloneThreeArea);
					</attribute>
				</button>
				<button id="btnThree" label="Clone by Serialization">
					<attribute name="onClick"><![CDATA[{
						import java.io.*;
						ByteArrayOutputStream boa = new ByteArrayOutputStream();
						new ObjectOutputStream(boa).writeObject(lbxThree);
						byte[] bs = boa.toByteArray();
						Object n = new ObjectInputStream(new ByteArrayInputStream(bs)).readObject();
						n.setId("lbxThree_serialize" + cnt++);
						((Component)n).setParent(cloneThreeArea);
					}]]></attribute>
				</button>
				<hbox id="cloneThreeArea" />
			</zk>

    """

   runZTL(zscript,
        () => {
        var outer: Widget = engine.$f("outer");
        var lbxOne: Widget = engine.$f("lbxOne");
        var lbxTwo: Widget = engine.$f("lbxTwo");
        var lbxThree: Widget = engine.$f("lbxThree");
        var tbOne: Widget = engine.$f("tbOne");
        var tbTwo: Widget = engine.$f("tbTwo");
        var btnOne: Widget = engine.$f("btnOne");
        var btnTwo: Widget = engine.$f("btnTwo");
        var btnThree: Widget = engine.$f("btnThree");
        var btnFour: Widget = engine.$f("btnFour");
        var pagingBtn: Widget = engine.$f("pagingBtn");
        var msg: Widget = engine.$f("msg");
        var itemHgh: Int = jq(lbxOne.$n()).find(".z-listitem").outerHeight(true);
        var checkList: java.util.List[Int] = new java.util.ArrayList[Int]();

        def selectItem = (id: String, num: Int) => {
          var lbx: Widget = engine.$f(id);
          input(tbOne.$n(), id);
          input(tbTwo.$n(), num+"");
          click(pagingBtn);
          sleep(600);
          var listitem: Element = jq(lbx.$n("body")).find(".z-listitem:contains(\"data "+num+"\")").get(0);
          click(listitem);
        }
        // check whether the selection of a listbox contains exactly the content in check list
        def checkSelection = (toCheck: java.util.List[Int], id: String) => {
          input(tbOne.$n(), id);
          click(btnFour);
          waitResponse();
          var selection: String = msg.$n().get("innerHTML");
          var item: String = "";
          for (i <- 0 to toCheck.size()-1) {
            item = "data "+toCheck.get(i);
            verifyTrue("the selection of "+id+"should contains "+item,
                selection.contains(item));
            selection = selection.replace(item, "");
          }
          verifyTrue("the selection should exactly contains the check list data, no more",
              selection.length() == 0);
        }
        def checkEqualSelection = (idOne: String, idTwo: String, assertValue: Boolean) => {
          input(tbOne.$n(), idOne);
          input(tbTwo.$n(), idTwo);
          click(btnOne);
          waitResponse();
          if (assertValue)
            verifyTrue("The selection of these two listbox ("+idOne+", "+idTwo+") should the same",
                msg.$n().get("innerHTML").equals("true"));
          else
            verifyTrue("The selection of these two listbox ("+idOne+", "+idTwo+") should different",
                msg.$n().get("innerHTML").equals("false"));
        }
        def input = (tb: Element, value: String) => {
          findElement(tb.toBy()).clear()
          `type`(tb, value)
          waitResponse();
        }
        selectItem("lbxOne", 2);
        checkEqualSelection("lbxOne", "lbxTwo", true);
        selectItem("lbxTwo", 200);
        checkEqualSelection("lbxOne", "lbxTwo", true);

        selectItem("lbxThree", 10);
        click(btnTwo);
        sleep(1000);
        click(btnThree);
        sleep(1000);

        checkList.add(10);
        checkSelection(checkList, "lbxThree");

        checkEqualSelection("lbxThree", "lbxThree_clone0", true);
        checkEqualSelection("lbxThree", "lbxThree_serialize1", true);
        selectItem("lbxThree", 212);
        selectItem("lbxThree_clone0", 213);
        selectItem("lbxThree_serialize1", 214);

        checkEqualSelection("lbxThree", "lbxThree_clone0", false);
        checkEqualSelection("lbxThree", "lbxThree_serialize1", false);
        checkEqualSelection("lbxThree_clone0", "lbxThree_serialize1", false);

        click(btnTwo);
        sleep(1000);
        click(btnThree);
        sleep(1000);

        checkList.clear();
        checkList.add(212);
        checkSelection(checkList, "lbxThree");

        checkEqualSelection("lbxThree", "lbxThree_clone2", true);
        checkEqualSelection("lbxThree", "lbxThree_serialize3", true);
    }
   );
  }
}