import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B86-ZK-3938TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-3938.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-3938TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		document.body.style.zoom = "125%";
	})();
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq("@listheader").eq(2).offset().left)(),
		),
		ztl.normalizeText(
			await ClientFunction(() => jq("@listcell").eq(2).offset().left)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq("@listheader").eq(3).offset().left)(),
		),
		ztl.normalizeText(
			await ClientFunction(() => jq("@listcell").eq(3).offset().left)(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq("@listheader").eq(4).offset().left)(),
		),
		ztl.normalizeText(
			await ClientFunction(() => jq("@listcell").eq(4).offset().left)(),
		),
		ztl.normalizeText("1"),
	);
	await ClientFunction(() => {
		document.body.style.zoom = "100%";
	})();
	await ztl.waitResponse(t);
});
