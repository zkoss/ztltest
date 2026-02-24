import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3147909TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3147909.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3147909TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.drag(
		Selector(() => jq(zk.Desktop._dt.$f("inner", true))[0]),
		7,
		0,
		{ offsetX: 3, offsetY: 3 },
	);
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("inner", true)).height(),
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(() => jq("$h").text().replace(/\s/g, " "))(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("100"),
		ztl.normalizeText(
			await ClientFunction(() => jq("$w").text().replace(/\s/g, " "))(),
		),
		ztl.normalizeText("1"),
	);
});
