import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-1322TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-1322.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-1322TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@timebox")[0]));
	await ztl.waitResponse(t);
	let time_cafe = await ClientFunction(
		() => zk.Widget.$(jq(".z-timebox")).$n("real").value,
	)();
	await t.pressKey("home").wait(1000);
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
	await t.pressKey("1 2 2 2 2 2").wait(1000);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(""))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq(".z-timebox")).$n("real").value,
				)(),
			),
		);
});
