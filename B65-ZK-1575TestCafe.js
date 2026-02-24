import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1575TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1575TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<groupbox title="groupbox" mold="3d" vflex="min" open="false">
		<div height="100px">test</div>
	</groupbox>
</zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
});
