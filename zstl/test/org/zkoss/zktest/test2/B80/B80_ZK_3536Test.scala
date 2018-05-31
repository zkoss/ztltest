package org.zkoss.zktest.test2.B80

import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * Created by wenninghsu on 01/11/2017.
  */
class B80_ZK_3536Test extends ZTL4ScalaTestCase {

  def test() = {
    runZTL(() => {
      click(jq(".z-button").get(0))
      waitResponse(true)
      click(jq(".z-menubar-right"))
      waitResponse(true)
      click(jq(".z-menubar-right"))
      waitResponse(true)
      click(jq(".z-menubar-right"))
      waitResponse(true)
      click(jq(".z-menubar-right"))
      waitResponse(true)
      click(jq(".z-menubar-right"))
      waitResponse(true)
      System.out.println(jq(".z-menu:eq(11)").offsetLeft())
      System.out.println(jq(".z-menu:eq(11)").outerWidth(true))
      System.out.println(jq(".z-menubar-right").offsetLeft())
      verifyTrue(jq(".z-menu:eq(11)").offsetLeft() + jq(".z-menu:eq(11)").outerWidth(true) < jq(".z-menubar-right").offsetLeft())
    })
  }

}
