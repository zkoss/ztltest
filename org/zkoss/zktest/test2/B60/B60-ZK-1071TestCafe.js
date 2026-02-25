import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1071TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-1071.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-1071TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-bandbox")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listcell:contains(B)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq(".z-bandbox")).$n("real").value,
				)(),
			),
		)
		.eql(ztl.normalizeText("B"), "the bandbox value should become 'B'");
	await t.click(Selector(() => jq(".z-button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-messagebox-window .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(
			ztl.normalizeText("value:B"),
			"it should pop up a 'value:B' messagebox",
		);
});
