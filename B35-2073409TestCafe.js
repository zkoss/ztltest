import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2073409TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2073409.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2073409TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$addgroup")[0]));
	await ztl.waitResponse(t);
	let txt_cafe = await ClientFunction(() =>
		jq(jq("$group1")).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(txt_cafe))
		.contains(ztl.normalizeText("Group1"), "");
	await t.click(Selector(() => jq("$group1").find("span")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("$row1")[0])()).ok();
	await t.expect(await ClientFunction(() => !!jq("$row2")[0])()).ok();
	await t
		.expect(await ClientFunction(() => jq("$row1").is(":visible"))())
		.ok();
	await t
		.expect(await ClientFunction(() => jq("$row2").is(":visible"))())
		.ok();
	await t.click(Selector(() => jq("$addfoot")[0]));
	await ztl.waitResponse(t);
	let txt1_cafe = await ClientFunction(() =>
		jq(jq("$foot1")).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("footer"))
		.eql(ztl.normalizeText(txt1_cafe));
});
