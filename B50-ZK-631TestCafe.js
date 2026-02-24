import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-631TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-631.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-631TestCafe", async (t) => {
	await ztl.initTest(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(zk.Desktop._dt.$f("dob", true).$n()).find("input"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(
				() => jq(zk.Desktop._dt.$f("dob", true).$n()).find("input")[0],
			),
		);
	await ztl.waitResponse(t);
	await t
		.pressKey("a b c")
		.click(Selector(() => zk.Desktop._dt.$f("doberr", true).$n()));
	await ztl.waitResponse(t);
	let errMsg_cafe = await ClientFunction(
		() => zk.Desktop._dt.$f("doberr", true).$n().innerHTML,
	)();
	await t
		.expect(ztl.normalizeText(errMsg_cafe))
		.contains(
			ztl.normalizeText("abc"),
			"should display custom error about date format",
		);
	await t
		.expect(ztl.normalizeText(errMsg_cafe))
		.contains(
			ztl.normalizeText("yyyy/MM/dd"),
			"should display custom error about date format",
		);
});
