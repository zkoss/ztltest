import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-568TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-568.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-568TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("box", true).$n("btn")),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => zk.Desktop._dt.$f("box", true).$n("pp")),
		scrollType: "vertical",
		percent: parseInt(
			await ClientFunction(
				() =>
					jq(
						jq(zk.Desktop._dt.$f("box", true).$n("pp")).find(
							".z-comboitem",
						)[49],
					)[0].offsetTop,
			)(),
		),
	});
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("box", true).$n("pp")).find(
					".z-comboitem",
				)[49],
		),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("box", true).$n("btn")),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	let top_cafe = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("box", true).$n("pp").scrollTop,
		)(),
	);
	let offset_cafe = parseInt(
		await ClientFunction(
			() =>
				jq(
					jq(zk.Desktop._dt.$f("box", true).$n("pp")).find(
						".z-comboitem",
					)[49],
				)[0].offsetTop,
		)(),
	);
	let bottom_cafe_0 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("box", true).$n("pp").scrollTop,
		)(),
	);
	let bottom_cafe_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("box", true).$n("pp")).height(),
	)();
	let bottom_cafe = bottom_cafe_0 + bottom_cafe_1;
	await t
		.expect(offset_cafe >= top_cafe && offset_cafe <= bottom_cafe)
		.ok("the last item should in view of drop down list");
	await t.click(
		Selector(() => zk.Desktop._dt.$f("btn", true).$n()),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("box", true).$n("btn")),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	top_cafe = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("box", true).$n("pp").scrollTop,
		)(),
	);
	let offset_cafe_2 = parseInt(
		await ClientFunction(
			() =>
				jq(
					jq(zk.Desktop._dt.$f("box", true).$n("pp")).find(
						".z-comboitem",
					)[14],
				)[0].offsetTop,
		)(),
	);
	offset_cafe = offset_cafe_2 + 4;
	let bottom_cafe_3 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("box", true).$n("pp")).height(),
	)();
	let bottom_cafe_4 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("box", true).$n("pp").scrollTop,
		)(),
	);
	bottom_cafe = bottom_cafe_4 + bottom_cafe_3;
	await t
		.expect(offset_cafe >= top_cafe && offset_cafe <= bottom_cafe)
		.ok("item 15 should in view of drop down list");
});
