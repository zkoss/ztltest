/* Z60_Combobox_ListModelListTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Jan 19 12:16:38 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.Z60

import java.lang.Boolean
import java.lang.Integer
import java.lang.String

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ClientWidget
import org.zkoss.ztl.Element
import org.zkoss.ztl.JQuery
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget

/**
 * A test class for bug Combobox-ListModelList
 * @author benbai
 *
 */
@Tags(tags = "Z60-Combobox-ListModelList.zul,Z60,A,E,Combobox,ListModelList")
class Z60_Combobox_ListModelListTest extends ZTL4ScalaTestCase {
	
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
				]]></zscript>
				<div>
					<div>1. There are 3 combobox below.</div>
					<div>2. For first two combobox, their select status will sync automatically after you select item.</div>
					<div>3. Select data 10 of third combobox.</div>
					<div>4. Click clone and 'clone by serialization', then two comboboxes should be created and also select data 10.</div>
					<div>5. Select data 11 of third combobox, data 12 of fourth and data 13 of fifth, the select status of last three combobox should not sync.</div>
					<div>6. Click clone and 'clone by serialization', you should see two comboboxes created and each combobox after fifth combobox select data 11.</div>
					<div>7. Click 'insert item', each select of combobox should not be changed.</div>
					<div>8. Click 'remove item', each select of combobox should not be changed.</div>
				</div>
				<combobox id="cbxOne" model="${model}" onSelect="" onOpen="" />
				<div height="10px"></div>
				<combobox id="cbxTwo" model="${model}" onSelect="" onOpen="" />
				<div height="10px"></div>
				<combobox id="cbxThree" model="${model2}" onSelect="" onOpen="" />
				<button id="clone" label="clone">
					<attribute name="onClick">
						Combobox cbx = cbxThree.clone();
						cbx.setId("cbxThree_clone" + cnt++);
						cbx.setParent(cloneThreeArea);
					</attribute>
				</button>
				<button id="serialize" label="Clone by Serialization">
					<attribute name="onClick"><![CDATA[{
						import java.io.*;
						ByteArrayOutputStream boa = new ByteArrayOutputStream();
						new ObjectOutputStream(boa).writeObject(cbxThree);
						byte[] bs = boa.toByteArray();
						Object n = new ObjectInputStream(new ByteArrayInputStream(bs)).readObject();
						n.setId("cbxThree_serialize" + cnt++);
						((Component)n).setParent(cloneThreeArea);
					}]]></attribute>
				</button>
				<button id="insert" label="insert item">
					<attribute name="onClick">
						model.add(0, "inserted "+elemcnt++);
						model2.add(0, "inserted "+elemcnt++);
					</attribute>
				</button>
				<button id="remove" label="remove item">
					<attribute name="onClick">
						model.remove(0);
						model2.remove(0);
					</attribute>
				</button>
				<div id="cloneThreeArea" />
			</zk>

    }

    runZTL(zscript,
        () => {
        var clone: Widget = engine.$f("clone");
        var serialize: Widget = engine.$f("serialize");
        var insert: Widget = engine.$f("insert");
        var remove: Widget = engine.$f("remove");
        var itemClass: String = ".z-comboitem";

        def selectItem(id: String, inum: Int) = {
          var cbx: Widget = engine.$f(id);
          var pp: Element = cbx.$n("pp");
          var $pp: JQuery = jq(pp);
          open(id, true);
          if (inum > 5) {
            var offset: Int = Integer.parseInt($pp.find(itemClass).get(inum-2).get("offsetTop"));
            pp.eval("scrollTop = "+offset);
          } else
            pp.eval("scrollTop = 0");
          click($pp.find(itemClass).get(inum));
          waitResponse();
        }
        def open (id: String, open: Boolean) = {
          var cbx: Widget = engine.$f(id);
          if (open != isOpen(id)) {
            click(cbx.$n("btn"));
          	waitResponse();
          }
        }
        def isOpen(id: String): Boolean = {
          var cbx: Widget = engine.$f(id);
          return !cbx.$n("pp").get("style.display").equals("none");
        }
        def isEqual(idOne: String, idTwo: String): Boolean = {
          var cbxOne: Widget = engine.$f(idOne);
          var cbxTwo: Widget = engine.$f(idTwo);
          return cbxOne.$n("real").get("value").equals(cbxTwo.$n("real").get("value"));
        }
        def clickAndWait (wgt: ClientWidget, ms: Int) {
          click(wgt);
          if (ms > 0)
            sleep(ms);
          else
            waitResponse();
        }
        def checkInsertRemove (irBtn: Widget) = {
          var cbxOne: Widget = engine.$f("cbxOne");
          var cbxTwo: Widget = engine.$f("cbxTwo");
          var cbxThree: Widget = engine.$f("cbxThree");
          var oldOne: String = cbxOne.$n("real").get("value");
          var oldTwo: String = cbxTwo.$n("real").get("value");
          var oldThree: String = cbxThree.$n("real").get("value");

          for (i <- 0 to 3) {
            clickAndWait(irBtn, 0);
            verifyTrue("The select should not changed after insert/remove item",
                oldOne.equals(cbxOne.$n("real").get("value")))
            verifyTrue("The select should not changed after insert/remove item",
                oldTwo.equals(cbxTwo.$n("real").get("value")))
            verifyTrue("The select should not changed after insert/remove item",
                oldThree.equals(cbxThree.$n("real").get("value")))
          }
        }
        selectItem("cbxOne", 200);
        verifyTrue("The select between first two combobox should sync",
            isEqual("cbxOne", "cbxTwo"));
        selectItem("cbxTwo", 0);
        verifyTrue("The select between first two combobox should sync",
            isEqual("cbxOne", "cbxTwo"));

        selectItem("cbxThree", 10);

        clickAndWait(clone, 0);
        clickAndWait(serialize, 0);

        verifyTrue("The select of third and cloned combobox should the same",
            isEqual("cbxThree", "cbxThree_clone0"));
        verifyTrue("The select of third and serialized combobox should the same",
            isEqual("cbxThree", "cbxThree_serialize1"));

        selectItem("cbxThree", 11);
        verifyFalse("The select of third and cloned combobox should not sync after cloned",
            isEqual("cbxThree", "cbxThree_clone0"));
        verifyFalse("The select of third and serialized combobox should not sync after serialized",
            isEqual("cbxThree", "cbxThree_serialize1"));

        selectItem("cbxThree_clone0", 12);
        verifyFalse("The select of third and cloned combobox should not sync after cloned",
            isEqual("cbxThree", "cbxThree_clone0"));
        verifyFalse("The select of cloned and serialized combobox should not sync",
            isEqual("cbxThree_clone0", "cbxThree_serialize1"));

        selectItem("cbxThree_serialize1", 13);
        verifyFalse("The select of third and serialized combobox should not sync after serialized",
            isEqual("cbxThree", "cbxThree_serialize1"));
        verifyFalse("The select of cloned and serialized combobox should not sync",
            isEqual("cbxThree_clone0", "cbxThree_serialize1"));

        clickAndWait(clone, 0);
        clickAndWait(serialize, 0);

        verifyTrue("The select of third and cloned combobox should the same",
            isEqual("cbxThree", "cbxThree_clone2"));
        verifyTrue("The select of third and serialized combobox should the same",
            isEqual("cbxThree", "cbxThree_serialize3"));

        checkInsertRemove(insert);
        checkInsertRemove(remove);
    }
   );
  }
}