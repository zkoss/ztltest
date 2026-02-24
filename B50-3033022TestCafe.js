import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3033022TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3033022.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3033022TestCafe", async (t) => {
	await ztl.initTest(t);
	let hgh_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tabpanel1", true)).outerHeight(),
	)();
	let tabhgh_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tabpanel2", true)).outerHeight(),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tb2", true).$n("cls")));
	await ztl.waitResponse(t);
	let hgh2_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tabpanel1", true)).outerHeight(),
	)();
	await t
		.expect(ztl.normalizeText(tabhgh_cafe))
		.eql(ztl.normalizeText(hgh2_cafe - hgh_cafe));
	hgh_cafe = hgh2_cafe;
	await t.click(Selector(() => zk.Desktop._dt.$f("tb3", true).$n("cls")));
	await ztl.waitResponse(t);
	hgh2_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tabpanel1", true)).outerHeight(),
	)();
	await t
		.expect(ztl.normalizeText(tabhgh_cafe))
		.eql(ztl.normalizeText(hgh2_cafe - hgh_cafe));
	hgh_cafe = hgh2_cafe;
	await t.click(Selector(() => zk.Desktop._dt.$f("tb4", true).$n("cls")));
	await ztl.waitResponse(t);
	hgh2_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tabpanel1", true)).outerHeight(),
	)();
	await t
		.expect(ztl.normalizeText(tabhgh_cafe))
		.eql(ztl.normalizeText(hgh2_cafe - hgh_cafe));
	hgh_cafe = hgh2_cafe;
	await t.click(Selector(() => zk.Desktop._dt.$f("tb5", true).$n("cls")));
	await ztl.waitResponse(t);
	hgh2_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tabpanel1", true)).outerHeight(),
	)();
	await t
		.expect(ztl.normalizeText(tabhgh_cafe))
		.eql(ztl.normalizeText(hgh2_cafe - hgh_cafe));
});
