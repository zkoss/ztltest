import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2945998TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2945998TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<zscript>
Label x = new Label();
</zscript>
<window id="mywin" border="normal">
<custom-attributes a="\${x}"/>
A window
</window>
Click 
<button label="test" onClick="new Div().appendChild(mywin)"/>
and you shall see the above window disappears
</zk>`,
	);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Desktop._dt.$f("mywin", true) &&
					!!zk.Desktop._dt.$f("mywin", true).$n(),
			)(),
		)
		.ok();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Desktop._dt.$f("mywin", true) &&
					!!zk.Desktop._dt.$f("mywin", true).$n(),
			)(),
		)
		.notOk();
});
