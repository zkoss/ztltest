package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B80-ZK-3094.zul")
class B80_ZK_3094Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {

        click(jq(".z-button:contains(\"make smaller\")"))
        waitResponse()

        verifyTrue("Expecting to see menubar left scrollable button, got none", jq(".z-menubar-left.z-menubar-scrollable").exists())
        verifyTrue("Expecting to see menubar right scrollable button, got none", jq(".z-menubar-right.z-menubar-scrollable").exists())

        click(jq(".z-button:contains(\"produce bug\")"))
        waitResponse()

        verifyTrue("Expecting to see menubar left scrollable button, got none", jq(".z-menubar-left.z-menubar-scrollable").exists())
        verifyTrue("Expecting to see menubar right scrollable button, got none", jq(".z-menubar-right.z-menubar-scrollable").exists())
      })
  }
}
