import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1737660TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1737660.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1737660TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(0)
						.find("@listitem")
						.find("@listcell")
						.eq(0)
						.outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(0)
						.find("@listhead")
						.find("@listheader")
						.eq(0)
						.outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(0)
						.find("@listitem")
						.find("@listcell")
						.eq(0)
						.outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(0)
						.find("@listhead")
						.find("@listheader")
						.eq(0)
						.outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(0)
						.find("@listitem")
						.find("@listcell")
						.eq(0)
						.outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(0)
						.find("@listhead")
						.find("@listheader")
						.eq(0)
						.outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(0)
						.find("@listitem")
						.find("@listcell")
						.eq(0)
						.outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(0)
						.find("@listhead")
						.find("@listheader")
						.eq(0)
						.outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(0)
						.find("@listitem")
						.find("@listcell")
						.eq(0)
						.outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(0)
						.find("@listhead")
						.find("@listheader")
						.eq(0)
						.outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(0)
						.find("@listitem")
						.find("@listcell")
						.eq(0)
						.outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(0)
						.find("@listhead")
						.find("@listheader")
						.eq(0)
						.outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(0)
						.find("@listitem")
						.find("@listcell")
						.eq(0)
						.outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(0)
						.find("@listhead")
						.find("@listheader")
						.eq(0)
						.outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(0)
						.find("@listitem")
						.find("@listcell")
						.eq(0)
						.outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(0)
						.find("@listhead")
						.find("@listheader")
						.eq(0)
						.outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(1)
						.find("@listitem")
						.find("@listcell")
						.eq(1)
						.outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(1)
						.find("@listhead")
						.find("@listheader")
						.eq(1)
						.outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(1)
						.find("@listitem")
						.find("@listcell")
						.eq(1)
						.outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(1)
						.find("@listhead")
						.find("@listheader")
						.eq(1)
						.outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(1)
						.find("@listitem")
						.find("@listcell")
						.eq(1)
						.outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(1)
						.find("@listhead")
						.find("@listheader")
						.eq(1)
						.outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(1)
						.find("@listitem")
						.find("@listcell")
						.eq(1)
						.outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(1)
						.find("@listhead")
						.find("@listheader")
						.eq(1)
						.outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(1)
						.find("@listitem")
						.find("@listcell")
						.eq(1)
						.outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(1)
						.find("@listhead")
						.find("@listheader")
						.eq(1)
						.outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(1)
						.find("@listitem")
						.find("@listcell")
						.eq(1)
						.outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(1)
						.find("@listhead")
						.find("@listheader")
						.eq(1)
						.outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(1)
						.find("@listitem")
						.find("@listcell")
						.eq(1)
						.outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(1)
						.find("@listhead")
						.find("@listheader")
						.eq(1)
						.outerWidth(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(1)
						.find("@listitem")
						.find("@listcell")
						.eq(1)
						.outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox")
						.eq(1)
						.find("@listhead")
						.find("@listheader")
						.eq(1)
						.outerWidth(),
				)(),
			),
		);
});
