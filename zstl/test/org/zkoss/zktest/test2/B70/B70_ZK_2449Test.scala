package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2449.zul")
class B70_ZK_2449Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<zk>
	<label multiline="true">
		The bottom two buttons should display in the same line. (the upload and normal)
	</label>
	<div style="border: 1px solid green">
		<button label="normal1"/>
		<button label="normal2"/>
	</div>

	<div style="border: 1px solid red">
		<button label="upload" upload="true" onUpload="Clients.showNotification(event.getMedia().getName())" />
		<button label="normal"/>
	</div>
</zk>

"""
    runZTL(zscript,
      () => {
        var top = jq(".z-div").first();
        var bottom = jq(".z-div").last();
        verifyTrue(top.outerHeight() == bottom.outerHeight());
      })

  }
}