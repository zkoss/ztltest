import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3278524TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3278524TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<tabbox>
				<tabs>
				<tab label="Hi"/>
				</tabs>
				<tabpanels>
				<tabpanel>
				You shall see a log (at the right bottom) showing "false"
			<include src="/test2/B50-3278524-inc.html"/>
				</tabpanel>
				</tabpanels>
			</tabbox>`,
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("#zk_log")[0].value)(),
			),
		)
		.contains(
			ztl.normalizeText("false"),
			"Should appear a log message 'false'",
		);
});
