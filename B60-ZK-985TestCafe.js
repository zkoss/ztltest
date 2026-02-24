import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-985TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-985.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-985TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		jq(zk.Desktop._dt.$f("tbx", true))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("tbx", true).$n()),
		ztl.normalizeText("asdf"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("lb", true)).html(),
				)(),
			),
		)
		.contains(ztl.normalizeText("asdf"), "Textbox should not be cleared");
});
