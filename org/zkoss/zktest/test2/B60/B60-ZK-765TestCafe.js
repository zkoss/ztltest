import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-765TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-765.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-765TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios")) {
		console.log("This issue is ignored in current browser! (ios)");
		return;
	}
	await t.click(Selector(() => zk.Desktop._dt.$f("btnTwo", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() =>
			!!jq("$msg:contains(selected index is undefined, no selection)")[0],
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => !!jq("$msg:contains(selected index is -1)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0 || verifyVariable_cafe_1_1)
		.ok(
			"message should be 'selected index is undefined, no selection or ... index is -1 ...'",
		);
	await t.click(Selector(() => jq(".z-listitem:contains(Item 1)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btnTwo", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(
						"$msg:contains(selected index is 1, widget selected is true)",
					)[0],
			)(),
		)
		.ok("message should be 'selected index is 1, widget selected is true'");
	await t.click(Selector(() => zk.Desktop._dt.$f("btnOne", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btnTwo", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(
						"$msg:contains(selected index is 1, widget selected is true)",
					)[0],
			)(),
		)
		.ok("message should be 'selected index is 1, widget selected is true'");
	await ztl.waitResponse(t);
	await t.eval(() => location.reload(true));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btnThree", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq("$msg:contains(selected no selection)")[0],
			)(),
		)
		.ok("message should be 'selected no selection'");
	await t.click(Selector(() => jq(".z-listitem:contains(Item 1)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btnThree", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq("$msg:contains(selected index is 1)")[0],
			)(),
		)
		.ok("message should be 'selected index is 1'");
	await t.click(Selector(() => zk.Desktop._dt.$f("btnOne", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btnThree", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq("$msg:contains(selected index is 1)")[0],
			)(),
		)
		.ok("message should be 'selected index is 1'");
});
