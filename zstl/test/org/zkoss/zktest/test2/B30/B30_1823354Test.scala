/* B30_1823354Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1823354Test extends ZTL4ScalaTestCase {
  @Test
  def testContentStyle() = {
    var zscript =
      """
				<zk xmlns:h="http://www.w3.org/1999/xhtml">
					<h:h3> [ 1823354 ] Listbox's content is fixed while vflex = true</h:h3>
					<h:pre>
				While user change outer window's height, listbox wont span it's content.
					</h:pre>
					<window id="win" title="test VFlex!!" sizable="true"
						width="300px" height="300px" border="normal">
						<zscript><![CDATA[
							import java.util.ArrayList;
							ArrayList list = new ArrayList();
							
							for(int i=1;i<=50;i++)
							{
								list.add("entry "+i);
							}
						]]></zscript>
						<listbox id="libox" width="250px" vflex="true">
							<listhead sizable="true">
								<listheader label="name" sort="auto"/>
							</listhead>
							<listitem forEach="${list}" label="${each}"/>
						</listbox>
					</window>
				</zk>
			 """
    val ztl$engine = engine()
    val win = ztl$engine.$f("win")
    val libox = ztl$engine.$f("libox")
    runZTL(zscript, () => {
      var originalListCellHeight = jq(".z-listcell:eq(0)").height()
      //System.out.println("Original height: " + originalListCellHeight)
      var winHeight = jq(win).height()
      dragdropTo(jq(win), "30," + (winHeight - 2), "30," + (winHeight * 1.4))
      //System.out.println("Current height: " + jq(".z-listcell:eq(0)").height())
      verifyTolerant(originalListCellHeight, jq(".z-listcell:eq(0)").height(), 1)
    })
  }
}



