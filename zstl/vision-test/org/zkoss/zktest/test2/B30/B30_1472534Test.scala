/* B30_1472534Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 11:50:43 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 *
 * @author jumperchen
 */
@Tags(tags = "B30-1472534.zul,C,E,Listbox,IE,VisionTest")
class B30_1472534Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = {
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>
					Click the "messageBox" button, and then the Error box should be
		moved over the listbox.(IE6only)
				</n:p>
				<vbox>
					<listbox mold="select" rows="1" id="list1" width="200px"/>
					<listbox mold="select" rows="1" id="list2" width="200px"/>
					<listbox mold="select" rows="1" id="list3" width="200px"/>
					<button label="messageBox" onClick="throw new
WrongValueException(list2, &quot;!!!!!!!!!!&quot;);"/>
				</vbox>
			</zk>
		}
		runZTL(zscript, () => {
			verifyImage()
			click(jq("@button"))
			waitResponse
			verifyImage()
		})
	}
}
