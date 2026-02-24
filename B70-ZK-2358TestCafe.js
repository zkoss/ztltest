import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2358TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2358.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2358TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq("@listitem").first().find("@listcell").last().offset()
						.left,
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() => jq("@listheader").last().offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
});
