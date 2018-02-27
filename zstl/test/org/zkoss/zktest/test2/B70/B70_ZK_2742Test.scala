package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Tags, ZK}

/**
 * Created by wenning on 1/20/16.
 */
@Tags(tags = "B70-ZK-2742.zul")
class B70_ZK_2742Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      click(jq(".z-combobox-button"))
      waitResponse()
      var cb = jq(".z-combobox")
      var cbpp = jq(".z-combobox-popup:eq(0)")
      verifyTolerant(cb.offsetTop() + cb.height(), cbpp.offsetTop(), 1)
    })
  }

}
