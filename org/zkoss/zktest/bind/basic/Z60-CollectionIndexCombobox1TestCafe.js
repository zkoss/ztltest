import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z60-CollectionIndexCombobox1TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-CollectionIndexCombobox1TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<include src="/bind/databinding/collection/collection-index-combobox.zul"/>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("$outergrid").find("@rows").children().length,
				)(),
			),
		)
		.eql(ztl.normalizeText("4"));
	await ClientFunction(() => {
		zk.Widget.$(
			jq("$outergrid").find("@rows").children().eq(0).find("@combobox"),
		).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(0)
							.find("@combobox")
							.find("@comboitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(0)
							.find("@combobox")
							.find("@comboitem")
							.eq(0),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A 0-0-0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(0)
							.find("@combobox")
							.find("@comboitem")
							.eq(0),
					).getDescription(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(0)
							.find("@combobox")
							.find("@comboitem")
							.eq(1),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A 1-1-0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(0)
							.find("@combobox")
							.find("@comboitem")
							.eq(1),
					).getDescription(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq("$outergrid").find("@rows").children().eq(0).find("@button"),
			).$n(),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$msg")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("item index 0"));
	await ClientFunction(() => {
		zk.Widget.$(
			jq("$outergrid").find("@rows").children().eq(1).find("@combobox"),
		).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(1)
							.find("@combobox")
							.find("@comboitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(1)
							.find("@combobox")
							.find("@comboitem")
							.eq(0),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("B 0-0-1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(1)
							.find("@combobox")
							.find("@comboitem")
							.eq(0),
					).getDescription(),
				)(),
			),
		)
		.eql(ztl.normalizeText("B 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(1)
							.find("@combobox")
							.find("@comboitem")
							.eq(1),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("B 1-1-1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(1)
							.find("@combobox")
							.find("@comboitem")
							.eq(1),
					).getDescription(),
				)(),
			),
		)
		.eql(ztl.normalizeText("B 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq("$outergrid").find("@rows").children().eq(1).find("@button"),
			).$n(),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$msg")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("item index 1"));
	await ClientFunction(() => {
		zk.Widget.$(
			jq("$outergrid").find("@rows").children().eq(2).find("@combobox"),
		).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(2)
							.find("@combobox")
							.find("@comboitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(2)
							.find("@combobox")
							.find("@comboitem")
							.eq(0),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C 0-0-2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(2)
							.find("@combobox")
							.find("@comboitem")
							.eq(0),
					).getDescription(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(2)
							.find("@combobox")
							.find("@comboitem")
							.eq(1),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C 1-1-2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(2)
							.find("@combobox")
							.find("@comboitem")
							.eq(1),
					).getDescription(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq("$outergrid").find("@rows").children().eq(2).find("@button"),
			).$n(),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$msg")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("item index 2"));
	await ClientFunction(() => {
		zk.Widget.$(
			jq("$outergrid").find("@rows").children().eq(3).find("@combobox"),
		).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(3)
							.find("@combobox")
							.find("@comboitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(3)
							.find("@combobox")
							.find("@comboitem")
							.eq(0),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D 0-0-3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(3)
							.find("@combobox")
							.find("@comboitem")
							.eq(0),
					).getDescription(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(3)
							.find("@combobox")
							.find("@comboitem")
							.eq(1),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D 1-1-3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid")
							.find("@rows")
							.children()
							.eq(3)
							.find("@combobox")
							.find("@comboitem")
							.eq(1),
					).getDescription(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq("$outergrid").find("@rows").children().eq(3).find("@button"),
			).$n(),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$msg")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("item index 3"));
});
