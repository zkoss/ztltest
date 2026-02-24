import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2997975TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-2997975.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-2997975TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("b", true).$n("real")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("b", true).$n("pp")).is(":visible"),
			)(),
		)
		.notOk();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("b", true).$n("btn")).css("display"),
				)(),
			),
		)
		.eql(ztl.normalizeText("none"));
	await t.click(Selector(() => zk.Desktop._dt.$f("c", true).$n("real")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("c", true).$n("pp")).is(":visible"),
			)(),
		)
		.notOk();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("c", true).$n("btn")).css("display"),
				)(),
			),
		)
		.eql(ztl.normalizeText("none"));
	await t.click(Selector(() => zk.Desktop._dt.$f("d", true).$n("real")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("d", true).$n("pp")).is(":visible"),
			)(),
		)
		.notOk();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("d", true).$n("btn")).css("display"),
				)(),
			),
		)
		.eql(ztl.normalizeText("none"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("t", true).$n("btn")).css("display"),
				)(),
			),
		)
		.eql(ztl.normalizeText("none"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("s", true).$n("btn")).css("display"),
				)(),
			),
		)
		.eql(ztl.normalizeText("none"));
	await t
		.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()))
		.click(Selector(() => zk.Desktop._dt.$f("b", true).$n("real")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("b", true).$n("pp")).is(":visible"),
			)(),
		)
		.notOk();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("b", true).$n("btn")).css("display"),
				)(),
			),
		)
		.notEql(ztl.normalizeText("none"), "");
	await t.click(Selector(() => zk.Desktop._dt.$f("c", true).$n("real")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("c", true).$n("pp")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("c", true).$n("btn")).css("display"),
				)(),
			),
		)
		.notEql(ztl.normalizeText("none"), "");
	await t.click(Selector(() => zk.Desktop._dt.$f("d", true).$n("real")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("d", true).$n("pp")).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("d", true).$n("btn")).css("display"),
				)(),
			),
		)
		.notEql(ztl.normalizeText("none"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("t", true).$n("btn")).css("display"),
				)(),
			),
		)
		.notEql(ztl.normalizeText("none"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("s", true).$n("btn")).css("display"),
				)(),
			),
		)
		.notEql(ztl.normalizeText("none"), "");
});
