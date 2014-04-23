package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2032.zul")
class B70_ZK_2032Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window border="normal" width="300px" title="Caption and Errorbox">
	<label multiline="true">
	  1. Click on the textbox.
	  2. Blur the textbox without typing anything.
	  3. It will show an errorbox and a popup groupbox.
	  4. The groupbox's caption should appear in the right position (in the line).
	</label>
	<textbox id="tb" hflex="1" constraint="no empty" onBlur='pp.open(tb, "after_end");'/>
	<popup id="pp">
		<groupbox >
			<caption>
				<label>
				Caption Caption Caption Caption Caption Caption 
				</label>
			</caption>
			<label>Content Content Content Content Content</label>
		</groupbox>
	</popup>
</window>"""  
  runZTL(zscript,
    () => {
      verifyImage()
      val tb = jq(".z-textbox")
      focus(tb)
      click(tb)
      waitResponse()
      blur(tb)
      click(jq(".z-window").toWidget().$n("cap"))
      waitResponse()
      verifyTrue("It will show an errorbox and a popup groupbox.", jq(".z-errorbox").exists && jq(".z-popup .z-groupbox").exists())
      verifyImage()
    })
    
  }
}