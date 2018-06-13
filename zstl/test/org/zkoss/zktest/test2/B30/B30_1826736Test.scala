/* B30_1826736Test.java

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
import org.zkoss.ztl.unit.Widget


class B30_1826736Test extends ZTL4ScalaTestCase {
  @Test
  def testSorting() = {
    var zscript =
      """
			<window id="win">
			The bug is that the first column of data disappear when i press the
			header to sort by a column.
			    <zscript><![CDATA[
					import java.util.*;
			                      
					List names = new ArrayList(3);
					names.add("Tom");
					names.add("John");
					names.add("Mary");
				]]></zscript>
			
				<listbox width="500px" id="boxListado" height="200px" model="@{names}">
					<listhead>
						<listheader label="name" sort="auto"/>
					</listhead>
					<listitem self="@{each=obj}">
						<listcell><label value="@{obj}"/></listcell>
					</listitem>
				</listbox>
				
			<zscript>
					import org.zkoss.zkplus.databind.*;
					
					AnnotateDataBinder binder = new AnnotateDataBinder(win);
					binder.loadAll();
			</zscript>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    val boxListado = ztl$engine.$f("boxListado")
    runZTL(zscript, () => {
      click(jq(".z-listheader"))
      waitResponse()
      click(jq(".z-listheader"))
    })
  }
}



