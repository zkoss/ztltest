package org.zkoss.zktest.test2.B80

import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * Created by wenninghsu on 01/11/2017.
  */
class B80_ZK_3411Test extends ZTL4ScalaTestCase {

  def test() = {
    runZTL(() => {
      verifyEquals(jq(".z-window-content").height(), jq(".z-grid").outerHeight())
    })
  }

}
