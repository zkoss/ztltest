import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2024TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2024.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2024TestCafe", async (t) => {
	await ztl.initTest(t);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-combobox")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => zk.Widget.$(jq(".z-combobox")).$n("real")),
		);
	await ztl.waitResponse(t);
	await t.pressKey("s e tab");
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("SE"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq(".z-combobox")).$n("real").value,
				)(),
			),
			"the value should show 'SE'.",
		);
	await t
		.expect(
			await ClientFunction(() => !!jq(".z-label:contains(Sverige)")[0])(),
		)
		.ok("the label should show 'Sverige'");
});
