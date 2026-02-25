import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2926128TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2926128TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
					1. The Datebox below should has value inside
					<separator/>
					2. Click this <button id="btn1" label="Set Null Value" onClick="db.setValue(null);"/>, the Datebox below should become empty
					<separator/>
					3. Click this <button id="btn2" label="Get Datebox Value" onClick="alert(db.getValue());"/>, it will popup a window, and the text inside should be "null"
					<separator/>
					4. Click this <button id="btn3" label="Set Current Date" onClick="db.setValue(new Date())"/>, the Datebox should set current date. And doesn\'t popup a Calendar. If a Calendar popup, it\'s wrong.
					<separator/>
					<datebox id="db" onCreate="db.setValue(new Date());"/>
				</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-datebox")).$n("real")).val(),
				)(),
			),
		)
		.notEql(ztl.normalizeText(""), "");
	let x_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-datebox")).$n("real")).val(),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-datebox")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-window-highlighted .z-messagebox .z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("null"));
	await t.click(Selector(() => jq(".z-window-highlighted .z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn3", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-datebox")).$n("real")).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText(x_cafe));
});
