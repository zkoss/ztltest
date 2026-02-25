import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z60-TemplateListbox3TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-TemplateListbox3TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<include src="bind/databinding/collection/collection-template-listbox.zul"/>`,
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
		.eql(ztl.normalizeText("B"));
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
		.eql(ztl.normalizeText("C"));
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
	await t.click(Selector(() => jq(".z-button:contains(change1)")[0]));
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
		.eql(ztl.normalizeText("X"));
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
		.eql(ztl.normalizeText("Model2"));
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
		.eql(ztl.normalizeText("A"));
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
		.eql(ztl.normalizeText("Model1"));
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
	await t.click(Selector(() => jq(".z-button:contains(change2)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => zk.Widget.$(jq("$outerbox")).nChildren,
	)();
	await t
		.expect(ztl.normalizeText(verifyVariable_cafe_2_2 - 1))
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
		.eql(ztl.normalizeText("B"));
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
		.eql(ztl.normalizeText("C"));
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
});
