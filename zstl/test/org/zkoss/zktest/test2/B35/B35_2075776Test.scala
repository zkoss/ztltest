/* B35_2075776Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Dec 25, 2011 11:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B35-2075776.zul,B,E,Window,Button")
class B35_2075776Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript =
      """
      <window title="Column's Menu Demo" border="normal" width="500px">
        1. Please click the "remove column1" or "remove column2" button.
        <separator/>
        2. Mouse-over the header of the grid. And then click on the menu icon of the header.
        <separator/>
        3. You should see the menu popup, that is correct.
        <grid id="gd">
          <columns sizable="true" menupopup="auto" id="cols">
            <column id="col" label="Type" sortAscending="&#36;{asc}" sortDescending="&#36;{dsc}"/>
            <column id="col1" label="Type1" sortAscending="&#36;{asc}" sortDescending="&#36;{dsc}"/>
            <column id="col2" label="Content"/>
          </columns>
          <rows id="rs">
            <row id="r1">
              <label value="File:" id="lb1"/>
              <label value="File1:"/>
              <textbox width="98%" id="tb1"/>
            </row>
            <row id="r2">
              <label value="File:" id="lb2"/>
              <label value="File1:"/>
              <textbox width="98%" id="tb2"/>
            </row>
            <row id="r3">
              <label value="Files:" id="lb3"/>
              <label value="File1s:"/>
              <textbox width="98%" id="tb3"/>
            </row>
          </rows>
        </grid>
        <button label="remove column1">
          <attribute name="onClick">
            cols.removeChild(col);
r1.removeChild(lb1);
r2.removeChild(lb2);
r3.removeChild(lb3);
          </attribute>
        </button>
        <button label="remove column2">
          <attribute name="onClick">
            cols.removeChild(col1);
r1.removeChild(tb1);
r2.removeChild(tb2);
r3.removeChild(tb3);
          </attribute>
        </button>
      </window>
    """;
    runZTL(zscript, () => {

      // Click on a remove button (The first one)
      click(jq("@button"));
      waitResponse();

      // Mouse over the column to see the menu popup
      mouseOver(jq(engine.$f("col1")));
      waitResponse();
      mouseOver(jq(engine.$f("col1").$n("btn")));
      waitResponse();

      // Click on the column menu
      click(jq(engine.$f("col1").$n("btn")));
      waitResponse();

      // Verify that the menu popup appear
      verifyTrue("The menu popup should be visible", jq(".z-menupopup").exists());
    })
  }
}