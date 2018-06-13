/* B35_2090152Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 12:11:42 TST 2011, Created by jumperchen

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;
import scala.collection.JavaConverters._
import scala.collection.JavaConversions._

/**
 *
 * @author jumperchen
 */
@Tags(tags = "B35-2090152.zul,B,E,Button,IE,VisionTest")
class B35_2090152Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = """
			<window width="300px">
				press button in grid, the image where is placed inside the button should appear in the left side of the
button text label, that is correct. (IE6~7 only).
				<grid sizedByContent="true">
					<columns sizable="true" width="500px">
						<column label="Type"/>
						<column label="Content"/>
					</columns>
					<rows>
						<row>
							<label value="File:"/>
							<button label="ClickMe" onClick='self.setLabel("Clicked OK.")' image="/test2/img/coffee.gif"/>
						</row>
						<row>
							<label value="Type:"/>
							<hbox>
								<listbox width="150px">
									<listitem>
										<listcell>
											Should See a button here.
											<button label="ClickMe" onClick='self.setLabel("Clicked OK."); self.setImage("/test2/img/coffee.gif")'/>
										</listcell>
									</listitem>
									<listitem label="And A button here">
										<listcell>
											<button label="ClickMe" onClick='self.setLabel("ClickedOK."); self.setImage("/test2/img/coffee.gif")'/>
										</listcell>
									</listitem>
								</listbox>
								<button label="ClickMe" onClick='self.setLabel("Clicked OK.");self.setImage("/test2/img/coffee.gif")'/>
							</hbox>
						</row>
						<row>
							<label value="Options:"/>
							<textbox rows="3" width="99%"/>
						</row>
					</rows>
				</grid>
			</window>
		"""
runZTL(zscript, () => {
			jq("@button").foreach(b => click(b));
			waitResponse()
			verifyImage()
		})
	}
}
