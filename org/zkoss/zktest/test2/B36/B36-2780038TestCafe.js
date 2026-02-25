import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2780038TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2780038TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				Please check both images showing by pressing the two button.
				<button label="Zhtml click" onClick=\'org.zkoss.zul.Messagebox.show("are you sure to quit?","title",16|32,org.zkoss.zhtml.Messagebox.INFORMATION);\'/>
				<button label="zul click" onClick=\'org.zkoss.zul.Messagebox.show("are you sure to quit?","title",16|32,org.zkoss.zul.Messagebox.INFORMATION);\'/>
			</zk>`,
	);
	await t.click(Selector(() => jq('@button[label="Zhtml click"]')[0]));
	await ztl.waitResponse(t);
	let zHtmlClass_cafe = await ClientFunction(() =>
		jq(".z-mssagebox-window").attr("class"),
	)();
	await t.click(
		Selector(() =>
			zk.Widget.$(jq("@window.z-window-highlighted")).$n("close"),
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('@button[label="zul click"]')[0]));
	await ztl.waitResponse(t);
	let zulClass_cafe = await ClientFunction(() =>
		jq(".z-mssagebox-window").attr("class"),
	)();
	await t.click(
		Selector(() =>
			zk.Widget.$(jq("@window.z-window-highlighted")).$n("close"),
		),
	);
	await t
		.expect(ztl.normalizeText(zulClass_cafe))
		.eql(ztl.normalizeText(zHtmlClass_cafe));
});
