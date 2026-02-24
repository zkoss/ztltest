import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2739TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2739TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2739.zul

	Purpose:

	Description:

	History:
		Fri, Jun 5, 2015  14:30:29 PM, Created by Jameschu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<window border="normal" title="Test" height="500px"
		contentStyle="overflow-y:scroll;" mode="modal">
		<vlayout spacing="10px">
			<textbox />
			<label multiline="true">
    			1. Click one of the buttons in the end of the page, one new modal is created.
    			2. Click \'close\'
    			3. The focus must return to the last element focused in the previous popup.(Must test in Chrome)
			</label>
			<hlayout>
				<textbox />
				<button label="Open Modal button without autodisabled" onFocus=\'Clients.log(self.label)\'
					onClick=\'Executions.createComponents("test2/B70-ZK-2739_1.zul", null, null)\' />
			</hlayout>
			<hlayout>
				<textbox />
				<button label="Open Modal button with autodisabled" onFocus=\'Clients.log(self.label)\'
					onClick=\'Executions.createComponents("test2/B70-ZK-2739_1.zul", null, null)\' autodisable="self" />
			</hlayout>
		</vlayout>
	</window>
</zk>`,
	);
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@window").last().find("@button")[0]));
	await ztl.waitResponse(t);
	await t.wait(200);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@button").eq(0).text().replace(/\s/g, " "),
				)(),
			),
		);
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(1)[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@window").last().find("@button")[0]));
	await ztl.waitResponse(t);
	await t.wait(200);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@button").eq(1).text().replace(/\s/g, " "),
				)(),
			),
		);
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
});
