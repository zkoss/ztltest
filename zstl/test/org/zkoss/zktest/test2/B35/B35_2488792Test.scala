/* B35_2488792Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B35_2488792Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<button onClick="dg.open = !dg.open" label="Click Me, if no error, that is correct!"/>
	<grid>
		<columns sizable="true">
			<column label="Brand" />
			<column label="Processor Type" width="150px"/>
			<column label="Memory (RAM)" width="120px"/>
			<column label="Price"  width="100px"/>
			<column label="Hard Drive Capacity" width="150px"/>
		</columns>
		<rows>
			<group label="Dell" id="dg"/>
			<row>
				<label style="padding-left:15px" value="Dell E4500 2.2GHz"/>
				<label value="Intel Core 2 Duo"/>
				<label value="2GB RAM"/>
				<label value="$261.00" style="color:green"/>
				<label value="500GB"/>
			</row>
			<row>
				<label style="padding-left:15px" value="XP-Pro Slim Dell-Inspiron-530-s"/>
				<label value="Intel Core 2 Duo"/>
				<label value="2GB RAM"/>
				<label value="$498.93" style="color:green"/>
				<label value="500GB"/>				
			</row>
			<row>
				<label style="padding-left:15px" value="Dell P4 3.2 GHz"/>
				<label value="Intel Pentium 4"/>
				<label value="4GB RAM"/>
				<label value="$377.99" style="color:green"/>
				<label value="500GB"/>				
			</row>
		</rows>
	</grid>
</zk>
			

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val dg = ztl$engine.$f("dg")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyFalse(jq(".z-error").exists())
    })
  }
}



