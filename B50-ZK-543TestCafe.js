import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-543TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-543TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<div>There should no extra space below the last row of the listbox.</div>
				<listbox id="listbox" width="400px" sizedByContent="true"
					rows="3">
					<listhead >
						<listheader label="Test" />
					</listhead>
					<listitem>
						<listcell>
							<label value="1" />
						</listcell>
						<listcell>
							<label value="DEQU8978163" />
						</listcell>
					</listitem>
					<listitem>
						<listcell>
							<label value="11-Oct-25 1929" />
						</listcell>
						<listcell>
							<label value="DEQU8978163" />
						</listcell>
					</listitem>
					<listitem>
						<listcell>
							<label value="11-Oct-25 1929" />
						</listcell>
						<listcell>
							<label value="TBBS15243100" />
						</listcell>
						<listcell>
							<label value="APLxzxzxzxzxz" />
						</listcell>
						<listcell>
							<label value="V152sfsfs" />
						</listcell>
						<listcell>
							<label value="V152" />
						</listcell>
						<listcell>
							<label value="Export" />
						</listcell>
					</listitem>
				</listbox>
			</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("listbox", true).$n("body")).outerHeight(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("listbox", true).$n("cave")).outerHeight(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							verifyVariable_cafe_0_0 +
							"-" +
							verifyVariable_cafe_1_1 +
							") < 3",
					),
				{
					dependencies: {
						verifyVariable_cafe_0_0,
						verifyVariable_cafe_1_1,
					},
				},
			)(),
		)
		.ok("the body height should equal to cave height");
});
