import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2995770TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2995770TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<window title="Region Disappears" border="normal">
	<tabbox>
		<tabs>
			<tab id="t1" label="tab 1" />
			<tab id="t2" label="tab 2" />
		</tabs>
		<tabpanels>
			<tabpanel>
				<borderlayout height="500px">
					<center>
						<label value="center" />
					</center>
					<east id="east" size="200px" collapsible="true" open="false">
						<label value="east" />
					</east>
				</borderlayout>
			</tabpanel>
			<tabpanel>
				<button id="btn" label="Go" onClick="east.open = true" />
			</tabpanel>
		</tabpanels>
	</tabbox>
</window>
</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("t2", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("t1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("east", true).$n("real")).outerWidth(),
				)(),
			),
		)
		.eql(ztl.normalizeText("200"));
});
