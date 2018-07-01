package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1403.zul,VisionTest")
class B65_ZK_1403Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<?page title="Combobutton on Tablet" contentType="text/html;charset=UTF-8"?>
<vlayout>
	Combobutton should display properly without unknown image icon.
	<combobutton label="Combobutton" />
</vlayout>"""
    runZTL(zscript,
      () => {
        verifyImage()
      })

  }
}