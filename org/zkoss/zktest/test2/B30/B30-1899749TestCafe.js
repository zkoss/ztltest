import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1899749TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1899749TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Test of Progressmetter">
	<html><![CDATA[
<p>At beginning, it shall be 30%.</p>
Case 1:
<ol>
<li>Click "width 200" and it shall scale correctly.</li>
<li>Click "hide", then "set 80", then, "show" and it shall be 80%.</li>
<li>Click "hide", then "width 100", then, "show" and it shall be 80% and 100px width.</li>
</ol>
Case 2: With IE6,
<ol>
<li>Click "set 80", "width 200" and "width 100"</li>
</li>
	]]></html>

	<div id="sp">
		<progressmeter width="100px" id="pm" value="30"/>
	</div>
	<button label="set 0" onClick="pm.setValue(0)"/>
	<button label="set 10" onClick="pm.setValue(10)"/>
	<button label="set 80" onClick="pm.setValue(80)"/>
	<button label="set 100" onClick="pm.setValue(100)"/>
	<button label="width 200">
		<attribute name="onClick">pm.setWidth("200px")</attribute>
	</button>
	<button label="width 100">
		<attribute name="onClick">pm.setWidth("100px")</attribute>
	</button>
	<button label="hide" onClick="sp.setVisible(false)"/>
	<button label="show" onClick="sp.setVisible(true)"/>
</window>`,
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Widget.$(jq("@progressmeter")).$n("img")).width(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq("@progressmeter").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("30"),
		ztl.normalizeText(
			(verifyVariable_cafe_0_0 * 100) / verifyVariable_cafe_1_1,
		),
		ztl.normalizeText("2"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("30"),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@progressmeter")).$n("img")).width(),
			)(),
		),
		ztl.normalizeText("2"),
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@progressmeter").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("100"));
	await t.click(Selector(() => jq("@button:eq(4)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq("@progressmeter").width(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(zk.Widget.$(jq("@progressmeter")).$n("img")).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("30"),
		ztl.normalizeText(
			(verifyVariable_cafe_3_3 * 100) / verifyVariable_cafe_2_2,
		),
		ztl.normalizeText("2"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("60"),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@progressmeter")).$n("img")).width(),
			)(),
		),
		ztl.normalizeText("2"),
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@progressmeter").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("200"));
	await t.click(Selector(() => jq("@button:eq(2)")[0]));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("160"),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@progressmeter")).$n("img")).width(),
			)(),
		),
		ztl.normalizeText("2"),
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@progressmeter").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("200"));
	await t.click(Selector(() => jq("@button:eq(6)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:eq(5)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:eq(7)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_4_4 = await ClientFunction(() =>
		jq("@progressmeter").width(),
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(() =>
		jq(zk.Widget.$(jq("@progressmeter")).$n("img")).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("80"),
		ztl.normalizeText(
			(verifyVariable_cafe_5_5 * 100) / verifyVariable_cafe_4_4,
		),
		ztl.normalizeText("2"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("80"),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@progressmeter")).$n("img")).width(),
			)(),
		),
		ztl.normalizeText("2"),
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@progressmeter").outerWidth())(),
			),
		)
		.eql(ztl.normalizeText("100"));
});
