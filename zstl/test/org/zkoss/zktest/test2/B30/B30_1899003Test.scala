/* B30_1899003Test.scala

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
 * A test class for bug 1899003
 * @author ldnigro
 *
 */
@Tags(tags = "B30-1899003.zul,C,E,Style,Vbox,Label,IE")
class B30_1899003Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = """
      
    		<window>
    			<html><![CDATA[
    				Test Environment: IE6<br/>
    				Expected Result: you shall see a blue line between abc and xyz
    			]]></html>
    			<vbox width="100%">
    				<label value="abc" />
    				<label value="xyz" />
    				</vbox>
    					<style>
    						tr.z-vbox-separator td {border-bottom: 1px solid blue}
    					</style>
    		</window>
          """
    runZTL(zscript,
        () => {
        
        	waitResponse();
            
        	//Test if vbox exists
        	val b=getText(jq("@label:eq(0)"));
        	
        	val b1=jq(jq(".z-vbox").toWidget().$n("chdex2")).hasClass("z-vbox-separator");
        	val b4=jq(jq("@vbox").toWidget().$n("chdex2")).css("border-bottom-color");
        	val b2=getText(jq(jq("@vbox").toWidget().$n("chdex")).find("@label"));
        	           
            //Assert First row = "abc"
            verifyTrue(b.equals("abc"));
            
            //Assert Second row = "xyz"
            verifyTrue(b2.equals("xyz"));
            
            //Middle Row is a separator 
            verifyTrue(b1);
            
            //Row separator line is blue
            verifyTrue(org.zkoss.ztl.util.ColorVerifingHelper.isEqualColor("blue", b4));
            
        }
    );
   }
}
