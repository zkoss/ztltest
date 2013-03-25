package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZK

@Tags(tags = "B65-ZK-1540.zul")
class B65_ZK_1540Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<label>
	Should see a blue shadow surrounding the datebox completely.
	</label><separator />
	<style>
		.z-datebox { box-shadow: 0 0 6px #00a5e1; margin: 3px; }
		.z-datebox-inp { border-color: #00a5e1; }
		.z-datebox .z-datebox-btn { border-color: #00a5e1;}
	</style>
	<datebox width="200px" />
</zk>
    """

    runZTL(zscript,
      () => {
        val shadow = jq(".z-datebox").css("box-shadow")
        val result = if (ZK.is("ie"))
          "0px 0px 6px #00a5e1"
        else
          "rgb(0, 165, 225) 0px 0px 6px 0px"

        verifyEquals("Should see a blue shadow surrounding the datebox completely.", shadow, result)
      })

  }
}
