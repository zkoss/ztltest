package org.zkoss.zktest.test2.F70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "F70-ZK-2338.zul")
class F70_ZK_2338Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>
<?taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c"?>
<!--
F70-ZK-2338.zul

	Purpose:
		
	Description:
		
	History:
		Wed, July 2, 2014  12:41:04 PM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<window>
	You should see four words "HelloWorld", "HelloWorld3", "HelloWorld34", "HelloWorld345".
	<separator/>
	
	<zscript>
	public class ABC{
		public String toString(){return "World";}
	}
	</zscript>
	<zscript>
 		ABC d = new ABC();
	</zscript>
	<label value="${c:cat('Hello', d)}"/><separator/>
	<label value="${c:cat3('Hello', d, 3)}"/><separator/>
	<label value="${c:cat4('Hello', d, 3, 4)}"/><separator/>
	<label value="${c:cat5('Hello', d, 3, 4, 5)}"/><separator/>
</window>
"""
    runZTL(zscript,
      () => {
        val ls = jq("@label");
        verifyEquals(ls.eq(1).html(), "HelloWorld")
        verifyEquals(ls.eq(2).html(), "HelloWorld3")
        verifyEquals(ls.eq(3).html(), "HelloWorld34")
        verifyEquals(ls.eq(4).html(), "HelloWorld345")
      })

  }
}