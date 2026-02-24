import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1881553TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1881553TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
				The tabbox\'s height shall be changed accordingly.
				<tabbox id="t" width="400px">
					<tabs>
						<tab label="Tab 1"/>
						<tab label="Tab 2"/>
					</tabs>
					<tabpanels>
						<tabpanel>This is panel 1</tabpanel>
						<tabpanel>This is panel 2</tabpanel>
					</tabpanels>
				</tabbox>
				<button id="oneHd" label="100" onClick=\'t.height = "100px"\'/>
				<button id="twoHd" label="200" onClick=\'t.height = "200px"\'/>
				<button id="threeHd" label="300" onClick=\'t.height = "300px"\'/>
			</window>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("oneHd", true).$n()));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("100"),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("t", true)).height(),
			)(),
		),
		ztl.normalizeText("2"),
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("twoHd", true).$n()));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("200"),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("t", true)).height(),
			)(),
		),
		ztl.normalizeText("2"),
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("threeHd", true).$n()));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("300"),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("t", true)).height(),
			)(),
		),
		ztl.normalizeText("2"),
	);
});
