package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2041.zul")
class B70_ZK_2041Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window id="win">
	<div height="300px">
		<vlayout vflex="1" spacing="5px">
			<hlayout vflex="1" spacing="5px" valign="top">
				<div vflex="1" hflex="1">
					<vlayout vflex="1" spacing="5px">
						<label value="Grid 1: " />
						<grid vflex="1" oddRowSclass="z-grid-odd" />
					</vlayout>
				</div>
				<div vflex="1" hflex="1">
					<vlayout vflex="1" spacing="5px">
						<label value="Grid 2: " />
						<grid vflex="1" />
					</vlayout>
				</div>
			</hlayout>
			<hlayout vflex="1" spacing="5px" valign="top">
				<div vflex="1" hflex="1">
					<vlayout vflex="1" spacing="5px">
						<label value="Grid 3: " />
						<grid vflex="1" />
					</vlayout>
				</div>
				<div vflex="1" hflex="1">
					<vlayout vflex="1" spacing="5px">
						<label value="Grid 4: " />
						<grid vflex="1" />
					</vlayout>
				</div>
			</hlayout>
		</vlayout>
	</div>
	<button label="Test" onClick="win.doModal()" />
</window>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}