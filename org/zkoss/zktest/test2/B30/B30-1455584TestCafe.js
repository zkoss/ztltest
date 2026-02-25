import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1455584TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1455584TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<vbox>
				Click "hello world", if you see the message change, it is ok.
				<zscript>
				public void doCreate(Event evt) {
					evt.target.setValue("    hello,\\n  world");
				}
				public void doClick(Event evt) {
					evt.target.setValue("    I have\\n  been   clicked");
				}
			</zscript>
				<label id="l1" onCreate="doCreate(event);" onClick="doClick(event)"
					style="font-family: monospace; white-space: pre;" />
				<label id="l2" onCreate="doCreate(event);" onClick="doClick(event)"
					pre="true" />
			</vbox>`,
	);
	let strClickBefor_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("l1", true)).text().replace(/\s/g, " "),
	)();
	await t.click(
		Selector(() => zk.Desktop._dt.$f("l1", true).$n()),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	let strClickAfter_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("l1", true)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("l1", true))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.notEql(ztl.normalizeText(strClickBefor_cafe), "");
	strClickBefor_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("l2", true)).text().replace(/\s/g, " "),
	)();
	await t.click(
		Selector(() => zk.Desktop._dt.$f("l2", true).$n()),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("l2", true))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.notEql(ztl.normalizeText(strClickBefor_cafe), "");
});
