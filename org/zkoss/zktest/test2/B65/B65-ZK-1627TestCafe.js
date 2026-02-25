import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1627TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1627TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
1. You should not see any exception after the page loaded.
<separator/>
2. Please focus in/out the datebox, you should see an error arrow points to the mid-bottom of the datebox. 
<datebox constraint="no empty, after_end"/>
</zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("You should not see any exception after the page loaded.");
	await t.click(
		Selector(() => jq(zk.Widget.$(jq(".z-datebox")).$n("real"))[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-label:eq(0)")[0]));
	await ztl.waitResponse(t);
	let dbLeft_cafe = await ClientFunction(
		() => jq(".z-datebox").offset().left,
	)();
	let pntMid_cafe_0 = await ClientFunction(
		() => jq(zk.Widget.$(jq(".z-errorbox")).$n("p")).offset().left,
	)();
	let pntMid_cafe_1 = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-errorbox")).$n("p")).outerWidth(),
	)();
	let pntMid_cafe = pntMid_cafe_0 + pntMid_cafe_1 / 2.0;
	let verifyVariable_cafe_0_2 = await ClientFunction(() =>
		jq(".z-datebox").outerWidth(),
	)();
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							pntMid_cafe +
							"-" +
							dbLeft_cafe +
							"-" +
							verifyVariable_cafe_0_2 +
							" / 2) <= 2",
					),
				{
					dependencies: {
						pntMid_cafe,
						dbLeft_cafe,
						verifyVariable_cafe_0_2,
					},
				},
			)(),
		)
		.ok(
			"you should see an error arrow points to the mid-bottom of the datebox.",
		);
});
