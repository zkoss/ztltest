import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-2202620TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2202620TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
				After click
				<button id="btn" label="start" onClick="org.zkoss.zktest.test2.B2202620.start(info)"/>
				You shall see only one message (Comet received) below
				<separator/>
				<div id="info" style="border: 1px solid blue"/>
			</window>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("span.z-label:gt(1)").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("span.z-label:gt(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Comet received"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("span.z-label:gt(2)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
});
