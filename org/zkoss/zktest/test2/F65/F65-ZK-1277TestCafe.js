import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F65-ZK-1277TestCafe`
	.page`http://localhost:8080/zktest/test2/F65-ZK-1277.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F65-ZK-1277TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-row").outerHeight())(),
		),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-group").outerHeight())(),
		),
		ztl.normalizeText("3"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-groupfoot").outerHeight())(),
		),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-group").outerHeight())(),
		),
		ztl.normalizeText("3"),
	);
	await t.click(Selector(() => jq(".z-button:contains(Autopaging)")[0]));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-row").outerHeight())(),
		),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-group").outerHeight())(),
		),
		ztl.normalizeText("3"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-groupfoot").outerHeight())(),
		),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-group").outerHeight())(),
		),
		ztl.normalizeText("3"),
	);
});
