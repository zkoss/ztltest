package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1797.zul")
class B65_ZK_1797Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<div id="mainDiv">
		<listbox>
			<attribute name="onSelect"><![CDATA[
			 	mainDiv.getChildren().clear();
			 	mainDiv.getTemplate("tmp").create(mainDiv, null, null, null);
				mainDiv.invalidate();
			]]></attribute>
			<listitem label="click me should not see any JS error"/>
		</listbox>
		<template name="tmp">
			<window >
				<popup>
					<button label="PopUpbutton"></button>
				</popup>
			</window>
		</template>
	</div>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-div"))
        waitResponse()
        verifyFalse("should see no javascript error", jq(".z-error").exists())
      })

  }
}