/* B30_1957661Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1957661Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
It is correct, if you saw "MyFunction" below.
<separator bar="true"/>
<zscript>
import org.zkoss.xel.Function;
import org.zkoss.xel.util.MethodFunction;
import org.zkoss.xel.util.SimpleMapper;

public class MyFunction extends SimpleMapper {
	public Function resolveFunction(String prefix, String name) {
		if ("getString".equals(name)) {
			try {
				return new MethodFunction(MyFunction.class.getMethod("getString", null));
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String getString(){
		return "MyFunction";
	}
}
page.addFunctionMapper(new MyFunction());
</zscript>
<label value="${c:getString()}"/>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyEquals("MyFunction", jq("@label:last").text())
    })
  }
}



