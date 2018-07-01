/* B50_ZK_606Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 14:59:28 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags;
import org.junit.Test

/**
 *
 * @author jumperchen
 */
@Tags(tags = "B50-ZK-606.zul,A,E,Borderlayout,Hflex,Vflex,Native,VisionTest")
class B50_ZK_606Test extends ZTL4ScalaTestCase {
	
  @Test
  def testCase() = {
		val zscript = """
			<zk xmlns:n="native">
				<borderlayout>
					<center>Please click the south icon to open it, then you should see "south" label at the south area</center>
					<south open="false" flex="true" title="south" collapsible="true">
						<hbox>
							<n:div/>
						</hbox>
					</south>
				</borderlayout>
			</zk>
		"""
runZTL(zscript, () => {
			click(jq(".z-south").toWidget().$n("btned"))
			waitResponse(true)
			verifyImage()
		})
	}
}
