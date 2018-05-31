package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2389.zul")
class B70_ZK_2389Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<zk>
	<div>
		if you see the javascript error after clicking add button, it's a bug.
	</div>
	<hlayout id="layout">
	    <button label="add" onClick="layout.appendChild(new Popup());" />
	</hlayout>
</zk>

"""
    runZTL(zscript,
      () => {
        clickAt(jq("@button"), "1,1");
        waitResponse();
        verifyFalse(jq(".z-error").exists());
      })

  }
}