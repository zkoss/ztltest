package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Biglistbox_Multiplecolumn_1_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<zscript><![CDATA[
		import org.zkoss.zkdemo.userguide.*;
		import org.zkoss.util.*;
		import org.zkoss.zul.*;
		
		FakerMatrixModel multipleColumn = new FakerMatrixModel(15, 10);
	]]></zscript>
	
	<vlayout vflex="1">
		<biglistbox id="biglist" 
			model="${multipleColumn}"
			hflex="1" vflex="1"
			fixFrozenCols="false"
			frozenCols="0"
			colWidth="130px" >
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
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
