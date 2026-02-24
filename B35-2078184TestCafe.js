import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2078184TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2078184TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await ztl.runZscript(
		t,
		`<zk>
<vbox>
<label value="1.scroll down the scrollbar"/>
<label value="2.click arrow-down button"/>
<label value="3.the value should be decreased instead of increased"/>
</vbox>
<div id="div1" height="300px" style="overflow: scroll;position:relative" width="200px">
<div height="400px">
<div height="100px"/>
<spinner id="sp1"/>
<spinner id="sp2"/>
</div>
</div>
</zk>`,
	);
	await ztl.doScroll({
		locator: Selector(() => jq("$div1")[0]),
		scrollType: "vertical",
		noBody: true,
		dist: "40",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("sp1", true).$n("btn-down")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("-1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("sp1", true).$n("real")).val(),
				)(),
			),
		);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("sp1", true).$n("btn-down")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("-2"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("sp1", true).$n("real")).val(),
				)(),
			),
		);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("sp2", true).$n("btn-down")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("-1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("sp2", true).$n("real")).val(),
				)(),
			),
		);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("sp2", true).$n("btn-down")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("-2"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("sp2", true).$n("real")).val(),
				)(),
			),
		);
});
