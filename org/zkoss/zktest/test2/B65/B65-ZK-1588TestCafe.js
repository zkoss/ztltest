import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1588TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1588TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<div height="100%">
		<div height="90%">
			when click the button of bandbox, the popup should be above bandbox.
		</div>
		<div height="10%">
			<bandbox id="bd" mold="rounded" xmlns:w="client">
				<bandpopup>
					<vbox>
						<hbox>
							Search
							<textbox />
						</hbox>
						<listbox width="200px"
							onSelect="bd.value=self.selectedItem.label; bd.close();">
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
</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq(".z-bandbox")).$n("btn")));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-bandbox")).$n("pp")).height(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(zk.Widget.$(jq(".z-bandbox")).$n("real")).offset().top,
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq(zk.Widget.$(jq(".z-bandbox")).$n("pp")).offset().top,
	)();
	await t
		.expect(
			verifyVariable_cafe_2_2 + verifyVariable_cafe_0_0 <=
				verifyVariable_cafe_1_1,
		)
		.ok(
			"when click the button of bandbox, the popup should be above bandbox.",
		);
});
