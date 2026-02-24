import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z60-TemplateGrid2TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-TemplateGrid2TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<include src="bind/databinding/collection/collection-template-grid.zul"/>`,
	);
	await t.click(
		Selector(
			() =>
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.nextSibling,
				)
					.find("@button")
					.eq(1)[0],
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
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
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
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
					).firstChild.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
					).firstChild.firstChild.nextSibling.nextSibling &&
					!!zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.firstChild.nextSibling.nextSibling,
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.firstChild.nextSibling.nextSibling,
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.firstChild.nextSibling.nextSibling,
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.firstChild.nextSibling.nextSibling,
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.firstChild.nextSibling.nextSibling,
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.firstChild.nextSibling.nextSibling,
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.firstChild.nextSibling.nextSibling,
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
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.lastChild.previousSibling,
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
						jq(
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.lastChild,
						).find("@label"),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
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
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
					).firstChild.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
					).firstChild.nextSibling.firstChild.nextSibling
						.nextSibling &&
					!!zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.firstChild.nextSibling
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.firstChild.nextSibling
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.firstChild.nextSibling
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.firstChild.nextSibling
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.firstChild.nextSibling
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.firstChild.nextSibling
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.firstChild.nextSibling
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
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.nextSibling.lastChild.previousSibling,
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
						jq(
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.lastChild,
						).find("@label"),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
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
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
					).firstChild.nextSibling.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D"));
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
					).firstChild.nextSibling.nextSibling.firstChild.nextSibling
						.nextSibling &&
					!!zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.firstChild
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.firstChild
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.firstChild
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.firstChild
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.firstChild
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.firstChild
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.firstChild
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
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.nextSibling.nextSibling.lastChild
						.previousSibling,
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
						jq(
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.lastChild,
						).find("@label"),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model1"));
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
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
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
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
					).firstChild.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.lastChild,
						).find("@label"),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
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
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
					).firstChild.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.lastChild,
						).find("@label"),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
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
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
					).firstChild.nextSibling.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.lastChild,
						).find("@label"),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
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
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
					).firstChild.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.nextSibling
								.lastChild,
						).find("@label"),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model2"));
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
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
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
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
					).firstChild.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.lastChild,
						).find("@label"),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
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
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
					).firstChild.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.lastChild,
						).find("@label"),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
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
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
					).firstChild.nextSibling.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C12"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.lastChild,
						).find("@label"),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
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
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
					).firstChild.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.nextSibling
								.lastChild,
						).find("@label"),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
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
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
					).firstChild.nextSibling.nextSibling.nextSibling.nextSibling.firstChild.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("D"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.nextSibling
								.nextSibling.lastChild,
						).find("@label"),
					).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Model2"));
});
