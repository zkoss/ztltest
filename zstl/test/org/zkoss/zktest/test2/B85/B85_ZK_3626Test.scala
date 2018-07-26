package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.openqa.selenium.By
import org.openqa.selenium.Keys

/* B85_ZK_3626Test.java

        Purpose:
                
        Description:
                
        History:
                Wed Mar 07 6:47 PM:14 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
class B85_ZK_3626Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
    runZTL(() => {
      getEval("document.body.style.zoom = '150%'")
      waitResponse()
      for (i <- 1 to 8) {
        jq(".z-menubar-right").eval("click()")
        jq(".z-tabbox-right-scroll").eval("click()")
        jq(".z-tabbox-down-scroll").eval("click()")
        waitResponse()
      }
      var manubarBodyWidth = jq(".z-menubar-body").width()
      var manubarBodyLeft = jq(".z-menubar-body").offsetLeft()
      var menu8Left = jq(jq(".z-menubar").toWidget().lastChild()).offsetLeft()
      var menuItemWidth = jq(jq(".z-menubar").toWidget().lastChild()).width()
      verifyTrue(manubarBodyLeft + manubarBodyWidth + 2 > (menu8Left + menuItemWidth))

      var tabsWidth = jq(".z-tabs:eq(0)").width()
      var tabsLeft =  jq(".z-tabs:eq(0)").offsetLeft()
      var tab8Width = jq(jq(".z-tabs:eq(0)").toWidget().lastChild()).width()
      var tab8Left =  jq(jq(".z-tabs:eq(0)").toWidget().lastChild()).offsetLeft()
      verifyTrue(tabsLeft + tabsWidth + 2 > (tab8Left + tab8Width))

      var tabsHeight1 = jq(".z-tabs:eq(1)").height()
      var tabsTop1 =  jq(".z-tabs:eq(1)").offsetTop()
      var tab8Height1 = jq(jq(".z-tabs:eq(1)").toWidget().lastChild).height()
      var tab8Top1 =  jq(jq(".z-tabs:eq(1)").toWidget().lastChild).offsetTop()
      verifyTrue(tabsTop1+ tabsHeight1 + 2 > (tab8Top1 + tab8Height1))
    })
  }
}
