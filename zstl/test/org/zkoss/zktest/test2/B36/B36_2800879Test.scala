/* B36_2800879Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2800879Test extends ZTL4ScalaTestCase {
  @Test
  def testSerialization() = {
    var zscript =
      """
			<window title="Test of Grid's Serialization">
					Please press on the "Clone" and the "Clone by Serialization" button, and then they should not appear any error.
				<vbox id="vb" width="100%">
					<grid id="grid">
						<columns sizable="true" menupopup="auto">
							<column label="Type" sort="auto"/>
							<column label="Content"/>
						</columns>
						<rows>
							<row>
								<label value="File:"/>
								<textbox width="98%"/>
							</row>
							<row>
								<label value="Type:"/>
								<hbox>
									<listbox rows="1" mold="select">
										<listitem label="Java Files,(*.java)"/>
										<listitem label="All Files,(*.*)"/>
									</listbox>
									<button label="Browse..."/>
								</hbox>
							</row>
							<row>
								<label value="Options:"/>
								<textbox rows="3" width="98%"/>
							</row>
						</rows>
					</grid>
					<zscript>
					int cnt = 0;
					</zscript>
					<button label="Clone">
						<attribute name="onClick">{
					Object l = grid.clone();
					l.setId("dst1");
					vb.insertBefore(l, self);
						}</attribute>
					</button>
					<button label="Clone by Serialization">
						<attribute name="onClick">{
					import java.io.*;
					ByteArrayOutputStream boa = new ByteArrayOutputStream();
					new ObjectOutputStream(boa).writeObject(grid);
					byte[] bs = boa.toByteArray();
					Object l = new ObjectInputStream(new ByteArrayInputStream(bs)).readObject();
					l.setId("dst2");
					vb.insertBefore(l, self);
					vb.insertBefore(new Label(bs.length+" bytes copied"), self);
						}</attribute>
					</button>
				</vbox>
				</window>
		"""
    val ztl$engine = engine()
    val vb = ztl$engine.$f("vb")
    val grid = ztl$engine.$f("grid")
    val dst1 = ztl$engine.$f("dst1")
    val dst2 = ztl$engine.$f("dst2")
    runZTL(zscript, () => {
      click(jq("@button[label=\"Clone\"]"))
      waitResponse()
      verifyFalse(jq("div.z-window-modal").exists())
      click(jq("@button[label=\"Clone by Serialization\"]"))
      waitResponse()
      verifyFalse(jq("div.z-window-modal").exists())
    })
  }
}



