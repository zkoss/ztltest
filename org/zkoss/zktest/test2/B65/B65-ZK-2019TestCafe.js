import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-2019TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-2019.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-2019TestCafe", async (t) => {
	await ztl.initTest(t);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-chosenbox")).$n("inp"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => zk.Widget.$(jq(".z-chosenbox")).$n("inp")),
		);
	await ztl.waitResponse(t);
	await t.pressKey("o h");
	await ztl.waitResponse(t);
	await t.wait(300);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-chosenbox-option:contains(john@company.org)")[0],
			)(),
		)
		.ok("Your will see 'John (john@company.org)' option.");
});
