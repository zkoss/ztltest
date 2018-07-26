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
  @Test
	def test()=  {
		runZTL(() => {
			waitResponse()
      getEval("recordWidths()")
      waitResponse()
      //first row
			for (i <- 0 to 6) { //cellSize - 1
				var num = jq(".z-cell").eq(i).find("span").text().toInt
				waitResponse()
        verifyTolerant(jq(".z-cell").eq(i).offsetLeft(), getEval("pos0[monthStrArr[" + (num - 1) + "]]"), 1)
			}

      //grid1
			for (i <- 0 to 43) { //rowinnerSize - 1
        var rowInners = jq(".z-grid:eq(0) .z-row-inner")
				var num = rowInners.eq(i).find("span").text().toInt
				waitResponse()
        verifyTolerant(rowInners.eq(i).offsetLeft(), getEval("pos0[monthStrArr[" + (num - 1) + "]]"), 1)
				if (num == 4 || num == 5) {
					checkWidth(i)
				}
			}

      //grid2
      for (i <- 0 to 5) {
        var rowInners = jq(".z-grid:eq(1) .z-row-inner")
        var num = rowInners.eq(i).find("span").text().toInt
        waitResponse()
        verifyTolerant(rowInners.eq(i).offsetLeft(), getEval("pos1[monthStrArr[" + (num - 1) + "]]"), 1)
      }

			verifyEquals("hidden", jq(".z-column:contains(\"Apr\"):eq(0)").css("visibility"))
			verifyEquals("hidden", jq(".z-column:contains(\"May\"):eq(0)").css("visibility"))
			verifyEquals("hidden", jq(".z-column:contains(\"Apr\"):eq(1)").css("visibility"))
			verifyEquals("hidden", jq(".z-column:contains(\"May\"):eq(1)").css("visibility"))
		})
	}

	def checkWidth(i : Int) = {
		verifyEquals(0, jq(".z-row-inner").eq(i).width())
	}
}
