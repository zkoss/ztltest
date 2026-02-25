import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1828044TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1828044TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
			When the header is invisible, the whole column should be disappeared.
			
				<grid>
					<columns id="cols">
						<column id="col1" label="Column1" width="20%"
							visible="false" />
						<column id="col2" label="Column2" width="80%" />
					</columns>
					<rows>
						<row>
							<label value="Row1" />
							<label value="Row2" />
						</row>
			
					</rows>
				</grid>
				<button label="visible"
					onClick=\'col1.visible = !col1.visible; col2.visible = !col2.visible;\' />
				<button label="cols visible"
					onClick=\'cols.visible = !cols.visible;\' />
			</window>`,
	);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	let faker1_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq("$col1")).$n("hdfaker")).attr("style"),
	)();
	let faker2_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq("$col2")).$n("hdfaker")).attr("style"),
	)();
	await t
		.expect(ztl.normalizeText(faker1_cafe))
		.notContains(ztl.normalizeText("collapse"), "");
	await t
		.expect(ztl.normalizeText(faker2_cafe))
		.contains(ztl.normalizeText("collapse"), "");
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	faker1_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq("$col1")).$n("hdfaker")).attr("style"),
	)();
	faker2_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq("$col2")).$n("hdfaker")).attr("style"),
	)();
	await t
		.expect(ztl.normalizeText(faker2_cafe))
		.notContains(ztl.normalizeText("collapse"), "");
	await t
		.expect(ztl.normalizeText(faker1_cafe))
		.contains(ztl.normalizeText("collapse"), "");
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$cols").is(":visible"))())
		.notOk();
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$cols").is(":visible"))())
		.ok();
});
