import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2721780TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2721780TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			Resize the outer window, the inner most window should not change.
			<window id="out" border="normal" title="." sizable="true"
			  mode="overlapped" width="500px" height="500px">
			  <window id="middle" border="normal" width="300px" height="300px">
			    <window id="innermost" border="normal" width="100px"
			      height="100px" sizable="true" mode="overlapped">
			
			    </window>
			  </window>
			</window>
			</zk>`,
	);
	let oldHeight_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("innermost", true)).outerHeight(),
	)();
	let oldWidth_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("innermost", true)).outerWidth(),
	)();
	await t.drag(
		Selector(() => zk.Widget.$(jq("$out")).$n("cap")),
		98,
		98,
		{ offsetX: 2, offsetY: 2 },
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("innermost", true)).outerHeight(),
				)(),
			),
		)
		.eql(ztl.normalizeText(oldHeight_cafe));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("innermost", true)).outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText(oldWidth_cafe));
});
