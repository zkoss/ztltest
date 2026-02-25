import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1053TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-1053.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-1053TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@selectbox")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(await ClientFunction(() => jq("$msg").html())()),
		)
		.contains(
			ztl.normalizeText("msg: Selectbox onFocus"),
			"You should see the msg become 'msg: Selectbox onFocus'",
		);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(await ClientFunction(() => jq("$msg").html())()),
		)
		.contains(
			ztl.normalizeText("msg: Selectbox onBlur"),
			"You should see the msg become 'msg: Selectbox onBlur'",
		);
	await t.click(Selector(() => jq("@chosenbox")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(await ClientFunction(() => jq("$msg").html())()),
		)
		.contains(
			ztl.normalizeText("msg: Chosenbox onFocus"),
			"You should see the msg become 'msg: Chosenbox onFocus'",
		);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(await ClientFunction(() => jq("$msg").html())()),
		)
		.contains(
			ztl.normalizeText("msg: Chosenbox onBlur"),
			"You should see the msg become 'msg: Chosenbox onBlur'",
		);
});
