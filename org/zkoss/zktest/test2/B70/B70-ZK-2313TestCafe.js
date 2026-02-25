import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2313TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2313.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2313TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(0)).$n(),
					),
				}),
			),
		)
		.notEql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(1)).$n(),
					),
				}),
			),
		)
		.notEql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(2)).$n(),
					),
				}),
			),
		)
		.notEql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(3)).$n(),
					),
				}),
			),
		)
		.notEql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(4)).$n(),
					),
				}),
			),
		)
		.notEql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(5)).$n(),
					),
				}),
			),
		)
		.notEql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(6)).$n(),
					),
				}),
			),
		)
		.notEql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(7)).$n(),
					),
				}),
			),
		)
		.notEql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(0)).$n(),
					),
				}),
			),
		)
		.eql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(1)).$n(),
					),
				}),
			),
		)
		.eql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(2)).$n(),
					),
				}),
			),
		)
		.eql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(3)).$n(),
					),
				}),
			),
		)
		.eql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(4)).$n(),
					),
				}),
			),
		)
		.eql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(5)).$n(),
					),
				}),
			),
		)
		.eql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(6)).$n(),
					),
				}),
			),
		)
		.eql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(7)).$n(),
					),
				}),
			),
		)
		.eql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t.click(Selector(() => jq("@button:eq(2)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(0)).$n(),
					),
				}),
			),
		)
		.notEql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(1)).$n(),
					),
				}),
			),
		)
		.notEql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(2)).$n(),
					),
				}),
			),
		)
		.notEql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(3)).$n(),
					),
				}),
			),
		)
		.notEql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(4)).$n(),
					),
				}),
			),
		)
		.notEql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(5)).$n(),
					),
				}),
			),
		)
		.notEql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(6)).$n(),
					),
				}),
			),
		)
		.notEql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Widget.$(jq("@listbox").eq(7)).$n(),
					),
				}),
			),
		)
		.notEql(
			ztl.normalizeText("0"),
			"scrolling should be changed after button click.",
		);
});
