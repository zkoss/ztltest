/* B30_1879389Test.java

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
import org.zkoss.ztl.unit.Widget


class B30_1879389Test extends ZTL4ScalaTestCase {
  @Test
  def testDataBinding() = {
    var zscript =
      """
			<zk>
				<zscript>
					import org.zkoss.zul.*;
					import org.zkoss.zkplus.databind.*;
					
					public class Test {
						private Integer foo;
						public Test(){
							foo = new Integer(123);
						}
						public Integer getFoo() {
							return foo;
						}
					}
				
					public class WinTest extends Window {
						public void onCreate() throws Exception{
							AnnotateDataBinder windowBind = new AnnotateDataBinder(this);
							windowBind.bindBean("testBean", new Test());
							windowBind.loadAll();
						}
					}
				</zscript>
			
				<window use="WinTest">
					You shall see the textbox containing 123
					<textbox id="myTxtbox" value="@{testBean.foo}"/>
				</window>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val myTxtbox = ztl$engine.$f("myTxtbox")
    runZTL(zscript, () => {
      verifyEquals("123", jq("$myTxtbox").`val`())
    })
  }
}



