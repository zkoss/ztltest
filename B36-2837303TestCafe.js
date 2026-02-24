import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2837303TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2837303TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			You should see the height of the progressmeter is 10px height.
			<progressmeter height="10px"  width="95%" value="50" />
			For example, The bottom progressmeter is bigger than 10px height.
			<progressmeter width="95%" value="50" />
			</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@progressmeter:eq(0)").outerHeight(),
				)(),
			),
		)
		.eql(ztl.normalizeText("10"));
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("@progressmeter:eq(1)").outerHeight(),
	)();
	await t.expect(verifyVariable_cafe_0_0 > 10).ok();
});
