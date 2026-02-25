import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2096807TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2096807.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2096807TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	let n_cafe = await ClientFunction(
		() => !!jq("@paging").find(".z-paging-next")[0],
	)();
	await t.expect(n_cafe).ok();
	await t
		.expect(ztl.normalizeText("undefined"))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@paging").find(".z-paging-next").attr("disabled"),
				)(),
			),
			"",
		);
	let l_cafe = await ClientFunction(
		() => !!jq("@paging").find(".z-paging-last")[0],
	)();
	await t.expect(l_cafe).ok();
	await t
		.expect(ztl.normalizeText("undefined"))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@paging").find(".z-paging-last").attr("disabled"),
				)(),
			),
			"",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@paging").find(".z-paging-first").attr("disabled"),
				)(),
			),
		)
		.notEql(ztl.normalizeText(""), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@paging").find(".z-paging-previous").attr("disabled"),
				)(),
			),
		)
		.notEql(ztl.normalizeText(""), "");
	await t.click(Selector(() => jq("@paging").find(".z-paging-next")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("undefined"))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@paging").find(".z-paging-next").attr("disabled"),
				)(),
			),
			"",
		);
	await t
		.expect(
			await ClientFunction(
				() => !!jq("@paging").find(".z-paging-next")[0],
			)(),
		)
		.ok();
	await t
		.expect(ztl.normalizeText("undefined"))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@paging").find(".z-paging-last").attr("disabled"),
				)(),
			),
			"",
		);
	await t
		.expect(
			await ClientFunction(
				() => !!jq("@paging").find(".z-paging-last")[0],
			)(),
		)
		.ok();
	await t
		.expect(ztl.normalizeText("undefined"))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@paging").find(".z-paging-first").attr("disabled"),
				)(),
			),
			"",
		);
	await t
		.expect(
			await ClientFunction(
				() => !!jq("@paging").find(".z-paging-first")[0],
			)(),
		)
		.ok();
	await t
		.expect(ztl.normalizeText("undefined"))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@paging").find(".z-paging-previous").attr("disabled"),
				)(),
			),
			"",
		);
	await t
		.expect(
			await ClientFunction(
				() => !!jq("@paging").find(".z-paging-previous")[0],
			)(),
		)
		.ok();
	await t.click(Selector(() => jq("@paging").find(".z-paging-last")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@paging").find(".z-paging-next").attr("disabled"),
				)(),
			),
		)
		.notEql(ztl.normalizeText(""), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@paging").find(".z-paging-last").attr("disabled"),
				)(),
			),
		)
		.notEql(ztl.normalizeText(""), "");
	await t
		.expect(ztl.normalizeText("undefined"))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@paging").find(".z-paging-first").attr("disabled"),
				)(),
			),
			"",
		);
	await t
		.expect(
			await ClientFunction(
				() => !!jq("@paging").find(".z-paging-first")[0],
			)(),
		)
		.ok();
	await t
		.expect(ztl.normalizeText("undefined"))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@paging").find(".z-paging-previous").attr("disabled"),
				)(),
			),
			"",
		);
	await t
		.expect(
			await ClientFunction(
				() => !!jq("@paging").find(".z-paging-previous")[0],
			)(),
		)
		.ok();
});
