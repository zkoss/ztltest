import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1553937TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1553937TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			listbox\'s horizontal scrollbar causes side effects
			<separator />
			<hbox width="300px">
				<listbox id="list" width="200px" height="200px" sizedByContent="true">
					<listitem>
						<listcell style="white-space: nowrap;"
							label="xxxx x xxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxx\n		xxxxxxxxx xxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxx\n		xxxxxxxxxxxxxxxxx" />
					</listitem>
				</listbox>
				<label value="Hi" style="font-size: 16px; font-weight: bold" />
			</hbox>
		</zk>`,
	);
	let w_cafe = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("list", true).$n().parentNode.offsetWidth,
		)(),
	);
	await t.expect(ztl.normalizeText(w_cafe)).eql(ztl.normalizeText("200"));
});
