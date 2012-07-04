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

/**
 * A test class for bug 1911864
 * @author ldnigro
 *
 */
@Tags(tags = "B30-1911864.zul,B,E,Combobox")
class B30_1911864Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
    		<window title="combobox in listbox" border="normal">
    			<vbox>
    				Clicks the dropdown button of the combobox to see if the dropdown
    				appears or not (it shall appear).
    				<listbox width="250px">
    					<listhead sizable="true">
    						<listheader label="name" sort="auto"/>
    						<listheader label="gender" sort="auto"/>
    					</listhead>
    					<listitem>
    						<listcell label="Mary"/>
    						<listcell label="FEMALE"/>
    					</listitem>
    					<listitem>
    						<listcell label="John"/>
    						<listcell>
    							<combobox id="cf8" cols="7">
    								<comboitem label="male"/>
    								<comboitem label="female"/>
    								<comboitem label="unkown"/>
    							</combobox>
    						</listcell>
    					</listitem>
    					<listitem>
    						<listcell label="Jane"/>
    						<listcell>
    							<datebox/>
    						</listcell>
    					</listitem>
    					<listitem>
    						<listcell label="Henry"/>
    						<listcell label="MALE"/>
    					</listitem>
    				</listbox>
    			</vbox>
    		</window>
    """

    runZTL(zscript,
        () => {
        
        	waitResponse();
            
        	//Get Combobox button
        	val combo=jq(".z-combobox-btn:eq(0)");
        	click(combo);
        	
        	waitResponse();

        	//Verify First item of dropdown exists
        	//and visible, => dropdown appears
            val item0=jq(".z-comboitem-text:eq(0)");
            verifyTrue(item0.isVisible());
            verifyEquals(getText(item0)," male");
                       
        }
    );
   }
}
