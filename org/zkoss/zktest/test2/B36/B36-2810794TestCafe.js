import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2810794TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2810794TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			You should not see any Javascript error in IE only
			<grid>
			<columns>
			<column label=\'column 1\'/>
			<column label=\'column 2\'/>
			<column label=\'column 3\'/>
			<column label=\'column 4\'/>
			<column label=\'column 5\'/>
			</columns>
			</grid>
			</zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq("div.z-error")[0])())
		.notOk();
});
