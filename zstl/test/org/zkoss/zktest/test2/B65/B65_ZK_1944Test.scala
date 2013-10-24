package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1944.zul")
class B65_ZK_1944Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<window border="normal" width="400px" apply="org.zkoss.bind.BindComposer"
				viewModel="@id('vm') @init('org.zkoss.zktest.test2.B65_ZK_1944')">
Should see 12.3 in the box.
<separator height="10px"/>
Decimalbox 1 in double(With VM): <decimalbox value="@bind(vm.dbValue)"/>
<separator height="10px"/>
Decimalbox 2 in float (with VM ) : <decimalbox value="@bind(vm.flValue)"/>
</window>"""
    runZTL(zscript,
      () => {
        0 to 1 foreach { index =>
          verifyTrue("Should see 12.3 in the box.",
            jq(".z-decimalbox").eq(index).`val`() == "12.3")
        }

      })

  }
}