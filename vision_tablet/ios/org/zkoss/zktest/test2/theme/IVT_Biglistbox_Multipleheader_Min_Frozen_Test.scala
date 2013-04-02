package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Biglistbox_Multipleheader_Min_Frozen_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<zscript><![CDATA[
		import org.zkoss.zkdemo.userguide.*;
		import org.zkoss.util.*;
		import org.zkoss.zul.*;
		
		FakerMatrixModel multipleHeader = new FakerMatrixModel(10, 10, 3);
	]]></zscript>
	
	<vlayout vflex="1">
		<biglistbox id="biglist" 
			model="${multipleHeader}"
			hflex="min" vflex="min"
			fixFrozenCols="true"
			frozenCols="3"
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
