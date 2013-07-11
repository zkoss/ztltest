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
import org.junit.Test

/**
 * A test class for bug 1893575
 * @author ldnigro
 *
 */
@Tags(tags = "B30-1893575.zul,A,E,Radiogroup,Window")
class B30_1893575Test extends ZTL4ScalaTestCase {
  
  @Test
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
        	click(jq("$female").toWidget().$n("real"));
            waitResponse();
            
            //Verify male not checked and female checked
            val f=jq("$female").toWidget().$n("real");
            val m=jq("$male1").toWidget().$n("real");
            val bf="true".equals(f.toElement().get("checked"));
            val bm="true".equals(m.toElement().get("checked"));
            verifyTrue(bf);
            verifyFalse(bm);
            
            //Click 'show' button
            click(jq("@button:eq(0)"));
            waitResponse();
            
            //Verify male not checked and female checked
            verifyTrue("true".equals(f.toElement().get("checked")));
            verifyFalse("true".equals(m.toElement().get("checked")));
                        
            
        }
    );
   }
}
