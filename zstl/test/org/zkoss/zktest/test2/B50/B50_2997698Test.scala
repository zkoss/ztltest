/* B50_2997698Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2997698Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<window title="Decimalbox Test" border="normal" width="500px">
<html>
<![CDATA[
<ol>
<li>If you see the numbers before the textbox are the same of in the textbox, then it is OK.</li>
<li>Otherwise, it is a bug</li>
</ol>
]]>
</html>
<hbox>% 1,235<decimalbox format="'%' #,##0" value="1234.56"/></hbox>
<hbox>% 1,235<decimalbox format="% #,##0" value="12.3456"/></hbox>
<hbox># 1,234.6<decimalbox format="'#' #,##0.0" value="1234.56"/></hbox>
</window>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      //strange, the result is different between FF and selenium started FF
      verifyEquals("% 1,235", jq("@window @decimalbox:eq(0)").`val`())
      verifyEquals("% 1,235", jq("@window @decimalbox:eq(1)").`val`())
      verifyEquals("# 1,234.6", jq("@window @decimalbox:eq(2)").`val`())
    })
  }
}



