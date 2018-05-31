package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1370.zul")
class B65_ZK_1370Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
                    Click "Test" button, should not see error message box.<separator/>
                    <datebox id="dbx"/>
                    <button label="Test" onClick='dbx.setDisplayedTimeZones("GMT+12");'>
                      <attribute name="onClick"><![CDATA[
			dbx.setDisplayedTimeZones("GMT+12");
			dbx.setDisplayedTimeZones(Collections.emptyList());
		]]></attribute>
                    </button>
                  </zk>
"""
    runZTL(zscript,
      () => {
        click(jq("@button"))
        waitResponse()
        verifyTrue("should not see error message box.", !jq(".z-popup-cl").isVisible())
      })

  }
}