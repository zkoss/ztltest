import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B102-ZK-4861TestCafe`
	.page`http://localhost:8080/zktest/test2/B102-ZK-4861.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B102-ZK-4861TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-timebox-input")[0]));
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-timebox-input")))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Widget.$(jq(".z-timebox-input")).$n()));
	await ztl.waitResponse(t);
	await t.pressKey(
		"backspace backspace backspace backspace backspace backspace f o o b a r",
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-timebox-input")[0].value)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t.expect("false").ok();
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-timebox-input")))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Widget.$(jq(".z-timebox-input")).$n()));
	await ztl.waitResponse(t);
	await t.pressKey(
		"backspace backspace backspace backspace backspace backspace 0 5 : 1 6",
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-timebox-input")[0].value)(),
			),
		)
		.eql(ztl.normalizeText("05:16"));
	await t.expect("true").ok();
});
