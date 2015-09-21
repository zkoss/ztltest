package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.ConfigHelper

@Tags(tags = "B80-ZK-2613.zul")
class B80_ZK_2613Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
F80-ZK-2613.zul

  Purpose:
    
  Description:
    
  History:
    Tue, Feb 03, 2015  3:42:46 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
  You should see an image link in the textarea with a domain name and contextPath
  <separator/>
  For example, 
  "http://localhost:8080/zktest/zkau/web/8aa8a092/img/spacer.gif"
  <x:img xmlns:x="xhtml" src="~./img/spacer.gif" xmlns:c="client" c:onBind='zk.log(this.$n().src)'/>
</zk>

""" 
  runZTL(zscript,
    () => {
      verifyTrue(jq("#zk_log").eval("val()").contains("/zktest/zkau/web/"))
      verifyTrue(jq("#zk_log").eval("val()").contains("/img/spacer.gif"))
    })
    
  }
}