/* B30_1898094Test.scala

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

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 1898094
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B30-1898094.zul,B,E,Window,Textbox")
class B30_1898094Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
    		<zk>        
    			If you see the focus be at the textbox (rather than button), It is fixed.
    			<window title="Test Popup Focus" mode="popup" width="300px" >
    			<button label="Button"/>
    				<textbox onCreate="self.focus()"/>
    			</window>
    		</zk>
   """
    runZTL(zscript,
      () => {

        waitResponse();

        //Look for a textbox focused
        val b = jq("@textbox:focus");

        //Look for a button focused
        val r = jq("@button:focus");

        //Textbox focused Exists?
        val bb = b.exists();

        //Button focused Exists?
        val br = r.exists();

        //Assert
        verifyTrue(bb);
        verifyFalse(br);


      }
    );
  }
}
