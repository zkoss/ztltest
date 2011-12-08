/* B30_1911129Test.scala

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
 * A test class for bug 1911129
 * @author ldnigro
 *
 */
@Tags(tags = "B30-1911129.zul,C,E,Menuseparator,Menupopup")
class B30_1911129Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
    		<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
	<n:p>Menuseparator's background should be shown.</n:p>
	<window title="Menu Demo" border="normal">
		<menubar id="menubar">
			<menu label="File" id="fm">
				<menupopup>
					<menuitem label="New" onClick="alert(self.label)"/>
					<menuitem label="Open" onClick="alert(self.label)"/>
					<menuitem label="Save" onClick="alert(self.label)"/>
					<menuseparator id="ms" />
					<menuitem label="Exit" onClick="alert(self.label)"/>
				</menupopup>
			</menu>
			<menu label="Help">
				<menupopup>
					<menuitem label="Index" onClick="alert(self.label)"/><menuseparator/>
					<menu label="About">
						<menupopup>
							<menuitem label="About ZK" onClick="alert(self.label)"/>
							<menuitem label="About Potix" onClick="alert(self.label)"/>
						</menupopup>
					</menu>
				</menupopup>
			</menu>
		</menubar>
	</window>
				
</zk>
    """

    runZTL(zscript,
        () => {
        
        	waitResponse();
                  	
        	//File Menu
        	val file=jq("$fm");
        	click(file);
        	
        	waitResponse();
        	
        	//Menu separator
        	val ms=jq("$ms");
        	
        	val ow=ms.width();
        	val oh=ms.height();
        	
        	//Width and Height of menuseparator>0
        	verifyTrue(ow>0);
        	verifyTrue(oh>0);
        	
        }
    );
   }
}
