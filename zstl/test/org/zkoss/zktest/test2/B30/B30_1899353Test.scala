/* B30_1899353Test.scala

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
 * A test class for bug 1899353
 * @author ldnigro
 *
 */
@Tags(tags = "B30-1899353.zul,B,E,Macro,BI")
class B30_1899353Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = """
    		<?component name="B1899353" macro-uri="B1899353.zul"
    				class="B1899353"?>
    		<zk>
    			<zscript>
    				public class B1899353 extends HtmlMacroComponent{
    					public B1899353() {
    						setMacroURI("/test2/B1899353.zul");
    					}	
    				}
    			</zscript>
    			<window title="Test" border="normal">
    				<attribute name="onCreate">
    				B1899353 b = new B1899353();
    				b.afterCompose();
    				b.setParent(test1);
    				</attribute>
    				If you see this page, the bug is fixed.
    				<vbox id="test1"/>
    			</window>
    		</zk>
   """

    runZTL(zscript,
        () => {
        
        	waitResponse();
            
        	//Test if vbox exists
        	val b=jq("$test1");
        	           
            //Assert
            verifyTrue(b.exists());
            
        }
    );
   }
}
