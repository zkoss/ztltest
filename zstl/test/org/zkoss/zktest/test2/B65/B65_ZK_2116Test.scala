package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-2116.zul")
class B65_ZK_2116Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-2116.zul

	Purpose:
		
	Description:
		
	History:
		Fri, Mar 28, 2014 12:12:36 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
If you can see this page without any JS error, that's correct.
<button>
	<attribute name="label">
		<![CDATA[ </script><script src=//a/e> ]]>
	</attribute>
</button>
<listbox>
<listitem>
<attribute name="label"><![CDATA[
</script ><script src=//a/e>
]]></attribute>
</listitem>
</listbox>
</zk>
"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button"))
      waitResponse()
      verifyFalse("should see no javascript error", jq(".z-error").exists())
    })
    
  }
}