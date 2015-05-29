package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.ConfigHelper

@Tags(tags = "B80-ZK-2598.zul")
class B80_ZK_2598Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B80-ZK-2598.zul

  Purpose:
    
  Description:
    
  History:
    Mon, Mar 23, 2015  4:16:25 PM, Created by hanhsu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
  <label multiline="true">
    1. the page should be rendered without any exception
    2. click on each of the three buttons, should all alert the forward event.
  </label>
  <include src="/test2/B80-ZK-2598_forward.zul"/>
</zk>

""" 
  runZTL(zscript,
    () => {
      var btns = jq(".z-button").iterator();
      click(jq(".z-button").eq(0));
      waitResponse();
      var result = jq(".z-messagebox-window .z-label").text();
      click(jq(".z-messagebox-button"));
      while (btns.hasNext()) {
        var btn = btns.next();
        click(btn);
        waitResponse();
        verifyTrue(jq(".z-messagebox-button").exists());
        verifyEquals(jq(".z-messagebox-window .z-label").text(), result);
        click(jq(".z-messagebox-button"));
        waitResponse();
      }
    })
    
  }
}