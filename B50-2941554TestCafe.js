import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2941554TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2941554TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<tabbox>
				    <tabs>
				        <tab id="t1" label="t1"/>
				        <tab id="t2" label="t2"/>
				    </tabs>
				    <tabpanels>
				        <tabpanel>
				            <textbox constraint="no empty, after_start" focus="true"/>
				            <button id="btn" label="click me" popup="pp"/>
				            <popup width="300px" id="pp">
				                After click the t2 tab, the popup and the errorbox should be hidden.
				            </popup>
				        </tabpanel>
				    </tabpanels>
				</tabbox>`,
	);
	await t.expect(await ClientFunction(() => !!jq("@popup")[0])()).notOk();
	await t.expect(await ClientFunction(() => !!jq("@errorbox")[0])()).notOk();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("@popup").is(":visible"))())
		.ok();
	await t
		.expect(await ClientFunction(() => jq("@errorbox").is(":visible"))())
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("t2", true).$n()));
	await ztl.waitResponse(t);
	await t.wait(500);
	await t
		.expect(await ClientFunction(() => jq("@popup").is(":visible"))())
		.notOk();
	await t
		.expect(await ClientFunction(() => jq("@errorbox").is(":visible"))())
		.notOk();
});
