import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2988187TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2988187TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<tabbox>
				<tabs>
					<tab label="tab1"/>
				</tabs>
				<tabpanels>
					<tabpanel>
						<button id="btn" label="click me" popup="pp"/>
						<popup id="pp" width="300px">
							Here is a Popup.
						</popup>
					</tabpanel>
				</tabpanels>
			</tabbox>
		</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("pp", true)).is(":visible"),
			)(),
		)
		.ok();
});
