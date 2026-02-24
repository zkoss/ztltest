import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z30-grid-0010TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z30-grid-0010TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Column should not show up here">
				<grid>
					<columns>
						<column/>
						<column align="center"/>
						<column align="right"/>
					</columns>
					<rows>
						<row>Testing whether header is visible</row>
					</rows>
				</grid>
			</window>`,
	);
	await t
		.expect(ztl.normalizeText("0"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@column:visible").length)(),
			),
		);
	await t
		.expect(ztl.normalizeText("3"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@column").length)(),
			),
		);
	await t
		.expect(ztl.normalizeText("4"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@column").length)(),
			),
			"",
		);
});
