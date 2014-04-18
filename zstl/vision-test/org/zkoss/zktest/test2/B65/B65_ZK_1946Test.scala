package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1946.zul")
class B65_ZK_1946Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window border="normal" width="300px">
	click "2", it should be selectable.
	<listbox>
		<listitem draggable="true" droppable="true">
			<listcell>
				<listbox multiple="true" mold="select">
					<listitem label="1" />
					<listitem label="2"/>
					<listitem label="3"/>
				</listbox>
			</listcell>
		</listitem>
	</listbox>
</window>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-option:contains(2)"))
      waitResponse()
      verifyImage()
    })
    
  }
}