import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2961834TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2961834TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<html>		
					<![CDATA[ <ol> <li>Press "r" in combobox.</li> <li>Combobox
					shall select "Richard" automatically</li> <li>Press "Hello"
					button. If you see the combobox show "r" again, it is a
					Bug.</li> </ol> ]]>		
				</html>
				<combobox id="mycombo" value="" constraint="strict, no empty">
					<comboitem id="i1" label="David" />
					<comboitem id="i2" label="Richard" />
					<comboitem id="i3" label="Tom" />
				</combobox>
				<button id="btn" label="Hello">
					<attribute name="onClick">
						new Comboitem("Henri").setParent(mycombo);
					</attribute>
				</button>
			</zk>`,
	);
	await ClientFunction(() => {
		zk.Desktop._dt.$f("mycombo", true).$n("real").focus();
	})();
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("mycombo", true).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => zk.Desktop._dt.$f("mycombo", true).$n("real")),
		);
	await ztl.waitResponse(t);
	await t.pressKey("R");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-combobox")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Richard"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-combobox")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Richard"));
});
