/* B30_2003798Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Dec 1, 2011 05:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget
import org.zkoss.ztl.Element
import org.zkoss.ztl.ZK
import org.zkoss.ztl.util.Scripts
import org.junit.Test

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B30-2003798.zul,B,E,Window,Button")
class B30_2003798Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript = {
      <window title="tree and listbox bug" border="normal">
        1. When you mouse over the "foo" word, the entire row should be highlight.
        <separator/>
        2. Then, click on the "foo" word, the entire row should be seleted.
        <tree id="tree" width="300px" rows="5">
          <treecols sizable="true">
            <treecol label="Name"/>
            <treecol label="Description"/>
          </treecols>
          <treechildren>
            <treeitem>
              <treerow>
                <treecell>
                  <hbox style="display:inline-table;border:1px solid red">
                    <image id="img" src="/img/live.gif"/>
                    <label value="foo"/>
                  </hbox>
                </treecell>
                <treecell label="Item 1 description"/>
              </treerow>
            </treeitem>
            <treeitem label="Item 3"/>
          </treechildren>
        </tree>
        <listbox width="300px">
          <listhead>
            <listheader label="Listbox"/>
          </listhead>
          <listitem label="test"/>
          <listitem>
            <listcell>
              <hbox style="display:inline-table;border:1px solid red">
                <image src="/img/live.gif"/>
                <label value="foo"/>
              </hbox>
            </listcell>
          </listitem>
        </listbox>
      </window>
    }
    runZTL(zscript, () => {
      // Mouse over the "foo" word
      // Option 2: mouseOver(jq(".z-label:contains(foo)"));
      val img = engine.$f("img");
      mouseOver(img);
      waitResponse();
      // Verify that the first row is selected
      verifyFalse("The row must be highlighted", "".equals(jq("@treecell:eq(0)").css("background")));
      click(img);
      waitResponse();

      var cssClass = jq("@treerow").get(0).get("className");
      verifyTrue("The row must be selected", cssClass.contains("z-treerow-selected"));

    })
  }
}