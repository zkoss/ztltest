/* B35_2083025Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 11:58:01 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags;
import org.junit.Test

/**
 * 
 * @author jumperchen
 */
@Tags(tags = "B35-2083025.zul,A,E,Tablelayout,VisionTest")
class B35_2083025Test extends ZTL4ScalaTestCase {
  @Test
	def testCase() = {
		val zscript = """"""
			<?component name="panel" extends="panel" width="200px" height="200px" ?>
<zk>
<label value="if the layout displayed properly, it is correct"/>
<tablelayout id="tbl" columns="4" width="100%" height="100%">
		<tablechildren id="tc1" rowspan="3">
			<panel title="table1" border="normal"
			 	maximizable="true" collapsible="true" >
			 	<panelchildren>Panel</panelchildren>	
			 </panel>
		</tablechildren>
		<tablechildren  colspan="3">
			<panel title="table2" border="normal"
			 	maximizable="true" maximized="true" collapsible="true">
			 	<panelchildren>Panel</panelchildren>
			 </panel>
		</tablechildren>
		<tablechildren >
			<panel title="table3" border="normal"
			 	maximizable="true" collapsible="true">
			 	<panelchildren>Panel</panelchildren>	
			 </panel>
		</tablechildren>
		<tablechildren>
			<panel title="table4" border="normal"
			 	maximizable="true" collapsible="true">
			 	<panelchildren>Panel</panelchildren>	
			 </panel>
		</tablechildren>
		<tablechildren>
			<panel title="table5" border="normal"
			 	maximizable="true" collapsible="true">
			 	<panelchildren>Panel</panelchildren>	
			 </panel>
		</tablechildren>
		<tablechildren>
			<panel title="table6" border="normal"
			 	maximizable="true" collapsible="true">
			 	<panelchildren>Panel</panelchildren>	
			 </panel>
		</tablechildren>
		<tablechildren>
			<panel title="table7" border="normal"
			 	maximizable="true" collapsible="true">
			 	<panelchildren>Panel</panelchildren>	
			 </panel>
		</tablechildren>
		<tablechildren>
			<panel title="table8" border="normal"
			 	maximizable="true" collapsible="true">
			 	<panelchildren>Panel</panelchildren>	
			 </panel>
		</tablechildren>
</tablelayout>
</zk>
		"""
runZTL(zscript, () => {
			verifyImage()
		})
	}
}
