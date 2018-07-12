/* F60_ZK_621Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 23 15:41:04 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-621
  *
  * @author benbai
  *
  */
@Tags(tags = "F60-ZK-621.zul,F60,A,E,Combobox,Bandbox")
class F60_ZK_621Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
				<div height="15px" />
				<div height="25px">Open combobox (the left one).</div>
				<div height="25px">You should see the message become 'message: combobox is open? true'.</div>
				<div height="25px">Close combobox (the left one).</div>
				<div height="25px">You should see the message become 'message: combobox is open? false'.</div>
				<div height="25px">Test above steps for the bandbox (the right one).</div>
				<combobox id="cbx">
					<attribute name="onOpen">
						lb.setValue("message: combobox is open? " + self.isOpen());
					</attribute>
					<comboitem label="Simple and Rich"/>
					<comboitem label="Cool!"/>
					<comboitem label="Ajax and RIA"/>
				</combobox>
				<bandbox id="bd">
					<attribute name="onOpen">
						lb.setValue("message: bandbox is open? " + self.isOpen());
					</attribute>
					<bandpopup>
						<listbox width="200px">
							<listhead>
								<listheader label="Name" />
								<listheader label="Description" />
							</listhead>
							<listitem>
								<listcell label="John" />
								<listcell label="CEO" />
							</listitem>
						</listbox>
					</bandpopup>
				</bandbox>
				<label id="lb" value="message: " />
			</zk>

    """
    runZTL(zscript,
      () => {
        var cbx: Widget = engine.$f("cbx");
        var bd: Widget = engine.$f("bd");
        var lb: Widget = engine.$f("lb");

        click(cbx.$n("btn"));
        waitResponse();
        verifyContains("You should see the message become 'message: combobox is open? true'.",
          lb.$n().attr("innerHTML"), "message: combobox is open? true")
        click(cbx.$n("btn"));
        waitResponse();
        verifyContains("You should see the message become 'message: combobox is open? false'.",
          lb.$n().attr("innerHTML"), "message: combobox is open? false")

        click(bd.$n("btn"));
        waitResponse();
        verifyContains("You should see the message become 'message: bandbox is open? true'.",
          lb.$n().attr("innerHTML"), "message: bandbox is open? true")
        click(bd.$n("btn"));
        waitResponse();
        verifyContains("You should see the message become 'message: bandbox is open? false'.",
          lb.$n().attr("innerHTML"), "message: bandbox is open? false")
      }
    );
  }
}