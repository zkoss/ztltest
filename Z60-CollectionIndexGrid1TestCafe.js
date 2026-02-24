import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z60-CollectionIndexGrid1TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-CollectionIndexGrid1TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<include src="/bind/databinding/collection/collection-index-grid.zul"/>`,
	);
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
							.first(),
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
							.first(),
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
							.first(),
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
							.next(),
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
							.next(),
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
							.next(),
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
						.firstChild.lastChild,
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
		.eql(ztl.normalizeText("B"));
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
							.first(),
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
							.first(),
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
							.first(),
					).firstChild.nextSibling.nextSibling.getValue(),
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
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.firstChild.nextSibling
								.nextSibling,
						)
							.find("@row")
							.next(),
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
							.next(),
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
							.next(),
					).firstChild.nextSibling.nextSibling.getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("B 1"));
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(
					zk.Widget.$(jq(zk.Widget.$(jq("$outergrid"))).find("@rows"))
						.firstChild.nextSibling.lastChild,
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
		.eql(ztl.normalizeText("C"));
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
							.first(),
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
							.first(),
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
							.first(),
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
							).firstChild.nextSibling.nextSibling.firstChild
								.nextSibling.nextSibling,
						)
							.find("@row")
							.next(),
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
							.next(),
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
							.next(),
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
						.firstChild.nextSibling.nextSibling.lastChild,
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
			await ClientFunction(
				() =>
					!!zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
					).firstChild.nextSibling.nextSibling.nextSibling.firstChild
						.nextSibling.nextSibling &&
					!!zk.Widget.$(
						jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.nextSibling
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.first(),
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
							).firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.first(),
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.first(),
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
							).firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.next(),
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
							).firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.next(),
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
							zk.Widget.$(
								jq(zk.Widget.$(jq("$outergrid"))).find("@rows"),
							).firstChild.nextSibling.nextSibling.nextSibling
								.firstChild.nextSibling.nextSibling,
						)
							.find("@row")
							.next(),
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
						.firstChild.nextSibling.nextSibling.nextSibling
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
		.eql(ztl.normalizeText("item index 3"));
});
