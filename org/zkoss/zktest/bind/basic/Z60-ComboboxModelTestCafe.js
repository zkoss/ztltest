import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z60-ComboboxModelTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-ComboboxModelTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/bind/basic/comboboxmodel.zul"/>`);
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.nextSibling,
				)
					.find("@button")
					.eq(1),
			).$n(),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Widget.$(
							jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
						).nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await ClientFunction(() => {
		zk.Widget.$(
			jq(
				zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
					.firstChild,
			).find("@combobox"),
		).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild,
								).find("@combobox"),
							),
						).find("@comboitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild,
								).find("@combobox"),
							),
						)
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
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild,
				).find("@button"),
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
			jq(
				zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
					.firstChild.nextSibling,
			).find("@combobox"),
		).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling,
								).find("@combobox"),
							),
						).find("@comboitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(0),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C 0-0-1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(1),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C 1-1-1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling,
								).find("@combobox"),
							),
						)
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
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.nextSibling,
				).find("@button"),
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
			jq(
				zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
					.firstChild.nextSibling.nextSibling,
			).find("@combobox"),
		).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling,
								).find("@combobox"),
							),
						).find("@comboitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(0),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D 0-0-2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(1),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D 1-1-2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling,
								).find("@combobox"),
							),
						)
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
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.nextSibling.nextSibling,
				).find("@button"),
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
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.nextSibling,
				)
					.find("@button")
					.eq(2),
			).$n(),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Widget.$(
							jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
						).nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("4"));
	await ClientFunction(() => {
		zk.Widget.$(
			jq(
				zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
					.firstChild,
			).find("@combobox"),
		).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild,
								).find("@combobox"),
							),
						).find("@comboitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild,
								).find("@combobox"),
							),
						)
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
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild,
				).find("@button"),
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
			jq(
				zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
					.firstChild.nextSibling,
			).find("@combobox"),
		).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling,
								).find("@combobox"),
							),
						).find("@comboitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(0),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C 0-0-1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(1),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C 1-1-1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling,
								).find("@combobox"),
							),
						)
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
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.nextSibling,
				).find("@button"),
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
			jq(
				zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
					.firstChild.nextSibling.nextSibling,
			).find("@combobox"),
		).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling,
								).find("@combobox"),
							),
						).find("@comboitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(0),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C1 0-0-2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(0),
					).getDescription(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C1 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(1),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C1 1-1-2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(1),
					).getDescription(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C1 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.nextSibling.nextSibling,
				).find("@button"),
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
			jq(
				zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
					.firstChild.nextSibling.nextSibling.nextSibling,
			).find("@combobox"),
		).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling
										.nextSibling,
								).find("@combobox"),
							),
						).find("@comboitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling
										.nextSibling,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling
										.nextSibling,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling
										.nextSibling,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling
										.nextSibling,
								).find("@combobox"),
							),
						)
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
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.nextSibling.nextSibling.nextSibling,
				).find("@button"),
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
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.nextSibling.nextSibling,
				)
					.find("@button")
					.eq(3),
			).$n(),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Widget.$(
							jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
						).nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("5"));
	await ClientFunction(() => {
		zk.Widget.$(
			jq(
				zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
					.firstChild,
			).find("@combobox"),
		).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild,
								).find("@combobox"),
							),
						).find("@comboitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild,
								).find("@combobox"),
							),
						)
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
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild,
				).find("@button"),
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
			jq(
				zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
					.firstChild.nextSibling,
			).find("@combobox"),
		).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling,
								).find("@combobox"),
							),
						).find("@comboitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(0),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C 0-0-1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(1),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C 1-1-1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling,
								).find("@combobox"),
							),
						)
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
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.nextSibling,
				).find("@button"),
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
			jq(
				zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
					.firstChild.nextSibling.nextSibling,
			).find("@combobox"),
		).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling,
								).find("@combobox"),
							),
						).find("@comboitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(0),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C12 0-0-2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(0),
					).getDescription(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C12 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(1),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C12 1-1-2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(1),
					).getDescription(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C12 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.nextSibling.nextSibling,
				).find("@button"),
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
			jq(
				zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
					.firstChild.nextSibling.nextSibling.nextSibling,
			).find("@combobox"),
		).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling
										.nextSibling,
								).find("@combobox"),
							),
						).find("@comboitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling
										.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(0),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C1 0-0-3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling
										.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(0),
					).getDescription(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C1 0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling
										.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(1),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C1 1-1-3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling
										.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(1),
					).getDescription(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C1 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.nextSibling.nextSibling.nextSibling,
				).find("@button"),
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
	await ClientFunction(() => {
		zk.Widget.$(
			jq(
				zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
					.firstChild.nextSibling.nextSibling.nextSibling.nextSibling,
			).find("@combobox"),
		).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling
										.nextSibling.nextSibling,
								).find("@combobox"),
							),
						).find("@comboitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling
										.nextSibling.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(0),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D 0-0-4"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling
										.nextSibling.nextSibling,
								).find("@combobox"),
							),
						)
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
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling
										.nextSibling.nextSibling,
								).find("@combobox"),
							),
						)
							.find("@comboitem")
							.eq(1),
					).getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D 1-1-4"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(
										jq(zk.Widget.$(jq("$outergrid"))).find(
											"@rows",
										),
									).firstChild.nextSibling.nextSibling
										.nextSibling.nextSibling,
								).find("@combobox"),
							),
						)
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
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.nextSibling.nextSibling.nextSibling
						.nextSibling,
				).find("@button"),
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
		.eql(ztl.normalizeText("item index 4"));
});
