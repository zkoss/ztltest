import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3004412TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3004412.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3004412TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t.click(Selector(() => zk.Desktop._dt.$f("cb", true).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.hover(Selector(() => zk.Desktop._dt.$f("cbi", true).$n()))
		.wait(1000);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("popup", true)).is(":visible"),
			)(),
		)
		.ok();
	let zindex_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("cb", true).$n("pp")).css("z-index"),
	)();
	let ppZindex_cafe = parseInt(zindex_cafe);
	zindex_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("popup", true)).css("z-index"),
	)();
	let popipZindex_cafe = parseInt(zindex_cafe);
	await t.expect(popipZindex_cafe > ppZindex_cafe).ok();
});
