import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2280258TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2280258.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2280258TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	let ce1_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq("$hb")).firstChild.$n("chdex")).width(),
	)();
	let ce2_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq("$hb")).lastChild.$n("chdex")).width(),
	)();
	let c1t_cafe = await ClientFunction(() =>
		jq(jq(zk.Widget.$(jq("$hb")).firstChild))
			.text()
			.replace(/\s/g, " "),
	)();
	let c2t_cafe = await ClientFunction(() =>
		jq(jq(zk.Widget.$(jq("$hb")).lastChild))
			.text()
			.replace(/\s/g, " "),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(parseInt(c1t_cafe)),
		ztl.normalizeText(ce1_cafe),
		ztl.normalizeText("2"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(parseInt(c2t_cafe)),
		ztl.normalizeText(ce2_cafe),
		ztl.normalizeText("2"),
	);
});
