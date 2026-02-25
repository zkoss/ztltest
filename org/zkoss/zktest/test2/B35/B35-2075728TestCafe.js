import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2075728TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2075728TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Test PortalLayout" border="normal">
	<groupbox open="false"><caption label="instructions(click to open)"/><html><![CDATA[  
Test Protal base Functionativity <br/>
1.After initl, there should have 4 column, column 1 and 3 is empty <br/>
2.Click button, then element in column 2, 4 should mvoe to column 1, 2 <br/>
3.You should able to darg any panel to column 3,4 still. <br/>
]]></html></groupbox>
	<zscript><![CDATA[//@IMPORT
	]]>
	<![CDATA[//@DECLARATION
	]]>
	<![CDATA[
	]]></zscript>
	<button id="btn" label="move" onClick="p1.parent=c1;p2.parent=c1;p3.parent=c2;p4.parent=c2"/>
	<portallayout>
		<portalchildren width="25%" id="c1">
		</portalchildren>
		<portalchildren width="25%" id="c2">
			<panel height="70px" title="Bandbox" id="p1">
				<panelchildren id="pc1">
					AA
				</panelchildren>
			</panel>
			<panel height="200px" title="Combobox" id="p2">
				<panelchildren id="pc2">
					BB
				</panelchildren>
			</panel>
		</portalchildren>
		<portalchildren width="25%" id="c3">
		</portalchildren>
		<portalchildren width="25%" id="c4">
			<panel height="70px" title="Bandbox" id="p3">
				<panelchildren id="pc3">
					CC
				</panelchildren>
			</panel>
			<panel height="200px" title="Combobox" id="p4">
				<panelchildren id="pc4">
					DD
				</panelchildren>
			</panel>
		</portalchildren>
	</portallayout>
</window>`,
	);
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("$c1")[0])()).ok();
	await t.expect(await ClientFunction(() => !!jq("$c2")[0])()).ok();
	await t.expect(await ClientFunction(() => !!jq("$c3")[0])()).ok();
	await t.expect(await ClientFunction(() => !!jq("$c4")[0])()).ok();
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => zk.Widget.$(jq("$c1")).nChildren,
	)();
	await t.expect(verifyVariable_cafe_0_0 == 0).ok();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => zk.Widget.$(jq("$c2")).nChildren,
	)();
	await t.expect(verifyVariable_cafe_1_1 > 0).ok();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => zk.Widget.$(jq("$c3")).nChildren,
	)();
	await t.expect(verifyVariable_cafe_2_2 == 0).ok();
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() => zk.Widget.$(jq("$c4")).nChildren,
	)();
	await t.expect(verifyVariable_cafe_3_3 > 0).ok();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_4_4 = await ClientFunction(
		() => zk.Widget.$(jq("$c1")).nChildren,
	)();
	await t.expect(verifyVariable_cafe_4_4 > 0).ok();
	await t
		.expect(ztl.normalizeText("p1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq("$c1")).firstChild.id,
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("p2"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq("$c1")).lastChild.id,
				)(),
			),
		);
	let verifyVariable_cafe_5_5 = await ClientFunction(
		() => zk.Widget.$(jq("$c2")).nChildren,
	)();
	await t.expect(verifyVariable_cafe_5_5 > 0).ok();
	await t
		.expect(ztl.normalizeText("p3"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq("$c2")).firstChild.id,
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("p4"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq("$c2")).lastChild.id,
				)(),
			),
		);
	let verifyVariable_cafe_6_6 = await ClientFunction(
		() => zk.Widget.$(jq("$c3")).nChildren,
	)();
	await t.expect(verifyVariable_cafe_6_6 == 0).ok();
	let verifyVariable_cafe_7_7 = await ClientFunction(
		() => zk.Widget.$(jq("$c4")).nChildren,
	)();
	await t.expect(verifyVariable_cafe_7_7 == 0).ok();
	let l_cafe = await ClientFunction(() => jq("$c3").offset().left)();
	let actionVariable_cafe_0_8 = await ClientFunction(
		() => jq("$c1").offset().left,
	)();
	let actionVariable_cafe_1_9 = await ClientFunction(
		() => jq("$c1").offset().left,
	)();
	let cafeCoord_1 = await ztl.convertCoordStrToArr(l_cafe + "," + 10);

	let cafeCoord_2 = await ztl.convertCoordStrToArr(
		actionVariable_cafe_0_8 + "," + 10,
		true,
	);

	await t.drag(
		Selector(() => jq(".z-panel-header-move:eq(0)")[0]),
		cafeCoord_1[0] - cafeCoord_2[0],
		cafeCoord_1[1] - cafeCoord_2[1],
		{ offsetX: cafeCoord_2[0], offsetY: cafeCoord_2[1] },
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_8_10 = await ClientFunction(
		() => zk.Widget.$(jq("$c1")).nChildren,
	)();
	await t.expect(verifyVariable_cafe_8_10 == 1).ok();
	await t
		.expect(ztl.normalizeText("p2"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq("$c1")).firstChild.id,
				)(),
			),
		);
	let verifyVariable_cafe_9_11 = await ClientFunction(
		() => zk.Widget.$(jq("$c3")).nChildren,
	)();
	await t.expect(verifyVariable_cafe_9_11 == 1).ok();
	await t
		.expect(ztl.normalizeText("p1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq("$c3")).firstChild.id,
				)(),
			),
		);
});
