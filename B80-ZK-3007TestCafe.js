import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3007TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3007.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3007TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.expect(await ClientFunction(() => !!jq("@grid").eq(0)[0])()).ok();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq("@column").eq(0).outerWidth())(),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq("@row").eq(0).children().eq(0).outerWidth(),
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq("@column").eq(1).outerWidth())(),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq("@row").eq(0).children().eq(1).outerWidth(),
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq("@column").eq(2).outerWidth())(),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq("@row").eq(0).children().eq(2).outerWidth(),
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq("@column").eq(3).outerWidth())(),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq("@row").eq(0).children().eq(3).outerWidth(),
			)(),
		),
		ztl.normalizeText("1"),
	);
});
