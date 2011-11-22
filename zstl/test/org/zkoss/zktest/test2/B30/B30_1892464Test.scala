/* B30_1892464Test.scala

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
 * A test class for bug 1892464
 * @author ldnigro 
 *
 */
@Tags(tags = "B30-1892464.zul,A,E,Groupbox,Clone,BI")
class B30_1892464Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<window id="mainwin">
    			If you see two same groupbox, it is correct!
    			<groupbox id="gbx2">
    				<caption label="caption2"/>
    				<label value="clone a groupbox"/>
    			</groupbox>

    			<zscript>
    				Groupbox gbx3 = gbx2.clone();
    				gbx3.setId("gbx3");
    				gbx3.setParent(mainwin);
    			</zscript>
    		</window>
    }

    runZTL(zscript,
        () => {
            
            waitResponse();
            
            //Verify if group boxes exists
            verifyTrue(jq("$gbx2").exists());
            verifyTrue(jq("$gbx3").exists());
              
            //Verify if group boxes are visible
            verifyTrue(jq("$gbx2").isVisible());
            verifyTrue(jq("$gbx3").isVisible());
            
            //Verify if group boxes are equal
            val c1=getText(jq("@caption:eq(0)").get(0));
            val c2=getText(jq("@caption:eq(1)").get(0));
            verifyEquals(c1,c2);
            
            val l1=getText(jq("$gbx2 @label:eq(0)").get(0));
            val l2=getText(jq("$gbx3 @label:eq(0)").get(0));
            verifyEquals(l1,l2);
            
        }
    );
   }
}
