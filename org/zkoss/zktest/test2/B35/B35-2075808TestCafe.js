import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2075808TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2075808.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2075808TestCafe", async (t) => {
	await ztl.initTest(t);
	let pLefWd_cafe = await ClientFunction(() => jq("$cLef").width())();
	let pMidWd_cafe = await ClientFunction(() => jq("$cMid").width())();
	let pRigWd_cafe = await ClientFunction(() => jq("$cRig").width())();
	let pLayWd_cafe = await ClientFunction(() => jq("$cLay").width())();
	await t.click(Selector(() => zk.Desktop._dt.$f("modify", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("remove", true).$n()));
	await ztl.waitResponse(t);
	let nLefWd_cafe = await ClientFunction(() => jq("$cLef").width())();
	let nMidWd_cafe = await ClientFunction(() => jq("$cMid").width())();
	let nRigWd_cafe = await ClientFunction(() => jq("$cRig").width())();
	let nLayWd_cafe = await ClientFunction(() => jq("$cLay").width())();
	await t
		.expect(ztl.normalizeText(nLefWd_cafe))
		.eql(ztl.normalizeText(pLefWd_cafe));
	await t
		.expect(ztl.normalizeText(nMidWd_cafe))
		.eql(ztl.normalizeText(pMidWd_cafe));
	await t
		.expect(ztl.normalizeText(nRigWd_cafe))
		.eql(ztl.normalizeText(pRigWd_cafe));
	await t
		.expect(ztl.normalizeText(nLayWd_cafe))
		.eql(ztl.normalizeText(pLayWd_cafe));
});
