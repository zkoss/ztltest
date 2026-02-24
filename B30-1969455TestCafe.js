import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1969455TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1969455TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="w" onA=\'l1.value += "A"\' onB=\'l1.value += "B"\'>
	You shall see "AB" is generated when clicking
	<button label="Test" forward="onA,onB"/>
	<label id="l1"/>
	<separator/>
	<div id="c" onC="l2.value += event.data"/>
	You shall see "XY" is generated when clicking
	<button label="Test" forward="\${c}.onC(XY)"/>
	<label id="l2"/>
	<separator/>
	<div id="d" onD="l3.value += event.data"/>
	You shall see "ZK" is generated when clicking
	<variables data="ZK"/>
	<button label="Test" forward="\${d}.onD(\${data})"/>
	<label id="l3"/>
</window>`,
	);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
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
		.eql(ztl.normalizeText("AB"));
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
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
		.eql(ztl.normalizeText("XY"));
	await t.click(Selector(() => jq("@button:eq(2)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("l3", true))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("ZK"));
});
