/* B30_1882320Test.scala

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
import scala.collection.JavaConversions._
import org.junit.Test
import org.zkoss.ztl.ClientWidget
import org.zkoss.ztl.Element
import org.zkoss.ztl.JQuery
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.Scripts
import org.zkoss.ztl.Widget
import org.zkoss.ztl.ZK
import org.zkoss.ztl.ZKClientTestCase
import java.lang._
import org.apache.velocity.texen.ant.TexenTask

/**
 * A test class for bug 1882320
 * @author ldnigro
 *
 */
@Tags(tags = "B30-1882320.zul,C,E,Textbox")
class B30_1882320Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">

    			<n:p>setSelectionRange won't work at following case due to the smartupdate. If you see the text is selected from 1 to 2, it is correct.</n:p>
    			<window id="win">

    			<zscript>

    				Textbox textboxTest = new Textbox();
    				textboxTest.setParent(win);
    				textboxTest.setValue( "0123456789" );
    				textboxTest.setSelectionRange(1,3);

    			</zscript>

    			</window>
    			
    		</zk>
   }

    runZTL(zscript,
        () => {

        	 waitResponse();
        	 //Compare with selection
        	 verifyEquals(zk(jq("@textbox")).eval("getSelectionRange()"),"[1, 3]");
        }
    );
   }
}
