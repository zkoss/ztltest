/* B85_ZK_3722Test.scala
        Purpose:

        Description:

        History:
                Tue Mar 06 4:41 PM:38 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "")
class B85_ZK_3722Test extends ZTL4ScalaTestCase {
  var pos0Map: Map[String, Int] = Map()
  var pos1Map: Map[String, Int] = Map()
  var monList = Array("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
  @Test
	def test()=  {
		runZTL(() => {
      var cellSize = 0
      var rowinnerSize = 0
			cellSize = jq(".z-cell").length()
			rowinnerSize = jq(".z-row-inner").length()
      var grid2Top = jq(".z-grid:eq(1)").offsetTop()
			for (i <- 0 to 11) {
				var mon = monList.apply(i)
				pos0Map += (mon -> jq(".z-column:contains(\""+ mon +"\"):eq(0)").offsetLeft())
				pos1Map += (mon -> jq(".z-column:contains(\""+ mon +"\"):eq(1)").offsetLeft())
			}
			waitResponse()
			for (i <- 0 to 6) { //cellSize - 1
				var num = jq(".z-cell").eq(i).find("span").text().toInt
				var offleft = jq(".z-cell").eq(i).offsetLeft()
				var offTop =  jq(".z-cell").eq(i).offsetTop()
				waitResponse()
				checkPos(num, offleft, offTop, grid2Top)
			}

			for (i <- 0 to 49) { //rowinnerSize - 1
				var num = jq(".z-row-inner").eq(i).find("span").text().toInt
				var offleft = jq(".z-row-inner").eq(i).offsetLeft()
				var offTop =  jq(".z-row-inner").eq(i).offsetTop()
				waitResponse()
				checkPos(num, offleft, offTop, grid2Top)
				if (num == 4 || num == 5) {
					checkWidth(i)
				}
			}
			verifyEquals("hidden", jq(".z-column:contains(\"Apr\"):eq(0)").css("visibility"))
			verifyEquals("hidden", jq(".z-column:contains(\"May\"):eq(0)").css("visibility"))
			verifyEquals("hidden", jq(".z-column:contains(\"Apr\"):eq(1)").css("visibility"))
			verifyEquals("hidden", jq(".z-column:contains(\"May\"):eq(1)").css("visibility"))
		})
	}

	def checkPos(num : Int, offleft : Int, offTop: Int, gridTop: Int)  = {
		var targetPos = 0
		targetPos = pos0Map.apply(monList.apply(num - 1))
		if (offTop < gridTop) {
			targetPos = pos0Map.apply(monList.apply(num - 1))
		} else {
			targetPos = pos1Map.apply(monList.apply(num - 1))
		}
		verifyTolerant(offleft, targetPos, 1)
	}
	def checkWidth(i : Int) = {
		verifyEquals(0, jq(".z-row-inner").eq(i).width())
	}
}
