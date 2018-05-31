package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1626.zul")
class B65_ZK_1626Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
You should only see "Visible row" below this line. Otherwise, that's a bug.
<separator/>
<n:table xmlns:n="native">
    <n:tr>
        <n:td n:colspan="2">Visible row</n:td>      
    </n:tr>
    <n:tr if="false">
        <n:td>Name</n:td>
        <n:td>
            <textbox value="Invisible"/>
        </n:td>
    </n:tr>
</n:table></zk>
    """

    runZTL(zscript,
      () => {
        verifyTrue("You should only see 'Visible row' below this line.", jq("td:contains(Visible row)").exists())
        verifyFalse("You should only see 'Visible row' below this line.", jq(".z-textbox").exists())
      })

  }
}
