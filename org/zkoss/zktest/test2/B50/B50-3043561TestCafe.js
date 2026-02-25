import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3043561TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3043561TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<decimalbox format="######.##" value="20.0100002288818359375"/>`,
	);
	await t
		.expect(ztl.normalizeText("20.01"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@decimalbox").val())(),
			),
		);
});
