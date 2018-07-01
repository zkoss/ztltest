package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1557.zul")
class B65_ZK_1557Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
	Please click the "Caption" once, and then it should show the content of the groupbox
	<groupbox mold="3d" width="100%" open="false">
		<caption label="Caption" />
		<div>
			<label value="Label 1"/>
			<textbox cols="30" maxlength="50" focus="true"/>
		</div>
		<div visible="false">
			<label value="Label 2"/>
			<combobox readonly="true"/>
		</div>
	</groupbox>
</zk>
    """

    runZTL(zscript,
      () => {
        click(jq(".z-caption"))
        waitResponse()

        verifyNotEquals("should show the content of the groupbox", jq(".z-groupbox-3d-cnt").css("display"), "none")
      })

  }
}
