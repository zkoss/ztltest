import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-1596TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1596TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="native">
	<label multiline="true">
		1. Click "Invalidate" button.
		2. If you see JS error showed, it is a bug.
	</label>
	<button id="btn" label="Invalidate" onClick="cave.invalidate()" />
	<div id="cave">
		<n:div>
			<window title="Root" border="normal">
				<n:div>
					<window title="Nest inside native" border="normal" />
				</n:div>
			</window>
		</n:div>
	</div>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(Invalidate)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
});
