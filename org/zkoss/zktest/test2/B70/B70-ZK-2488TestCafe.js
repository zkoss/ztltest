import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2488TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2488TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
		1. you should see the circle icon display at label\'s left
	</label>
	<groupbox closable="true" title="Groupbox">
		<caption iconSclass="z-icon-circle">
			<label value="Test-Label" />
		</caption>
		caption in groupbox
	</groupbox>
	<separator />
	<tabbox>
		<tabs>
			<tab>
				<caption iconSclass="z-icon-circle">
					<label value="Test-Label" />
				</caption>
			</tab>
		</tabs>
		<tabpanels>
			<tabpanel>caption in tabbox/tab</tabpanel>
		</tabpanels>
	</tabbox>
	<separator />
	<panel closable="true" minimizable="true"  title="Panel">
		<caption iconSclass="z-icon-circle">
			<label value="Test-Label" />
		</caption>
		<panelchildren>caption in panel</panelchildren>
	</panel>
	<separator />
	<window closable="true" minimizable="true"  title="Window">
		<caption iconSclass="z-icon-circle">
			<label value="Test-Label" />
		</caption>
		caption in window
	</window>
</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-caption-content").eq(0).position().left,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-caption-content>.z-label").eq(0).position().left,
	)();
	await t.expect(verifyVariable_cafe_0_0 < verifyVariable_cafe_1_1).ok();
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() => jq(".z-caption-content").eq(1).position().left,
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(
		() => jq(".z-caption-content>.z-label").eq(1).position().left,
	)();
	await t.expect(verifyVariable_cafe_0_0t < verifyVariable_cafe_1_1t).ok();
	let verifyVariable_cafe_0_0tt = await ClientFunction(
		() => jq(".z-caption-content").eq(2).position().left,
	)();
	let verifyVariable_cafe_1_1tt = await ClientFunction(
		() => jq(".z-caption-content>.z-label").eq(2).position().left,
	)();
	await t.expect(verifyVariable_cafe_0_0tt < verifyVariable_cafe_1_1tt).ok();
	let verifyVariable_cafe_0_0ttt = await ClientFunction(
		() => jq(".z-caption-content").eq(3).position().left,
	)();
	let verifyVariable_cafe_1_1ttt = await ClientFunction(
		() => jq(".z-caption-content>.z-label").eq(3).position().left,
	)();
	await t
		.expect(verifyVariable_cafe_0_0ttt < verifyVariable_cafe_1_1ttt)
		.ok();
});
