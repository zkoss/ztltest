/* B30_1893575Test.scala

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
import org.openqa.selenium.internal.seleniumemulation.IsChecked

/**
 * A test class for bug 1893575
 * @author ldnigro
 *
 */
@Tags(tags = "B30-1893575.zul,A,E,Radiogroup,Window")
class B30_1893575Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
    		<window id="w" mode="modal" xmlns:n="http://www.zkoss.org/2005/zk/native" width="500px">
    			<n:p>Please click the "female" radio, and then click the "show" button, and then you should see that only "female" is checked. (Only IE)</n:p>
    			<radiogroup id="radiochoice">
    				<radio id="male1" label="male" checked="true" />
    				<radio id="female" label="female" />
    			</radiogroup>
    			<button label="show">
    				<attribute name="onClick">
						new Label("Test").page = w.page;
    				</attribute>
    			</button>
    		</window>
   }

    runZTL(zscript,
        () => {
        
        	//Click 'female' radio
        	jq("$female input").eval("checked=''");
        	jq("$male1 input").eval("checked=''");
            click(jq("$female input"));
            waitResponse();
            
            //Verify male not checked and female checked
            val f=jq("$female input");
            val m=jq("$male1 input");
            val bf="checked".equals(jq("$female input").attr("checked"));
            val bm="checked".equals(jq("$male1 input").attr("checked"));
            verifyTrue(bf);
            verifyFalse(bm);
            
            //Click 'show' button
            click(jq("@button:eq(0)"));
            waitResponse();
            
            //Verify male not checked and female checked
            verifyTrue("checked".equals(jq("$female input").attr("checked")));
            verifyFalse("checked".equals(jq("$male1 input").attr("checked")));
                        
            
        }
    );
   }
}
