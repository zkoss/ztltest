/* B35_2075731Test.scala

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
  * A test class for bug 2075731
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B35-2075731.zul,A,E,Tablelayout")
class B35_2075731Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
    		<?xml version="1.0" encoding="UTF-8"?>
<zk>
If you can't the loading progress bar to keep alive, the bug is fixed.
<panel title="table1" border="normal"  collapsible="true">
<panelchildren>
<tablelayout>
<tablechildren>
<panel>
<panelchildren>
<label value="Panel" />
</panelchildren>
</panel>
</tablechildren>
</tablelayout>
Panel
</panelchildren>
</panel>
</zk>
    """

    runZTL(zscript,
      () => {

        waitResponse();

        //Check loading
        val c1 = jq(".z-loading-icon");
        verifyFalse(c1.exists());

      }
    );
  }
}
