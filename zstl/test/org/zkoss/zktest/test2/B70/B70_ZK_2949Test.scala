package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.JQuery

@Tags(tags = "B70-ZK-2949.zul")
class B70_ZK_2949Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        def resizeColumn(grid: JQuery) = {
          val firstColumn = grid.find(".z-column").eq(0);
          dragdropTo(firstColumn, (firstColumn.offsetLeft() + firstColumn.width() - 3) + "," + (firstColumn.offsetTop() + 5)
            , (firstColumn.offsetLeft() + firstColumn.width() - 30) + "," + (firstColumn.offsetTop() + 5))
          waitResponse();
        }

        val grids = jq(".z-grid");
        resizeColumn(grids.eq(0));
        resizeColumn(grids.eq(1));
        resizeColumn(grids.eq(2));

        val toggleButton = jq(".z-button:contains(toggle flag (mvvm))");
        click(toggleButton);
        waitResponse();

        var column4 = jq("div.z-column-content:contains(mvvm4)");
        var column5 = jq("div.z-column-content:contains(mvvm5)");
        verifyEquals(column4.eq(0).width(), 0);
        verifyEquals(column4.eq(1).width(), 0);
        verifyEquals(column4.eq(2).width(), 0);
        verifyNotEquals(column5.eq(0).width(), 0);
        verifyNotEquals(column5.eq(1).width(), 0);
        verifyNotEquals(column5.eq(2).width(), 0);

        val column1Width = grids.eq(0).find(".z-column").eq(0).width();

        val invalidate1grid = jq(".z-button:contains(invalidate 1st grid)");
        click(invalidate1grid);

        verifyEquals(column1Width, grids.eq(0).find(".z-column").eq(0).width());

        evalScript("window.scrollTo(0,1000)");
        resizeColumn(grids.eq(3));

        val toggleButton2 = jq(".z-button:contains(toggle flag (mvc))");
        click(toggleButton2);
        waitResponse();

        column4 = jq("div.z-column-content:contains(mvc4)");
        column5 = jq("div.z-column-content:contains(mvc5)");
        verifyEquals(column4.eq(0).width(), 0);
        verifyNotEquals(column5.eq(0).width(), 0);

        val toggleButton3 = jq(".z-button:contains(column 1 set align - center (mvc))");
        click(toggleButton3);
        waitResponse();

        verifyEquals(grids.eq(3).find(".z-column").eq(0).css("text-align"), "center");

        val toggleButton4 = jq(".z-button:contains(column 2 set vertical align - top (mvc))");
        click(toggleButton4);
        waitResponse();

        verifyEquals(grids.eq(3).find(".z-column").eq(1).css("vertical-align"), "top");
      })

  }
}