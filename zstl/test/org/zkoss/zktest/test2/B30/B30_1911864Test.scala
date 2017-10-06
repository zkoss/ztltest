/* B30_1911864Test.scala

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
import org.junit.Test

/**
 * A test class for bug 1911864
 * @author ldnigro
 *
 */
@Tags(tags = "B30-1911864.zul,B,E,Combobox")
class B30_1911864Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        
        	waitResponse();
            
        	//Get Combobox button
        	click(jq(".z-combobox").toWidget().$n("btn"));
        	
        	waitResponse();

        	//Verify First item of dropdown exists
        	//and visible, => dropdown appears
            val item0=jq(".z-comboitem");
            verifyTrue(item0.isVisible());
            verifyEquals(getText(item0),"male");
                       
        }
    );
   }
}
