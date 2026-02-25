import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1804TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1804TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<hbox>
		<calendar id="cal" />
		<label>Should not be able to select year less than 1900 or greater than 2099</label>
	</hbox>
</zk>`,
	);
	await t.click(
		Selector(() => jq(".z-calendar-title .z-calendar-text:eq(1)")[0]),
	);
	await ztl.waitResponse(t);
	await t
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("right")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("right")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("right")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("right")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("right")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("right")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("right")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("right")));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq("td:contains(2100)")[0])())
		.notOk("Should not be able to select year greater than 2099");
	await t
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")))
		.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq("td:contains(1899)")[0])())
		.notOk("Should not be able to select year less than 1900");
});
