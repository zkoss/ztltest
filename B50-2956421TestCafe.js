import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2956421TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2956421TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
					<html><![CDATA[
					<ol>
					<li>Click a1 and the first item shall be selected</li>
					<li>Click b1 and the second item shall be selected</li>
					</ol>
					]]></html>
				
					<listbox width="200px">
						<listhead>
							<listheader label="col1" />
							<listheader label="col2" />
						</listhead>
						<listitem id="item1">
							<listcell id="a1" label="a1"/>
							<listcell label="a2"/>
						</listitem>
						<listitem  id="item2">
							<listcell id="b1" label="b1" onClick=""/>
							<listcell label="b2" />
						</listitem>
					</listbox>
				</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("a1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				zk.Desktop._dt.$f("item1", true).isSelected(),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("item1", true)).hasClass(
					"z-listitem-selected",
				),
			)(),
		)
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("b1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				zk.Desktop._dt.$f("item2", true).isSelected(),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("item1", true)).hasClass(
					"z-listitem-selected",
				),
			)(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("item2", true)).hasClass(
					"z-listitem-selected",
				),
			)(),
		)
		.ok();
});
