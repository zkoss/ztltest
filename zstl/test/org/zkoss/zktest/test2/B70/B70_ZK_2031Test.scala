package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2031.zul")
class B70_ZK_2031Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window border="normal" title="Button's image" width="300px">
	<label multiline="true">
		1. click the checkbox.
		2. The button's image should show up.
	</label>
	<separator/>
	<checkbox id="acceptTermBox" onCheck="setImage()"/>
	<space/>
	<button id="btn" label="Button" />
	<zscript><![CDATA[
		public void setImage(){
			if (acceptTermBox.isChecked()){
				btn.setImage("/img/battery.gif");
			} else {
				btn.setImage("");
			}
		}
	]]></zscript>
</window>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-checkbox"))
      waitResponse()
      
      verifyTrue("The button's image should show up.", jq(".z-button-image").exists)
    })
    
  }
}