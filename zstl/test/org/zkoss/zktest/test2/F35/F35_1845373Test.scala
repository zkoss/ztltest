/* F35_1845373Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class F35_1845373Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window title="Test of switch/case">
	You shall see the following below the separator
	<vbox>
		<label value="Correct 1"/>
		<label value="Correct 2"/>
		<label value="Correct 4"/>
		<label value="Correct 3"/>
		<label value="Correct 5"/>
		<label value="Correct 6"/>
	</vbox>
	<separator bar="true"/>
	<variables var="apple"/>
	<vbox>
	<zk switch="${var}">
		<zk case="wrong">
			Error 1
		</zk>
		<zk case="orange, apple">
			Correct 1
			<zk choose="">
				<zk when="${var == 'orange'}">
					Error 1.1
				</zk>
				<zk when="${var == 'apple'}">
					Correct 2
				</zk>
				<zk>
					Error 1.2
				</zk>
			</zk>
		</zk>
		<zk>
			Error 2
		</zk>
	</zk>
	<zk switch="${each}" forEach="zk, gwt">
		<zk case="gwt">
			Correct 3
		</zk>
		<zk case="${each}" forEach="best, zk">
			Correct 4
		</zk>
		<zk>
			Error 3
		</zk>
	</zk>
	<zk switch="apple">
		<zk case="/a..e/">
			Error 4
		</zk>
		<zk case="/a.*e/">
			Correct 5
		</zk>
		<zk>
			Error 5
		</zk>
	</zk>
	<zk switch="${noexist}">
		<zk case="">
			Error 6
		</zk>
		<zk if="${!empty nothing}">
			Error 7
		</zk>
		<zk>
			Correct 6
		</zk>
		<zk case="more">
			Error 8
		</zk>
	</zk>
	</vbox>
</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      var answers = Array(
        "Correct 1",
        "Correct 2",
        "Correct 4",
        "Correct 3",
        "Correct 5",
        "Correct 6"
      )
      var jq$labels = jq("@label:gt(6)")
      for (i <- 0 until jq$labels.length()) {
        verifyEquals(answers(i), jq$labels.eq(i).text().trim())
      }
      verifyNotEquals("Correct 2", jq$labels.eq(0).text().trim())
    })
  }
}



