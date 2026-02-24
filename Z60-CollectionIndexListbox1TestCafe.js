import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z60-CollectionIndexListbox1TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-CollectionIndexListbox1TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<include src="/bind/databinding/collection/collection-index-listbox.zul"/>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => zk.Widget.$(jq("$outerbox")).nChildren,
	)();
	await t
		.expect(ztl.normalizeText(verifyVariable_cafe_0_0 - 1))
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
							.first(),
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
							.first(),
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
							.first(),
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
							.first()
							.next(),
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
							.first()
							.next(),
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
							.first()
							.next(),
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
						.lastChild,
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
		.eql(ztl.normalizeText("B"));
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
							.first(),
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
							.first(),
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
							.first(),
					).firstChild.nextSibling.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("B 0"));
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
							.first()
							.next(),
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
							.first()
							.next(),
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
							.first()
							.next(),
					).firstChild.nextSibling.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("B 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outerbox")).firstChild.nextSibling
						.nextSibling.lastChild,
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
		.eql(ztl.normalizeText("C"));
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
							.first(),
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
							.first(),
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
							.first(),
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
										.nextSibling.nextSibling.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.first()
							.next(),
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
							.first()
							.next(),
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
							.first()
							.next(),
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
						.nextSibling.nextSibling.lastChild,
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
			await ClientFunction(
				() =>
					!!zk.Widget.$(
						jq(
							zk.Widget.$(jq("$outerbox")).firstChild.nextSibling
								.nextSibling.nextSibling.nextSibling,
						).find("@listbox"),
					) &&
					!!zk.Widget.$(
						jq(
							zk.Widget.$(jq("$outerbox")).firstChild.nextSibling
								.nextSibling.nextSibling.nextSibling,
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
										.nextSibling.nextSibling.nextSibling
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
										.nextSibling.nextSibling.nextSibling
										.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.first(),
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
										.nextSibling.nextSibling.nextSibling
										.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.first(),
					).firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling.nextSibling.nextSibling
										.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.first(),
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
										.nextSibling.nextSibling.nextSibling
										.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.first()
							.next(),
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
										.nextSibling.nextSibling.nextSibling
										.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.first()
							.next(),
					).firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(
									zk.Widget.$(jq("$outerbox")).firstChild
										.nextSibling.nextSibling.nextSibling
										.nextSibling,
								).find("@listbox"),
							),
						)
							.find("@listitem")
							.first()
							.next(),
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
						.nextSibling.nextSibling.nextSibling.lastChild,
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
});
