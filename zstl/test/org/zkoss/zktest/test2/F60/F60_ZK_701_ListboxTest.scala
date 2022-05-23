/* F60_ZK_701_ListboxTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Feb 20 19:14:13 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.Widget

/**
  * A test class for bug ZK-701-Listbox
  *
  * @author benbai
  *
  */
@Tags(tags = "F60-ZK-701-Listbox.zul,F60,A,E,Cloneable,Listbox,Listgroup,GroupModel")
class F60_ZK_701_ListboxTest extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
				<vbox id="vb">
				1. Please close the node of "Seafood".
				<separator/>
				2. Press the "Clone" button (it should not show any exception)
				<separator/>
				3. Please open the node of "Seafood" from the top grid, it should work as expected 
				<button id="btn" label="Clone">
					<attribute name="onClick">{
				Object l = grid.clone();
				l.setId("dst" + ++cnt);
				vb.insertBefore(l, self);
					}</attribute>
				</button>
				<button label="Clone by Serialization">
					<attribute name="onClick">{
				import java.io.*;
				ByteArrayOutputStream boa = new ByteArrayOutputStream();
				new ObjectOutputStream(boa).writeObject(grid);
				byte[] bs = boa.toByteArray();
				Object l = new ObjectInputStream(new ByteArrayInputStream(bs)).readObject(); 
				l.setId("dst" + ++cnt);
				vb.insertBefore(l, self);
				vb.insertBefore(new Label(bs.length+" bytes copied"), self);
					}</attribute>
				</button>
			    <zscript><![CDATA[
			  int cnt = 0;
			Object[][] foods = new Object[][] {
			    new Object[] { "Vegetables", "Asparagus", "Vitamin K", 115, 43},
			    new Object[] { "Vegetables", "Beets", "Folate", 33, 74},
			    new Object[] { "Vegetables", "Bell peppers", "Vitamin C", 291, 24},
			    new Object[] { "Vegetables", "Cauliflower", "Vitamin C", 92, 28},
			    new Object[] { "Vegetables", "Eggplant", "Dietary Fiber", 10, 27},
			    new Object[] { "Vegetables", "Onions", "Chromium", 21, 60},
			    new Object[] { "Vegetables", "Potatoes", "Vitamin C", 26, 132},
			    new Object[] { "Vegetables", "Spinach", "Vitamin K", 1110, 41},
			    new Object[] { "Vegetables", "Tomatoes", "Vitamin C", 57, 37},
			    new Object[] { "Seafood", "Salmon", "Tryptophan", 103, 261},
			    new Object[] { "Seafood", "Shrimp", "Tryptophan", 103, 112},
			    new Object[] { "Seafood", "Scallops", "Tryptophan", 81, 151},
			    new Object[] { "Seafood", "Cod", "Tryptophan", 90, 119}
			};
			
			
			ListitemRenderer renderer = new org.zkoss.zktest.test2.group.FoodGroupRenderer2();
			GroupsModel model = new GroupsModelArray(foods, new ArrayComparator(0, true));
			    ]]></zscript>
			    <listbox id="grid" model="${model}" itemRenderer="${renderer}">
			        <listhead>
			            <listheader label="Category" sort="auto(0)"/>
			            <listheader label="Name" sort="auto(1)"/>
			            <listheader label="Top Nutrients" sort="auto(2)"/>
			            <listheader label="% of Daily" sort="auto(3)"/>
			            <listheader label="Calories" sort="auto(4)"/>
			        </listhead>
			    </listbox>
				</vbox>
			</zk>

    """

    runZTL(zscript,
      () => {
        var btn: Widget = engine.$f("btn");
        var grid: Widget = engine.$f("grid");
        var clonedGrid: Widget = engine.$f("clonedGrid");

        click(jq(".z-listgroup:contains(Seafood)").toWidget().$n("img"));
        waitResponse();
        click(btn);
        waitResponse();
        clonedGrid = jq(".z-listbox").eq(0).toWidget;
        click(jq(clonedGrid).find(".z-listgroup:contains(Seafood)").toWidget().$n("img"));
        waitResponse();
        verifyTrue("Seafood group of cloned grid should be opened",
          jq(clonedGrid).find(".z-listgroup:contains(Seafood)").toWidget().$n("img").exists());
      }
    );
  }
}