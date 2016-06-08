/* B80_ZK_2890Test.scala

	Purpose:

	Description:

	History:
		Tue, Jun  7, 2016 11:30:17 AM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
 * 
 * @author Sefi
 */
@Tags(tags = "")
class B80_ZK_2890Test extends ZTL4ScalaTestCase {
	@Test
	def test() = {
		val zscript =
			"""<zk>
					<label multiline="true">
					There are 2 errors on drag ghost from Tree / Treeitem component.
					On multiple selection, only the dragged item text is showed, and when the Tree has Treecols, the drag message generated is one concatenation of all Treecells.

					When drag on the Tree component, the ghost element should display like the List component behavior.
					</label>
					 <window border="normal" title="hello">
							<vlayout width="100%">
								 <tree id="tree" width="400px" multiple="true" checkmark="true">
										<treecols sizable="true">
											 <treecol label="Name" />
											 <treecol label="Description" />
										</treecols>
										<treechildren>
											 <treeitem draggable="true" selected="true">
													<treerow>
														 <treecell label="1" />
														 <treecell label="1 description" />
													</treerow>
											 </treeitem>
											 <treeitem draggable="true" selected="true">
													<treerow>
														 <treecell label="2" />
														 <treecell label="2 description" />
													</treerow>
													<treechildren>
														 <treeitem draggable="true" selected="true">
																<treerow>
																	 <treecell label="2.1" />
																	 <treecell label="2.1 description" />
																</treerow>
														 </treeitem>
												 </treechildren>
											 </treeitem>
										</treechildren>
								 </tree>
								 <listbox width="150px" multiple="true" checkmark="true">
										<listhead>
											 <listheader label="header 1" />
											 <listheader label="header 2" />
										</listhead>
										<listitem draggable="true">
											 <listcell label="1" />
											 <listcell label="item 1" />
										</listitem>
										<listitem draggable="true">
											 <listcell label="2" />
											 <listcell label="item 2" />
										</listitem>
										<listitem draggable="true">
											 <listcell label="3" />
											 <listcell label="item 3" />
										</listitem>
								 </listbox>
							</vlayout>
					 </window>
				</zk>"""
		runZTL(zscript, () => {
			val treerow = jq(".z-treerow").eq(0)
			mouseDownAt(treerow, "10,10")
			waitResponse()
			mouseMoveAt(treerow, "100,10")
			waitResponse()

			val ghost = jq("#zk_ddghost")
			verifyTrue(ghost.exists())
			val content = ghost.find(".z-drop-content")
			verifyEquals(content.length(), 3)
			verifyTrue(content.eq(0).text().endsWith("1"))
			verifyTrue(content.eq(1).text().endsWith("2"))
			verifyTrue(content.eq(2).text().endsWith("2.1"))
		})
	}
}
