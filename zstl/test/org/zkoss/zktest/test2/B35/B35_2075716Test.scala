/* B35_2075716Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Dec 15, 2011 00:00:00 AM , Created by Fernando Selvatici
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
@Tags(tags = "B35-2075716.zul,B,E,Window,Button")
class B35_2075716Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    val zscript =
      """
      <window>
        1. Press the "add" button, and see the new column of Portallayout is 50% of right remainder width.
        <separator/>
        2. Press the "remove" button, and see the column disappear.
        <separator/>
        3. If no any error, that is true.
        <button label="add" onClick="add()"/>
        <button label="remove" onClick="remove()"/>
        <portallayout id="cl">
          <portalchildren width="200px" style="padding: 5px">
            <panel height="100px" title="portal" border="normal" maximizable="true" collapsible="true">
              <panelchildren>Panel</panelchildren>
            </panel>
          </portalchildren>
        </portallayout>
        <zscript>
          <![CDATA[
	import org.zkoss.zkmax.zul.Portalchildren;
	import org.zkoss.zul.Spinner;
	
	Portalchildren[] cc = new Portalchildren[15];
	int count = 0;
	
	public void add() {
		if (count > 14) return;
		
		cc[count] = new Portalchildren();
		cc[count].setWidth("50%");
		cc[count].setParent(cl);
		
		Panel p = new Panel();
		p.setHeight("100px");
		p.setStyle("padding: 5px");
		p.setTitle("portal " + count);
		p.setBorder("normal");
		
		
		Panelchildren pc = new Panelchildren();
		Label l = new Label("test");
		l.setParent(pc);
		pc.setParent(p);
		p.setParent(cc[count]);
		count++;
	}
	public void remove() {
		if (count > 0)
			cc[--count].detach();
	}
]]>
        </zscript>
      </window>
    """;
    runZTL(zscript, () => {
      // Record total width
      var total_width: Int = jq(".z-portallayout").width();

      // Record width of the first panel
      var panel0_width: Int = jq(".z-portalchildren").width();

      // Click on add button
      click(jq("@button:contains(add)"));
      waitResponse()

      // Record new panel width
      var new_panel_width: Int = jq(".z-portalchildren:contains(portal 0)").width();

      // Record the remainder width
      val remainder_width: Int = (total_width - panel0_width) - 10;

      verifyTolerant(remainder_width / 2, new_panel_width, 2);
      verifyFalse(jq(".z-error").exists())
    })
  }
}