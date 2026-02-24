import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-2128058TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2128058TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<borderlayout height="500px">
	<north  id="west" visible="false" maxsize="300" size="50%" splittable="true" collapsible="true">
	</north>
	<center border="0">
		
<button label="Click me, then you should see the North region." onClick=\'west.visible = !west.visible\'/>
	</center>
</borderlayout>`,
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("west", true)).is(":visible"),
			)(),
		)
		.notOk("west.isVisible() is true!");
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("west", true)).is(":visible"),
			)(),
		)
		.ok("west.isVisible() is not found.");
});
