/* B35_2090137Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 12:08:08 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 * 
 * @author jumperchen
 */
@Tags(tags = "B35-2090137.zul,B,E,Window,Grid,IE,VisionTest")
class B35_2090137Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = """"""
		<zk>
<style>
.ie6 .z-window-content {
	width: 478px;
	overflow:hidden;
}
</style>
<window width="500px" title="abc" border="normal" contentStyle="position:relative;">
The width of grid should not exceed the width of window, if any, that is wrong.

<grid width="550px">
<columns>
<column label="Name" />
<column label="Description" />
</columns>
<rows>
<row>
<label value="Ivan" />
<label value="MIS" />
</row>
<row>
<label value="ohpizz" />
<label value="Testing" />
</row>
</rows>
</grid>

</window>
</zk>
		"""
runZTL(zscript, () => {
		verifyImage()
		})
	}
}
