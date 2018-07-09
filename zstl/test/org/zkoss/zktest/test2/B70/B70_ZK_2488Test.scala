package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2488.zul")
class B70_ZK_2488Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<zk>
	<label multiline="true">
		1. you should see the circle icon display at label's left
	</label>
	<groupbox closable="true" title="Groupbox">
		<caption iconSclass="z-icon-circle">
			<label value="Test-Label" />
		</caption>
		caption in groupbox
	</groupbox>
	<separator />
	<tabbox>
		<tabs>
			<tab>
				<caption iconSclass="z-icon-circle">
					<label value="Test-Label" />
				</caption>
			</tab>
		</tabs>
		<tabpanels>
			<tabpanel>caption in tabbox/tab</tabpanel>
		</tabpanels>
	</tabbox>
	<separator />
	<panel closable="true" minimizable="true"  title="Panel">
		<caption iconSclass="z-icon-circle">
			<label value="Test-Label" />
		</caption>
		<panelchildren>caption in panel</panelchildren>
	</panel>
	<separator />
	<window closable="true" minimizable="true"  title="Window">
		<caption iconSclass="z-icon-circle">
			<label value="Test-Label" />
		</caption>
		caption in window
	</window>
</zk>

"""
    runZTL(zscript,
      () => {
        var index = 0
        var c = jq(".z-caption-content")
        var l = jq(".z-caption-content>.z-label")
        while (index < 4) { //c.length, l.length
          var caption = c.eq(index)
          var label = l.eq(index)
          verifyTrue(caption.positionLeft() < label.positionLeft());
          index += 1
        }
      })
  }
}