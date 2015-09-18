package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.ConfigHelper

@Tags(tags = "B80-ZK-1983.zul")
class B80_ZK_1983Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
F80-ZK-1983.zul

  Purpose:
    
  Description:
    
  History:
    Mon, Apr 20, 2015  2:51:33 PM, Created by Chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->

<zk>
  <label multiline="true">
  1. There is a link that helps us jump to today by set "showTodayLink" property as true
  2. buttons to toggle this feature
  </label>
  <datebox id="db" showTodayLink="true" ></datebox>
  <calendar id="cal" showTodayLink="true"></calendar>

  <button onClick="db.setShowTodayLink(!db.getShowTodayLink())">toggle datebox today button</button>
  <button onClick="cal.setShowTodayLink(!cal.getShowTodayLink())">toggle calendar today button</button>
</zk>

""" 
  runZTL(zscript,
    () => {
      var calendarTitle = jq(".z-calendar").toWidget().$n("title");
      var title = jq(calendarTitle).text();
      var calendarToday = jq(".z-calendar").toWidget().$n("today");
      click(calendarTitle);
      waitResponse();
      click(calendarToday);
      waitResponse();
      verifyEquals(title, jq(calendarTitle).text());
      
      click(jq(".z-datebox-button"));
      var dtitle = jq("@calendar").toWidget().$n("title");
      var dtoday = jq("@calendar").toWidget().$n("today");
      title = jq(dtitle).text();
      click(dtitle);
      waitResponse();
      click(dtoday);
      waitResponse();
      verifyEquals(title, jq(dtitle).text());
    })
    
  }
}