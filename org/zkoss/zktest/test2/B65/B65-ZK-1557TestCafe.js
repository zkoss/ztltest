import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1557TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1557TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	Please click the "Caption" once, and then it should show the content of the groupbox
	<groupbox mold="3d" width="100%" open="false">
		<caption label="Caption" />
		<div>
			<label value="Label 1"/>
			<textbox cols="30" maxlength="50" focus="true"/>
		</div>
		<div visible="false">
			<label value="Label 2"/>
			<combobox readonly="true"/>
		</div>
	</groupbox>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-caption")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("none"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-groupbox-3d-cnt").css("display"),
				)(),
			),
			"should show the content of the groupbox",
		);
});
