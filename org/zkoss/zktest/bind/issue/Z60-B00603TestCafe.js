import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z60-B00603TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-B00603TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/bind/issue/B00603.zul" />`);
	await t
		.expect(ztl.normalizeText("4"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("outsidebox", true).nChildren,
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt
						.$f("outsidebox", true)
						.firstChild.nextSibling.firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A"));
	await t.expect("true").ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(
								zk.Desktop._dt.$f("outsidebox", true).firstChild
									.nextSibling,
							).find("@listbox"),
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
							jq(
								zk.Desktop._dt.$f("outsidebox", true).firstChild
									.nextSibling,
							).find("@listbox"),
						)
							.find("@listitem")
							.first(),
					).firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							jq(
								zk.Desktop._dt.$f("outsidebox", true).firstChild
									.nextSibling,
							).find("@listbox"),
						)
							.find("@listitem")
							.first(),
					).firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A AA"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							jq(
								zk.Desktop._dt.$f("outsidebox", true).firstChild
									.nextSibling,
							).find("@listbox"),
						)
							.find("@listitem")
							.first()
							.next(),
					).firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A B"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							jq(
								zk.Desktop._dt.$f("outsidebox", true).firstChild
									.nextSibling,
							).find("@listbox"),
						)
							.find("@listitem")
							.first()
							.next(),
					).firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("A BB"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt
						.$f("outsidebox", true)
						.firstChild.nextSibling.nextSibling.firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("B"));
	await t.expect("true").ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(
								zk.Desktop._dt.$f("outsidebox", true).firstChild
									.nextSibling.nextSibling,
							).find("@listbox"),
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
							jq(
								zk.Desktop._dt.$f("outsidebox", true).firstChild
									.nextSibling.nextSibling,
							).find("@listbox"),
						)
							.find("@listitem")
							.first(),
					).firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("B A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							jq(
								zk.Desktop._dt.$f("outsidebox", true).firstChild
									.nextSibling.nextSibling,
							).find("@listbox"),
						)
							.find("@listitem")
							.first(),
					).firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("B AA"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							jq(
								zk.Desktop._dt.$f("outsidebox", true).firstChild
									.nextSibling.nextSibling,
							).find("@listbox"),
						)
							.find("@listitem")
							.first()
							.next(),
					).firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("B B"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							jq(
								zk.Desktop._dt.$f("outsidebox", true).firstChild
									.nextSibling.nextSibling,
							).find("@listbox"),
						)
							.find("@listitem")
							.first()
							.next(),
					).firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("B BB"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt
						.$f("outsidebox", true)
						.firstChild.nextSibling.nextSibling.nextSibling.firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C"));
	await t.expect("true").ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(
							jq(
								zk.Desktop._dt.$f("outsidebox", true).firstChild
									.nextSibling.nextSibling.nextSibling,
							).find("@listbox"),
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
							jq(
								zk.Desktop._dt.$f("outsidebox", true).firstChild
									.nextSibling.nextSibling.nextSibling,
							).find("@listbox"),
						)
							.find("@listitem")
							.first(),
					).firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C A"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							jq(
								zk.Desktop._dt.$f("outsidebox", true).firstChild
									.nextSibling.nextSibling.nextSibling,
							).find("@listbox"),
						)
							.find("@listitem")
							.first(),
					).firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C AA"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							jq(
								zk.Desktop._dt.$f("outsidebox", true).firstChild
									.nextSibling.nextSibling.nextSibling,
							).find("@listbox"),
						)
							.find("@listitem")
							.first()
							.next(),
					).firstChild.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C B"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(
						jq(
							jq(
								zk.Desktop._dt.$f("outsidebox", true).firstChild
									.nextSibling.nextSibling.nextSibling,
							).find("@listbox"),
						)
							.find("@listitem")
							.first()
							.next(),
					).firstChild.nextSibling.getLabel(),
				)(),
			),
		)
		.eql(ztl.normalizeText("C BB"));
});
