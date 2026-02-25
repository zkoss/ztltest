import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3303725TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3303725.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3303725TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.dragToElement(
		Selector(() => zk.Desktop._dt.$f("p2", true).$n("cap")),
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("p1", true).$n()).find(
					".z-panelchildren",
				)[0],
		),
		{
			offsetX: 100,
			offsetY: 10,
			destinationOffsetX: 100,
			destinationOffsetY: 180,
		},
	);
	await ztl.waitResponse(t);
	let h1_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-portalchildren")).$n("cave")).height(),
	)();
	let h2_cafe_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("p3", true).$n()).outerHeight(),
	)();
	let h2_cafe_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("p1", true).$n()).outerHeight(),
	)();
	let h2_cafe_2 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("p2", true).$n()).outerHeight(),
	)();
	let h2_cafe = h2_cafe_1 + h2_cafe_2 + h2_cafe_0;
	await t
		.expect(
			await ClientFunction(
				() => eval("Math.abs(" + h1_cafe + " - " + h2_cafe + ") < 10"),
				{ dependencies: { h1_cafe, h2_cafe } },
			)(),
		)
		.ok(
			"the sum of the height of the three panel (0) should close to the height of the Portallayout (0)",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("p2", true).$n().id,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("ptl", true).$n()).find(
							".z-panel",
						)[1].id,
				)(),
			),
		);
});
