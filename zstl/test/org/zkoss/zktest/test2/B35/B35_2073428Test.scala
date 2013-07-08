/* B35_2073428Test.scala

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
import org.zkoss.ztl.util.ColorVerifingHelper

/**
 * A test class for bug 2073428
 * @author ldnigro
 *
 */
@Tags(tags = "B35-2073428.zul,A,E,Menu")
class B35_2073428Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
    		<?xml version="1.0" encoding="UTF-8"?>
<?page title="Welcome to ZK Demo"?>
	<!--
		index.zul {{IS_NOTE Purpose: Description: History: Thu May 11 17:24:33
		2006, Created by tomyeh }}IS_NOTE Copyright (C) 2006 Potix
		Corporation. All Rights Reserved. {{IS_RIGHT }}IS_RIGHT
	-->
<window title="Menu Demo" border="normal" id="lbl">	
	<label  value='button "stone" should not be freezed after clicked and move the mouse away (it means the mouseover style should be removed)'/>
	<menubar>		
		<menu label="stone" id="stone" />
	</menubar>	
</window>
    """

    runZTL(zscript,
        () => {
        	/* cant get hover style
        	waitResponse();
                  
        	//Stone Menu
        	val menu=engine.$f("stone").$n("a");
        	click(menu);
        	
        	waitResponse();
        	
        	mouseOver(menu);
        	
        	waitResponse();
        	
        	//Verify Over Style
        	val mo = jq("$stone").css("border-color");
        	verifyTrue(if("".equals(mo)) false else ColorVerifingHelper.isEqualColor("#8fb9d0", mo))
        	
        	//Move the mouse out of the menu
        	mouseOut(menu);
        	waitResponse();
        	
        	//Verify Over style isn't present
        	val mo1 = jq("$stone").css("border-color");
        	verifyFalse(if("".equals(mo)) false else ColorVerifingHelper.isEqualColor("#8fb9d0", mo))
        	*/        	        	        	
        }
    );
   }
}
