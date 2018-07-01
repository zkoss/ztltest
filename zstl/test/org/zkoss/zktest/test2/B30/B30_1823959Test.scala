/* B30_1823959Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 7, 2012 12:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author Fernando Selvatici
  *
  */
@Tags(tags = "B30-1823959.zul,B,E,Window,Button")
class B30_1823959Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript =
      """
      <zk xmlns:h="http://www.w3.org/1999/xhtml">
        <h:h3> [ 1823959 ] Grid failed to re-sync model (Opera/IE/IE7)</h:h3>
        <h:pre>
          In IE/IE7/Opera, JavaScript error when re-sync model multiple times.
(If you cannot see any JavaScript error, the bug is fixed)
        </h:pre>
        <zscript>
          ListModel strset = new org.zkoss.zktest.test2.grid.FakeListModel(1);
        </zscript>
        <vbox>
          <button label="Resync Model" onClick="strset.invalidate()"/>
          <grid model="${strset}">
            <columns sizable="true">
              <column label="Type"/>
            </columns>
          </grid>
        </vbox>
      </zk>
    """
    runZTL(zscript, () => {
      // Click the button
      click(jq("@button"));

      // Verify there is no javascript error
      verifyFalse(jq(".z-error").exists());
    })
  }
}