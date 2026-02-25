//@nonConcurrent
import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2152TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2152.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2152TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-datebox-button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-timebox-input").eq(0)[0]));
	await ClientFunction(() => {
		zk(jq(".z-timebox-input").eq(0)).setSelectionRange(0);
	})();
	await t.pressKey("home");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() => jq(jq(".z-timebox-input").eq(0))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-timebox-input").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("2 1 0 0 0 0");
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("10/10/2014 21:00:00"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@datebox").eq(0)).getText(),
				)(),
			),
		);
	await t.click(Selector(() => jq(".z-datebox-button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-timebox-input").eq(1)[0]));
	await ClientFunction(() => {
		zk(jq(".z-timebox-input").eq(1)).setSelectionRange(0);
	})();
	await t.pressKey("home");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() => jq(jq(".z-timebox-input").eq(1))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-timebox-input").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 1 0 0 0 0");
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("10/10/2014 11:00:00 AM"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@datebox").eq(1)).getText(),
				)(),
			),
		);
	await t.click(Selector(() => jq(".z-datebox-button").eq(2)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-timebox-input").eq(2)[0]));
	await ClientFunction(() => {
		zk(jq(".z-timebox-input").eq(2)).setSelectionRange(0);
	})();
	await t.pressKey("home");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() => jq(jq(".z-timebox-input").eq(2))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-timebox-input").eq(2)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 1 0 0 0 0");
	await ztl.waitResponse(t);
	await t.pressKey("right");
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("10/10/2014 11:00:00 AM"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@datebox").eq(2)).getText(),
				)(),
			),
		);
	await t.click(Selector(() => jq(".z-datebox-button").eq(3)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-timebox-input").eq(3)[0]));
	await ClientFunction(() => {
		zk(jq(".z-timebox-input").eq(3)).setSelectionRange(0);
	})();
	await t.pressKey("home");
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() => jq(jq(".z-timebox-input").eq(3))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-timebox-input").eq(3)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("2 1 0 0 0 0");
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("10/10/2014 21:00:00"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@datebox").eq(3)).getText(),
				)(),
			),
		);
});
