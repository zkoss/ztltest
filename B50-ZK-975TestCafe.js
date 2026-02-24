import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-975TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-975.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-975TestCafe", async (t) => {
	await ztl.initTest(t);
	let width0_cafe = await ClientFunction(() =>
		jq(".z-textbox:eq(0)").width(),
	)();
	let width1_cafe = await ClientFunction(() =>
		jq(".z-textbox:eq(1)").width(),
	)();
	let width2_cafe = await ClientFunction(() =>
		jq(".z-textbox:eq(2)").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(width0_cafe),
		ztl.normalizeText(width1_cafe),
		ztl.normalizeText("10"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(width0_cafe),
		ztl.normalizeText(width2_cafe),
		ztl.normalizeText("10"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(width1_cafe),
		ztl.normalizeText(width2_cafe),
		ztl.normalizeText("10"),
	);
});
