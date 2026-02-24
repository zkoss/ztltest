import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3165081TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3165081.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3165081TestCafe", async (t) => {
	await ztl.initTest(t);
	let s1l_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("s1", true)).position().left,
	)();
	let s2l_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("s2", true)).position().left,
	)();
	let s3t_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("s3", true)).position().top,
	)();
	let s4t_cafe = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("s4", true)).position().top,
	)();
	await t
		.drag(
			Selector(() => zk.Desktop._dt.$f("s1", true).$n()),
			30,
			0,
			{ offsetX: 0, offsetY: 0 },
		)
		.drag(
			Selector(() => zk.Desktop._dt.$f("s2", true).$n()),
			30,
			0,
			{ offsetX: 0, offsetY: 0 },
		)
		.drag(
			Selector(() => zk.Desktop._dt.$f("s3", true).$n()),
			0,
			30,
			{ offsetX: 0, offsetY: 0 },
		)
		.drag(
			Selector(() => zk.Desktop._dt.$f("s4", true).$n()),
			0,
			30,
			{ offsetX: 0, offsetY: 0 },
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(zk.Desktop._dt.$f("s1", true)).position().left,
				)(),
			),
		)
		.eql(ztl.normalizeText(s1l_cafe));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(zk.Desktop._dt.$f("s2", true)).position().left,
				)(),
			),
		)
		.eql(ztl.normalizeText(s2l_cafe));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(zk.Desktop._dt.$f("s3", true)).position().top,
				)(),
			),
		)
		.eql(ztl.normalizeText(s3t_cafe));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq(zk.Desktop._dt.$f("s4", true)).position().top,
				)(),
			),
		)
		.eql(ztl.normalizeText(s4t_cafe));
});
