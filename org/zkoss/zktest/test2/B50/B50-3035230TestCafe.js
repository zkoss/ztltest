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
	// the header labels differ ("col 1", "col 2"), so compare each column's width beside its own header text
	const widthBesideText = ClientFunction((id) => {
		const col = zk.Desktop._dt.$f(id, true);
		return jq(col).outerWidth() - zk(col.$n("cave")).textWidth();
	});
	await t
		.expect(
			Math.abs(
				(await widthBesideText("c1")) - (await widthBesideText("c2")),
			),
		)
		.lte(
			3,
			"both columns of the 300px grid should be sized by their content",
		);
	await t
		.expect(
			Math.abs(
				(await widthBesideText("c3")) - (await widthBesideText("c4")),
			),
		)
		.lte(
			3,
			"both columns of the grid in the 300px div should be sized by their content",
		);
});
