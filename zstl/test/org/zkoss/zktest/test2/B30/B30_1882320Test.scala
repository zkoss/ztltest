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

    			<n:script type="text/javascript">
    				<![CDATA[ 
    				function getText(control)
    				{ 
    					
    					var txt=""; 
    					if (window.getSelection){ 
    						txt=window.getSelection();
    					} else if (document.getSelection){
    						txt=document.getSelection();
    					} else if (document.selection.createRange) { 
    						txt = document.selection.createRange().text;
    					} 
    					
    					document.getElementById(control).value=txt;
    					
    					return txt;
    				}
    			]]></n:script>


    			<n:p>setSelectionRange won't work at following case due to the smartupdate. If you see the text is selected from 1 to 2, it is correct.</n:p>
    			<window id="win">

    			<zscript>
    				<!-- Support objects to Get selected Text-->
    				
    				<!-- Input to compare selected Text-->
    				Textbox textboxTest1 = new Textbox();
    				textboxTest1.setId("text");
    				textboxTest1.setParent(win);
    				textboxTest1.setVisible(false);

    				Textbox textboxTest = new Textbox();
    				textboxTest.setParent(win);
    				textboxTest.setValue( "0123456789" );
    				textboxTest.setSelectionRange(1,3);

    			</zscript>

    			<zscript>
    				
    				<!-- Get selected Text-->
    				<![CDATA[
    					Clients.evalJavaScript("getText('"+textboxTest1.uuid+"')");
    				]]>
    			</zscript>
    				 
    			</window>
    			
    		</zk>
   }

    runZTL(zscript,
        () => {
        	waitResponse();
        	//Get Widget
        	var l1: Widget = engine.$f("text");
        	waitResponse();
        	
        	//Get Selected value from auxiliary input
        	var b=getValue(l1);

        	//Compare with selection
        	verifyEquals(b,"12");    
        }
    );
   }
}
