/* Z60_Listbox_ListModelMap_Multiple_noRODTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Jan 17 11:38:01 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.Z60

import java.lang._

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Element, Tags, Widget}

/**
  * A test class for bug Listbox-ListModelMap-Multiple-noROD
  *
  * @author benbai
  *
  */
@Tags(tags = "Z60-Listbox-ListModelMap-Multiple-noROD.zul,Z60,A,E,Listbox,ListModelMap,Multiple")
class Z60_Listbox_ListModelMap_Multiple_noRODTest extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
				<zscript>
					<![CDATA[
					import org.zkoss.zktest.test2.select.models.*;
					
					ListModelMap model = ListModelMaps.getModel(ListModelMaps.MULTIPLE);
					ListModelMap model2 = ListModelMaps.getModel(ListModelMaps.MULTIPLE_AND_CLONEABLE);
			
					int cnt = 0;
					int elemcnt = 1001;
					int rmcnts = 0;
					int rmcntm = 1001;
			
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
				]]></zscript>
				<div>
					<div>1. There are 3 Listbox below.</div>
					<div>2. For first two Listbox, their select status will sync automatically after you select item.</div>
					<div>3. Select data 10 and data 11 of third Listbox.</div>
					<div>4. Click clone and 'clone by serialization', then two Listboxes should be created and also select data 10 and data 11.</div>
					<div>5. Hold Ctrl then Select data 212 of third Listbox, data 213 of fourth and data 214 of fifth, the select status of last three listbox should not sync.</div>
					<div>6. Click clone and 'clone by serialization', you should see two Listboxes created and each Listbox after fifth Listbox select data 10, 11 and 212.</div>
					<div>7. Click 'insert item', each select of Listbox should not be changed.</div>
					<div>8. Click 'remove item', each select of Listbox should not be changed.</div>
				</div>
    			<label id="outer" value="outer" />
				<custom-attributes org.zkoss.zul.listbox.rod="false" />
				<hbox>
					<listbox id="lbxOne" height="150px" width="200px" model="${model}" onSelect="" multiple="true" checkmark="true" />
					<listbox id="lbxTwo" height="150px" width="200px" model="${model}" onSelect="" multiple="true" checkmark="true" />
					<listbox id="lbxThree" height="150px" width="200px" model="${model2}" onSelect="" multiple="true" checkmark="true" />
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
				<button id="btnSix" label="insert item">
					<attribute name="onClick">
						model.put("item "+elemcnt, "data "+elemcnt);
						model2.put("item "+elemcnt, "data "+elemcnt);
						elemcnt++;
					</attribute>
				</button>
				<button id="btnSeven" label="remove item">
					<attribute name="onClick"><![CDATA[
						String key = "item ";
						if (rmcntm < elemcnt) {
							key += rmcntm;
							rmcntm++;
						} else {
							key += rmcnts;
							rmcnts++;
						}
						model.remove(key);
						model2.remove(key);
					]]></attribute>
				</button>
				<hbox id="cloneThreeArea" />
				<hbox>
					<textbox id="tbOne" value="box one" onChange="" />
					<textbox id="tbTwo" value="box two" onChange="" />
					<button id="btnOne" label="check equal selection" onClick='checkEqualSelection(tbOne.getValue(), tbTwo.getValue(), msg);' />
					<button id="btnFour" label="show selection" onClick='showSelection(tbOne.getValue(), msg);' />
					<label id="msg" />
				</hbox>
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
        var btnSix: Widget = engine.$f("btnSix");
        var btnSeven: Widget = engine.$f("btnSeven");
        var msg: Widget = engine.$f("msg");
        var itemHgh: Int = jq(lbxOne.$n()).find(".z-listitem").outerHeight(true);
        var checkList: java.util.List[Int] = new java.util.ArrayList[Int]();

        def selectItem = (id: String, num: Int) => {
          var lbx: Widget = engine.$f(id);

          verScroll(lbx, if (num > 2) (num - 3) / 300.0 else 0.0)
          waitResponse();

          sleep(1000);
          var listitem: Element = jq(lbx.$n("body")).find(".z-listitem:contains(\"data " + num + "\")").get(0);

          click(listitem);
        }

        // check whether the selection of a listbox contains exactly the content in check list
        def checkSelection = (toCheck: java.util.List[Int], id: String) => {
          input(tbOne.$n(), id);
          click(btnFour);
          waitResponse();
          var selection: String = getText(msg);
          var item: String = "";
          for (i <- 0 to toCheck.size() - 1) {
            item = "item " + toCheck.get(i) + "=data " + toCheck.get(i);
            verifyTrue("the selection of " + id + "should contains " + item,
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
            verifyTrue("The selection of these two listbox (" + idOne + ", " + idTwo + ") should the same",
              getText(msg).equals("true"));
          else
            verifyTrue("The selection of these two listbox (" + idOne + ", " + idTwo + ") should different",
              getText(msg).equals("false"));
        }

        def input = (tb: Element, value: String) => {
          findElement(tb.toBy()).clear()
          `type`(tb, value)
          waitResponse();
        }

        def checkInsertRemove = () => {
          var selsOne: String = getSelection("lbxOne");
          var selsTwo: String = getSelection("lbxTwo");
          var selsThree: String = getSelection("lbxThree");
          click(btnSix);
          waitResponse();
          click(btnSix);
          waitResponse();
          click(btnSix);
          waitResponse();
          verifyTrue("The selection should not change after insert items",
            getSelection("lbxOne").equals(selsOne));
          verifyTrue("The selection should not change after insert items",
            getSelection("lbxTwo").equals(selsTwo));
          verifyTrue("The selection should not change after insert items",
            getSelection("lbxThree").equals(selsThree));
          click(btnSeven);
          waitResponse();
          click(btnSeven);
          waitResponse();
          click(btnSeven);
          waitResponse();
          verifyTrue("The selection should not change after insert items",
            getSelection("lbxOne").equals(selsOne));
          verifyTrue("The selection should not change after insert items",
            getSelection("lbxTwo").equals(selsTwo));
          verifyTrue("The selection should not change after insert items",
            getSelection("lbxThree").equals(selsThree));
        }

        def getSelection(id: String): String = {
          input(tbOne.$n(), id);
          click(btnFour);
          waitResponse();
          var sels: String = getText(msg);
          return sels;
        }

        selectItem("lbxOne", 2);
        checkEqualSelection("lbxOne", "lbxTwo", true);
        selectItem("lbxTwo", 200);
        checkEqualSelection("lbxOne", "lbxTwo", true);

        selectItem("lbxThree", 10);
        selectItem("lbxThree", 11);
        click(btnTwo);
        sleep(1000);
        click(btnThree);
        sleep(1000);

        checkList.add(10);
        checkList.add(11);
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
        checkList.add(10);
        checkList.add(11);
        checkList.add(212);
        checkSelection(checkList, "lbxThree");

        checkEqualSelection("lbxThree", "lbxThree_clone2", true);
        checkEqualSelection("lbxThree", "lbxThree_serialize3", true);
        checkInsertRemove();
      }
    );
  }
}