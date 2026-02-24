import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-355TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-355TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				1. Please scroll the scrollbar to the middle of the list, and click the "click me" button.
				<separator/>
				2. You should see the scrollbar is placed at the same area.
				<separator/>
				3. you may set custom-attributes org.zkoss.zul.listbox.rod="false" as need

					<zscript>
						ListModel strset = new org.zkoss.zktest.test2.grid.FakeListModel(3000);
					</zscript>

					<listbox id="list" width="200px" rows="10" model="&#36;{strset}">
						<listhead>
							<listheader label="Load on Demend" sort="auto"/>
						</listhead>
					</listbox>
				<button id="btn1" label="click me" onClick="list.invalidate()"/>
			</zk>`,
	);
	await ztl.doScroll({
		locator: Selector(() => zk.Desktop._dt.$f("list", true).$n()),
		scrollType: "vertical",
		percent: "0.5",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let scOne_cafe = await ztl.getScrollTop({
		locator: Selector(() => zk.Desktop._dt.$f("list", true).$n()),
	});
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t.wait(500);
	let scTwo_cafe = await ztl.getScrollTop({
		locator: Selector(() => zk.Desktop._dt.$f("list", true).$n()),
	});
	await t
		.expect(ztl.normalizeText(scTwo_cafe))
		.eql(ztl.normalizeText(scOne_cafe));
});
