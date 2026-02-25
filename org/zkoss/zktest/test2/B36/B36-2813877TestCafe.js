import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2813877TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-2813877.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-2813877TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq('@button[label="Overlap"]')[0]));
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("$win")[0]),
		278,
		6,
		{ offsetX: 341, offsetY: 292 },
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq("@caption")[0]),
		2,
		47,
		{ offsetX: 174, offsetY: 19 },
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('@button[label="Embed"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('@button[label="Popup"]')[0]));
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => zk.Widget.$(jq("$win")).$n("cave")),
		305,
		-4,
		{ offsetX: 349, offsetY: 222 },
	);
	await ztl.waitResponse(t);
});
