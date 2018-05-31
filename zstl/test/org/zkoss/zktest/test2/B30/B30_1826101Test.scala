/* B30_1826101Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1826101Test extends ZTL4ScalaTestCase {
  @Test
  def testPaging() = {
    var zscript =
      """
				<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<window>
				
				<n:ol>
				<n:li>Listbox with mold = paging:</n:li>
				<n:li>It should have scrollbar when columns do not fit in the container;</n:li>
				<n:li>It shouldn't allow to set the size of columns smaller than contents in IE6.0. </n:li>
				</n:ol>
				
				</window>
				<window title="listbox demo" border="normal" width="80px">
				
					<listbox width="95%" mold="paging">
						<listhead sizable="true">
							<listheader width="200px" label="name" sort="auto" />
							<listheader width="200px" label="gender" sort="auto" />
						</listhead>
						<listitem>
							<listcell label="Mary" />
							<listcell label="FEMALE" />
						</listitem>
						<listitem>
							<listcell label="John" />
							<listcell label="MALE" />
						</listitem>
						<listitem>
							<listcell label="Jane" />
							<listcell label="FEMALE" />
						</listitem>
						<listitem>
							<listcell label="Henry" />
							<listcell label="MALE" />
						</listitem>
					</listbox>
				</window>
				</zk>
			 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      var listboxWidth = jq(".z-listbox").width()
      var listitemWidth = jq(".z-listitem:eq(0)").width()
      //System.out.println(listboxWidth)
      //System.out.println(listitemWidth)
      verifyTrue(listitemWidth > listboxWidth)
    })
  }
}



