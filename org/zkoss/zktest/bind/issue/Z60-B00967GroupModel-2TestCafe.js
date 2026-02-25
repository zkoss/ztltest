import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z60-B00967GroupModel-2TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-B00967GroupModel-2TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<include src="/bind/issue/B00967GroupModelListbox.zul"/>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("$listbox").find("@listgroup").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("$listbox").find("@listgroupfoot").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("$listbox").find("@listitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("5"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$listbox")
							.find("@listgroup")
							.eq(0)
							.find("@listcell"),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Fruits"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$listbox")
							.find("@listgroup")
							.eq(1)
							.find("@listcell"),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Seafood"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$listbox")
							.find("@listgroup")
							.eq(2)
							.find("@listcell"),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Vegetables"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$listbox")
							.find("@listgroupfoot")
							.eq(0)
							.find("@listcell"),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$listbox")
							.find("@listgroupfoot")
							.eq(1)
							.find("@listcell"),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$listbox")
							.find("@listgroupfoot")
							.eq(2)
							.find("@listcell"),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$listbox")
							.find("@listitem")
							.eq(0)
							.find("@label")
							.eq(1),
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
						jq("$listbox")
							.find("@listitem")
							.eq(1)
							.find("@label")
							.eq(1),
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
						jq("$listbox")
							.find("@listitem")
							.eq(2)
							.find("@label")
							.eq(1),
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
						jq("$listbox")
							.find("@listitem")
							.eq(3)
							.find("@label")
							.eq(1),
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
						jq("$listbox")
							.find("@listitem")
							.eq(4)
							.find("@label")
							.eq(1),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Beets"));
	await t.click(
		Selector(() =>
			zk.Widget.$(jq("$listbox").find("@listitem").eq(4)).$n(),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l1")).getValue())(),
			),
		)
		.eql(ztl.normalizeText("Beets"));
	await t.click(Selector(() => zk.Widget.$(jq("$sel1")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l1")).getValue())(),
			),
		)
		.eql(ztl.normalizeText("Apples"));
	await t.click(Selector(() => zk.Widget.$(jq("$sel2")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => zk.Widget.$(jq("$l1")).getValue())(),
			),
		)
		.eql(ztl.normalizeText("Salmon"));
});
