import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z60-B00967GroupModel-1TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-B00967GroupModel-1TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<include src="/bind/issue/B00967GroupModel.zul"/>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$grid").find("@group").length)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("$grid").find("@groupfoot").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("$grid").find("@row").length)(),
			),
		)
		.eql(ztl.normalizeText("5"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$grid").find("@group").eq(0)).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Fruits"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$grid").find("@group").eq(1)).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Seafood"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$grid").find("@group").eq(2)).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Vegetables"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$grid").find("@groupfoot").eq(0).find("@label"),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$grid").find("@groupfoot").eq(1).find("@label"),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$grid").find("@groupfoot").eq(2).find("@label"),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$grid").find("@row").eq(0).find("@label").eq(1),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Apples"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$grid").find("@row").eq(1).find("@label").eq(1),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Salmon"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$grid").find("@row").eq(2).find("@label").eq(1),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Shrimp"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$grid").find("@row").eq(3).find("@label").eq(1),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Asparagus"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$grid").find("@row").eq(4).find("@label").eq(1),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Beets"));
});
