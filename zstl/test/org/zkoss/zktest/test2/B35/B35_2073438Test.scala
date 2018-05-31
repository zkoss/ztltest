/* B35_2073438Test.scala

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
import org.zkoss.ztl.Tags

/**
  * A test class for bug 2073438
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B35-2073438.zul,A,E,Menu,Menupopup")
class B35_2073438Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
    		<?xml version="1.0" encoding="UTF-8"?>
<?page title="Welcome to ZK Demo"?>
	<!--
		index.zul {{IS_NOTE Purpose: Description: History: Thu May 11 17:24:33
		2006, Created by tomyeh }}IS_NOTE Copyright (C) 2006 Potix
		Corporation. All Rights Reserved. {{IS_RIGHT }}IS_RIGHT
	-->
<window title="Menu Demo" border="normal" id="win">
	<label id="label" value='Please scroll down to click the menu item "Dynamically Attribute" the window should not scroll top automatically'/>
	<div height="1000px"> 123</div>
	<window>
		<menubar>
			<menu label="Dynamically Attribute" id="dynamic">
				<menupopup>
				</menupopup>
			</menu>
		</menubar>
	</window>
</window>
    """

    runZTL(zscript,
      () => {
        //Dynamic menu
        val menu = jq("$dynamic");

        waitResponse();

        //Scroll down
        focus(menu);

        val top = jq("document.body.parentNode").scrollTop();
        waitResponse();

        //Dynamic menu click
        click(menu);

        waitResponse();

        //Verify if scroll if down
        verifyTrue(top == jq("document.body.parentNode").scrollTop())

      }
    );
  }
}
