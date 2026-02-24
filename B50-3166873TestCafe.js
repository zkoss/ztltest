import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3166873TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3166873.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3166873TestCafe", async (t) => {
	await ztl.initTest(t);
	let left_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("s1", true)).offset().left,
	)();
	let top_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("s2", true)).offset().top,
	)();
	await t.drag(
		Selector(() => zk.Desktop._dt.$f("s1", true).$n()),
		10,
		0,
		{ offsetX: 3, offsetY: 3 },
	);
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => zk.Desktop._dt.$f("s2", true).$n()),
		0,
		10,
		{ offsetX: 3, offsetY: 3 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(zk.Desktop._dt.$f("s1", true)).offset().left,
				)(),
			),
		)
		.notEql(ztl.normalizeText(left_cafe), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(zk.Desktop._dt.$f("s2", true)).offset().top,
				)(),
			),
		)
		.notEql(ztl.normalizeText(top_cafe), "");
});
