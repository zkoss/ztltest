/* B35_2095278Test.scala

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
import org.zkoss.ztl.Widget
import org.zkoss.ztl.Element


/**
 * A test class for bug 2095278
 * @author ldnigro
 *
 */
@Tags(tags = "B35-2095278.zul,A,E,Button")
class B35_2095278Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2095278.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Sep  8 10:18:18     2008, Created by tomyeh
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<window width="100%" height="100%">
<vbox>
You shall see the "hello" button shown up when you click the "toggle visibility"
button.
<button id="tv" label="toggle visibility" onClick="bt.visible=!bt.visible"/>
<button id="bt" label="hello" visible="false"/>
</vbox>
</window>


    """

    runZTL(zscript,
        () => {
        	
            waitResponse();
            var b1=jq("$bt")
            verifyFalse(b1.isVisible());
            
            //click open button
        	click(jq("$tv"));
        	waitResponse();
        	
        	//b1 shown up
        	verifyTrue(b1.isVisible());
        	        	
        }
    );
   }
}
