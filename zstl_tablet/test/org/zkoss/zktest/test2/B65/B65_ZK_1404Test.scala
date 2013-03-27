package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._

@Tags(tags = "Touch,Android")
class B65_ZK_1404Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<label multiline="true">
	1. iPad/Android only
	2. Should see splitter size correctly.
	</label>
	<hbox>
		<panel title="Splitter, Default Mold" sclass="center-bg-win"
			framable="true" border="normal" height="300px" width="300px">
			<panelchildren>
				<hbox spacing="0" height="100%">
					<vbox spacing="0" width="100%" height="100%">
						Vbox Content
						<splitter collapse="before" />
						Vbox Content
					</vbox>
					<splitter collapse="before" />
					Hbox Content
				</hbox>
			</panelchildren>
		</panel>
		<window title="Splitter, Default Mold" sclass="center-bg-win"
			border="normal" height="300px" width="300px">
			<hbox spacing="0" height="100%">
				<vbox spacing="0" width="100%" height="100%">
					Vbox Content
					<splitter collapse="before" />
					Vbox Content
				</vbox>
				<splitter collapse="before" />
				Hbox Content
			</hbox>
		</window>
	</hbox>
</zk>

    """

    runZTL(zscript,
      () => {
        for (hor <- jq(".z-splitter-hor").iterator()) {
          verifyTrue("Should see splitter size correctly.", (hor.height() - 234).abs < 3)
        }

        for (ver <- jq(".z-splitter-ver").iterator()) {
          verifyTrue("Should see splitter size correctly.", (ver.width() - 72).abs < 3)
        }
        
        for (td <- jq(".z-label:contains(Vbox)").parent().iterator()) {
          verifyTrue("Should see splitter size correctly.", (td.height() - 113).abs < 3)
        }
      })

  }
}
