/* B50_ZK_518Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 14:37:16 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 *
 * @author jumperchen
 */
@Tags(tags = "B50-ZK-518.zul,A,E,Combobox,Select,VisionTest")
class B50_ZK_518Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = """
			<zk>
				<html><![CDATA[
<ol>
<li>Select one item from combobox</li>
<li>The view port of input box should keep at begining</li>
</ol>
]]></html>
				<combobox id="box" width="100px" mold="rounded">
					<comboitem id="scf" label="Server+client Fusion"/>
					<comboitem id="pd" label="Pattern Driven"/>
					<comboitem id="ei" label="Enterprise Integration"/>
				</combobox>
			</zk>
		"""
runZTL(zscript, () => {
			click(engine.$f("box").$n("btn"))
			waitResponse
			click(engine.$f("ei"))
			verifyImage()
		})
	}
}
