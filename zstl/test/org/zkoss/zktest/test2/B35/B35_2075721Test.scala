/* B35_2075721Test.scala

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
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll

/**
 * A test class for bug 2075721
 * @author ldnigro
 *
 */
@Tags(tags = "B35-2075721.zul,C,E,Button")
class B35_2075721Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
    		<zk>
	Click Button 1, Button 2, Button 3 and then Button 1.
	The label is changed but the space in between shall remain.
	<separator/>
	<button id="b1" label="Button 1">
	<attribute name="onClick">
	self.label = "" + new Date();
	</attribute>
	</button>
	<button id="b2" label="Button 2">
	<attribute name="onClick">
	self.label = "" + new Date();
	</attribute>
	</button>
	<button id="b3" label="Button 3">
	<attribute name="onClick">
	self.label = "" + new Date();
	</attribute>
	</button>
</zk>

    """

    runZTL(zscript,
        () => {
        	
            waitResponse();
          
            //click button 1
            click(jq("$b1"));
            
            waitResponse();
            
            //label change 
            verifyNotEquals(getText(jq("$b1")),"Button 1");
            var b1t=getText(jq("$b1"));
            
            var pl=jq("$b1 .z-button-cm").css("padding-left");
            var pr=jq("$b1 .z-button-cm").css("padding-right");
            
            //click button 2
            click(jq("$b2"));
            
            waitResponse();
            
            //label change 
            verifyNotEquals(getText(jq("$b2")),"Button 2");
            
            var pl2=jq("$b2 .z-button-cm").css("padding-left");
            var pr2=jq("$b2 .z-button-cm").css("padding-right");
            
            //click button 3
            click(jq("$b3"));
                        
            waitResponse();            
            
            //label change 
            verifyNotEquals(getText(jq("$b3")),"Button 3");
            
            var pl3=jq("$b1 .z-button-cm").css("padding-left");
            var pr3=jq("$b1 .z-button-cm").css("padding-right");
                        
            //Wait timer change
            sleep(1000);
            
            //click button 1 again
            click(jq("$b1"));
            
            waitResponse();
            
            //label change 
            var b1tn=getText(jq("$b1"));
            verifyNotEquals(b1tn,b1t);
            
            //space in between shall remain
            verifyEquals(pl,jq("$b1 .z-button-cm").css("padding-left"));
            verifyEquals(pr,jq("$b1 .z-button-cm").css("padding-right"));
            
            verifyEquals(pl2,jq("$b2 .z-button-cm").css("padding-left"));
            verifyEquals(pr2,jq("$b2 .z-button-cm").css("padding-right"));
            
            verifyEquals(pl3,jq("$b3 .z-button-cm").css("padding-left"));
            verifyEquals(pr3,jq("$b3 .z-button-cm").css("padding-right"));
            
        	
        }
    );
   }
}
