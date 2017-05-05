/* Z60_Selectbox_ListModelListTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Jan 20 12:50:05 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.Z60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ClientWidget
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget

/**
 * A test class for bug Selectbox-ListModelList
 * @author benbai
 *
 */
@Tags(tags = "Z60-Selectbox-ListModelList.zul,Z60,A,E,Selectbox,ListModelList")
class Z60_Selectbox_ListModelListTest extends ZTL4ScalaTestCase {
	@Test
  def testClick() = {
    val zscript = """
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
					<div>1. There are 3 selectbox below.</div>
					<div>2. For first two selectbox, their select status will sync automatically after you select item.</div>
					<div>3. Select data 10 of third selectbox.</div>
					<div>4. Click clone and 'clone by serialization', then two selectboxes should be created and also select data 10.</div>
					<div>5. Select data 11 of third selectbox, data 12 of fourth and data 13 of fifth, the select status of last three selectbox should not sync.</div>
					<div>6. Click clone and 'clone by serialization', you should see two selectboxes created and each selectbox after fifth selectbox select data 11.</div>
					<div>7. Click 'insert item', each select of selectbox should not be changed.</div>
					<div>8. Click 'remove item', each select of Selectbox should not be changed.</div>
				</div>
    			<label id="outer" value="outer" />
				<selectbox id="sbxOne" model="${model}" onSelect="" />
				<div height="10px"></div>
				<selectbox id="sbxTwo" model="${model}" onSelect="" />
				<div height="10px"></div>
				<selectbox id="sbxThree" model="${model2}" onSelect="" />
				<button id="clone" label="clone">
					<attribute name="onClick">
						Selectbox sbx = sbxThree.clone();
						sbx.setId("sbxThree_clone" + cnt++);
						sbx.setParent(cloneThreeArea);
					</attribute>
				</button>
				<button id="serialize" label="Clone by Serialization">
					<attribute name="onClick"><![CDATA[{
						import java.io.*;
						ByteArrayOutputStream boa = new ByteArrayOutputStream();
						new ObjectOutputStream(boa).writeObject(sbxThree);
						byte[] bs = boa.toByteArray();
						Object n = new ObjectInputStream(new ByteArrayInputStream(bs)).readObject();
						n.setId("sbxThree_serialize" + cnt++);
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

    """
runZTL(zscript,
        () => {
        var outer: Widget = engine.$f("outer");
        var clone: Widget = engine.$f("clone");
        var serialize: Widget = engine.$f("serialize");
        var insert: Widget = engine.$f("insert");
        var remove: Widget = engine.$f("remove");
        def select (id: String, num: Int) {
          var sbx: Widget = engine.$f(id);
          this.select(sbx, num);
          click(outer);
          waitResponse();
        }
        def equal (idOne: String, idTwo: String): Boolean = {
          return getSelectedItem(idOne).equals(getSelectedItem(idTwo));
        }
        def getSelectedItem(id: String): String = {
          return getSelenium().getEval("jq('$"+id+"')[0].options[jq('$"+id+"')[0].selectedIndex].innerHTML");
        }
        def clickAndWait (target: ClientWidget, delay: Int) = {
          click(target);
          if (delay > 0)
            sleep(delay);
          else
            waitResponse();
        }
        def getItemAt (id: String, num: Int): String = {
          return getSelenium().getEval("jq('$"+id+"')[0].options["+num+"].innerHTML");
        }
        def checkInsertRemove (irBtn: ClientWidget) = {
          var oldOne: String = getSelectedItem("sbxOne");
          var oldTwo: String = getSelectedItem("sbxTwo");
          var oldThree: String = getSelectedItem("sbxThree");
          for (i <- 0 to 3) {
            clickAndWait(irBtn, 0);
            verifyTrue("Select should not changed after insert/remove item",
                oldOne.equals(getSelectedItem("sbxOne"))
                && oldTwo.equals(getSelectedItem("sbxTwo"))
                && oldThree.equals(getSelectedItem("sbxThree")));
          }
        }

        select("sbxOne", 3);
        verifyTrue("The select of first two selectbox should sync",
            equal("sbxOne", "sbxTwo"));
        select("sbxTwo", 0);
        verifyTrue("The select of first two selectbox should sync",
            equal("sbxOne", "sbxTwo"));

        select("sbxThree", 10);
        clickAndWait(clone, 0);
        clickAndWait(serialize, 0);
        verifyTrue("Third selectbox should not changed after clone/serialize",
            getItemAt("sbxThree", 10).equals(getSelectedItem("sbxThree")));
        verifyTrue("Cloned selectbox should select the same item",
            equal("sbxThree", "sbxThree_clone0"));
        verifyTrue("Serialized selectbox should select the same item",
            equal("sbxThree", "sbxThree_serialize1"));

        select("sbxThree", 11);
        verifyFalse("Cloned selectbox should not sync with third selectbox",
            equal("sbxThree", "sbxThree_clone0"));
        verifyFalse("Serialized selectbox should not sync with third selectbox",
            equal("sbxThree", "sbxThree_serialize1"));
        select("sbxThree_clone0", 12);
        verifyFalse("Cloned selectbox should not sync with third selectbox",
            equal("sbxThree", "sbxThree_clone0"));
        verifyFalse("Cloned selectbox should not sync with serialized selectbox",
            equal("sbxThree_clone0", "sbxThree_serialize1"));
        select("sbxThree_serialize1", 13);
        verifyFalse("Serialized selectbox should not sync with third selectbox",
            equal("sbxThree", "sbxThree_serialize1"));
        verifyFalse("Serializedselectbox should not sync with cloned selectbox",
            equal("sbxThree_clone0", "sbxThree_serialize1"));

        clickAndWait(clone, 0);
        clickAndWait(serialize, 0);
        verifyTrue("Third selectbox should not changed after clone/serialize",
            getItemAt("sbxThree", 11).equals(getSelectedItem("sbxThree")));
        verifyTrue("Cloned selectbox should select the same item",
            equal("sbxThree", "sbxThree_clone2"));
        verifyTrue("Serialized selectbox should select the same item",
            equal("sbxThree", "sbxThree_serialize3"));

        checkInsertRemove(insert);
        checkInsertRemove(remove);
    }
   );
  }
}