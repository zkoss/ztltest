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

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 1899003
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B30-1899003.zul,C,E,Style,Vbox,Label,IE")
class B30_1899003Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
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
        val sep = jq(jq(".z-vbox").toWidget().$n("real")).find("tr:eq(1)");
        verifyEquals(sep.prev().text(), "abc");
        verifyEquals(sep.next().text(), "xyz");
        verifyTrue(sep.hasClass("z-vbox-separator"));
        verifyEqualColor("blue", jq(sep).find("td").css("border-bottom-color"))
      }
    )
  }
}
