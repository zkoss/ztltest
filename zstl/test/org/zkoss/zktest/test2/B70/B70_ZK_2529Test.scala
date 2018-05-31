package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2529.zul")
class B70_ZK_2529Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<zk>
	<label multiline="true">
		1. try to type to each textbox
		2. if you can't type any letter, it is bug
	</label>
	textbox with onOK/onCancel listener
	<separator />
	<textbox onOK='alert("OK")'/>
	<textbox onCancel='alert("Cancel")'/>
	<textbox ctrlKeys="^k" onCtrlKey='alert("ctrl key")'/>
</zk>
    
"""
    runZTL(zscript,
      () => {
        var text = jq(".z-textbox");
        var it = text.iterator();
        while (it.hasNext()) {
          var t = it.next();
          keyPress(t, "chunfu");
          waitResponse();
          verifyTrue(t.eval("val()").equals("chunfu"));
        }

      })

  }
}