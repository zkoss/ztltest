import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2694TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2694TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2694.zul

	Purpose:

	Description:

	History:
		Tue Jun  9 09:26:34 CST 2015, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<custom-attributes org.zkoss.zul.nativebar="false"/>
	<borderlayout height="400px" width="600px">
		<west size="150px">
		<label multiline="true">
		1. Please click the first "div toggle tree on click"
		2. Open tree item "1", "1.1", "2" and then close "1"
		3. Open tree item "2.1" and then open "1"
		4. You should see a scrollbar appears
		</label>
		</west>
		<center autoscroll="true" id="center">
			<grid id="grid">
				<rows>
					<row>
						<cell>
							<div onClick="inc1.setVisible(!inc1.isVisible())">div toggle tree on click</div>
							<include src="test2/B70-ZK-2694_1.zul" id="inc1" visible="false"/>
						</cell>
					</row>
					<row>
						<cell>
							<div onClick="inc2.setVisible(!inc2.isVisible())">div toggle tree on click</div>
							<include src="test2/B70-ZK-2694_1.zul" id="inc2" visible="false"/>
						</cell>
					</row>
					<row>
						<cell>
							<div onClick="inc3.setVisible(!inc3.isVisible())">div toggle tree on click</div>
							<include src="test2/B70-ZK-2694_1.zul" id="inc3" visible="false"/>
						</cell>
					</row>
				</rows>
			</grid>
		</center>
		<east size="150px">
		</east>
	</borderlayout>

</zk>`,
	);
	await t.click(Selector(() => jq("@div")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq('.z-treecell :contains("1")').find(".z-tree-icon")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq('.z-treecell :contains("1.1")').find(".z-tree-icon")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq('.z-treecell :contains("2")').find(".z-tree-icon").last()[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq('.z-treecell :contains("1")').find(".z-tree-icon")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq('.z-treecell :contains("2.1")').find(".z-tree-icon")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq('.z-treecell :contains("1")').find(".z-tree-icon")[0],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ztl.hasVScrollbar({
				locator: Selector(() => jq("@center")[0]),
			}),
		)
		.ok();
});
