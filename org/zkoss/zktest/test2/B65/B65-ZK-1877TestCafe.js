import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1877TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1877TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1877.zul

	Purpose:
		
	Description:
		
	History:
		Thu, Aug 01, 2013  9:40:21 AM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
<label multiline="true">
1. Please drag the slider to the right-most.
2. Please drag the slider to the left-most.
3. You should see the curpos stays in 0, not 1.
</label>
<grid>
	<rows>                                                                 
		<row>
			<cell width="70px">
				<label value="curpos:" />
				<label id="lblAlpha" />
			</cell>
			<cell>
				<slider id="slider" onScroll="lblAlpha.setValue(String.valueOf(self.getCurpos()))" />
			</cell>
		</row>
	</rows>
</grid>
</zk>`,
	);
	await t.drag(
		Selector(() => zk.Widget.$(jq(".z-slider-horizontal")).$n("btn")),
		220,
		0,
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => zk.Widget.$(jq(".z-slider-horizontal")).$n("btn")),
		-220,
		0,
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label:contains(curpos:) + .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(
			ztl.normalizeText("0"),
			"You should see the curpos stays in 0",
		);
});
