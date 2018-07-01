package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1904.zul")
class B65_ZK_1904Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window width="500px" border="1" title="IE only">
	Click the calendar and select a date, then click the calendar again.
	The datebox should sync dropdown stackup well
	<grid width="500px">
		<columns>
			<column />
			<column />
		</columns>
		<rows>
			<row>
				<cell />
				<datebox id="dt"/>
			</row>
			<row>
				<cell colspan="2">
					<hlayout>
						<button label="ok" />
						<button label="cancel"/>
					</hlayout>
				</cell>
			</row>
		</rows>
	</grid>
</window>"""  
  runZTL(zscript,
    () => {
      val btn = jq(".z-datebox").toWidget().$n("btn")
      click(btn)
      waitResponse()
      click(jq("td:contains(16)"))
      waitResponse()
      click(btn)
      waitResponse()
      verifyImage()
    })
    
  }
}