import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-1622TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-1622.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-1622TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.doScroll({
		locator: Selector(() => zk.Widget.$(jq("@listbox")).$n()),
		scrollType: "vertical",
		percent: "1.0",
	});
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listcell:contains(50)")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq(zk.Widget.$(jq("@listbox"))).find(".z-paging-next")[0],
		),
	);
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => zk.Widget.$(jq("@listbox")).$n()),
		scrollType: "vertical",
		percent: "1.0",
	});
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@listbox")).$n("cave")).outerHeight(),
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() =>
					jq(zk.Widget.$(jq("@listbox")).$n("body"))[0].scrollHeight,
			)(),
		),
		ztl.normalizeText("2"),
	);
	await ztl.doScroll({
		locator: Selector(() => zk.Widget.$(jq("@tree")).$n()),
		scrollType: "vertical",
		percent: "1.0",
	});
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-treecell:contains(50)")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(zk.Widget.$(jq("@tree"))).find(".z-paging-next")[0]),
	);
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => zk.Widget.$(jq("@tree")).$n()),
		scrollType: "vertical",
		percent: "1.0",
	});
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@tree")).$n("cave")).outerHeight(),
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(
				() => jq(zk.Widget.$(jq("@tree")).$n("body"))[0].scrollHeight,
			)(),
		),
		ztl.normalizeText("2"),
	);
});
