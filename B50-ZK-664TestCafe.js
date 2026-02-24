import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-664TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-664.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-664TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("chrome,ff,safari,edge_legacy,edge")) {
		console.log(
			"This issue is ignored in current browser! (chrome,ff,safari,edge_legacy,edge)",
		);
		return;
	}
	await t.click(Selector(() => jq("@textbox").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t.wait(800).click(Selector(() => jq("@textbox").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t.wait(800).click(Selector(() => jq("@textbox").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("space");
	await ztl.waitResponse(t);
	await t.wait(800).click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.wait(800).click(Selector(() => jq("@textbox").eq(0)[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(zk.Widget.$(jq("@textbox").eq(0)))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Widget.$(jq("@textbox").eq(0)).$n()),
		ztl.normalizeText("abcd"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@textbox")
						.eq(0)
						.find("input")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					$("iframe").contents().find(".test1").eq(0).text(),
				)(),
			),
		)
		.eql(ztl.normalizeText("5"));
	await t.click(Selector(() => jq("@textbox").eq(3)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t.wait(800).click(Selector(() => jq("@textbox").eq(3)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t.wait(800).click(Selector(() => jq("@textbox").eq(3)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("space");
	await ztl.waitResponse(t);
	await t.wait(800).click(Selector(() => jq("@button").eq(2)[0]));
	await ztl.waitResponse(t);
	await t.wait(800).click(Selector(() => jq("@textbox").eq(3)[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(zk.Widget.$(jq("@textbox").eq(3)))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Widget.$(jq("@textbox").eq(3)).$n()),
		ztl.normalizeText("abcd"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(3)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@textbox")
						.eq(3)
						.find("input")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					$("iframe").contents().find(".test1").eq(0).text(),
				)(),
			),
		)
		.eql(ztl.normalizeText("9"));
	await t.click(Selector(() => jq("@textbox").eq(4)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t.wait(800).click(Selector(() => jq("@textbox").eq(4)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t.wait(800).click(Selector(() => jq("@textbox").eq(4)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("space");
	await ztl.waitResponse(t);
	await t.wait(800).click(Selector(() => jq("@button").eq(4)[0]));
	await ztl.waitResponse(t);
	await t.wait(800).click(Selector(() => jq("@textbox").eq(4)[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(zk.Widget.$(jq("@textbox").eq(4)))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Widget.$(jq("@textbox").eq(4)).$n()),
		ztl.normalizeText("abcd"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(5)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@textbox")
						.eq(4)
						.find("input")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					$("iframe").contents().find(".test1").eq(0).text(),
				)(),
			),
		)
		.eql(ztl.normalizeText("13"));
	await t.click(Selector(() => jq("@textbox").eq(7)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t.wait(800).click(Selector(() => jq("@textbox").eq(7)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("enter");
	await ztl.waitResponse(t);
	await t.wait(800).click(Selector(() => jq("@textbox").eq(7)[0]));
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("space");
	await ztl.waitResponse(t);
	await t.wait(800).click(Selector(() => jq("@button").eq(6)[0]));
	await ztl.waitResponse(t);
	await t.wait(800).click(Selector(() => jq("@textbox").eq(7)[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(zk.Widget.$(jq("@textbox").eq(7)))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Widget.$(jq("@textbox").eq(7)).$n()),
		ztl.normalizeText("abcd"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(7)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@textbox")
						.eq(7)
						.find("input")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					$("iframe").contents().find(".test1").eq(0).text(),
				)(),
			),
		)
		.eql(ztl.normalizeText("17"));
	await t.click(Selector(() => jq("$resetBtn")[0]));
});
