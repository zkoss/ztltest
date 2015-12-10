package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2839.zul")
class B70_ZK_2839Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2839.zul

	Purpose:
		
	Description:
		
	History:
		Wed Aug 19 11:43:43 CST 2015, Created by jumperchen

Copyright (C) 2015 Potix Corporation. All Rights Reserved.

-->
<zk xmlns:w="client">
    Please click the following two buttons, you should see some messages in zk.log by each click.
       <zscript><![CDATA[
       import org.zkoss.zk.au.out.AuInvoke;
       ]]></zscript>
       <script><![CDATA[
             function f1() { zk.log("hello from global f1()"); }
       ]]></script>
       <window title="Hello World!!" border="normal" width="640px" height="480px">
             <attribute w:name="f2"><![CDATA[
           function() { zk.log("hello from local f2()"); }
        ]]></attribute>
             <vbox hflex="1" vflex="1">
                    <label id="l" value="You are using ZK version: ${desktop.webApp.version}" style="color:blue"/>
                    <space/>
                    <hlayout>
                           <button label="global" height="100px">
                                  <attribute name="onClick"><![CDATA[
                                        Clients.response(new AuInvoke("f1", null));
                                  ]]></attribute>
                           </button>
                           <button label="local" height="100px">
                                  <attribute name="onClick"><![CDATA[
                                        Clients.response(new AuInvoke(self.parent.parent.parent, "f2", null));
                                  ]]></attribute>
                           </button>
                    </hlayout>
             </vbox>
       </window>
</zk>

"""  
  runZTL(zscript,
    () => {
      //click the global button twice
      click(jq("button").eq(0))
      waitResponse()
      click(jq("button").eq(0))
      waitResponse()
      //click the local button once
      click(jq("button").eq(1))
      waitResponse(true)
      //check for 3 messages in zk.log
      verifyEquals("hello from global f1()\nhello from global f1()\nhello from local f2()\n", getZKLog())
    })
  }
}