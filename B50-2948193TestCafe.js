import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2948193TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2948193TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
					Please click invalidate button, and it will not happen js error.
					<button id="btn" label="invalidate" onClick="center.invalidate();"/>
					<borderlayout width="100%" height="100%">
						<center id="center" >
							<listbox vflex="true" />
						</center>
					</borderlayout>
				</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t.wait(1000);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
