import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3035230TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3035230TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<zscript><![CDATA[
	String[] datas = new String[50];
]]></zscript>
	<html><![CDATA[ <h1>Grid sizedByContent</h1> ]]></html>
	<hbox>
		<vbox>
			<label value="grid has 300px width" />
			<grid sizedByContent="true" height="200px" width="300px">
				<columns>
					<column id="c1" label="col 1" />
					<column id="c2" label="col 2" />
				</columns>
				<rows>
					<row forEach="\${datas}">
						<label value="item" />
						<label value="item" />
					</row>
				</rows>
			</grid>
		</vbox>
		<separator orient="vertical" />
		<vbox>
			<label value="grid without width in a div with 300px width" />
			<div width="300px">
				<grid sizedByContent="true" height="200px">
					<columns>
						<column id="c3" label="col 1" />
						<column id="c4" label="col 2" />
					</columns>
					<rows>
						<row forEach="\${datas}">
							<label value="item" />
							<label value="item" />
						</row>
					</rows>
				</grid>
			</div>
		</vbox>
	</hbox>
</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("c2", true)).outerWidth(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("c1", true)).outerWidth(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							verifyVariable_cafe_1_1 +
							"-" +
							verifyVariable_cafe_0_0 +
							") <= 3",
					),
				{
					dependencies: {
						verifyVariable_cafe_1_1,
						verifyVariable_cafe_0_0,
					},
				},
			)(),
		)
		.ok();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("c3", true)).outerWidth(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("c4", true)).outerWidth(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							verifyVariable_cafe_2_2 +
							"-" +
							verifyVariable_cafe_3_3 +
							") <= 3",
					),
				{
					dependencies: {
						verifyVariable_cafe_2_2,
						verifyVariable_cafe_3_3,
					},
				},
			)(),
		)
		.ok();
});
