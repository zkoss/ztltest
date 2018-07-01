/* B35_2526699Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 12:46:50 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags;

/**
 * 
 * @author jumperchen
 */
@Tags(tags = "B35-2526699.zul,A,E,Tabpanel,IE,BI,VisionTest")
class B35_2526699Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = """"""
		<hbox id="mainBox" widths="20%,1024px,20%" height="768px"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns="http://www.zkoss.org/2005/zul"
	xsi:schemaLocation="http://www.zkoss.org/2005/zul
http://www.zkoss.org/2005/zul/zul.xsd">

	<box />

	<box>
	Click the accordion tab and resize the window, the accordion tab should shouldn't float to left. 
		<window id="mainWindow" border="normal" width="1200px"
			height="768px" apply="${mainWindowController}">
			<!-- The height for the include is important or IE will interpret the
				height as 100% of the screen -->
			<hbox pack="center" align="center"
				widths="100px,924px,100px">
				<label />
				<label />
			</hbox>

			<tabbox id="bidSessionSelectorTabBox" width="1016px"
				height="685px">
				<tabs>
					<tab id="Tab2" label="Tab2" />
				</tabs>
				<tabpanels>
					<tabpanel>
						<box>
							<hbox>
								<window title="My Window"
									border="normal" width="324px" height="437px">
									<tabbox mold="accordion">
										<tabs>
											<tab label="Test1"></tab>
											<tab id="test2" label="Test2"></tab>
											<tab label="Test3"></tab>
										</tabs>
										<tabpanels>
											<tabpanel>
												<grid height="50px">
													<rows>
														<row>
															<label
																value="TEST" />
														</row>
														<row>
															<label
																value="TEST2" />
														</row>
													</rows>
												</grid>
											</tabpanel>
											<tabpanel>
												<grid height="190px">
													<rows>
														<row>
															<label
																value="TEST" />
														</row>
														<row>
															<label
																value="TEST2" />
														</row>
													</rows>
												</grid>
											</tabpanel>
											<tabpanel>
												<grid height="190px">
													<rows>
														<row>
															<label
																value="TEST" />
														</row>
														<row>
															<label
																value="TEST2" />
														</row>
													</rows>
												</grid>
											</tabpanel>
										</tabpanels>
									</tabbox>

								</window>
							</hbox>
						</box>
					</tabpanel>
				</tabpanels>
			</tabbox>
		</window>
	</box>
	<box />
</hbox>
		"""
runZTL(zscript, () => {
			verifyImage()
			click(jq("$test2"))
			waitResponse(true)
			windowResizeTo(500, 800)
			waitResponse()
			verifyImage()
		})
	}
}
