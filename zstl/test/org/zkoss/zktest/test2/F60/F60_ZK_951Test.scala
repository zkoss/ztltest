/* F60_ZK_951Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Apr 06 10:14:56 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.{JQuery, Widget}

/**
  * A test class for bug ZK-951
  *
  * @author benbai
  *
  */
@Tags(tags = "F60-ZK-951.zul,F60,A,E,Biglistbox,Model")
class F60_ZK_951Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """
			<zk>
    		<div if="${zk.ie != 6 and zk.ie != 7}">
    		<label id="outer" value="outer" />
			<vlayout vflex="1">
		<label style="font-weight:bold">This feature only support on IE8+, Firefox, Chrome, Safari, and Opera</label>
		<zscript><![CDATA[
			import org.zkoss.zktest.test2.big.*;
			import org.zkoss.util.*;
			
			FakerMatrixModel NonHeader = new FakerMatrixModel(10, 10, 0);
			FakerMatrixModel MultipleHeader = new FakerMatrixModel(10, 10, 3);
			FakerMatrixModel SingleColumn = new FakerMatrixModel(1, 10);
			FakerMatrixModel MultipleColumn = new FakerMatrixModel(100, 10);
			FakerMatrixModel HugeColumn = new FakerMatrixModel(10000, 10);
			FakerMatrixModel SingleRow = new FakerMatrixModel(10, 1);
			FakerMatrixModel MultipleRow = new FakerMatrixModel(10, 100);
			FakerMatrixModel HugeRow = new FakerMatrixModel(10, 10000);
			FakerMatrixModel BigData = new FakerMatrixModel(1000000, 1000000);
			
			Pair[] models = new Pair[] {
				new Pair("NonHeader", NonHeader), 
				new Pair("MultipleHeader", MultipleHeader),
				new Pair("SingleColumn", SingleColumn),
				new Pair("MultipleColumn", MultipleColumn),
				new Pair("HugeColumn", HugeColumn),
				new Pair("SingleRow", SingleRow),
				new Pair("MultipleRow", MultipleRow),
				new Pair("HugeRow", HugeRow),
				new Pair("BigData", BigData)
			};
			ListModelList modelList = new ListModelList(Arrays.asList(models));
			modelList.addToSelection(modelList.get(0));
			ListModelList tenSize = new ListModelList(Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
			tenSize.addToSelection(tenSize.get(0));
			ListModelList colsSize = new ListModelList(Arrays.asList(new Integer[]{5, 10, 15, 20}));
			ListModelList rowsSize = new ListModelList(Arrays.asList(new Integer[]{5, 10, 15, 20}));
		]]></zscript>
		<vlayout>
			<hlayout valign="bottom">
			Change Models:
			<selectbox id="sbx" model="${modelList}">
				<attribute name="onSelect">
				biglist.frozenCols = 0;
				tenSize.addToSelection(tenSize.get(0));
				biglist.setModel(event.selectedObjects.iterator().next().y);
				</attribute>
				<template name="model">
				${each.x}
				</template>
			</selectbox>
			Change V/Hflex:
			<radiogroup onCheck="biglist.vflex = biglist.hflex= self.selectedItem.label; biglist.invalidate();">
			<radio id="rdo" label="1" checked="true"/>
			<radio id="rdoTwo" label="min"/>
			</radiogroup>
			</hlayout>
			<hlayout>
			Change fixForzenCols:
				<radiogroup onCheck='biglist.fixFrozenCols = self.selectedItem.label.equals("Enable") '>
				<radio label="Disable" checked="true"/>
				<radio label="Enable"/>
				</radiogroup>
			Change frozenCols:
				<selectbox id="sbx2" model="${tenSize}">
					<attribute name="onSelect">
					if (self.selectedIndex > biglist.cols -1) {
						self.selectedIndex = self.selectedIndex - 1;
						alert("FrozenCols cannot be greater than Cols");
					} else
						biglist.frozenCols = self.selectedIndex
					</attribute>
				</selectbox>
			
			Change cols: 
				<selectbox id="sbx3" model="${colsSize}">
					<attribute name="onSelect">
					int i = event.selectedObjects.iterator().next();
					if (biglist.frozenCols > i-1) {
						self.selectedIndex = self.selectedIndex - 1;
						alert("FrozenCols cannot be greater than Cols");
					} else {
						biglist.autoCols = false;
						biglist.cols = i;
					}
					</attribute>
				</selectbox>
			Change rows: 
				<selectbox id="sbx4" model="${rowsSize}" onSelect="biglist.autoRows = false;biglist.rows = event.selectedObjects.iterator().next()"/>
			</hlayout>
			<hlayout>
			Invalidate should look the same as before: <button label="invalidate" onClick="biglist.invalidate()"/>
			</hlayout>
		</vlayout>
    	<div id="div" hflex="1" vflex="1">
		<biglistbox id="biglist" hflex="1" vflex="1" colWidth="130px" model="${NonHeader}">
			<!-- Template example -->
			<template name="heads">
				<html><![CDATA[
					<div title="x=${matrixInfo[0]},y=${matrixInfo[1]}">${each[matrixInfo[0]]}</div>
				]]></html>
			</template>
			<template name="rows">
				<html><![CDATA[
					<div title="x=${matrixInfo[0]},y=${matrixInfo[1]}">${each[matrixInfo[0]]}</div>
				]]></html>
			</template>
		</biglistbox>
		</div></vlayout>
    			</div>
			</zk>
    """

    runZTL(zscript,
      () => {
        var outer: Widget = engine.$f("outer");
        var biglist: Widget = engine.$f("biglist");
        var div: Widget = engine.$f("div");
        var sbx: Widget = engine.$f("sbx");
        var sbx2: Widget = engine.$f("sbx2");
        var sbx3: Widget = engine.$f("sbx3");
        var sbx4: Widget = engine.$f("sbx4");
        var rdo: Widget = engine.$f("rdo");
        var rdoTwo: Widget = engine.$f("rdoTwo");
        var windowWidth: Int = jq(div).outerWidth(true);
        var windowHeight: Int = jq(div).outerHeight(true);
        var numberOfColumns: Int = 0;
        var numberOfRows: Int = 0;
        var numberOfCells: Int = 0;

        def sel(sbx: Widget, item: String) {
          select(sbx, item);
        }

        def nselect(sbx: Widget, num: Int) { // select function for ie8-
          click(sbx);
          sbx.$n().eval("selectedIndex = " + num);
          click(outer);
          waitResponse();
        }

        def setValues() {
          numberOfColumns = jq(biglist.$n("cols")).find("th").length();
          numberOfRows = jq(biglist.$n("rows")).find("tr").length();
          numberOfCells = jq(biglist.$n("rows")).find("td").length();
        }

        def checkRange() {
          var rows: JQuery = jq(biglist.$n("rows"));
          var rowSize: Int = rows.find("tr").length();
          var cols: JQuery = jq(rows.find("tr").get(0)).find("td");
          var colSize: Int = cols.length();
          var hbar: JQuery = jq(biglist.$n("hbar"));
          var vbar: JQuery = jq(biglist.$n("vbar"));
          for (i <- 0 until rowSize) { //rowSize
            var row: JQuery = jq(rows.find("tr").get(i));

            if ((row.offsetTop() + row.outerHeight(true)) > hbar.offsetTop()) {
              numberOfRows = i - 1;
            } else if (i == (rowSize - 1))
              numberOfRows = i;
          }
          for (j <- 0 until colSize) { //colSize
            var col: JQuery = jq(cols.get(j));
            if ((col.offsetLeft() + col.outerWidth(true)) > vbar.offsetLeft()) {
              numberOfColumns = j - 1;
            } else if (j == (colSize - 1))
              numberOfColumns = j;
          }
        }

        def checkFlexMin() {
          var rowRange: Int = 0;
          var colRange: Int = 0;
          var row: JQuery = null;
          var col: JQuery = null;
          var listWidth: Int = 0;
          var listHeight: Int = 0;
          click(rdoTwo.$n("real"));
          waitResponse();
  
          checkRange();

          row = jq(jq(biglist.$n("rows")).find("tr").get(numberOfRows));
          col = jq(jq(jq(biglist.$n("rows")).find("tr").get(0)).find("td").get(numberOfColumns));
          listWidth = jq(biglist.$n("body")).offsetLeft() + jq(biglist.$n("body")).outerWidth();
          listHeight = jq(biglist.$n("body")).offsetTop() + jq(biglist.$n("body")).outerHeight();

          println("List size should match the range")
          verifyTolerant(listWidth, col.offsetLeft() + col.outerWidth(), 3)
          verifyTolerant(listHeight, row.offsetTop() + row.outerHeight(), 3)
        }

        def checkFrozen() {
          var col: JQuery = jq(jq(biglist.$n("rows")).find("td").get(0));
          var fxCol: JQuery = null;
          var oldOfsLeft: Int = 0;
          // frozen at column 2
          sel(sbx2, "2");
          waitResponse();
          fxCol = jq(jq(biglist.$n("rowsfx")).find("td").get(1));
          oldOfsLeft = fxCol.offsetLeft();

          click(jq(biglist.$n("hbar")).find(".z-biglistbox-wscroll-down"));
          waitResponse();
          click(jq(biglist.$n("hbar")).find(".z-biglistbox-wscroll-down"));
          waitResponse();
          verifyTrue("First two column should not be moved",
            fxCol.offsetLeft() == oldOfsLeft);
        }
        // check multiple header
        sel(sbx, "MultipleHeader");
        waitResponse();
        verifyTrue("Has multiple header",
          jq(biglist.$n("cols")).find("tr").length() == 3
            && jq(biglist.$n("cols")).find("th:contains(Header x = 1, y = 2)").exists());

        // check single column
        sel(sbx, "SingleColumn");
        waitResponse();
        setValues();
        verifyTrue("Only single column",
          numberOfColumns == 1 && numberOfRows == numberOfCells);

        // check multiple column
        sel(sbx, "MultipleColumn");
        waitResponse();
        setValues();
        verifyTrue("Has multiple column",
          numberOfColumns > 1 && numberOfCells == numberOfColumns * numberOfRows);

        // check single row
        sel(sbx, "SingleRow");
        waitResponse();
        setValues();

        verifyTrue("Only single row",
          numberOfRows == 1 && numberOfColumns == numberOfCells);

        // check multiple row
        sel(sbx, "MultipleRow");
        waitResponse();
        setValues();
        verifyTrue("Has multiple row",
          numberOfRows > 1 && numberOfCells == numberOfColumns * numberOfRows);

        // change to big data
        sel(sbx, "BigData");
        waitResponse();
        checkFlexMin();

        checkFrozen();

        // change col number and row number
        sel(sbx4, "5");
        waitResponse();
        verifyTrue("Change to 5 rows",
          jq(biglist.$n("rowsfx")).find("tr").length() == 5
            && jq(biglist.$n("rows")).find("tr").length() == 5);
        sel(sbx3, "5");
        waitResponse();
        verifyTrue("Change to 5 cols",
          jq(jq(biglist.$n("rowsfx")).find("tr").get(0)).find("td").length()
            + jq(jq(biglist.$n("rows")).find("tr").get(0)).find("td").length() == 5);
      }
    );
  }
}