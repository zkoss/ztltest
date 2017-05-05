/* B30_1896725Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Nov 23, 2011 10:00:00 PM , Created by Fernando Selvatici
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

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B30-1896725.zul,B,E,Window,Button")
class B30_1896725Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = """
      <zk xmlns:n="http://www.zkoss.org/2005/zk/native">
        <n:p>
          In IE6, the listbox still can be active when Clients.showBusy() is
invoked (Please click the "Echo Event" button).
        </n:p>
        <window id="w" width="200px" title="Test echoEvent" border="normal">
          <attribute name="onLater">
            Thread.sleep(5000);
	  Clients.clearBusy();
	  new Label("Done.").setParent(w);
          </attribute>
          <vbox>
            <listbox rows="1" mold="select">
              <listitem label="option1"/>
              <listitem label="option2"/>
              <listitem label="option3"/>
            </listbox>
            <button label="Echo Event">
              <attribute name="onClick">
                Clients.showBusy("Execute... (about 5 sec.)");
	  Events.echoEvent("onLater", w, null);
              </attribute>
            </button>
          </vbox>
        </window>
      </zk>
    """
runZTL(zscript, () => {
      if (ZK.is("ie6")) {
        click(jq("@button"));
        waitResponse();
        verifyFalse(jq("@select").isVisible())
      }
    })
  }
}