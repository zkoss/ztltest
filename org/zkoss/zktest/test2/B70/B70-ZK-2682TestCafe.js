import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2682TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2682.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2682TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		zk.Widget.$(jq("@combobox")).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Widget.$(jq("@combobox"))).find("@comboitem")
							.length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("@grid:first").find("@row").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("@listbox:first").find("@listitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("@grid:last").find("@row").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("@listbox:last").find("@listitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t.click(Selector(() => jq("@grid:last").find(".z-paging-next")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("@grid:last").find("@row").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t.click(
		Selector(() => jq("@listbox:last").find(".z-paging-next")[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("@listbox:last").find("@listitem").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await ClientFunction(() => {
		zk.Widget.$(jq("@combobox")).open();
	})();
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Widget.$(jq("@combobox")))
					.find("@comboitem")
					.last()[0],
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listbox:first")
					.find("@listitem")
					.last()
					.hasClass("z-listitem-selected"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listbox:last")
					.find("@listitem")
					.last()
					.hasClass("z-listitem-selected"),
			)(),
		)
		.ok();
	await ClientFunction(() => {
		zk.Widget.$(jq("@combobox")).open();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("@combobox")))
					.find("@comboitem")
					.last()
					.hasClass("z-comboitem-selected"),
			)(),
		)
		.ok();
});
