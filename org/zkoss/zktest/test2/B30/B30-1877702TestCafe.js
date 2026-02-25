import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1877702TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1877702TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<vbox>
					Please select a comboitem, and then press the reset button, and then re-select the previous comboitem, the onSelect event should be fired.
					<combobox id="cb1" constraint="strict"
						onSelect=\'msg.value = "onSelect is fired, " + self.selectedItem.label\'>
						<comboitem label="aaa" value="1" />
						<comboitem label="bbb" value="2" />
					</combobox>
					<label id="msg"/>
					<button id="reset" label="reset" onClick="cb1.selectedIndex = -1; msg.value = &quot;&quot;" />
				</vbox>
			</zk>`,
	);
	await t.click(
		Selector(() => jq(zk.Widget.$(jq(".z-combobox")).$n("btn"))[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-comboitem:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-combobox")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("aaa"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$msg").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("onSelect is fired, aaa"));
	await t.click(Selector(() => zk.Desktop._dt.$f("reset", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-combobox-input").val())(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t.click(
		Selector(() => jq(zk.Widget.$(jq(".z-combobox")).$n("btn"))[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-comboitem:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-combobox")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("aaa"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$msg").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("onSelect is fired, aaa"));
});
