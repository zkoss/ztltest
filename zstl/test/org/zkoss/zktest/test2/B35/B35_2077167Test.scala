/* B35_2077167Test.scala

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
  * A test class for bug 2077167
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B35-2077167.zul,A,E,Window")
class B35_2077167Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
    		<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2077167.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Aug 27 16:10:00 TST 2008, Created by jumperchen
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<zk>
1.Please click the "Minimize" icon of the window, and then click the "visible" button.
<separator/>
2. The window appears, that is correct.
<button id="btn" onClick="minmaxWin.setVisible(true);" label="visible"/>
<window id="minmaxWin" width="300px" title="test caption window"
minimizable="true" border="normal">
</window>
</zk>

    """

    runZTL(zscript,
      () => {

        //click minimize button
        click(jq("$minmaxWin").toWidget().$n("min"));

        waitResponse();

        //Window is minimized
        verifyFalse(jq("$minmaxWin").isVisible());

        //click visible button
        click(jq("$btn"));

        waitResponse();

        //Window is visible
        verifyTrue(jq("$minmaxWin").isVisible());

      }
    );
  }
}
