import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3032885TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3032885TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<vbox>
<div><combobox mold="rounded" inplace="true" />&lt;&lt;Combobox Here</div>
<div><bandbox mold="rounded" inplace="true" />&lt;&lt;Bandbox Here</div>
<div><datebox mold="rounded" inplace="true" />&lt;&lt;Datebox Here</div>
<div><timebox mold="rounded" inplace="true" />&lt;&lt;Timebox Here</div>
<div><spinner mold="rounded" inplace="true" />&lt;&lt;Spinner Here</div>
<label>When any of the Combo Input above gets focus, this label will be pushed down.</label>
</vbox>
</zk>`,
	);
	let t1_cafe = await ClientFunction(() => jq("@label:eq(0)").offset().top)();
	await ClientFunction(() => {
		zk.Widget.$(jq("@combobox")).$n("real").focus();
	})();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@label:eq(0)").offset().top)(),
			),
		)
		.eql(ztl.normalizeText(t1_cafe));
	t1_cafe = await ClientFunction(() => jq("@label:eq(1)").offset().top)();
	await ClientFunction(() => {
		zk.Widget.$(jq("@bandbox")).$n("real").focus();
	})();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@label:eq(1)").offset().top)(),
			),
		)
		.eql(ztl.normalizeText(t1_cafe));
	t1_cafe = await ClientFunction(() => jq("@label:eq(2)").offset().top)();
	await ClientFunction(() => {
		zk.Widget.$(jq("@datebox")).$n("real").focus();
	})();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@label:eq(2)").offset().top)(),
			),
		)
		.eql(ztl.normalizeText(t1_cafe));
	t1_cafe = await ClientFunction(() => jq("@label:eq(3)").offset().top)();
	await ClientFunction(() => {
		zk.Widget.$(jq("@timebox")).$n("real").focus();
	})();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@label:eq(3)").offset().top)(),
			),
		)
		.eql(ztl.normalizeText(t1_cafe));
	t1_cafe = await ClientFunction(() => jq("@label:eq(4)").offset().top)();
	await ClientFunction(() => {
		zk.Widget.$(jq("@spinner")).$n("real").focus();
	})();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@label:eq(4)").offset().top)(),
			),
		)
		.eql(ztl.normalizeText(t1_cafe));
});
