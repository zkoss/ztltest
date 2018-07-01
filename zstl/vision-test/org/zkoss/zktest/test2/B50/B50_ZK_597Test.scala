/* B50_ZK_597Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 14:50:56 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags;

/**
 *
 * @author jumperchen
 */
@Tags(tags = "B50-ZK-597.zul,A,E,Hlayout,Vlayout,Tabbox,Tree,VisionTest")
class B50_ZK_597Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = """
			<tabbox width="100%" tabscroll="false">
				<tabs>
					<tab label="Tab1"/>
					<tab id="srcView" label="Tab2"/>
				</tabs>
				<tabpanels>
					<tabpanel>
						Please click "Tab2" to test it
					</tabpanel>
					<tabpanel>
						<window id="view" fulfill="srcView.onSelect">
							<hlayout id="hl" width="100%" height="500px">
								<vlayout hflex="1" vflex="1" id="vl">
									Please click the dottree radiobox, then the tree should display well.
									<separator/>
									Note: it cannot be empty size on Safari or Chrome, and not aligned to center on IE or Firefox
									<radiogroup onCheck='tree.setZclass("z-"+self.selectedItem.value)'>
										<vlayout>
											<radio label="Default" value="tree" selected="true"/>
											<radio id="rd" label="Dot Tree" value="dottree"/>
											<radio label="XP Explorer" value="filetree"/>
											<radio label="Vista Explorer" value="vfiletree"/>
										</vlayout>
									</radiogroup>
								</vlayout>
								<tree id="tree" hflex="2" vflex="1">
									<treecols sizable="true">
										<treecol label="Name"/>
										<treecol label="Description"/>
									</treecols>
									<treechildren>
										<treeitem>
											<treerow>
												<treecell label="Item 1"/>
												<treecell label="Item 1 description"/>
											</treerow>
										</treeitem>
										<treeitem>
											<treerow>
												<treecell label="Item 2"/>
												<treecell label="Item 2 description"/>
											</treerow>
											<treechildren>
												<treeitem>
													<treerow>
														<treecell label="Item 2.1"/>
													</treerow>
													<treechildren>
														<treeitem>
															<treerow>
																<treecell label="Item 2.1.1"/>
															</treerow>
														</treeitem>
														<treeitem>
															<treerow>
																<treecell label="Item 2.1.2"/>
															</treerow>
														</treeitem>
													</treechildren>
												</treeitem>
												<treeitem>
													<treerow>
														<treecell label="Item 2.2"/>
													</treerow>
													<treechildren>
														<treeitem>
															<treerow>
																<treecell label="Item 2.2.1"/>
															</treerow>
														</treeitem>
													</treechildren>
												</treeitem>
											</treechildren>
										</treeitem>
										<treeitem label="Item 3"/>
									</treechildren>
								</tree>
							</hlayout>
						</window>
					</tabpanel>
				</tabpanels>
			</tabbox>
		"""
runZTL(zscript, () => {
			click(jq("$srcView"))
			waitResponse()
			click(engine.$f("rd").$n("real"))
			waitResponse()
			verifyImage()
		})
	}
}
