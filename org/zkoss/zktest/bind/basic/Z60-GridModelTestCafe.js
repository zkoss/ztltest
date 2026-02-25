import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z60-GridModelTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-GridModelTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/bind/basic/gridmodel.zul"/>`);
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
						.nextSibling,
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
					() => zk.Widget.$(jq("$outergrid").find("@rows")).nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
						.firstChild.nextSibling.nextSibling &&
					!!zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.firstChild.nextSibling.nextSibling.$n(),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						).find("@row").length,
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
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
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
						.nextSibling.firstChild.nextSibling.nextSibling &&
					!!zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.firstChild.nextSibling.nextSibling.$n(),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						).find("@row").length,
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
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
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
						.nextSibling.nextSibling.firstChild.nextSibling
						.nextSibling &&
					!!zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.firstChild.nextSibling.nextSibling.$n(),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						).find("@row").length,
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
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
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
						.nextSibling,
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
					() => zk.Widget.$(jq("$outergrid").find("@rows")).nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("4"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
						.firstChild.nextSibling.nextSibling &&
					!!zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.firstChild.nextSibling.nextSibling.$n(),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						).find("@row").length,
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
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
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
						.nextSibling.firstChild.nextSibling.nextSibling &&
					!!zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.firstChild.nextSibling.nextSibling.$n(),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						).find("@row").length,
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
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
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C1"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
						.nextSibling.nextSibling.firstChild.nextSibling
						.nextSibling &&
					!!zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.firstChild.nextSibling.nextSibling.$n(),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						).find("@row").length,
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C1 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
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
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.nextSibling.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
						.nextSibling.nextSibling.nextSibling.firstChild
						.nextSibling.nextSibling &&
					!!zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.nextSibling.$n(),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						).find("@row").length,
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
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
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
						.nextSibling.nextSibling,
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
					() => zk.Widget.$(jq("$outergrid").find("@rows")).nChildren,
				)(),
			),
		)
		.eql(ztl.normalizeText("5"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
						.firstChild.nextSibling.nextSibling &&
					!!zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.firstChild.nextSibling.nextSibling.$n(),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						).find("@row").length,
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
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
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
						.nextSibling.firstChild.nextSibling.nextSibling &&
					!!zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.firstChild.nextSibling.nextSibling.$n(),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						).find("@row").length,
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
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
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C12"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
						.nextSibling.nextSibling.firstChild.nextSibling
						.nextSibling &&
					!!zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.firstChild.nextSibling.nextSibling.$n(),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						).find("@row").length,
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C12 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
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
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.nextSibling.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C1"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
						.nextSibling.nextSibling.nextSibling.firstChild
						.nextSibling.nextSibling &&
					!!zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.nextSibling.$n(),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						).find("@row").length,
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C1 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
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
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("4"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
						.nextSibling.nextSibling.nextSibling.nextSibling
						.firstChild.nextSibling.nextSibling &&
					!!zk.Widget.$(
						jq("$outergrid").find("@rows"),
					).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.nextSibling.$n(),
			)(),
		)
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.nextSibling.firstChild.nextSibling.nextSibling,
						).find("@row").length,
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.nextSibling.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.nextSibling.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("4"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.nextSibling.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(0),
					).firstChild.nextSibling.nextSibling.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.nextSibling.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.getValue(),
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
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.nextSibling.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("4"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(jq("$outergrid").find("@rows"))
								.firstChild.nextSibling.nextSibling.nextSibling
								.nextSibling.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.eq(1),
					).firstChild.nextSibling.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq("$outergrid").find("@rows")).firstChild
						.nextSibling.nextSibling.nextSibling.nextSibling
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
		.eql(ztl.normalizeText("item index 4"));
});
