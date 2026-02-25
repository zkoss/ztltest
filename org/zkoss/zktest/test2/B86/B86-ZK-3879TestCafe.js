import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B86-ZK-3879TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-3879.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-3879TestCafe", async (t) => {
	await ztl.initTest(t);
	let listboxHeight_cafe = await ClientFunction(() =>
		jq("@listbox").height(),
	)();
	let pageSize_cafe = parseInt(
		await ClientFunction(() => zk.Widget.$(jq("@paging"))._pageSize)(),
	);
	let pageCount_cafe = parseInt(
		await ClientFunction(() => zk.Widget.$(jq("@paging"))._pageCount)(),
	);
	let totalSize_cafe = parseInt(
		await ClientFunction(() => zk.Widget.$(jq("@paging"))._totalSize)(),
	);
	await t.click(Selector(() => jq("$pagingId").find(".z-paging-last")[0]));
	await ztl.waitResponse(t);
	let lastRow_cafe = parseInt(
		await ClientFunction(() => zk.Widget.$(jq("@listbox"))._nrows)(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText("318"),
		ztl.normalizeText(listboxHeight_cafe),
		ztl.normalizeText("1"),
	);
	await t
		.expect(
			ztl.normalizeText(
				pageSize_cafe * (pageCount_cafe - 1) + lastRow_cafe,
			),
		)
		.eql(ztl.normalizeText(totalSize_cafe));
});
