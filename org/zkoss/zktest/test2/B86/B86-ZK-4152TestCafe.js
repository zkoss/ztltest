import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B86-ZK-4152TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-4152.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-4152TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("chrome,safari,edge_legacy,ie11,ie10,ie9")) {
		console.log(
			"This issue is ignored in current browser! (chrome,safari,edge_legacy,ie11,ie10,ie9)",
		);
		return;
	}
	await t.drag(
		Selector(() => jq(".z-label")[1]),
		5,
		120,
	);
	await ztl.waitResponse(t);
	await t.wait(500);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("dropped: Drag me"));
});
