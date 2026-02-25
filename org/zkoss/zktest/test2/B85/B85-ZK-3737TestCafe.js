import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3737TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3737.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3737TestCafe", async (t) => {
	await ztl.initTest(t);
	let headerWidth_cafe_0 = await ClientFunction(() =>
		jq(".z-listheader:eq(0)").outerWidth(),
	)();
	let headerWidth_cafe = headerWidth_cafe_0;
	let verifyVariable_cafe_0_1 = await ClientFunction(() =>
		jq(".z-listcell:eq(0)").outerWidth(),
	)();
	let verifyVariable_cafe_1_2 = await ClientFunction(() =>
		jq(".z-listcell:eq(0)").outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(headerWidth_cafe),
		ztl.normalizeText(verifyVariable_cafe_1_2),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_2_3 = await ClientFunction(() =>
		jq(".z-column:eq(0)").outerWidth(),
	)();
	let verifyVariable_cafe_3_4 = await ClientFunction(() =>
		jq(".z-column:eq(0)").outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(headerWidth_cafe),
		ztl.normalizeText(verifyVariable_cafe_3_4),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_4_5 = await ClientFunction(() =>
		jq(".z-row-inner:eq(0)").outerWidth(),
	)();
	let verifyVariable_cafe_5_6 = await ClientFunction(() =>
		jq(".z-row-inner:eq(0)").outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(headerWidth_cafe),
		ztl.normalizeText(verifyVariable_cafe_5_6),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_6_7 = await ClientFunction(() =>
		jq(".z-treecol:eq(0)").outerWidth(),
	)();
	let verifyVariable_cafe_7_8 = await ClientFunction(() =>
		jq(".z-treecol:eq(0)").outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(headerWidth_cafe),
		ztl.normalizeText(verifyVariable_cafe_7_8),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_8_9 = await ClientFunction(() =>
		jq(".z-treecell:eq(0)").outerWidth(),
	)();
	let verifyVariable_cafe_9_10 = await ClientFunction(() =>
		jq(".z-treecell:eq(0)").outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(headerWidth_cafe),
		ztl.normalizeText(verifyVariable_cafe_9_10),
		ztl.normalizeText("1"),
	);
	let headerWidth_cafe_0t = await ClientFunction(() =>
		jq(".z-listheader:eq(1)").outerWidth(),
	)();
	let headerWidth_cafet = headerWidth_cafe_0t;
	let verifyVariable_cafe_0_1t = await ClientFunction(() =>
		jq(".z-listcell:eq(1)").outerWidth(),
	)();
	let verifyVariable_cafe_1_2t = await ClientFunction(() =>
		jq(".z-listcell:eq(1)").outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(headerWidth_cafet),
		ztl.normalizeText(verifyVariable_cafe_1_2t),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_2_3t = await ClientFunction(() =>
		jq(".z-column:eq(1)").outerWidth(),
	)();
	let verifyVariable_cafe_3_4t = await ClientFunction(() =>
		jq(".z-column:eq(1)").outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(headerWidth_cafet),
		ztl.normalizeText(verifyVariable_cafe_3_4t),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_4_5t = await ClientFunction(() =>
		jq(".z-row-inner:eq(1)").outerWidth(),
	)();
	let verifyVariable_cafe_5_6t = await ClientFunction(() =>
		jq(".z-row-inner:eq(1)").outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(headerWidth_cafet),
		ztl.normalizeText(verifyVariable_cafe_5_6t),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_6_7t = await ClientFunction(() =>
		jq(".z-treecol:eq(1)").outerWidth(),
	)();
	let verifyVariable_cafe_7_8t = await ClientFunction(() =>
		jq(".z-treecol:eq(1)").outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(headerWidth_cafet),
		ztl.normalizeText(verifyVariable_cafe_7_8t),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_8_9t = await ClientFunction(() =>
		jq(".z-treecell:eq(1)").outerWidth(),
	)();
	let verifyVariable_cafe_9_10t = await ClientFunction(() =>
		jq(".z-treecell:eq(1)").outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(headerWidth_cafet),
		ztl.normalizeText(verifyVariable_cafe_9_10t),
		ztl.normalizeText("1"),
	);
});
