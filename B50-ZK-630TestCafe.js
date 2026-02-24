import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-630TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-630TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>You should see no Java Exception</div>
				<doublespinner id="db" value="1" constraint="no negative" />
				<zscript>
					db.getValue();
				</zscript>
			</zk>`,
	);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Desktop._dt.$f("db", true) &&
					!!zk.Desktop._dt.$f("db", true).$n(),
			)(),
		)
		.ok("page should rendered well");
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("should no exception");
});
