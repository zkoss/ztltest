import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1882323TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1882323.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1882323TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android,ff")) {
		console.log(
			"This issue is ignored in current browser! (ios,android,ff)",
		);
		return;
	}
	await t.click(Selector(() => jq(".z-intbox")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("home");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk(jq("@intbox")).getSelectionRange()[0],
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t.pressKey("right");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk(jq("@intbox")).getSelectionRange()[0],
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t.pressKey("right");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk(jq("@intbox")).getSelectionRange()[0],
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t.pressKey("left");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk(jq("@intbox")).getSelectionRange()[0],
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t.pressKey("home");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk(jq("@intbox")).getSelectionRange()[0],
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t.pressKey("right");
	await ztl.waitResponse(t);
	await t.pressKey("right");
	await ztl.waitResponse(t);
	await t.pressKey("delete");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk(jq("@intbox")).getSelectionRange()[0],
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t.pressKey("end");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk(jq("@intbox")).getSelectionRange()[0],
				)(),
			),
		)
		.eql(ztl.normalizeText("4"));
});
