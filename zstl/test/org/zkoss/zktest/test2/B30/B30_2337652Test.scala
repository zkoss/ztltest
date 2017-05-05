/* B30_2337652Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 16, 2012 10:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B30-2337652.zul,B,E,Window,Button")
class B30_2337652Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = """
      <window>
        It is correct if you see nothing but this line.
        <zscript>
          Window root = new Window();
	Grid grid = new Grid();
	grid.setId( "grid1" );
	root.appendChild( grid );
	root.removeChild( grid );

	grid = new Grid();
	grid.setId( "grid1" );
	root.appendChild( grid );
        </zscript>
      </window>
    """
runZTL(zscript, () => {
      // Verify that the grid doesn't exists
      verifyFalse("The grid should doesn't exists", jq("$grid1").exists());
      
	  //Verify no error
      verifyFalse(jq(".z-msgbox-error").exists());
      verifyFalse(jq(".z-error").exists());
      
    })
  }
}