import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2389TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2389TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<zk>
	<div>
		if you see the javascript error after clicking add button, it\'s a bug.
	</div>
	<hlayout id="layout">
	    <button label="add" onClick="layout.appendChild(new Popup());" />
	</hlayout>
</zk>`,
	);
	await t.click(
		Selector(() => jq("@button")[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
