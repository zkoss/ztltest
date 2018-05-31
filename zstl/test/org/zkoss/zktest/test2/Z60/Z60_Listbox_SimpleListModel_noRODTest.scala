/* Z60_Listbox_SimpleListModel_noRODTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Jan 16 10:53:08 CST 2012 , Created by benbai
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
  * A test class for bug Listbox-SimpleListModel-noROD
  *
  * @author benbai
  *
  */
@Tags(tags = "Z60-Listbox-SimpleListModel-noROD.zul,Z60,A,E,Listbox,SimpleListModel")
class Z60_Listbox_SimpleListModel_noRODTest extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
				<zscript>
					<![CDATA[
					import org.zkoss.zktest.test2.select.models.*;
					
					SimpleListModel model = SimpleListModels.getModel(SimpleListModels.DEFAULT);
					SimpleListModel model2 = SimpleListModels.getModel(SimpleListModels.CLONEABLE);
			
					int cnt = 0;
					int elemcnt = 0;
			
					public void checkEqualSelection (String idOne, String idTwo, Label msg) {
						Listbox lbOne = msg.getPage().getFellow(idOne);
						Listbox lbTwo = msg.getPage().getFellow(idTwo);
						Set s1 = lbOne.getSelectedItems();
						Set s2 = lbTwo.getSelectedItems();
						boolean matched = false;
						for (Object o : s1) {
							for (Object o2 : s2) {
								if (((Listitem)o).getValue().equals(((Listitem)o2).getValue())) {
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
				<custom-attributes org.zkoss.zul.listbox.rod="false" />
				<hbox>
					<listbox id="lbxOne" height="150px" width="140px" model="${model}" onSelect="" checkmark="true" />
					<listbox id="lbxTwo" height="150px" width="140px" model="${model}" onSelect="" checkmark="true" />
					<listbox id="lbxThree" height="150px" width="140px" model="${model2}" onSelect="" checkmark="true" />
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
				<hbox>
					<textbox id="tbOne" value="box one" onChange="" />
					<textbox id="tbTwo" value="box two" onChange="" />
					<button id="btnOne" label="check equal selection" onClick='checkEqualSelection(tbOne.getValue(), tbTwo.getValue(), msg);' />
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
        var msg: Widget = engine.$f("msg");
        var itemHgh: Int = jq(lbxOne.$n()).find(".z-listitem").outerHeight(true);

        def selectItem = (id: String, num: Int) => {
          var lbx: Widget = engine.$f(id);

          verScroll(lbx, if (num > 2) (num - 3) / 300.0 else 0.0)
          waitResponse();

          sleep(600);
          var listitem: Element = jq(lbx.$n("body")).find(".z-listitem:contains(\"data " + num + "\")").get(0);
          click(listitem);
        }

        def checkEqualSelection = (idOne: String, idTwo: String, assertValue: Boolean) => {
          input(tbOne.$n(), idOne);
          input(tbTwo.$n(), idTwo);
          click(btnOne);
          waitResponse();
          if (assertValue)
            verifyTrue("The selection of these two listbox (" + idOne + ", " + idTwo + ") should the same",
              msg.$n().get("innerHTML").equals("true"));
          else
            verifyTrue("The selection of these two listbox (" + idOne + ", " + idTwo + ") should different",
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
        checkEqualSelection("lbxThree", "lbxThree_clone0", true);
        checkEqualSelection("lbxThree", "lbxThree_serialize1", true);
        selectItem("lbxThree", 212);
        selectItem("lbxThree_clone0", 213);
        selectItem("lbxThree_serialize1", 214);
        checkEqualSelection("lbxThree", "lbxThree_clone0", false);
        checkEqualSelection("lbxThree", "lbxThree_serialize1", false);
        checkEqualSelection("lbxThree_clone0", "lbxThree_serialize1", false);
      }
    );
  }
}