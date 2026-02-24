import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2468TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2468.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2468TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-column").eq(0).offset().left)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() => jq(".z-row:eq(0) > .z-cell").eq(0).offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-column").eq(1).offset().left)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() => jq(".z-row:eq(0) > .z-cell").eq(1).offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-column").eq(2).offset().left)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() => jq(".z-row:eq(0) > .z-cell").eq(2).offset().left,
			)(),
		),
		ztl.normalizeText("1"),
	);
});
