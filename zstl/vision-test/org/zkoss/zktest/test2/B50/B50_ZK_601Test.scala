/* B50_ZK_601Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 14:56:21 TST 2011, Created by jumperchen

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
@Tags(tags = "B50-ZK-601.zul,B,E,Grid,Frozen,IE8,VisionTest")
class B50_ZK_601Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = {
			<zk>
				Please scroll to the end of the scrollbar (right-most), and then scroll back to the begin of the scrollbar.
				<separator/>
				In IE8, all of the textbox shouldn't cut its right border.
				<grid height="350px" width="817px">
					<frozen style="background: #DFDED8" columns="3">
						<div style="padding: 0 10px;"/>
					</frozen>
					<columns>
						<column width="80px" label="1" align="right"/>
						<column width="80px" label="2" align="right"/>
						<column width="80px" label="3" align="right"/>
						<column width="80px" label="4" align="right"/>
						<column width="80px" label="5" align="right"/>
						<column width="80px" label="6" align="right"/>
						<column width="80px" label="7" align="right"/>
						<column width="80px" label="8" align="right"/>
						<column width="80px" label="9" align="right"/>
						<column width="80px" label="10" align="right"/>
					</columns>
					<rows>
						<row>
							<intbox value="12345" style="text-align:right;" width="50px"/>
							<intbox value="12345" style="text-align:right;" width="50px"/>
							<intbox value="12345" style="text-align:right;" width="50px"/>
							<intbox value="12345" style="text-align:right;" width="50px"/>
							<intbox value="12345" style="text-align:right;" width="50px"/>
							<intbox value="12345" style="text-align:right;" width="50px"/>
							<intbox value="12345" style="text-align:right;" width="50px"/>
							<intbox value="12345" style="text-align:right;" width="50px"/>
							<intbox value="12345" style="text-align:right;" width="50px"/>
							<intbox value="12345" style="text-align:right;" width="50px"/>
						</row>
					</rows>
				</grid>
			</zk>
		}
		runZTL(zscript, () => {
			val $jq = jq(".z-grid-body")
			$jq.scrollLeft($jq.scrollWidth())
			$jq.scrollLeft(0)
			verifyImage()
		})
	}
}
