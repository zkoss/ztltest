/* B35_2078093Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Nov 08 22:51:02 GFT 2011 , Created by ldnigro
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 2078093
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B35-2078093.zul,A,E,Window")
class B35_2078093Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2078093.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Aug 28 09:14:31 TST 2008, Created by jumperchen
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->

<zk>
1. Click the first button, then the window will disappear.
<separator/>
2. Click the second button, then the window should be shown, that is correct.
<button id="bt1">
<attribute name="onCreate"><![CDATA[
self.setLabel("DO: Win.setVisible="+(!win.isVisible()));
]]></attribute>

<attribute name="onClick"><![CDATA[
win.setVisible(!win.isVisible());
self.setLabel("DO: Win.setVisible="+(!win.isVisible()));
]]></attribute>
</button>
<button id="bt2" onClick="win.doEmbedded()" label="doEmbedded"/>

<window id="win" title="test"
sizable="true"
minimizable="true" maximizable="true" border="normal">




</window>
</zk>


    """

    runZTL(zscript,
      () => {

        //click first button
        click(jq("$bt1"));

        waitResponse();

        //Window is invisible
        verifyFalse(jq("$win").isVisible());

        //click second button
        click(jq("$bt2"));

        waitResponse();

        //Window is visible & embedded
        verifyTrue(jq("$win").isVisible());
        verifyTrue(jq(".z-window-embedded").isVisible());

      }
    );
  }
}
