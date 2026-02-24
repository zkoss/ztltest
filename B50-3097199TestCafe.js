import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3097199TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3097199TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<combobox id="cb" constraint="strict:Please select">
					<comboitem label="Simple and Rich"
						description="The simplest way to make Web applications rich" />
					<comboitem label="Cool!" description="The coolest technology" />
					<comboitem label="Ajax and RIA"
						description="Rich Internet Application by Ajax" />
				</combobox>
			</zk>`,
	);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("cb", true).$n("real")),
		ztl.normalizeText("Test"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-errorbox-content").html())(),
			),
		)
		.eql(ztl.normalizeText("Please select"));
});
