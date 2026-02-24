import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1552TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1552TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios")) {
		console.log("This issue is ignored in current browser! (ios)");
		return;
	}
	await ztl.runZscript(
		t,
		`<window height="100%" border="normal">
	<div>
		<div>1. click the btn of combobox</div>
		<div>2. scroll to bottom, then scroll back to top</div>
		<div>3. should not show popup</div>
		<div>4. repeat these steps on datebox and bandbox</div>
	</div>
	<borderlayout>
		<center autoscroll="true">
			<div style="height: 1500px">
				<div style="margin-top: 200px">
					<combobox>
						<comboitem>First</comboitem>
						<comboitem>Second</comboitem>
						<comboitem>Third</comboitem>
					</combobox>
					<datebox></datebox>
					<bandbox id="bd">
						<bandpopup>
							<vbox>
								<hbox>
									Search
									<textbox />
								</hbox>
								<listbox width="200px"
									onSelect="bd.value=self.selectedItem.label;bd.close();">
									<listhead>
										<listheader label="Name" />
										<listheader label="Description" />
									</listhead>
									<listitem>
										<listcell label="John" />
										<listcell label="CEO" />
									</listitem>
									<listitem>
										<listcell label="Joe" />
										<listcell label="Engineer" />
									</listitem>
									<listitem>
										<listcell label="Mary" />
										<listcell label="Supervisor" />
									</listitem>
								</listbox>
							</vbox>
						</bandpopup>
					</bandbox>
				</div>
			</div>
		</center>
	</borderlayout>
</window>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq(".z-combobox")).$n("btn")));
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq(".z-center")[0]),
		scrollType: "vertical",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq(".z-center")[0]),
		scrollType: "vertical",
		percent: "0.0",
	});
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-combobox")).$n("pp")).is(":visible"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0)
		.notOk("should not show the combobox popup");
	await t.click(Selector(() => zk.Widget.$(jq(".z-datebox")).$n("btn")));
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq(".z-center")[0]),
		scrollType: "vertical",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq(".z-center")[0]),
		scrollType: "vertical",
		percent: "0.0",
	});
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0t = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-datebox")).$n("pp")).is(":visible"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0t)
		.notOk("should not show the datebox popup");
	await t.click(Selector(() => zk.Widget.$(jq(".z-bandbox")).$n("btn")));
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq(".z-center")[0]),
		scrollType: "vertical",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq(".z-center")[0]),
		scrollType: "vertical",
		percent: "0.0",
	});
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tt = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-bandbox")).$n("pp")).is(":visible"),
	)();
	await t
		.expect(verifyVariable_cafe_0_0tt)
		.notOk("should not show the bandbox popup");
});
