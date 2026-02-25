import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1909TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1909TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	enter number 111 to the doublebox and blur, it should not show any error message.
	<separator></separator>
	<doublebox maxlength="3" onChange=""/>
</zk>`,
	);
	if (
		await ClientFunction(
			() => jq(jq(".z-doublebox"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-doublebox")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 1 1");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await t
		.expect(await ClientFunction(() => !!jq(".z-errbox")[0])())
		.notOk("should not show any error message");
});
