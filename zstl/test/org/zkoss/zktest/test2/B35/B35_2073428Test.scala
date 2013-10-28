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
import org.junit.Test
import org.zkoss.ztl.ZK
import org.zkoss.ztl.util.Scripts

/**
 * A test class for bug 2073428
 * @author ldnigro
 *
 */
@Tags(tags = "B35-2073428.zul,A,E,Menu")
class B35_2073428Test extends ZTL4ScalaTestCase {
	
  @Test
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
        
        	waitResponse();
                  
        	//Stone Menu
        	val menu=engine.$f("stone").$n("a");
        	click(menu);
        	
        	waitResponse();
        	
        	if(!ZK.is("ie9_"))
        		mouseOver(menu);
        	else
        		Scripts.triggerMouseEventAt(getWebDriver(), menu, "mouseover", "5,5");
        	
        	waitResponse();
        	
        	//Verify Over Style
        	val mo=jq("$stone .z-menu-body-over");
        	verifyTrue(mo.exists());
        	
        	//Move the mouse out of the menu
        	mouseOut(menu);
        	waitResponse();
        	
        	//Verify Over style isn't present
        	val mo1=jq("$stone .z-menu-body-over");
        	verifyFalse(mo1.exists());        	
        	        	        	        	
        }
    );
   }
}
