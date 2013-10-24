package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1837.zul")
class B65_ZK_1837Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1837.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Jul 03, 2013  3:49:55 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
<groupbox id="guarantorInfogb" mold="3d" open="true"  height="25px">
    <attribute name="onOpen"><![CDATA[
alert("If you can see this, that is a bug!");
    ]]></attribute>
        <caption  label="Please check the checkbox, and nothing happen is correct!">
            <hbox>
                <checkbox/> 
            </hbox>
        </caption>
</groupbox>
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-checkbox"))
      waitResponse()
      
      verifyImage()
    })
    
  }
}