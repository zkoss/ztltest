import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-620TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-620.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-620TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("$tab")[0]));
	await ztl.waitResponse(t);
	let areaHeight_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq("@north").eq(0)).$n("cave")).outerHeight(),
	)();
	let areaPaddings_cafe_0 = parseInt(
		await ClientFunction(() =>
			jq(zk.Widget.$(jq("@north").eq(0)).$n("cave")).css(
				"padding-bottom",
			),
		)(),
	);
	let areaPaddings_cafe_1 = parseInt(
		await ClientFunction(() =>
			jq(zk.Widget.$(jq("@north").eq(0)).$n("cave")).css("padding-top"),
		)(),
	);
	let areaPaddings_cafe = areaPaddings_cafe_1 + areaPaddings_cafe_0;
	let wh_cafe = await ClientFunction(() =>
		jq(jq("@window").eq(0)).outerHeight(true),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(areaHeight_cafe - areaPaddings_cafe),
		ztl.normalizeText(wh_cafe),
		ztl.normalizeText("2"),
	);
	let areaHeight_cafet = await ClientFunction(() =>
		jq(zk.Widget.$(jq("@center").eq(0)).$n("cave")).outerHeight(),
	)();
	let areaPaddings_cafe_0t = parseInt(
		await ClientFunction(() =>
			jq(zk.Widget.$(jq("@center").eq(0)).$n("cave")).css(
				"padding-bottom",
			),
		)(),
	);
	let areaPaddings_cafe_1t = parseInt(
		await ClientFunction(() =>
			jq(zk.Widget.$(jq("@center").eq(0)).$n("cave")).css("padding-top"),
		)(),
	);
	let areaPaddings_cafet = areaPaddings_cafe_1t + areaPaddings_cafe_0t;
	let wh_cafet = await ClientFunction(() =>
		jq(jq("@window").eq(1)).outerHeight(true),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(areaHeight_cafet - areaPaddings_cafet),
		ztl.normalizeText(wh_cafet),
		ztl.normalizeText("2"),
	);
});
