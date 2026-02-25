import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-2015TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-2015TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="IE10 Only" xmlns:n="native" border="normal">
	Click show and hide, BB and CC will show and hide normally.
	<button label="show">
		<attribute name="onClick"><![CDATA[
			cell1.setVisible(true);
			cell2.setVisible(true);
		]]></attribute>
	</button>
	<button label="hide">
		<attribute name="onClick"><![CDATA[
			cell1.setVisible(false);
			cell2.setVisible(false);
		]]></attribute>
	</button>

	<grid width="300px" id="grid">
		<columns>
			<column label="col" />
			<column label="col" />
			<column label="col" />
		</columns>
		<rows>
			<row>
				<cell>AA</cell>
				<cell id="cell1">BB</cell>
				<cell id="cell2">CC</cell>
			</row>
		</rows>
	</grid>
</window>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(show)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(hide)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-cell:contains(BB)").attr("style"),
				)(),
			),
		)
		.contains(ztl.normalizeText("none"), "BB and CC will hide");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-cell:contains(CC)").attr("style"),
				)(),
			),
		)
		.contains(ztl.normalizeText("none"), "BB and CC will hide");
	await t.click(Selector(() => jq(".z-button:contains(show)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-cell:contains(BB)").attr("style"),
				)(),
			),
		)
		.notContains(ztl.normalizeText("none"), "BB and CC will show");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-cell:contains(CC)").attr("style"),
				)(),
			),
		)
		.notContains(ztl.normalizeText("none"), "BB and CC will show");
});
