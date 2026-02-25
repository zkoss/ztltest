import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F30-1721273TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F30-1721273TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<n:h2>[ 1721273 ] Event Enachment</n:h2>
			<n:ol>
				<n:li>Focus into the textbox, then you press the "Enter" key, you will see alert message</n:li>
			</n:ol>
			<textbox id="tb1" value="Support onOK event 1" onOK="alert(self.value);"/>
		</zk>`,
	);
	await t.expect(await ClientFunction(() => !!jq("@window")[0])()).notOk();
	await ClientFunction(() => {
		zk.Desktop._dt.$f("tb1", true).focus();
	})();
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("@window")[0])()).ok();
});
