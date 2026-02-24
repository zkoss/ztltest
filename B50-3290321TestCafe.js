import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3290321TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3290321TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Listbox" border="normal">
				Please scroll to the right most, and click upon the header of the grid to trigger a sorting function, and then the label inside the header should not be appeared in the current screen. 
				<separator bar="true" />
				<listbox id="lb">
					<listhead sizable="true">
						<listheader align="center" width="40px"
							image="/img/Centigrade-Widget-Icons/ArrowsUpDown-16x16.png" />
						<listheader align="center" width="40px"
							image="/img/Centigrade-Widget-Icons/Envelope-16x16.png" />
						<listheader align="center" width="40px"
							image="/img/Centigrade-Widget-Icons/PaperClip-16x16.png" />
						<listheader id="sh" label="Subject" width="4000px" sort="auto" />
						<listheader label="Received" sort="auto" />
					</listhead>
					<listitem height="28px">
						<listcell
							image="/img/Centigrade-Widget-Icons/ArrowUpOrange-16x16.png" />
						<listcell
							image="/img/Centigrade-Widget-Icons/EnvelopeOpen-16x16.png" />
						<listcell
							image="/img/Centigrade-Widget-Icons/PaperClip-16x16.png" />
						<listcell label="ZK Jet 0.8.0 is released" />
						<listcell label="2008/11/17 17:41:29" />
					</listitem>
					<listitem height="28px">
						<listcell
							image="/img/Centigrade-Widget-Icons/ArrowDown-16x16.png" />
						<listcell
							image="/img/Centigrade-Widget-Icons/Envelope-16x16.png" />
						<listcell
							image="/img/Centigrade-Widget-Icons/PaperClip-16x16.png" />
						<listcell label="URLs for iPhone-Optimized Google Sites" />
						<listcell label="2008/11/17 15:56:37" />
					</listitem>
					<listitem height="28px">
						<listcell label="&#160;" />
						<listcell
							image="/img/Centigrade-Widget-Icons/EnvelopeOpen-16x16.png" />
						<listcell label="&#160;" />
						<listcell label="Style Guide for ZK 3.5 released" />
						<listcell label="2008/11/14 13:23:07" />
					</listitem>
					<listitem height="28px">
						<listcell
							image="/img/Centigrade-Widget-Icons/ArrowUpOrange-16x16.png" />
						<listcell
							image="/img/Centigrade-Widget-Icons/EnvelopeOpen-16x16.png" />
						<listcell label="&#160;" />
						<listcell label="ZK Studio 0.9.0 released." />
						<listcell label="2008/11/16 10:26:37" />
					</listitem>
				</listbox>
			</window>`,
	);
	await ztl.doScroll({
		locator: Selector(() => zk.Desktop._dt.$f("lb", true).$n()),
		scrollType: "horizontal",
		dist: "3000",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let actionVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lb", true)).outerWidth(),
	)();
	let cafeCoord_1 = await ztl.convertCoordStrToArr(
		actionVariable_cafe_0_0 - 5 + "," + 2,
	);

	await t.click(
		Selector(() => zk.Desktop._dt.$f("lb", true).$n()),
		{ offsetX: cafeCoord_1[0], offsetY: cafeCoord_1[1] },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollLeft({
					locator: Selector(() => zk.Desktop._dt.$f("lb", true).$n()),
				}),
			),
		)
		.notEql(ztl.normalizeText("0"), "");
});
