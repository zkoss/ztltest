import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z60-TemplateListbox2TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-TemplateListbox2TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<include src="bind/databinding/collection/collection-template-listbox.zul"/>`,
	);
	await t.click(
		Selector(
			() =>
				jq(
					zk.Widget.$(jq("$outerbox")).firstChild.nextSibling
						.nextSibling,
				)
					.find("@button")
					.eq(1)[0],
		),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => zk.Widget.$(jq("$outerbox")).nChildren,
	)();
	await t
		.expect(ztl.normalizeText(verifyVariable_cafe_0_0 - 1))
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(
						jq(
							zk.Widget.$(jq("$outerbox")).firstChild.nextSibling,
						).find("@listbox"),
					) &&
					!!zk.Widget.$(
						jq(
							zk.Widget.$(jq("$outerbox")).firstChild.nextSibling,
						).find("@listbox"),
					).$n(),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling,
								).find("@listbox"),
							),
						).find("@listitem").length,
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
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(0),
					).firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(0),
					).firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(0),
					).firstChild.nextSibling.nextSibling.getLabel(),
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
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(1),
					).firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(1),
					).firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(1),
					).firstChild.nextSibling.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outerbox")).firstChild.nextSibling
						.lastChild.previousSibling,
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
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.lastChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(
						jq(
							zk.Widget.$(jq("$outerbox")).firstChild.nextSibling
								.nextSibling,
						).find("@listbox"),
					) &&
					!!zk.Widget.$(
						jq(
							zk.Widget.$(jq("$outerbox")).firstChild.nextSibling
								.nextSibling,
						).find("@listbox"),
					).$n(),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling.nextSibling,
								).find("@listbox"),
							),
						).find("@listitem").length,
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
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(0),
					).firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(0),
					).firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(0),
					).firstChild.nextSibling.nextSibling.getLabel(),
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
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(1),
					).firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(1),
					).firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(1),
					).firstChild.nextSibling.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outerbox")).firstChild.nextSibling
						.nextSibling.lastChild.previousSibling,
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
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.lastChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(
						jq(
							zk.Widget.$(jq("$outerbox")).firstChild.nextSibling
								.nextSibling.nextSibling,
						).find("@listbox"),
					) &&
					!!zk.Widget.$(
						jq(
							zk.Widget.$(jq("$outerbox")).firstChild.nextSibling
								.nextSibling.nextSibling,
						).find("@listbox"),
					).$n(),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling.nextSibling.nextSibling,
								).find("@listbox"),
							),
						).find("@listitem").length,
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
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling.nextSibling.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(0),
					).firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling.nextSibling.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(0),
					).firstChild.nextSibling.getLabel(),
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
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling.nextSibling.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(0),
					).firstChild.nextSibling.nextSibling.getLabel(),
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
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling.nextSibling.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(1),
					).firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling.nextSibling.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(1),
					).firstChild.nextSibling.getLabel(),
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
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling.nextSibling.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.eq(1),
					).firstChild.nextSibling.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outerbox")).firstChild.nextSibling
						.nextSibling.nextSibling.lastChild.previousSibling,
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
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.lastChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model1"));
	await t.click(
		Selector(
			() =>
				jq(
					zk.Widget.$(jq("$outerbox")).firstChild.nextSibling
						.nextSibling,
				)
					.find("@button")
					.eq(2)[0],
		),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => zk.Widget.$(jq("$outerbox")).nChildren,
	)();
	await t
		.expect(ztl.normalizeText(verifyVariable_cafe_1_1 - 1))
		.eql(ztl.normalizeText("4"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.lastChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.lastChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.lastChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.lastChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model2"));
	await t.click(
		Selector(
			() =>
				jq(
					zk.Widget.$(jq("$outerbox")).firstChild.nextSibling
						.nextSibling.nextSibling,
				)
					.find("@button")
					.eq(3)[0],
		),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => zk.Widget.$(jq("$outerbox")).nChildren,
	)();
	await t
		.expect(ztl.normalizeText(verifyVariable_cafe_2_2 - 1))
		.eql(ztl.normalizeText("5"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.lastChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.lastChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C12"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.lastChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.lastChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("4"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outerbox"),
					).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.lastChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model2"));
});
