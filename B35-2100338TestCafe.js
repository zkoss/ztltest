import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2100338TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2100338.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2100338TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$lm1")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$lm2")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-error")[0])())
		.notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	let vl_cafe = await ClientFunction(() =>
		jq(".z-listcell").eq(0).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 0"))
		.eql(ztl.normalizeText(vl_cafe));
	let vl_cafet = await ClientFunction(() =>
		jq(".z-listcell").eq(1).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 1"))
		.eql(ztl.normalizeText(vl_cafet));
	let vl_cafett = await ClientFunction(() =>
		jq(".z-listcell").eq(2).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 2"))
		.eql(ztl.normalizeText(vl_cafett));
	let vl_cafettt = await ClientFunction(() =>
		jq(".z-listcell").eq(3).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 3"))
		.eql(ztl.normalizeText(vl_cafettt));
	let vl_cafetttt = await ClientFunction(() =>
		jq(".z-listcell").eq(4).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 4"))
		.eql(ztl.normalizeText(vl_cafetttt));
	let vl_cafettttt = await ClientFunction(() =>
		jq(".z-listcell").eq(5).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 5"))
		.eql(ztl.normalizeText(vl_cafettttt));
	let vl_cafetttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(6).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 6"))
		.eql(ztl.normalizeText(vl_cafetttttt));
	let vl_cafettttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(7).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 7"))
		.eql(ztl.normalizeText(vl_cafettttttt));
	let vl_cafetttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(8).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 8"))
		.eql(ztl.normalizeText(vl_cafetttttttt));
	let vl_cafettttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(9).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 9"))
		.eql(ztl.normalizeText(vl_cafettttttttt));
	await t.click(
		Selector(() => jq("$lb1").find(".z-paging").find(".z-paging-last")[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$lm1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-error")[0])())
		.notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	let vl_cafetttttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(0).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 0"))
		.eql(ztl.normalizeText(vl_cafetttttttttt));
	let vl_cafettttttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(1).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 1"))
		.eql(ztl.normalizeText(vl_cafettttttttttt));
	let vl_cafetttttttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(2).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 2"))
		.eql(ztl.normalizeText(vl_cafetttttttttttt));
	let vl_cafettttttttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(3).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 3"))
		.eql(ztl.normalizeText(vl_cafettttttttttttt));
	let vl_cafetttttttttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(4).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 4"))
		.eql(ztl.normalizeText(vl_cafetttttttttttttt));
	let vl_cafettttttttttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(5).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 5"))
		.eql(ztl.normalizeText(vl_cafettttttttttttttt));
	let vl_cafetttttttttttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(6).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 6"))
		.eql(ztl.normalizeText(vl_cafetttttttttttttttt));
	let vl_cafettttttttttttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(7).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 7"))
		.eql(ztl.normalizeText(vl_cafettttttttttttttttt));
	let vl_cafetttttttttttttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(8).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 8"))
		.eql(ztl.normalizeText(vl_cafetttttttttttttttttt));
	let vl_cafettttttttttttttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(9).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 9"))
		.eql(ztl.normalizeText(vl_cafettttttttttttttttttt));
	await t.click(Selector(() => jq("$lm2")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-error")[0])())
		.notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	let vl_cafetttttttttttttttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(0).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 60"))
		.eql(ztl.normalizeText(vl_cafetttttttttttttttttttt));
	let vl_cafettttttttttttttttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(1).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 61"))
		.eql(ztl.normalizeText(vl_cafettttttttttttttttttttt));
	let vl_cafetttttttttttttttttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(2).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 62"))
		.eql(ztl.normalizeText(vl_cafetttttttttttttttttttttt));
	let vl_cafettttttttttttttttttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(3).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 63"))
		.eql(ztl.normalizeText(vl_cafettttttttttttttttttttttt));
	let vl_cafetttttttttttttttttttttttt = await ClientFunction(() =>
		jq(".z-listcell").eq(4).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 64"))
		.eql(ztl.normalizeText(vl_cafetttttttttttttttttttttttt));
	await t.click(Selector(() => jq("$gm1")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$gm2")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-error")[0])())
		.notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	let vl_cafettttttttttttttttttttttttt = await ClientFunction(() =>
		jq(jq(".z-row .z-label").eq(0)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 60"))
		.eql(ztl.normalizeText(vl_cafettttttttttttttttttttttttt));
	let vl_cafetttttttttttttttttttttttttt = await ClientFunction(() =>
		jq(jq(".z-row .z-label").eq(1)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 61"))
		.eql(ztl.normalizeText(vl_cafetttttttttttttttttttttttttt));
	let vl_cafettttttttttttttttttttttttttt = await ClientFunction(() =>
		jq(jq(".z-row .z-label").eq(2)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 62"))
		.eql(ztl.normalizeText(vl_cafettttttttttttttttttttttttttt));
	let vl_cafetttttttttttttttttttttttttttt = await ClientFunction(() =>
		jq(jq(".z-row .z-label").eq(3)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 63"))
		.eql(ztl.normalizeText(vl_cafetttttttttttttttttttttttttttt));
	let vl_cafettttttttttttttttttttttttttttt = await ClientFunction(() =>
		jq(jq(".z-row .z-label").eq(4)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 64"))
		.eql(ztl.normalizeText(vl_cafettttttttttttttttttttttttttttt));
	await t.click(
		Selector(() => jq("$gd1").find(".z-paging").find(".z-paging-last")[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$gm1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-error")[0])())
		.notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	let vl_cafetttttttttttttttttttttttttttttt = await ClientFunction(() =>
		jq(jq(".z-row .z-label").eq(0)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 0"))
		.eql(ztl.normalizeText(vl_cafetttttttttttttttttttttttttttttt));
	let vl_cafettttttttttttttttttttttttttttttt = await ClientFunction(() =>
		jq(jq(".z-row .z-label").eq(1)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 1"))
		.eql(ztl.normalizeText(vl_cafettttttttttttttttttttttttttttttt));
	let vl_cafetttttttttttttttttttttttttttttttt = await ClientFunction(() =>
		jq(jq(".z-row .z-label").eq(2)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 2"))
		.eql(ztl.normalizeText(vl_cafetttttttttttttttttttttttttttttttt));
	let vl_cafettttttttttttttttttttttttttttttttt = await ClientFunction(() =>
		jq(jq(".z-row .z-label").eq(3)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 3"))
		.eql(ztl.normalizeText(vl_cafettttttttttttttttttttttttttttttttt));
	let vl_cafetttttttttttttttttttttttttttttttttt = await ClientFunction(() =>
		jq(jq(".z-row .z-label").eq(4)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 4"))
		.eql(ztl.normalizeText(vl_cafetttttttttttttttttttttttttttttttttt));
	let vl_cafettttttttttttttttttttttttttttttttttt = await ClientFunction(() =>
		jq(jq(".z-row .z-label").eq(5)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 5"))
		.eql(ztl.normalizeText(vl_cafettttttttttttttttttttttttttttttttttt));
	let vl_cafetttttttttttttttttttttttttttttttttttt = await ClientFunction(() =>
		jq(jq(".z-row .z-label").eq(6)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 6"))
		.eql(ztl.normalizeText(vl_cafetttttttttttttttttttttttttttttttttttt));
	let vl_cafettttttttttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq(jq(".z-row .z-label").eq(7)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 7"))
		.eql(ztl.normalizeText(vl_cafettttttttttttttttttttttttttttttttttttt));
	let vl_cafetttttttttttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq(jq(".z-row .z-label").eq(8)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 8"))
		.eql(ztl.normalizeText(vl_cafetttttttttttttttttttttttttttttttttttttt));
	let vl_cafettttttttttttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq(jq(".z-row .z-label").eq(9)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("A option 9"))
		.eql(ztl.normalizeText(vl_cafettttttttttttttttttttttttttttttttttttttt));
	await t.click(Selector(() => jq("$gm2")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-messagebox-error")[0])())
		.notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	let vl_cafetttttttttttttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq(jq(".z-row .z-label").eq(0)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 60"))
		.eql(
			ztl.normalizeText(vl_cafetttttttttttttttttttttttttttttttttttttttt),
		);
	let vl_cafettttttttttttttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq(jq(".z-row .z-label").eq(1)).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("B option 61"))
		.eql(
			ztl.normalizeText(vl_cafettttttttttttttttttttttttttttttttttttttttt),
		);
	let vl_cafetttttttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(() =>
			jq(jq(".z-row .z-label").eq(2)).text().replace(/\s/g, " "),
		)();
	await t
		.expect(ztl.normalizeText("B option 62"))
		.eql(
			ztl.normalizeText(
				vl_cafetttttttttttttttttttttttttttttttttttttttttt,
			),
		);
	let vl_cafettttttttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(() =>
			jq(jq(".z-row .z-label").eq(3)).text().replace(/\s/g, " "),
		)();
	await t
		.expect(ztl.normalizeText("B option 63"))
		.eql(
			ztl.normalizeText(
				vl_cafettttttttttttttttttttttttttttttttttttttttttt,
			),
		);
	let vl_cafetttttttttttttttttttttttttttttttttttttttttttt =
		await ClientFunction(() =>
			jq(jq(".z-row .z-label").eq(4)).text().replace(/\s/g, " "),
		)();
	await t
		.expect(ztl.normalizeText("B option 64"))
		.eql(
			ztl.normalizeText(
				vl_cafetttttttttttttttttttttttttttttttttttttttttttt,
			),
		);
});
