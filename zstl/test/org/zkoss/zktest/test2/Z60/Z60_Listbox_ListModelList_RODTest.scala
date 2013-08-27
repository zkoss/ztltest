/* Z60_Listbox_ListModelList_RODTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Jan 17 10:38:24 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.Z60

import org.zkoss.zstl.ZTL4MeshTestCase
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
 * A test class for bug Listbox-ListModelList-ROD
 * @author benbai
 *
 */
@Tags(tags = "Z60-Listbox-ListModelList-ROD.zul,Z60,A,E,Listbox,ListModelList,ROD")
class Z60_Listbox_ListModelList_RODTest extends ZTL4MeshTestCase {
	
  @Test
  def testClick() = {
    val zscript = {
			<zk>
				<zscript>
					<![CDATA[
			 		import org.zkoss.zktest.test2.select.models.*;
					
					ListModelList model = ListModelLists.getModel(ListModelLists.DEFAULT);
					ListModelList model2 = ListModelLists.getModel(ListModelLists.CLONEABLE);
			
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
					<div>3. Select data 10 of third Listbox.</div>
					<div>4. Click clone and 'clone by serialization', then two Listboxes should be created and also select data 10.</div>
					<div>5. Select data 212 of third Listbox, data 213 of fourth and data 214 of fifth, the select status of last three listbox should not sync.</div>
					<div>6. Click clone and 'clone by serialization', you should see two Listboxes created and each Listbox after fifth Listbox select data 212.</div>
					<div>7. Click 'insert item', each select of Listbox should not be changed.</div>
					<div>8. Click 'remove item', each select of Listbox should not be changed.</div>
				</div>
    			<label id="outer" value="outer" />
				<hbox>
					<listbox id="lbxOne" height="150px" width="140px" model="${model}" onSelect="" checkmark="true" />
					<listbox id="lbxTwo" height="150px" width="140px" model="${model}" onSelect="" checkmark="true" />
					<listbox id="lbxThree" height="150px" width="140px" model="${model2}" onSelect="" checkmark="true" />
				</hbox>
				<hbox>
					<textbox id="tbOne" value="box one" />
					<textbox id="tbTwo" value="box two" />
					<button id="btnOne" label="check equal selection" onClick='checkEqualSelection(tbOne.getValue(), tbTwo.getValue(), msg);' />
					<button id="btnFour" label="show selection" onClick='showSelection(tbOne.getValue(), msg);' />
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
				<button id="btnSix" label="insert item">
					<attribute name="onClick">
						model.add(0, "inserted "+elemcnt++);
						model2.add(0, "inserted "+elemcnt++);
					</attribute>
				</button>
				<button id="btnSeven" label="remove item">
					<attribute name="onClick">
						model.remove(0);
						model2.remove(0);
					</attribute>
				</button>
				<hbox id="cloneThreeArea" />
			</zk>

    }
    runZTL(zscript,
        () => {
        var lbxOne: Widget = engine.$f("lbxOne")
        var lbxTwo: Widget = engine.$f("lbxTwo")
        var lbxThree: Widget = engine.$f("lbxThree")
        var tbOne: Widget = engine.$f("tbOne")
        var tbTwo: Widget = engine.$f("tbTwo")
        var btnOne: Widget = engine.$f("btnOne")
        var btnTwo: Widget = engine.$f("btnTwo")
        var btnThree: Widget = engine.$f("btnThree")
        var btnFour: Widget = engine.$f("btnFour")
        var btnSix: Widget = engine.$f("btnSix")
        var btnSeven: Widget = engine.$f("btnSeven")
        var msg: Widget = engine.$f("msg")
        var itemHgh: Int = jq(lbxOne.$n()).find(".z-listitem").outerHeight(true)
        var checkList: java.util.List[Int] = new java.util.ArrayList[Int]()

        enterFullScreen
        
        selectListitem(lbxOne, 2)
        checkEqualSelection("lbxOne", "lbxTwo", true)
        selectListitem(lbxTwo, 200)
        checkEqualSelection("lbxOne", "lbxTwo", true)

        selectListitem(lbxThree, 12)
        click(btnTwo, false)
        click(btnThree, false)
        
        var lbxThree_clone0: Widget = engine.$f("lbxThree_clone0")
        var lbxThree_serialize1: Widget = engine.$f("lbxThree_serialize1")

        checkList.add(12)
        checkSelection(checkList, "lbxThree")

        checkEqualSelection("lbxThree", "lbxThree_clone0", true)
        checkEqualSelection("lbxThree", "lbxThree_serialize1", true)

        selectListitem(lbxThree, 212)
        selectListitem(lbxThree_clone0, 213)
        selectListitem(lbxThree_serialize1, 214)
        checkEqualSelection("lbxThree", "lbxThree_clone0", false)
        checkEqualSelection("lbxThree", "lbxThree_serialize1", false)
        checkEqualSelection("lbxThree_clone0", "lbxThree_serialize1", false)

        click(btnTwo, false)
        click(btnThree, false)

        checkList.clear
        checkList.add(212)
        checkSelection(checkList, "lbxThree")

        checkEqualSelection("lbxThree", "lbxThree_clone2", true)
        checkEqualSelection("lbxThree", "lbxThree_serialize3", true)

        checkInsertRemove
        
        exitFullScreen
    }
   );
  }
}