import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2359TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2359.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2359TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() => jq("@listbox").find(".z-paging-button").eq(2)[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq("@listbox").find(".z-paging-button").eq(2)[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq("@listbox").find(".z-paging-button").eq(2)[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	let value_cafe = await ClientFunction(() =>
		jq("@listbox").find(".z-paging-input").attr("value"),
	)();
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox").find(".z-paging-input").attr("value"),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(value_cafe),
			"value should be the same. it means no flickering.",
		);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox").find(".z-paging-input").attr("value"),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(value_cafe),
			"value should be the same. it means no flickering.",
		);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox").find(".z-paging-input").attr("value"),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(value_cafe),
			"value should be the same. it means no flickering.",
		);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox").find(".z-paging-input").attr("value"),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(value_cafe),
			"value should be the same. it means no flickering.",
		);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox").find(".z-paging-input").attr("value"),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(value_cafe),
			"value should be the same. it means no flickering.",
		);
	await t.click(
		Selector(() => jq("@grid").find(".z-paging-button").eq(2)[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq("@grid").find(".z-paging-button").eq(2)[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq("@grid").find(".z-paging-button").eq(2)[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	let value_cafet = await ClientFunction(() =>
		jq("@grid").find(".z-paging-input").attr("value"),
	)();
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@grid").find(".z-paging-input").attr("value"),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(value_cafet),
			"value should be the same. it means no flickering.",
		);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@grid").find(".z-paging-input").attr("value"),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(value_cafet),
			"value should be the same. it means no flickering.",
		);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@grid").find(".z-paging-input").attr("value"),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(value_cafet),
			"value should be the same. it means no flickering.",
		);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@grid").find(".z-paging-input").attr("value"),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(value_cafet),
			"value should be the same. it means no flickering.",
		);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@grid").find(".z-paging-input").attr("value"),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(value_cafet),
			"value should be the same. it means no flickering.",
		);
	await t.click(
		Selector(() => jq("@tree").find(".z-paging-button").eq(2)[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq("@tree").find(".z-paging-button").eq(2)[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq("@tree").find(".z-paging-button").eq(2)[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	let value_cafett = await ClientFunction(() =>
		jq("@tree").find(".z-paging-input").attr("value"),
	)();
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@tree").find(".z-paging-input").attr("value"),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(value_cafett),
			"value should be the same. it means no flickering.",
		);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@tree").find(".z-paging-input").attr("value"),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(value_cafett),
			"value should be the same. it means no flickering.",
		);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@tree").find(".z-paging-input").attr("value"),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(value_cafett),
			"value should be the same. it means no flickering.",
		);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@tree").find(".z-paging-input").attr("value"),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(value_cafett),
			"value should be the same. it means no flickering.",
		);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@tree").find(".z-paging-input").attr("value"),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(value_cafett),
			"value should be the same. it means no flickering.",
		);
});
