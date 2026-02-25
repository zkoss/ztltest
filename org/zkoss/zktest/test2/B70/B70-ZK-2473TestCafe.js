import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2473TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2473TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
		According to zhtml\'s lang.xml, it can recognize zhtml, htm, html, and xhtml file type.
		So the include component should be instant mode for this case.
	</label>
	<include src="/test2/B70-ZK-2473_include.xhtml" />
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("label > span").first().text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Included content"), "");
});
