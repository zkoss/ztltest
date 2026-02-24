import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F70-ZK-1721TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F70-ZK-1721TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	Click the button it should redirect to F70-ZK-1721-1.zul correctly.
	<button label="redirect" onClick=\'Executions.getCurrent().sendRedirect("test2/F70-ZK-1721-1.zul", true)\' />
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button")[0])).wait(2000);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-label:contains(Destination)")[0],
			)(),
		)
		.ok("should redirect to F70-ZK-1721-1.zul correctly.");
});
