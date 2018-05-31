/* B30_2522437Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 17, 2011 12:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B30-2522437.zul,B,E,Window,Button")
class B30_2522437Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript =
      """
      <borderlayout>
        <center>
          <div>
            <button label='Click Me' onClick='self.desktop.invalidate()'/>
            and you shall see this page remains the same
          </div>
        </center>
      </borderlayout>
    """
    runZTL(zscript, () => {
      // Record the html of the page
      val contentBefore = getBodyText();

      // Click on the button
      click(jq("@button"));
      waitResponse();

      // Record again the html
      val contentAfter = getBodyText();

      // Verify that all is the same
      verifyTrue("The html content should not be changed", contentBefore.equals(contentAfter));

    })
  }
}