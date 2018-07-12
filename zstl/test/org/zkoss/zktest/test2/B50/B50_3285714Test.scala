/* B50_3285714Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Oct 13 18:59:08 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{Element, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug 3285714
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-3285714.zul,A,E,Grid,ROD")
class B50_3285714Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
				<html><![CDATA[
					<ol>
						<li>Drag the scroll to the middle. You should see row numbers are around 5,000. Otherwise it is a bug.</li>
					</ol>
				]]></html>
				<zscript><![CDATA[
					rows = new String[10000];
					for(int i = 0; i < 10000; i++)
						rows[i] = "Row " + i;
				]]></zscript>
				<grid id="grid" width="200px" height="300px">
					<rows id="rows">
						<row forEach="${rows}">
							<label value="${each}" />
						</row>
					</rows>
				</grid>
			</zk>

    """
    runZTL(zscript,
      () => {
        var grid: Widget = engine.$f("grid");
        var rows: Widget = engine.$f("rows");

        verScroll(grid, 1)
        sleep(600);
        verScroll(grid, .5)
        sleep(600);

        var rowCnt: Int = jq(rows.$n()).find(".z-row").length();
        val top = getScrollTop(grid) - jq(grid.$n("tpad")).outerHeight();
        def findTopRow(i: Int, max: Int): Element = {
          var row: Element = jq(rows.$n()).find(".z-row").get(i);
          if (parseInt(row.attr("offsetTop")) >= top
            || (i + 1) >= max)
            return row;
          else
            return findTopRow(i + 1, max);
        }

        var topRow: Element = findTopRow(0, rowCnt);
        var content: String = getText(topRow);

        var itemCnt: Integer = parseInt(content)
        verifyTrue(getEval("Math.abs(5000 -" + itemCnt + ") <= 50"))
      }
    );

  }
}