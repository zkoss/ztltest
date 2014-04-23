package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2192.zul")
class B70_ZK_2192Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk xmlns:w='client'>
	<label multiline="true">
		1. Click the "Slide" button.
		2. When the window is sliding, click the combobutton.
		3. The popup should show up.
	</label>
	<button label="Slide" w:onClick="jq(this.$f('t')).slideToggle(5000)" />
    <zscript><![CDATA[
        ListModelList lm = new ListModelList(Arrays.asList(new String[] { "David",
                "Thomas", "Steven"}));
    ]]></zscript>
	<combobox model="${lm}"/>
	<window id="t" title="This is a Window" border="normal" height="400px" />
</zk>"""  
  runZTL(zscript,
    () => {
      val cb = jq(".z-combobox").toWidget()
      click(jq(".z-button"))
      click(cb.$n("btn"))
      waitResponse()
      verifyTrue("The popup should show up", cb.$n("pp").exists)
    })
    
  }
}