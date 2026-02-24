import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2026493TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-2026493.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-2026493TestCafe", async (t) => {
	await ztl.initTest(t);
	let body_cafe = await ClientFunction(() =>
		jq("tbody:eq(0)").outerHeight(),
	)();
	let paging_cafe = await ClientFunction(() =>
		jq(".z-paging").parent().outerHeight(),
	)();
	let listbox_cafe = await ClientFunction(() =>
		jq("div.z-listbox").outerHeight(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(listbox_cafe),
		ztl.normalizeText(body_cafe + paging_cafe),
		ztl.normalizeText("3"),
	);
});
