import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2874039TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-2874039.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-2874039TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$change")[0]));
	await ztl.waitResponse(t);
	let bug_cafe = await ClientFunction(() =>
		jq(jq(".z-center-header")).text().replace(/\s/g, " "),
	)();
	await t.expect(ztl.normalizeText("Bug")).eql(ztl.normalizeText(bug_cafe));
	let h_cafe = await ClientFunction(() => zk("$listbox").hasHScroll())();
	await ztl.waitResponse(t);
	await t.expect(ztl.normalizeText("false")).eql(ztl.normalizeText(h_cafe));
	let h1_cafe = await ClientFunction(() =>
		zk(zk.Widget.$(jq("$listbox")).$n("body")).hasHScroll(),
	)();
	await t.expect(ztl.normalizeText("false")).eql(ztl.normalizeText(h1_cafe));
});
