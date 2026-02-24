import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3022197TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3022197TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
   <html><![CDATA[
	<ul>
	<li>click "set selected"</li>
	<li>select "B" tab</li>
	<li>"BB" tab shall be selected</li>
	</ul>
	]]></html>
	<button label="set selected" onClick="tabB.selected = true;" />
	<tabbox>
		<tabs>
			<tab label="A" />
			<tab label="B" id="b" />
		</tabs>
		<tabpanels>
			<tabpanel>A</tabpanel>
			<tabpanel>
				<tabbox>
					<tabs>
						<tab label="BA" />
						<tab label="BB" id="tabB"/>
					</tabs>
					<tabpanels>
						<tabpanel>BA</tabpanel>
						<tabpanel>BB</tabpanel>
					</tabpanels>
				</tabbox>
			</tabpanel>
		</tabpanels>
	</tabbox>
</zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("b", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-tab-selected:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("BB"));
});
