import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3567TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3567.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3567TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.drag(
		Selector(() => jq(".z-listitem")[0]),
		90,
		190,
		{ offsetX: 10, offsetY: 10 },
	);
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("#zk_log")[0])()).notOk();
	await t.click(Selector(() => jq(".z-listitem")[1]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("#zk_log")[0])()).notOk();
	await t.hover(Selector(() => jq(".z-button")[0])).wait(1000);
	await t.expect(await ClientFunction(() => !!jq("#zk_log")[0])()).notOk();
});
