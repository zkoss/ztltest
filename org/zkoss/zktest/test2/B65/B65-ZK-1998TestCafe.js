import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1998TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1998TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	Should see checkbox in Header is checked.
	<window apply="org.zkoss.zktest.test2.B65_ZK_1998Composer">
		<listbox id="listbox">
			<listhead>
				<listheader label="Category" />
				<listheader label="Name" />
				<listheader label="Top Nutrients" />
			</listhead>
		</listbox>
	</window>
</zk>`,
	);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-listheader-checkable.z-listheader-checked")[0],
			)(),
		)
		.ok("Should see checkbox in Header is checked.");
});
