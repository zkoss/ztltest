package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1793.zul")
class B65_ZK_1793Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<label>Grid with hidden header should not flicker back and forth when you scroll horizontally.</label>
	<grid width="300px">
		<columns sizable="true" visible="false">
			<column label="Type" sort="auto" width="300px" />
			<column label="Content" width="300px"/>
		</columns>
		<rows>
			<row>
				<label value="File:"/>
				<textbox width="98%"/>
			</row>
			<row>
				<label value="Type:"/>
				<hlayout>
					<listbox rows="1" mold="select">
						<listitem label="Java Files,(*.java)"/>
						<listitem label="All Files,(*.*)"/>
					</listbox>
					<button label="Browse..."/>
				</hlayout>
			</row>
			<row>
				<label value="Options:"/>
				<textbox rows="3" width="98%"/>
			</row>
		</rows>
	</grid>

</zk>
"""  
  runZTL(zscript,
    () => {
      horScroll(jq(".z-grid"), 1)
      verifyImage()
    })
    
  }
}