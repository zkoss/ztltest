/* B35_2182972Test.scala

	Purpose:
		
	Description:
		
	History:
		Tue Dec 13 12:36:22 TST 2011, Created by jumperchen

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
@Tags(tags = "B35-2182972.zul,A,M,Window,VisionTest")
class B35_2182972Test extends ZTL4ScalaTestCase {
	def testCase() = {
		val zscript = """
			<zk>
				Please test each mode ("Overlap, Popup, Embed, and Modal") with title and border, or not.
	It should be looked well.
				<window id="win" border="normal" width="350px" title="abc">
					<button id="b1" label="Overlap" onClick="win.doOverlapped();"/>
					<button id="b2" label="Popup" onClick="win.doPopup();"/>
					<button id="b3" label="Embed" onClick="win.doEmbedded();"/>
					<button id="b4" label="Modal" onClick="win.doModal();"/>
					<button id="bt" label="Title on/off">
						<attribute name="onClick"><![CDATA[
							if ("".equals(win.getTitle())){
								win.setTitle("Title");
							}
							else 
		win.setTitle("");
						]]></attribute>
					</button>
					<button id="bb" label="Border on/off">
						<attribute name="onClick"><![CDATA[
							if ("normal".equals(win.getBorder())){
								win.setBorder("none");
							}
							else 
		win.setBorder("normal");
						]]></attribute>
					</button>
				</window>
			</zk>
		"""
runZTL(zscript, () => {
			List("$b1", "$b2", "$b3", "$b4").foreach(id => {
				click(jq(id))
				waitResponse()
				verifyImage()
				val btns = List("$bt", "$bb")
				btns.foreach(b => {
					click(jq(b))
					waitResponse()
					verifyImage()
				})
				// reset
				btns.foreach(b => click(jq(b)))
			})
		})
	}
}
