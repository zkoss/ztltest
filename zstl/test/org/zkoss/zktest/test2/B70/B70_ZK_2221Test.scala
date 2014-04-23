package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2221.zul")
class B70_ZK_2221Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2221.zul

	Purpose:
		
	Description:
		
	History:
		Fri, Mar 21, 2014 11:59:59 AM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
If you don't see the loading process icon running infinite loop, that's correct. (that means no JS error)
	<zscript><![CDATA[
		import org.zkoss.zktest.test2.big.*;
		import org.zkoss.util.*;
		
		FakerMatrixModel BigData = new FakerMatrixModel(0, 0);
	]]></zscript>
	<biglistbox id="biglist"  hflex="1" vflex="1" colWidth="130px" model="${BigData}"/>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyFalse("should see no javascript error", jq(".z-error").exists())
    })
    
  }
}