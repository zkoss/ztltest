import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2987076TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2987076TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<button id="setBtn" onClick=\'tr.tooltiptext="row"\'/>
				<button id="getBtn" onClick=\'msg.value = tr.tooltiptext\'/>
				<label id="msg"/>
			   <tree>
					<treechildren>
						<treeitem>
							<treerow id="tr">
								<treecell>
									Item 1
								</treecell>					
							</treerow>
						</treeitem>
					</treechildren>
				</tree>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("setBtn", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("getBtn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("msg", true)).html(),
				)(),
			),
		)
		.eql(ztl.normalizeText("row"));
});
