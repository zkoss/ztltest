import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2202TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2202.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2202TestCafe", async (t) => {
	await ztl.initTest(t);
	let value_cafe = await ClientFunction(
		() => zk.Widget.$(jq(".z-datebox")).$n("real").value,
	)();
	await t.click(Selector(() => zk.Widget.$(jq(".z-datebox")).$n("btn")));
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-timebox")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Widget.$(jq(".z-timebox")).$n("real")));
	await ztl.waitResponse(t);
	await t.pressKey("home right right right up enter");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq(".z-datebox")).$n("real").value,
				)(),
			),
		)
		.notEql(
			ztl.normalizeText(value_cafe),
			"the value of datebox should be updated",
		);
});
