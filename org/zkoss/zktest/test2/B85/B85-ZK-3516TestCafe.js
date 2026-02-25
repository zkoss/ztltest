import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3516TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3516.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3516TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("chrome,ff")) {
		console.log("This issue is ignored in current browser! (chrome,ff)");
		return;
	}
	let wSplitter_cafe = await ClientFunction(() =>
		jq(".z-splitter-outer").width(),
	)();
	await t.resizeWindow(200, 800);
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(wSplitter_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-splitter-outer").width())(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-div:eq(1)").width())(),
		),
		ztl.normalizeText(await ClientFunction(() => jq(".z-hbox").width())()),
		ztl.normalizeText("1"),
	);
	await t.resizeWindow(1400, 800);
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(wSplitter_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-splitter-outer").width())(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-div:eq(1)").width())(),
		),
		ztl.normalizeText(await ClientFunction(() => jq(".z-hbox").width())()),
		ztl.normalizeText("1"),
	);
	await t.resizeWindow(1100, 800);
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(wSplitter_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-splitter-outer").width())(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-div:eq(1)").width())(),
		),
		ztl.normalizeText(await ClientFunction(() => jq(".z-hbox").width())()),
		ztl.normalizeText("1"),
	);
	await t.resizeWindow(1100, 600);
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(wSplitter_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-splitter-outer").width())(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-div:eq(1)").width())(),
		),
		ztl.normalizeText(await ClientFunction(() => jq(".z-hbox").width())()),
		ztl.normalizeText("1"),
	);
	await t.resizeWindow(1100, 400);
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(wSplitter_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-splitter-outer").width())(),
		),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-div:eq(1)").width())(),
		),
		ztl.normalizeText(await ClientFunction(() => jq(".z-hbox").width())()),
		ztl.normalizeText("1"),
	);
});
