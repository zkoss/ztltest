/* B50_2943174Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2943174Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk xmlns:w="client">
                	<html>
                		<![CDATA[
                <ol>
                <li>Check if the right edge of the textbox in 1st row is aligned to right edge of the listbox in 2nd row.</li>
                <li>If aligned correctly, it is OK; otherwise, it is a bug.
                </ol>
                ]]>
                	</html>
                	<grid>
                		<rows>
                			<row>
                				<textbox id="tb" hflex="1"/>
                			</row>
                			<row>
                				<listbox id="lb" hflex="1" mold="select">
                					<listitem label="Gerge"/>
                					<listitem label="Mary"/>
                					<listitem label="Tom"/>
                					<listitem label="Henri"/>
                				</listbox>
                			</row>
                		</rows>
                	</grid>
                	<button label="show size" w:onClick="var $tb = jq('$tb');var $lb = jq('$lb'); zk.log($tb.offset().left + $tb.outerWidth() == $lb.offset().left + $lb.outerWidth());" />
                </zk>
			"""
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyContains(getZKLog(), "true")
    })
  }
}



