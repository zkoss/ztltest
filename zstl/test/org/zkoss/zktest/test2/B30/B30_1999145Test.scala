/* B30_1999145Test.scala

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
  * A test class for bug 1999145
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B30-1999145.zul,B,E,Combobox")
class B30_1999145Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
    		<zk>
    			You should see the width of combobox is stretch to 100% with its button. 
    			<window border="normal">
    				<combobox width="100%" >
    					<comboitem label="Simple and Rich"/>
    					<comboitem label="Cool!"/>
    					<comboitem label="Thumbs Up!"/>
    				</combobox>
    			</window>
    		</zk>
    """

    runZTL(zscript,
      () => {

        waitResponse();

        //Combo box
        val cb = jq("@combobox:eq(0)");

        //Combo width
        val cw = cb.width();

        //Combo parent
        var parent = cb.parent();

        //Parent width
        var pw = parent.width();

        //Parent and Combo width are same size, so combo = 100% of parent
        verifyEquals(cw, pw);

      }
    );
  }
}
