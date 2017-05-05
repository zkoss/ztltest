/* B50_ZK_508Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 14:34:56 TST 2011, Created by jumperchen

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
@Tags(tags = "B50-ZK-508.zul,B,E,Tree,Alignmenet,Theme,VisionTest")
class B50_ZK_508Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = """
			<zk>
				You should see the two cells "_____" are aligned the same height.
				<tree>
					<treecols sizable="true">
						<treecol label="A" width="80px"/>
						<treecol label="B"/>
					</treecols>
					<treechildren>
						<treeitem>
							<treerow>
								<treecell label="_____"/>
								<treecell label="_____"/>
							</treerow>
						</treeitem>
					</treechildren>
				</tree>
			</zk>
		"""
runZTL(zscript, () => {
			verifyImage()
		})
	}
}
