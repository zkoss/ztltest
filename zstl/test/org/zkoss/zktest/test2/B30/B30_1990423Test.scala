/* B30_1990423Test.scala

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
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * A test class for bug 1990423
 * @author ldnigro
 *
 */
@Tags(tags = "B30-1990423.zul,B,E,Window")
class B30_1990423Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
    		<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
    			<window title="toolbar demo" border="normal" width="300px" id="win">
    				Each button works well.
    				<button label="has border" onClick='win.border = "normal"'/>
    				<button label="none border" onClick='win.border = "none"'/>
    			</window>
    		</zk>
    """

    runZTL(zscript,
        () => {
        
        	waitResponse();
            
        	//Button "none border"
        	val nb=jq("@button:eq(1)");
        	click(nb);
        	
        	waitResponse();
        	
        	//Test if border isn't pressent
        	val win1=jq("@window:eq(0)");
        	var br1=win1.toWidget().get("border");
        	verifyEquals(br1,"none");
        	
        	//border classes
        	verifyFalse(jq(".z-window-embedded-cl").exists());
        	verifyFalse(jq(".z-window-embedded-bl").exists());        
            
        	//Button "has border"
        	val hb=jq("@button:eq(0)");
        	click(hb);
        	
        	waitResponse();

        	//Test if border is pressent
        	val win=jq("@window:eq(0)");
        	var br=win.toWidget().get("border");
        	verifyEquals(br,"normal");
        	
        	//border classes
        	verifyTrue(jq(".z-window-embedded-cl").exists());
        	verifyTrue(jq(".z-window-embedded-bl").exists());    
        	
        }
    );
   }
}
