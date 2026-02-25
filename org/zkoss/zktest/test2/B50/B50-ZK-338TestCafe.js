import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-338TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-338.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-338TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ff,edge_legacy")) {
		console.log(
			"This issue is ignored in current browser! (ff,edge_legacy)",
		);
		return;
	}
	await t.click(Selector(() => jq(".z-timebox-up")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@label")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$log")[0]));
	await ztl.waitResponse(t);
	let origin_cafe = await ClientFunction(() =>
		jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
	)();
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await t.doubleClick(
		Selector(() => jq(".z-timebox-input")[0]),
		{ offsetX: 3, offsetY: 3 },
	);
	await ztl.waitResponse(t);
	await t.pressKey("right");
	await ztl.waitResponse(t);
	await t.pressKey("right");
	await ztl.waitResponse(t);
	await t.pressKey("right");
	await ztl.waitResponse(t);
	await t.pressKey("up");
	await ztl.waitResponse(t);
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t.pressKey("down");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$log")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText(origin_cafe));
});
