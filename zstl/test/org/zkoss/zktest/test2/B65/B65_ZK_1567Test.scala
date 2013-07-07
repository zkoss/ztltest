package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1567.zul")
class B65_ZK_1567Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk xmlns="http://www.zkoss.org/2005/zul">
1. Please click "More" menu.
<separator/>
2. The menupopup should align with the left of "More" menu
<hlayout>
<label value="Actions:"/>
<menubar zclass="none">
<menu label="More">
<menupopup>
<menuitem label="Action 1"/>
<menuitem label="Action 2"/>
</menupopup>
</menu>
</menubar>
</hlayout>
</zk>
    """

    runZTL(zscript,
      () => {
        click(jq(".z-menu:contains(More)"))
        waitResponse()

        verifyEquals("The menupopup should align with the left of 'More' menu", jq(".z-menu").offsetLeft(), jq(".z-menupopup").offsetLeft())
      })

  }
}
