import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2974364TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2974364TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
					<html><![CDATA[
					<ul>
					 <li>Click siwtchStyle then the text shall become green and bold</li>
					 <li>Click again and the text shall become black and normal</li>
					</ul>
					]]></html>
					<bandbox id="bb" value="something">
					<bandpopup>
					<listbox width="100px">
					<listitem label="A" />
					<listitem label="B" />
					<listitem label="C" />
					</listbox>
					</bandpopup>
					</bandbox>
					<button id="btn" label="switchStyle" onClick="switchStyle()" />
					<zscript>
					void switchStyle() {
					Object tag = btn.getAttribute("tag");
					if (tag == null) {
					btn.setAttribute("tag", "1");
					bb.setStyle("color:green;font-weight:bold");
					} else {
					btn.removeAttribute("tag");
					bb.setStyle("");
					}
					}
					</zscript>
				</zk>`,
	);
	let origColor_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("bb", true).$n("real")).css("color"),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ztl.isEqualColor(
				ztl.normalizeText("green"),
				ztl.normalizeText(
					await ClientFunction(() =>
						jq(zk.Desktop._dt.$f("bb", true).$n("real")).css(
							"color",
						),
					)(),
				),
			),
		)
		.ok();
	await t
		.expect(ztl.normalizeText("700bold"))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("bb", true).$n("real")).css(
						"font-weight",
					),
				)(),
			),
			"",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("bb", true).$n("real")).css("color"),
				)(),
			),
		)
		.eql(ztl.normalizeText(origColor_cafe));
	await t
		.expect(ztl.normalizeText("400normal"))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("bb", true).$n("real")).css(
						"font-weight",
					),
				)(),
			),
			"",
		);
});
