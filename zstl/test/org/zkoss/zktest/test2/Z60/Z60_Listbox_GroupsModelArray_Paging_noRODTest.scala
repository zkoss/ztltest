/* Z60_Listbox_GroupsModelArray_Paging_noRODTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Jan 18 11:31:40 CST 2012 , Created by benbai
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
 * A test class for bug Listbox-GroupsModelArray-Paging-noROD
 * @author benbai
 *
 */
@Tags(tags = "Z60-Listbox-GroupsModelArray-Paging-noROD.zul,Z60,A,E,Listbox,GroupsModelArray,Paging")
class Z60_Listbox_GroupsModelArray_Paging_noRODTest extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
				<zscript>
					<![CDATA[
					import org.zkoss.zktest.test2.select.models.*;
					import org.zkoss.zul.impl.*;
					
					GroupsModel model = GroupsModelArrays.getModel();
					GroupsModel model2 = GroupsModelArrays.getModel();
			
					int cnt = 0;
					int elemcnt = 0;
			
					public void showItems(String id, String gnum, Label msg) {
						Page page = msg.getPage();
						Listbox lbx = page.getFellow(id);
						GroupsModel gm = ((GroupsListModel)lbx.getModel()).getGroupsModel();
						int gi = Integer.parseInt(gnum);
						String s = "";
						for (int i = 0; i < gm.getChildCount(gi); i++) {
							Object[] o = (Object[])gm.getChild(gi, i);
							s += o[1];
						}
						msg.setValue(s);
					}
					public void changePage(String id, String gnum, Page page) {
						Listbox lbx = page.getFellow(id);
						lbx.setActivePage(getPageOfGroup(id, gnum, page));
					}
    				public void checkClose(String id, String gnum, Label msg) {
						Page page = msg.getPage();
						Listbox lbx = page.getFellow(id);
						GroupsModel gm = ((GroupsListModel)lbx.getModel()).getGroupsModel();
						int gi = Integer.parseInt(gnum);
						msg.setValue(gm.isClose(gi)+"");
    				}
					public int getPageOfGroup(String id, String gnum, Page page) {
						Listbox lbx = page.getFellow(id);
						GroupsModel gm = ((GroupsListModel)lbx.getModel()).getGroupsModel();
						int gi = Integer.parseInt(gnum);
						int idx = 0;
						for (int i = 0; i < gi; i++) {
							idx += 1;
							if (!gm.isClose(i))
								idx += gm.getChildCount(i);
						}
						return idx/lbx.getPageSize();
					}
				]]></zscript>
				<div>
					<div>** should remove this case after GroupsModelArray support ROD</div>
					<div>1. There are 3 Grid with Grouping below.</div>
					<div>2. For first two Grid, their open/close/sorting status will sync automatically after you open/close/sorting it.</div>
					<div>3. Close the Last Group of third Grid, if it can not be closed, it is a bug.</div>
					<div>4. Click clone and 'clone by serialization', then two Grids should be created and also closed the Last Group.</div>
					<div>5. Open the Last Group of the third Grid, the Last Group of the fourth and the fifth should not sync.</div>
					<div>6. Close the Itemset 0 and the Itemset 1 of the third Grid and click the "clone" and "clone by serialization".</div>
					<div>7. Open the Itemset 1 of the last two Grid, its content will open well (if it opens the Itemset 0 Group's content, that is a bug).</div>
				</div>
				<custom-attributes org.zkoss.zul.listbox.rod="false" />
				<hbox>
					<listbox id="lbxOne" height="200px" width="310px" mold="paging" pageSize="5" model="${model}" onSelect="" checkmark="true">
						<listhead>
			            	<listheader label="Category" sort="auto(0)"/>
			            	<listheader label="Name" sort="auto(1)"/>
			            	<listheader label="Calories" sort="auto(2)"/>
			        	</listhead>
			        	<template name="model:grouping">
							<listgroup open="${groupingInfo.open}" label="${each}"/>
						</template>
						<template name="model">
							<listitem>
								<listcell label="${each[0]}"/>
								<listcell label="${each[1]}"/>
								<listcell label="${each[2]}"/>
							</listitem>
						</template>
					</listbox>
					<listbox id="lbxTwo" height="200px" width="310px" mold="paging" pageSize="5" model="${model}" onSelect="" checkmark="true">
						<listhead>
			            	<listheader label="Category" sort="auto(0)"/>
			            	<listheader label="Name" sort="auto(1)"/>
			            	<listheader label="Calories" sort="auto(2)"/>
			        	</listhead>
			        	<template name="model:grouping">
							<listgroup open="${groupingInfo.open}" label="${each}"/>
						</template>
						<template name="model">
							<listitem>
								<listcell label="${each[0]}"/>
								<listcell label="${each[1]}"/>
								<listcell label="${each[2]}"/>
							</listitem>
						</template>
					</listbox>
					<listbox id="lbxThree" height="200px" width="310px" mold="paging" pageSize="5" model="${model2}" onSelect="" checkmark="true">
						<listhead>
			            	<listheader label="Category" sort="auto(0)"/>
			            	<listheader label="Name" sort="auto(1)"/>
			            	<listheader label="Calories" sort="auto(2)"/>
			        	</listhead>
			        	<template name="model:grouping">
							<listgroup open="${groupingInfo.open}" label="${each}"/>
						</template>
						<template name="model">
							<listitem>
								<listcell label="${each[0]}"/>
								<listcell label="${each[1]}"/>
								<listcell label="${each[2]}"/>
							</listitem>
						</template>
					</listbox>
				</hbox>
				<hbox>
					<textbox id="tbOne" />
					<textbox id="tbTwo" />
					<button id="btnOne" label="change page" onClick="changePage(tbOne.getValue(), tbTwo.getValue(), self.getPage());" />
					<button id="btnTwo" label="show items" onClick="showItems(tbOne.getValue(), tbTwo.getValue(), msg);" />
    				<button id="checkClose" label="check close" onClick="checkClose(tbOne.getValue(), tbTwo.getValue(), msg);" />
					<label id="msg" />
				</hbox>
				<div height="10px"></div>
				<button id="btnThree" label="clone">
					<attribute name="onClick">
						Listbox lbx = lbxThree.clone();
						lbx.setId("lbxThree_clone" + cnt++);
						lbx.setParent(cloneThreeArea);
					</attribute>
				</button>
				<button id="btnFour" label="Clone by Serialization">
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
        var tbOne: Widget = engine.$f("tbOne");
        var tbTwo: Widget = engine.$f("tbTwo");
        var btnOne: Widget = engine.$f("btnOne");
        var btnTwo: Widget = engine.$f("btnTwo");
        var btnThree: Widget = engine.$f("btnThree");
        var btnFour: Widget = engine.$f("btnFour");
        var checkClose: Widget = engine.$f("checkClose");
        var msg: Widget = engine.$f("msg");

        def closeGroup (id: String, gnum: String, close: Boolean) {
          var lbx: Widget = engine.$f(id);
          var gstr: String = getGstr(gnum);
          changePage(id, gnum);
          if (close != isClose(id, gnum)) {
            click(jq(lbx.$n("rows")).find(".z-listgroup:contains(Itemset "+gstr+")").find(".z-listgroup-img").get(0));
            waitResponse();
          }
          
        }
        def sortAndCheck (idOne: String, idTwo: String, cate: String, gnum: String) {
        	sort(idOne, cate);
	        checkEqual(idOne, idTwo, gnum);
        }
        def sort (id: String, cate: String) {
          var lbx: Widget = engine.$f(id);
          click(jq(lbx.$n("head")).find(".z-listheader-cnt:contains("+cate+")"));
          waitResponse();
        }
        def checkEqual(idOne: String, idTwo: String, gnum: String) {
          var lbxOne: Widget = engine.$f(idOne);
          var lbxTwo: Widget = engine.$f(idTwo);
          changePage(idOne, gnum);
          changePage(idTwo, gnum);

          for (i <- 0 to 2) {
            verifyTrue("The content sequence should equal between two listbox "+idOne+" and "+idTwo,
                jq(lbxOne.$n("rows")).find(".z-listcell-cnt:contains(Value)").get(i).get("innerHTML")
                .equals(jq(lbxTwo.$n("rows")).find(".z-listcell-cnt:contains(Value)").get(i).get("innerHTML")));
          }
        }
        def isClose(id: String, gnum: String): Boolean =  {
          var lbx: Widget = engine.$f(id);
          var gstr: String = getGstr(gnum);
          if (!jq(lbx.$n("rows")).find(".z-listgroup:contains(Itemset "+gstr+")").exists())
            changePage(id, gnum);
          return jq(lbx.$n("rows")).find(".z-listgroup:contains(Itemset "+gstr+")").find(".z-listgroup-img-close").get(0).exists();
        }
        def changePage (id: String, gnum: String) {
          input(tbOne.$n(), id);
          input(tbTwo.$n(), gnum);
          click(btnOne);
          waitResponse();
        }
        def input = (tb: Element, value: String) => {
          focus(tb);
          tb.eval("value = \"" + value+"\"");
          blur(tb);
          waitResponse();
        }
        def getGstr (gnum: String): String = {
          var gstr: String = gnum;
          if (gstr.length() == 1)
            return "00"+gstr;
          else if (gstr.length() == 2)
            return "0"+gstr;
          return gstr;
        }
        closeGroup("lbxOne", "5", true);
        verifyTrue("The open/close status should sync between first two grid",
            isClose("lbxTwo", "5"));
        closeGroup("lbxOne", "197", true);
        verifyTrue("The open/close status should sync between first two grid",
            isClose("lbxTwo", "197"));
        closeGroup("lbxTwo", "5", false);
        verifyFalse("The open/close status should sync between first two grid",
            isClose("lbxOne", "5"));
        sortAndCheck("lbxOne", "lbxTwo", "Name", "50");
        sortAndCheck("lbxOne", "lbxTwo", "Name", "50");
        sortAndCheck("lbxOne", "lbxTwo", "Name", "50");

        closeGroup("lbxThree", "199", true);
        verifyTrue("The last group should closed without any problem",
            isClose("lbxThree", "199"));

        click(btnThree);
        waitResponse();
        click(btnFour);
        waitResponse();
        verifyTrue("The last group should closed without any problem",
            isClose("lbxThree_clone0", "199"));
        verifyTrue("The last group should closed without any problem",
            isClose("lbxThree_serialize1", "199"));

        closeGroup("lbxThree", "199", false);
        verifyTrue("The last group should closed without any problem",
            isClose("lbxThree_clone0", "199"));
        verifyTrue("The last group should closed without any problem",
            isClose("lbxThree_serialize1", "199"));

        closeGroup("lbxThree", "0", true);
        closeGroup("lbxThree", "1", true);
        click(btnThree);
        waitResponse();
        click(btnFour);
        waitResponse();

        closeGroup("lbxThree_clone2", "1", false);
        closeGroup("lbxThree_serialize3", "1", false);
        verifyTrue("The last group should closed without any problem",
            isClose("lbxThree_clone2", "0"));
        verifyTrue("The last group should closed without any problem",
            isClose("lbxThree_serialize3", "0"));
        verifyFalse("The last group should closed without any problem",
            isClose("lbxThree_clone2", "1"));
        verifyFalse("The last group should closed without any problem",
            isClose("lbxThree_serialize3", "1"));
    }
   );
  }
}