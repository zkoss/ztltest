package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Biglistbox_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vlayout vflex="1">
	<label style="font-weight:bold">This feature only support on IE8+, Firefox, Chrome, Safari, and Opera</label>
	<zscript>
	<![CDATA[
	import org.zkoss.util.Pair;
	import org.zkoss.zktest.test2.big.FakerMatrixModel;

	ListModel NonHeader 	 = new FakerMatrixModel(10, 10, 0);
	ListModel MultipleHeader = new FakerMatrixModel(10, 10, 3);
	ListModel SingleColumn 	 = new FakerMatrixModel(1, 10);
	ListModel MultipleColumn = new FakerMatrixModel(100, 10);
	ListModel HugeColumn 	 = new FakerMatrixModel(10000, 10);
	ListModel SingleRow 	 = new FakerMatrixModel(10, 1);
	ListModel MultipleRow 	 = new FakerMatrixModel(10, 100);
	ListModel HugeRow 		 = new FakerMatrixModel(10, 10000);
	ListModel BigData 		 = new FakerMatrixModel(1000000, 1000000);

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
			<selectbox model="${modelList}">
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
				<radio label="1" checked="true"/>
				<radio label="min"/>
			</radiogroup>
		</hlayout>
		<hlayout valign="bottom">
			Change fixForzenCols:
			<radiogroup onCheck='biglist.fixFrozenCols = self.selectedItem.label.equals("Enable") '>
				<radio label="Disable" checked="true"/>
				<radio label="Enable"/>
			</radiogroup>
			Change frozenCols:
			<selectbox model="${tenSize}">
				<attribute name="onSelect">
				if (self.selectedIndex > biglist.cols -1) {
					self.selectedIndex = self.selectedIndex - 1;
					alert("FrozenCols cannot be greater than Cols");
				} else
					biglist.frozenCols = self.selectedIndex
				</attribute>
			</selectbox>
			Change cols: 
			<selectbox model="${colsSize}">
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
			<selectbox model="${rowsSize}" onSelect="biglist.autoRows = false;biglist.rows = event.selectedObjects.iterator().next()"/>
		</hlayout>
		<hlayout valign="bottom">
			Invalidate should look the same as before: <button label="invalidate" onClick="biglist.invalidate()"/>
		</hlayout>
	</vlayout>
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
</vlayout>
		""";

		runZTL(zscript,
			() => {
				// Nonheader
				verifyImage();
				
				// Multiple header
				select(jq("select:eq(0)"), 1);
				sleep(500);
				verifyImage();
				
				// Single Column
				select(jq("select:eq(0)"), 2);
				sleep(500);
				verifyImage();
				
				// Multiple Column
				select(jq("select:eq(0)"), 3);
				sleep(500);
				verifyImage();
				
				// Single Row
				select(jq("select:eq(0)"), 5);
				sleep(500);
				verifyImage();
				
				// Multiple Row
				select(jq("select:eq(0)"), 6);
				sleep(500);
				verifyImage();
				
				// Change frozen columns to 1
				select(jq("select:eq(1)"), 1);
				sleep(500);
				verifyImage();
			});
	}
}