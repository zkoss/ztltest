import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3025674TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3025674.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3025674TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(ztl.normalizeText(""))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("msg", true).getValue(),
				)(),
			),
		);
});
