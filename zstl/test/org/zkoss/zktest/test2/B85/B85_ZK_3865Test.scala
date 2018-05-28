/* B85_ZK_3865Test.java

        Purpose:
        
        Description:
        
        History:
                Mon May 28 15:55:01 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B85_ZK_3865Test extends ZTL4ScalaTestCase {
	@Test
	def test(): Unit = {
		runZTL(() => {
			val outers = jq(".outer")
			for (i <- 0 to outers.length() - 1) {
				var widthToMinus = 0
				var heightToMinus = 0
				val outer = outers.eq(i)
				val inner = outer.find(".inner")
				val innerWidget = inner.toWidget
				if (innerWidget.get("hflex").equals("1")) {
					widthToMinus += pxToInt(inner.css("margin-left"))
					widthToMinus += pxToInt(inner.css("margin-right"))
					verifyEquals(inner.width(), outer.width() - widthToMinus)
				}
				if (innerWidget.get("vflex").equals("1")) {
					heightToMinus += pxToInt(inner.css("margin-top"))
					heightToMinus += pxToInt(inner.css("margin-bottom"))
					verifyEquals(inner.height(), outer.height() - heightToMinus)
				}
			}
		})
	}
	
	def pxToInt(px: String): Int = {
		return px.substring(0, px.indexOf("px")).toInt
	}
}
