import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1881557TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1881557TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
<n:ol>
		<n:li>Clicks textbox (to gain focus), </n:li>
		<n:li>Clicks other place (to lose focus), and then you shall see nothing happen.<n:br />(if a messagebox is shown, that\'s wrong. )</n:li>

</n:ol>
<window>
	<textbox id="test" onChange=\'alert("1");\' constraint="no negative,no zero"/>
</window>
</zk>`,
	);
	await ClientFunction(() => {
		jq("$test").focus();
	})();
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@window").length)(),
			),
		);
	await ClientFunction(() => {
		jq("$test").focus();
	})();
	await t.typeText(
		Selector(() => jq("$test")[0]),
		ztl.normalizeText("123"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("2"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq("@window").length)(),
			),
		);
});
