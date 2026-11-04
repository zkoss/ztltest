import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2086302TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2086302.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2086302TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("$bt1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$bl1").is(":visible"))())
		.ok();
	const filledSize = {
		filledWidth: (el) => {
			const layout = zk.Widget.$(el);
			return [layout.west, layout.center, layout.east]
				.filter((region) => region)
				.flatMap((region) => [region.$n("real"), region.$n("split")])
				.filter((part) => part)
				.reduce(
					(sum, part) => sum + part.getBoundingClientRect().width,
					0,
				);
		},
		filledHeight: (el) => {
			const layout = zk.Widget.$(el);
			return [layout.north, layout.center, layout.south]
				.filter((region) => region)
				.flatMap((region) => [region.$n("real"), region.$n("split")])
				.filter((part) => part)
				.reduce(
					(sum, part) => sum + part.getBoundingClientRect().height,
					0,
				);
		},
	};
	const outerLayout = Selector(() => jq("$bl1")[0]).addCustomDOMProperties(
		filledSize,
	);
	const northLayout = Selector(() => jq("$bl2")[0]).addCustomDOMProperties(
		filledSize,
	);
	const centerLayout = Selector(() => jq("$bl3")[0]).addCustomDOMProperties(
		filledSize,
	);
	let bl1h_cafe = await ClientFunction(() => jq("$bl1").height())();
	let bl1w_cafe = await ClientFunction(() => jq("$bl1").width())();
	await t.expect(bl1h_cafe == 500).ok();
	let bl2w_cafe = await ClientFunction(() => jq("$bl2").width())();
	let w2w_cafe = await ClientFunction(() =>
		jq("$w2").parent().outerWidth(),
	)();
	let verifyVariable_cafe_0_0 = parseInt(0.0);
	let verifyVariable_cafe_1_1 = parseInt(0.0);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(parseInt(bl2w_cafe * 0.25 + "")),
		ztl.normalizeText(w2w_cafe),
		ztl.normalizeText("1"),
	);
	const northLayoutWidth = await northLayout.offsetWidth;
	await t
		.expect(northLayout.filledWidth)
		.within(
			northLayoutWidth - 1,
			northLayoutWidth + 1,
			"the north layout's center should take the rest of its width",
		);
	let e2w_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq("$bl2").find("@east")).$n("cave")).outerWidth(),
	)();
	let verifyVariable_cafe_4_5 = parseInt(0.0);
	let verifyVariable_cafe_5_6 = parseInt(0.0);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(parseInt(bl2w_cafe * 0.5 + "")),
		ztl.normalizeText(e2w_cafe),
		ztl.normalizeText("1"),
	);
	await t
		.expect(ztl.normalizeText("0px"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$bl2").find("@east").css("border-top-width"),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("0px"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$bl2").find("@east").css("border-left-width"),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("0px"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$bl2").find("@east").css("border-right-width"),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("0px"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$bl2").find("@east").css("border-bottom-width"),
				)(),
			),
		);
	let bl3w_cafe = await ClientFunction(() => jq("$bl3").width())();
	let w3w_cafe = await ClientFunction(() =>
		jq("$w3").parent().outerWidth(),
	)();
	let verifyVariable_cafe_6_7 = parseInt(0.0);
	let verifyVariable_cafe_7_8 = parseInt(0.0);
	await t
		.expect(ztl.normalizeText(w3w_cafe))
		.eql(ztl.normalizeText(parseInt(bl3w_cafe * 0.3 + "")));
	const centerLayoutWidth = await centerLayout.offsetWidth;
	await t
		.expect(centerLayout.filledWidth)
		.within(
			centerLayoutWidth - 1,
			centerLayoutWidth + 1,
			"the center layout's center should take the rest of its width",
		);
	await t
		.expect(
			Selector(() => jq("$bl3").find(".z-center")[0]).hasClass(
				"z-center-noborder",
			),
		)
		.notOk("the center layout's center should keep its border");
	let e3w_cafe = await ClientFunction(() =>
		jq("$e3").parent().outerWidth(),
	)();
	let verifyVariable_cafe_10_12 = parseInt(0.0);
	let verifyVariable_cafe_11_13 = parseInt(0.0);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(parseInt(bl3w_cafe * 0.3 + "")),
		ztl.normalizeText(e3w_cafe),
		ztl.normalizeText("1"),
	);
	let bl2h_cafe = await ClientFunction(() =>
		jq("$bl2").parent().outerHeight(),
	)();
	await t
		.expect(ztl.normalizeText(parseInt(bl1h_cafe / 2)))
		.eql(ztl.normalizeText(bl2h_cafe));
	const outerLayoutHeight = await outerLayout.offsetHeight;
	await t
		.expect(outerLayout.filledHeight)
		.within(
			outerLayoutHeight - 1,
			outerLayoutHeight + 1,
			"the outer layout's center should take the rest of its height",
		);
});
