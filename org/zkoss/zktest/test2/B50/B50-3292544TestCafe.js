import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3292544TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3292544.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3292544TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.click(Selector(() => zk.Widget.$(jq("@doublespinner")).$n("real")))
		.typeText(
			Selector(() => zk.Widget.$(jq("@doublespinner")).$n("real")),
			ztl.normalizeText("0.5"),
		);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq("@doublespinner")).$n("real").value,
				)(),
			),
		)
		.eql(ztl.normalizeText("0.5"));
});
