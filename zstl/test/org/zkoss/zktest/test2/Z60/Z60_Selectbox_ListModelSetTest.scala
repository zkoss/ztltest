/* Z60_Selectbox_ListModelSetTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Jan 20 14:19:30 CST 2012 , Created by benbai
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
import org.zkoss.ztl.ClientWidget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
 * A test class for bug Selectbox-ListModelSet
 * @author benbai
 *
 */
@Tags(tags = "Z60-Selectbox-ListModelSet.zul,Z60,A,E,Selectbox,ListModelSet")
class Z60_Selectbox_ListModelSetTest extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
				<zscript>
					<![CDATA[
					import org.zkoss.zktest.test2.select.models.*;
					
					ListModelSet model = ListModelSets.getModel(ListModelSets.DEFAULT);
					ListModelSet model2 = ListModelSets.getModel(ListModelSets.CLONEABLE);
			
					int cnt = 0;
					int elemcnt = 1001;
					int rmcnts = 0;
					int rmcntm = 1001;
				]]></zscript>
				<div>
					<div>1. There are 3 Selectbox below.</div>
					<div>2. For first two Selectbox, their select status will sync automatically after you select item.</div>
					<div>3. Select data 10 of third Selectbox.</div>
					<div>4. Click clone and 'clone by serialization', then two Selectboxes should be created and also select data 10.</div>
					<div>5. Select data 11 of third Selectbox, data 12 of fourth and data 13 of fifth, the select status of last three Selectbox should not sync.</div>
					<div>6. Click clone and 'clone by serialization', you should see two Selectboxes created and each Selectbox after fifth Selectbox select data 11.</div>
					<div>7. Click 'insert item', each select of Selectbox should not be changed.</div>
					<div>8. Click 'remove item', each select of Selectbox should not be changed.</div>
				</div>
    			<label id="outer" value="outer" />
				<selectbox id="sbxOne" model="${model}" onSelect="" onOpen="" />
				<div height="10px"></div>
				<selectbox id="sbxTwo" model="${model}" onSelect="" onOpen="" />
				<div height="10px"></div>
				<selectbox id="sbxThree" model="${model2}" onSelect="" onOpen="" />
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
						model.add("data "+elemcnt);
						model2.add("data "+elemcnt);
						elemcnt++;
					</attribute>
				</button>
				<button id="remove" label="remove item">
					<attribute name="onClick"><![CDATA[
						String obj = "data ";
						if (rmcntm < elemcnt) {
							obj += rmcntm;
							rmcntm++;
						} else {
							obj += rmcnts;
							rmcnts++;
						}
						model.remove(obj);
						model2.remove(obj);
					]]></attribute>
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