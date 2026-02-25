import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1823229TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1823229TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				Splitter- The image of bar isn\'t updated, when dynamically call setCollapse method.
				<window border="normal" width="800px" title="Case 1: hbox and splitter">
						<hbox height="100px" width="100%">
						cdacdacdacdacdaca
						<splitter id="hsplitter" collapse="none"/>
						cdacdacdacdacacsdc
						</hbox>
						<label id="d" />
						<radiogroup>
							<attribute name="onCheck">
								hsplitter.setCollapse(self.selectedItem.label);
								d.setValue("Collapse: "+self.selectedItem.label);
							</attribute>
							<radio id="r1" selected="true" label="none"/>
							<radio id="r2" label="before"/>
							<radio id="r3" label="after"/>
						</radiogroup>
				</window>
			</zk>`,
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("hsplitter", true).$n("icon")).is(
					":visible",
				),
			)(),
		)
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("r2", true).$n("real")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("hsplitter", true).$n("icon")).is(
					":visible",
				),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("hsplitter", true).$n("icon")).hasClass(
					"z-icon-caret-left",
				),
			)(),
		)
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("r3", true).$n("real")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("hsplitter", true).$n("icon")).is(
					":visible",
				),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("hsplitter", true).$n("icon")).hasClass(
					"z-icon-caret-left",
				),
			)(),
		)
		.notOk();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("hsplitter", true).$n("icon")).hasClass(
					"z-icon-caret-right",
				),
			)(),
		)
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("r1", true).$n("real")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("hsplitter", true).$n("icon")).is(
					":visible",
				),
			)(),
		)
		.notOk();
});
