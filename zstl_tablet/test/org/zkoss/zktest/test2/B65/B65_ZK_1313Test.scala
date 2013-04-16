package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1313.zul,Android")
class B65_ZK_1313Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<window mode="modal" width="500px" height="1000px" xmlns:ca="client/attribute" title="Main" border="normal">
	<borderlayout>
		<north id="north">
			<groupbox id="groupbox">
				<caption>Basics</caption>
				<grid ca:data-scrollable="false">
					<columns>
						<column label="Left" />
						<column label="Right" />
					</columns>
					<rows>
						<row>
							<label value="Item 1.1" />
							<label value="Item 1.2" />
						</row>
						<row>
							<label value="Item 2.1" />
							<label value="Item 2.2" />
						</row>
						<row>
							<label value="Item 3.1" />
							<label value="Item 3.2" />
						</row>
						<row>
							<label value="Item 4.1" />
							<label value="Item 4.2" />
						</row>
						<row>
							<label value="Item 5.1" />
							<label value="Item 5.2" />
						</row>
						<row>
							<label value="Item 6.1" />
							<label value="Item 6.2" />
						</row>
						<row>
							<label value="Item 7.1" />
							<label value="Item 7.2" />
						</row>
					</rows>
				</grid>
			</groupbox>
		</north>
		<center>
			<div height="500px">
				iPad/Android Only
				1. Click "Open Wizard" button.<separator />
				2. Click on the combobox button and select any item.<separator />
				3. Blur the combobox should not see the modal window jump.
			</div>
		</center>
		<south>
			<div>
				<button id="wizBtn" label="Open Wizard" onClick='Executions.createComponents("/test2/B65-ZK-1313-1.zul", null, null);'></button>
				<div id="subWin"></div>
			</div>
		</south>
	</borderlayout>
</window>"""  
  runZTL(zscript,
    () => {
      swipeUp(jq(".z-window-modal"), 380)
      waitResponse()
      singleTap(jq(".z-button:contains(Open)"))
      waitResponse()
      sleep(500)
      singleTap(jq(".z-combobox-btn"))
      waitResponse()
      singleTap(jq(".z-comboitem:eq(0)"))
      waitResponse()
      blur(jq(".z-combobox-inp"))
      waitResponse()
      verifyTrue("should not see the modal window jump", jq(".z-window-modal").length() == 2)
    })
    
  }
}