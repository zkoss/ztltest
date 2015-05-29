package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.ConfigHelper

@Tags(tags = "B80-ZK-2738.zul")
class B80_ZK_2738Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>
<!--
B80-ZK-2738.zul

  Purpose:
    
  Description:
    
  History:
    Fri, May 8, 2015  11:50:18 AM, Created by Jameschu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk xmlns:sh="shadow">
  <label multiline="true">
  1. The following two lines should be the same.
  </label>
  <div apply="org.zkoss.bind.BindComposer">
    <sh:apply template="with-params-1" param1="AAA" param2="BBB" param3="@ref('CCC-ref')" param4="DDD" />
    <template name="with-params-1">
      <sh:apply template="nested-1">
        <template name="nested-1">
          <div>
            <label value="@load(param1)"/>
            <label value="@load(param2)"/>
            <label value="@load(param3)"/>
            <label value="@load(param4)"/>
          </div>
        </template>
      </sh:apply>
    </template>
  </div>
  <div id="host" apply="org.zkoss.bind.BindComposer">
    <sh:apply template="with-params-2" param1="AAA" param2="BBB" param3="@ref('CCC-ref')" param4="DDD" />
    <template name="with-params-2">
      <div>
        <sh:apply id="a2" template="nested-2">
          <template name="nested-2">
            <label value="@load(param1)"/>
            <label value="@load(param2)"/>
            <label value="@load(param3)"/>
            <label value="@load(param4)"/>
          </template>
        </sh:apply>
      </div>
    </template>
  </div>
</zk>

""" 
  runZTL(zscript,
    () => {
      var d1 = jq(".z-div").eq(0);
      var l1 = d1.find(".z-label");
      verifyEquals(4, l1.length());
      var d2 = jq(".z-div").eq(1);
      var l2 = d2.find(".z-label");
      verifyEquals(4, l2.length());
      
      for (i <- 0 to 3){
        verifyEquals(l1.eq(i).text(), l2.eq(i).text());
      }
    })
    
  }
}