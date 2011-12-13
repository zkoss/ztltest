/* B50_ZK_398Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 14:31:09 TST 2011, Created by jumperchen

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
@Tags(tags = "B50-ZK-398.zul,B,E,Listbox,Grid,Tree,VisionTest,IE8")
class B50_ZK_398Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = {
			<zk>
				<div>Auxheader and header (first and second rows) in each Grid/Listbox/Tree should align.</div>
				<div>The each cell should be enclosed by border (IE8 only).</div>
				<grid hflex="min">
					<auxhead>
						<auxheader>
							<button label="button"/>
						</auxheader>
						<auxheader>
							<textbox/>
						</auxheader>
					</auxhead>
					<columns>
						<column>
							<button label="button"/>
						</column>
						<column>
							<textbox/>
						</column>
					</columns>
				</grid>
				<listbox hflex="min">
					<auxhead>
						<auxheader>
							<button label="button"/>
						</auxheader>
						<auxheader>
							<textbox/>
						</auxheader>
					</auxhead>
					<listhead>
						<listheader>
							<button label="button"/>
						</listheader>
						<listheader>
							<textbox/>
						</listheader>
					</listhead>
				</listbox>
				<tree hflex="min">
					<auxhead>
						<auxheader>
							<button label="button"/>
						</auxheader>
						<auxheader>
							<textbox/>
						</auxheader>
					</auxhead>
					<treecols>
						<treecol>
							<button label="button"/>
						</treecol>
						<treecol>
							<textbox/>
						</treecol>
					</treecols>
				</tree>
				<grid hflex="min">
					<auxhead>
						<auxheader label="A"/>
						<auxheader label="A"/>
					</auxhead>
					<columns>
						<column label="A"/>
						<column label="A"/>
					</columns>
				</grid>
				<listbox hflex="min">
					<auxhead>
						<auxheader label="A"/>
						<auxheader label="A"/>
					</auxhead>
					<listhead>
						<listheader label="A"/>
						<listheader label="A"/>
					</listhead>
				</listbox>
				<tree hflex="min">
					<auxhead>
						<auxheader label="A"/>
						<auxheader label="A"/>
					</auxhead>
					<treecols>
						<treecol label="A"/>
						<treecol label="A"/>
					</treecols>
				</tree>
			</zk>

		}
		runZTL(zscript, () => {
			verifyImage()
		})
	}
}
