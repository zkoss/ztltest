/* B30_2199361Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 11, 2012 11:00:00 PM , Created by Fernando Selvatici
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Widget
import org.zkoss.ztl.Element
import org.zkoss.ztl.ZK
import org.zkoss.ztl.util.Scripts

/**
 * @author Fernando Selvatici
 *
 */
@Tags(tags = "B30-2199361.zul,B,E,Window,Button")
class B30_2199361Test extends ZTL4ScalaTestCase {
  def testClick() = {
    val zscript = {
      """
<?xml version="1.0" encoding="UTF-8"?>
<?init class="org.zkoss.zktest.test2.B2199361"?>
<zk>
<separator/>
You shall see "Hello, Initiator" above this.
</zk>
      """
    }
    runZTL(zscript, () => {
      // Verify the existence of the "Hello, Initiator" label. Should be a count of 2 because of the explanation label
      verifyTrue("The label \"Hello, Initiator\" should be visible above the separator", jq(".z-label:contains(Hello, Initiator)").length() == 2);
    })
  }
}