import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z60-TemplateGrid3TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-TemplateGrid3TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<include src="bind/databinding/collection/collection-template-grid.zul"/>`,
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
		.eql(ztl.normalizeText("B"));
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
		.eql(ztl.normalizeText("C"));
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
	await t.click(Selector(() => jq(".z-button:contains(change1)")[0]));
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
		.eql(ztl.normalizeText("X"));
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
		.eql(ztl.normalizeText("Model2"));
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
		.eql(ztl.normalizeText("A"));
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
		.eql(ztl.normalizeText("Model1"));
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
	await t.click(Selector(() => jq(".z-button:contains(change2)")[0]));
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
		.eql(ztl.normalizeText("B"));
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
		.eql(ztl.normalizeText("C"));
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
});
