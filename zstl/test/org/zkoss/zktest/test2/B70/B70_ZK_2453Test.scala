package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2453.zul")
class B70_ZK_2453Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<zk>
  <window border="normal" title="Progressmeter in 7.0.3 with 'visible=false' give JS error, page rendering is stopped" >
    <label multiline="true">
    	1. you should load this page without js error.
    </label>
    <progressmeter id="progressMeter" visible="false" />

  </window>
</zk>


"""
    runZTL(zscript,
      () => {
        var error = jq(".z-error");
        verifyTrue(error.length() == 0);
      })

  }
}