import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F60-ZK-1583TestCafe`
	.page`http://localhost:8080/zktest/test2/F60-ZK-1583.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F60-ZK-1583TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() => jq('.z-radio input[value="before_start"]')[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(info)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0 = await ClientFunction(
		() => jq("div[style*=green]").offset().left,
	)();
	let divLeftMid_cafe_1 = await ClientFunction(() =>
		jq("div[style*=green]").width(),
	)();
	let divLeftMid_cafe = divLeftMid_cafe_0 + 0.5 * divLeftMid_cafe_1;
	let pointerLeftMid_cafe_2 = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3 = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafe =
		pointerLeftMid_cafe_3 + 0.5 * pointerLeftMid_cafe_2;
	let divTopMid_cafe_4 = await ClientFunction(
		() => jq("div[style*=green]").offset().top,
	)();
	let divTopMid_cafe_5 = await ClientFunction(() =>
		jq("div[style*=green]").height(),
	)();
	let divTopMid_cafe = divTopMid_cafe_4 + 0.5 * divTopMid_cafe_5;
	let pointerTopMid_cafe_6 = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7 = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafe = pointerTopMid_cafe_6 + 0.5 * pointerTopMid_cafe_7;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafe +
							"-" +
							pointerLeftMid_cafe +
							") < 11",
					),
				{ dependencies: { divLeftMid_cafe, pointerLeftMid_cafe } },
			)(),
		)
		.ok(
			">>>before_start:info, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(warning)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0t = await ClientFunction(
		() => jq("div[style*=yellow]").offset().left,
	)();
	let divLeftMid_cafe_1t = await ClientFunction(() =>
		jq("div[style*=yellow]").width(),
	)();
	let divLeftMid_cafet = divLeftMid_cafe_0t + 0.5 * divLeftMid_cafe_1t;
	let pointerLeftMid_cafe_2t = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3t = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafet =
		pointerLeftMid_cafe_3t + 0.5 * pointerLeftMid_cafe_2t;
	let divTopMid_cafe_4t = await ClientFunction(
		() => jq("div[style*=yellow]").offset().top,
	)();
	let divTopMid_cafe_5t = await ClientFunction(() =>
		jq("div[style*=yellow]").height(),
	)();
	let divTopMid_cafet = divTopMid_cafe_4t + 0.5 * divTopMid_cafe_5t;
	let pointerTopMid_cafe_6t = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7t = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafet =
		pointerTopMid_cafe_6t + 0.5 * pointerTopMid_cafe_7t;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafet +
							"-" +
							pointerLeftMid_cafet +
							") < 11",
					),
				{ dependencies: { divLeftMid_cafet, pointerLeftMid_cafet } },
			)(),
		)
		.ok(
			">>>before_start:warning, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(error)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tt = await ClientFunction(
		() => jq("div[style*=red]").offset().left,
	)();
	let divLeftMid_cafe_1tt = await ClientFunction(() =>
		jq("div[style*=red]").width(),
	)();
	let divLeftMid_cafett = divLeftMid_cafe_0tt + 0.5 * divLeftMid_cafe_1tt;
	let pointerLeftMid_cafe_2tt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3tt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafett =
		pointerLeftMid_cafe_3tt + 0.5 * pointerLeftMid_cafe_2tt;
	let divTopMid_cafe_4tt = await ClientFunction(
		() => jq("div[style*=red]").offset().top,
	)();
	let divTopMid_cafe_5tt = await ClientFunction(() =>
		jq("div[style*=red]").height(),
	)();
	let divTopMid_cafett = divTopMid_cafe_4tt + 0.5 * divTopMid_cafe_5tt;
	let pointerTopMid_cafe_6tt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7tt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafett =
		pointerTopMid_cafe_6tt + 0.5 * pointerTopMid_cafe_7tt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafett +
							"-" +
							pointerLeftMid_cafett +
							") < 11",
					),
				{ dependencies: { divLeftMid_cafett, pointerLeftMid_cafett } },
			)(),
		)
		.ok(
			">>>before_start:error, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq('.z-radio input[value="before_center"]')[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(info)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttt = await ClientFunction(
		() => jq("div[style*=green]").offset().left,
	)();
	let divLeftMid_cafe_1ttt = await ClientFunction(() =>
		jq("div[style*=green]").width(),
	)();
	let divLeftMid_cafettt = divLeftMid_cafe_0ttt + 0.5 * divLeftMid_cafe_1ttt;
	let pointerLeftMid_cafe_2ttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3ttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafettt =
		pointerLeftMid_cafe_3ttt + 0.5 * pointerLeftMid_cafe_2ttt;
	let divTopMid_cafe_4ttt = await ClientFunction(
		() => jq("div[style*=green]").offset().top,
	)();
	let divTopMid_cafe_5ttt = await ClientFunction(() =>
		jq("div[style*=green]").height(),
	)();
	let divTopMid_cafettt = divTopMid_cafe_4ttt + 0.5 * divTopMid_cafe_5ttt;
	let pointerTopMid_cafe_6ttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7ttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafettt =
		pointerTopMid_cafe_6ttt + 0.5 * pointerTopMid_cafe_7ttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafettt +
							"-" +
							pointerLeftMid_cafettt +
							") < 11",
					),
				{
					dependencies: {
						divLeftMid_cafettt,
						pointerLeftMid_cafettt,
					},
				},
			)(),
		)
		.ok(
			">>>before_center:info, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(warning)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().left,
	)();
	let divLeftMid_cafe_1tttt = await ClientFunction(() =>
		jq("div[style*=yellow]").width(),
	)();
	let divLeftMid_cafetttt =
		divLeftMid_cafe_0tttt + 0.5 * divLeftMid_cafe_1tttt;
	let pointerLeftMid_cafe_2tttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3tttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafetttt =
		pointerLeftMid_cafe_3tttt + 0.5 * pointerLeftMid_cafe_2tttt;
	let divTopMid_cafe_4tttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().top,
	)();
	let divTopMid_cafe_5tttt = await ClientFunction(() =>
		jq("div[style*=yellow]").height(),
	)();
	let divTopMid_cafetttt = divTopMid_cafe_4tttt + 0.5 * divTopMid_cafe_5tttt;
	let pointerTopMid_cafe_6tttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7tttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafetttt =
		pointerTopMid_cafe_6tttt + 0.5 * pointerTopMid_cafe_7tttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafetttt +
							"-" +
							pointerLeftMid_cafetttt +
							") < 11",
					),
				{
					dependencies: {
						divLeftMid_cafetttt,
						pointerLeftMid_cafetttt,
					},
				},
			)(),
		)
		.ok(
			">>>before_center:warning, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(error)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().left,
	)();
	let divLeftMid_cafe_1ttttt = await ClientFunction(() =>
		jq("div[style*=red]").width(),
	)();
	let divLeftMid_cafettttt =
		divLeftMid_cafe_0ttttt + 0.5 * divLeftMid_cafe_1ttttt;
	let pointerLeftMid_cafe_2ttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3ttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafettttt =
		pointerLeftMid_cafe_3ttttt + 0.5 * pointerLeftMid_cafe_2ttttt;
	let divTopMid_cafe_4ttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().top,
	)();
	let divTopMid_cafe_5ttttt = await ClientFunction(() =>
		jq("div[style*=red]").height(),
	)();
	let divTopMid_cafettttt =
		divTopMid_cafe_4ttttt + 0.5 * divTopMid_cafe_5ttttt;
	let pointerTopMid_cafe_6ttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7ttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafettttt =
		pointerTopMid_cafe_6ttttt + 0.5 * pointerTopMid_cafe_7ttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafettttt +
							"-" +
							pointerLeftMid_cafettttt +
							") < 11",
					),
				{
					dependencies: {
						divLeftMid_cafettttt,
						pointerLeftMid_cafettttt,
					},
				},
			)(),
		)
		.ok(
			">>>before_center:error, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('.z-radio input[value="before_end"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(info)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().left,
	)();
	let divLeftMid_cafe_1tttttt = await ClientFunction(() =>
		jq("div[style*=green]").width(),
	)();
	let divLeftMid_cafetttttt =
		divLeftMid_cafe_0tttttt + 0.5 * divLeftMid_cafe_1tttttt;
	let pointerLeftMid_cafe_2tttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3tttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafetttttt =
		pointerLeftMid_cafe_3tttttt + 0.5 * pointerLeftMid_cafe_2tttttt;
	let divTopMid_cafe_4tttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().top,
	)();
	let divTopMid_cafe_5tttttt = await ClientFunction(() =>
		jq("div[style*=green]").height(),
	)();
	let divTopMid_cafetttttt =
		divTopMid_cafe_4tttttt + 0.5 * divTopMid_cafe_5tttttt;
	let pointerTopMid_cafe_6tttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7tttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafetttttt =
		pointerTopMid_cafe_6tttttt + 0.5 * pointerTopMid_cafe_7tttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafetttttt +
							"-" +
							pointerLeftMid_cafetttttt +
							") < 11",
					),
				{
					dependencies: {
						divLeftMid_cafetttttt,
						pointerLeftMid_cafetttttt,
					},
				},
			)(),
		)
		.ok(
			">>>before_end:info, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(warning)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().left,
	)();
	let divLeftMid_cafe_1ttttttt = await ClientFunction(() =>
		jq("div[style*=yellow]").width(),
	)();
	let divLeftMid_cafettttttt =
		divLeftMid_cafe_0ttttttt + 0.5 * divLeftMid_cafe_1ttttttt;
	let pointerLeftMid_cafe_2ttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3ttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafettttttt =
		pointerLeftMid_cafe_3ttttttt + 0.5 * pointerLeftMid_cafe_2ttttttt;
	let divTopMid_cafe_4ttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().top,
	)();
	let divTopMid_cafe_5ttttttt = await ClientFunction(() =>
		jq("div[style*=yellow]").height(),
	)();
	let divTopMid_cafettttttt =
		divTopMid_cafe_4ttttttt + 0.5 * divTopMid_cafe_5ttttttt;
	let pointerTopMid_cafe_6ttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7ttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafettttttt =
		pointerTopMid_cafe_6ttttttt + 0.5 * pointerTopMid_cafe_7ttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafettttttt +
							"-" +
							pointerLeftMid_cafettttttt +
							") < 11",
					),
				{
					dependencies: {
						divLeftMid_cafettttttt,
						pointerLeftMid_cafettttttt,
					},
				},
			)(),
		)
		.ok(
			">>>before_end:warning, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(error)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().left,
	)();
	let divLeftMid_cafe_1tttttttt = await ClientFunction(() =>
		jq("div[style*=red]").width(),
	)();
	let divLeftMid_cafetttttttt =
		divLeftMid_cafe_0tttttttt + 0.5 * divLeftMid_cafe_1tttttttt;
	let pointerLeftMid_cafe_2tttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3tttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafetttttttt =
		pointerLeftMid_cafe_3tttttttt + 0.5 * pointerLeftMid_cafe_2tttttttt;
	let divTopMid_cafe_4tttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().top,
	)();
	let divTopMid_cafe_5tttttttt = await ClientFunction(() =>
		jq("div[style*=red]").height(),
	)();
	let divTopMid_cafetttttttt =
		divTopMid_cafe_4tttttttt + 0.5 * divTopMid_cafe_5tttttttt;
	let pointerTopMid_cafe_6tttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7tttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafetttttttt =
		pointerTopMid_cafe_6tttttttt + 0.5 * pointerTopMid_cafe_7tttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafetttttttt +
							"-" +
							pointerLeftMid_cafetttttttt +
							") < 11",
					),
				{
					dependencies: {
						divLeftMid_cafetttttttt,
						pointerLeftMid_cafetttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>before_end:error, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('.z-radio input[value="after_start"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(info)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttttttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().left,
	)();
	let divLeftMid_cafe_1ttttttttt = await ClientFunction(() =>
		jq("div[style*=green]").width(),
	)();
	let divLeftMid_cafettttttttt =
		divLeftMid_cafe_0ttttttttt + 0.5 * divLeftMid_cafe_1ttttttttt;
	let pointerLeftMid_cafe_2ttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3ttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafettttttttt =
		pointerLeftMid_cafe_3ttttttttt + 0.5 * pointerLeftMid_cafe_2ttttttttt;
	let divTopMid_cafe_4ttttttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().top,
	)();
	let divTopMid_cafe_5ttttttttt = await ClientFunction(() =>
		jq("div[style*=green]").height(),
	)();
	let divTopMid_cafettttttttt =
		divTopMid_cafe_4ttttttttt + 0.5 * divTopMid_cafe_5ttttttttt;
	let pointerTopMid_cafe_6ttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7ttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafettttttttt =
		pointerTopMid_cafe_6ttttttttt + 0.5 * pointerTopMid_cafe_7ttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafettttttttt +
							"-" +
							pointerLeftMid_cafettttttttt +
							") < 11",
					),
				{
					dependencies: {
						divLeftMid_cafettttttttt,
						pointerLeftMid_cafettttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>after_start:info, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(warning)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().left,
	)();
	let divLeftMid_cafe_1tttttttttt = await ClientFunction(() =>
		jq("div[style*=yellow]").width(),
	)();
	let divLeftMid_cafetttttttttt =
		divLeftMid_cafe_0tttttttttt + 0.5 * divLeftMid_cafe_1tttttttttt;
	let pointerLeftMid_cafe_2tttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3tttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafetttttttttt =
		pointerLeftMid_cafe_3tttttttttt + 0.5 * pointerLeftMid_cafe_2tttttttttt;
	let divTopMid_cafe_4tttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().top,
	)();
	let divTopMid_cafe_5tttttttttt = await ClientFunction(() =>
		jq("div[style*=yellow]").height(),
	)();
	let divTopMid_cafetttttttttt =
		divTopMid_cafe_4tttttttttt + 0.5 * divTopMid_cafe_5tttttttttt;
	let pointerTopMid_cafe_6tttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7tttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafetttttttttt =
		pointerTopMid_cafe_6tttttttttt + 0.5 * pointerTopMid_cafe_7tttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafetttttttttt +
							"-" +
							pointerLeftMid_cafetttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divLeftMid_cafetttttttttt,
						pointerLeftMid_cafetttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>after_start:warning, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(error)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().left,
	)();
	let divLeftMid_cafe_1ttttttttttt = await ClientFunction(() =>
		jq("div[style*=red]").width(),
	)();
	let divLeftMid_cafettttttttttt =
		divLeftMid_cafe_0ttttttttttt + 0.5 * divLeftMid_cafe_1ttttttttttt;
	let pointerLeftMid_cafe_2ttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3ttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafettttttttttt =
		pointerLeftMid_cafe_3ttttttttttt +
		0.5 * pointerLeftMid_cafe_2ttttttttttt;
	let divTopMid_cafe_4ttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().top,
	)();
	let divTopMid_cafe_5ttttttttttt = await ClientFunction(() =>
		jq("div[style*=red]").height(),
	)();
	let divTopMid_cafettttttttttt =
		divTopMid_cafe_4ttttttttttt + 0.5 * divTopMid_cafe_5ttttttttttt;
	let pointerTopMid_cafe_6ttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7ttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafettttttttttt =
		pointerTopMid_cafe_6ttttttttttt + 0.5 * pointerTopMid_cafe_7ttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafettttttttttt +
							"-" +
							pointerLeftMid_cafettttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divLeftMid_cafettttttttttt,
						pointerLeftMid_cafettttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>after_start:error, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq('.z-radio input[value="after_center"]')[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(info)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().left,
	)();
	let divLeftMid_cafe_1tttttttttttt = await ClientFunction(() =>
		jq("div[style*=green]").width(),
	)();
	let divLeftMid_cafetttttttttttt =
		divLeftMid_cafe_0tttttttttttt + 0.5 * divLeftMid_cafe_1tttttttttttt;
	let pointerLeftMid_cafe_2tttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3tttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafetttttttttttt =
		pointerLeftMid_cafe_3tttttttttttt +
		0.5 * pointerLeftMid_cafe_2tttttttttttt;
	let divTopMid_cafe_4tttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().top,
	)();
	let divTopMid_cafe_5tttttttttttt = await ClientFunction(() =>
		jq("div[style*=green]").height(),
	)();
	let divTopMid_cafetttttttttttt =
		divTopMid_cafe_4tttttttttttt + 0.5 * divTopMid_cafe_5tttttttttttt;
	let pointerTopMid_cafe_6tttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7tttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafetttttttttttt =
		pointerTopMid_cafe_6tttttttttttt +
		0.5 * pointerTopMid_cafe_7tttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafetttttttttttt +
							"-" +
							pointerLeftMid_cafetttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divLeftMid_cafetttttttttttt,
						pointerLeftMid_cafetttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>after_center:info, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(warning)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().left,
	)();
	let divLeftMid_cafe_1ttttttttttttt = await ClientFunction(() =>
		jq("div[style*=yellow]").width(),
	)();
	let divLeftMid_cafettttttttttttt =
		divLeftMid_cafe_0ttttttttttttt + 0.5 * divLeftMid_cafe_1ttttttttttttt;
	let pointerLeftMid_cafe_2ttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3ttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafettttttttttttt =
		pointerLeftMid_cafe_3ttttttttttttt +
		0.5 * pointerLeftMid_cafe_2ttttttttttttt;
	let divTopMid_cafe_4ttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().top,
	)();
	let divTopMid_cafe_5ttttttttttttt = await ClientFunction(() =>
		jq("div[style*=yellow]").height(),
	)();
	let divTopMid_cafettttttttttttt =
		divTopMid_cafe_4ttttttttttttt + 0.5 * divTopMid_cafe_5ttttttttttttt;
	let pointerTopMid_cafe_6ttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7ttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafettttttttttttt =
		pointerTopMid_cafe_6ttttttttttttt +
		0.5 * pointerTopMid_cafe_7ttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafettttttttttttt +
							"-" +
							pointerLeftMid_cafettttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divLeftMid_cafettttttttttttt,
						pointerLeftMid_cafettttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>after_center:warning, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(error)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tttttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().left,
	)();
	let divLeftMid_cafe_1tttttttttttttt = await ClientFunction(() =>
		jq("div[style*=red]").width(),
	)();
	let divLeftMid_cafetttttttttttttt =
		divLeftMid_cafe_0tttttttttttttt + 0.5 * divLeftMid_cafe_1tttttttttttttt;
	let pointerLeftMid_cafe_2tttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3tttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafetttttttttttttt =
		pointerLeftMid_cafe_3tttttttttttttt +
		0.5 * pointerLeftMid_cafe_2tttttttttttttt;
	let divTopMid_cafe_4tttttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().top,
	)();
	let divTopMid_cafe_5tttttttttttttt = await ClientFunction(() =>
		jq("div[style*=red]").height(),
	)();
	let divTopMid_cafetttttttttttttt =
		divTopMid_cafe_4tttttttttttttt + 0.5 * divTopMid_cafe_5tttttttttttttt;
	let pointerTopMid_cafe_6tttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7tttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafetttttttttttttt =
		pointerTopMid_cafe_6tttttttttttttt +
		0.5 * pointerTopMid_cafe_7tttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafetttttttttttttt +
							"-" +
							pointerLeftMid_cafetttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divLeftMid_cafetttttttttttttt,
						pointerLeftMid_cafetttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>after_center:error, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('.z-radio input[value="after_end"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(info)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttttttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().left,
	)();
	let divLeftMid_cafe_1ttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=green]").width(),
	)();
	let divLeftMid_cafettttttttttttttt =
		divLeftMid_cafe_0ttttttttttttttt +
		0.5 * divLeftMid_cafe_1ttttttttttttttt;
	let pointerLeftMid_cafe_2ttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3ttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafettttttttttttttt =
		pointerLeftMid_cafe_3ttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2ttttttttttttttt;
	let divTopMid_cafe_4ttttttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().top,
	)();
	let divTopMid_cafe_5ttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=green]").height(),
	)();
	let divTopMid_cafettttttttttttttt =
		divTopMid_cafe_4ttttttttttttttt + 0.5 * divTopMid_cafe_5ttttttttttttttt;
	let pointerTopMid_cafe_6ttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7ttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafettttttttttttttt =
		pointerTopMid_cafe_6ttttttttttttttt +
		0.5 * pointerTopMid_cafe_7ttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafettttttttttttttt +
							"-" +
							pointerLeftMid_cafettttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divLeftMid_cafettttttttttttttt,
						pointerLeftMid_cafettttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>after_end:info, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(warning)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tttttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().left,
	)();
	let divLeftMid_cafe_1tttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=yellow]").width(),
	)();
	let divLeftMid_cafetttttttttttttttt =
		divLeftMid_cafe_0tttttttttttttttt +
		0.5 * divLeftMid_cafe_1tttttttttttttttt;
	let pointerLeftMid_cafe_2tttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3tttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafetttttttttttttttt =
		pointerLeftMid_cafe_3tttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2tttttttttttttttt;
	let divTopMid_cafe_4tttttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().top,
	)();
	let divTopMid_cafe_5tttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=yellow]").height(),
	)();
	let divTopMid_cafetttttttttttttttt =
		divTopMid_cafe_4tttttttttttttttt +
		0.5 * divTopMid_cafe_5tttttttttttttttt;
	let pointerTopMid_cafe_6tttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7tttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafetttttttttttttttt =
		pointerTopMid_cafe_6tttttttttttttttt +
		0.5 * pointerTopMid_cafe_7tttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafetttttttttttttttt +
							"-" +
							pointerLeftMid_cafetttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divLeftMid_cafetttttttttttttttt,
						pointerLeftMid_cafetttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>after_end:warning, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(error)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().left,
	)();
	let divLeftMid_cafe_1ttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=red]").width(),
	)();
	let divLeftMid_cafettttttttttttttttt =
		divLeftMid_cafe_0ttttttttttttttttt +
		0.5 * divLeftMid_cafe_1ttttttttttttttttt;
	let pointerLeftMid_cafe_2ttttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3ttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafettttttttttttttttt =
		pointerLeftMid_cafe_3ttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2ttttttttttttttttt;
	let divTopMid_cafe_4ttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().top,
	)();
	let divTopMid_cafe_5ttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=red]").height(),
	)();
	let divTopMid_cafettttttttttttttttt =
		divTopMid_cafe_4ttttttttttttttttt +
		0.5 * divTopMid_cafe_5ttttttttttttttttt;
	let pointerTopMid_cafe_6ttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7ttttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafettttttttttttttttt =
		pointerTopMid_cafe_6ttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7ttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divLeftMid_cafettttttttttttttttt +
							"-" +
							pointerLeftMid_cafettttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divLeftMid_cafettttttttttttttttt,
						pointerLeftMid_cafettttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>after_end:error, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq('.z-radio input[value="start_before"]')[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(info)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().left,
	)();
	let divLeftMid_cafe_1tttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=green]").width(),
	)();
	let divLeftMid_cafetttttttttttttttttt =
		divLeftMid_cafe_0tttttttttttttttttt +
		0.5 * divLeftMid_cafe_1tttttttttttttttttt;
	let pointerLeftMid_cafe_2tttttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3tttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafetttttttttttttttttt =
		pointerLeftMid_cafe_3tttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2tttttttttttttttttt;
	let divTopMid_cafe_4tttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().top,
	)();
	let divTopMid_cafe_5tttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=green]").height(),
	)();
	let divTopMid_cafetttttttttttttttttt =
		divTopMid_cafe_4tttttttttttttttttt +
		0.5 * divTopMid_cafe_5tttttttttttttttttt;
	let pointerTopMid_cafe_6tttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7tttttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafetttttttttttttttttt =
		pointerTopMid_cafe_6tttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7tttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafetttttttttttttttttt +
							"-" +
							pointerTopMid_cafetttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafetttttttttttttttttt,
						pointerTopMid_cafetttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>start_before:info, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(warning)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().left,
	)();
	let divLeftMid_cafe_1ttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=yellow]").width(),
	)();
	let divLeftMid_cafettttttttttttttttttt =
		divLeftMid_cafe_0ttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1ttttttttttttttttttt;
	let pointerLeftMid_cafe_2ttttttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3ttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafettttttttttttttttttt =
		pointerLeftMid_cafe_3ttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2ttttttttttttttttttt;
	let divTopMid_cafe_4ttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().top,
	)();
	let divTopMid_cafe_5ttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=yellow]").height(),
	)();
	let divTopMid_cafettttttttttttttttttt =
		divTopMid_cafe_4ttttttttttttttttttt +
		0.5 * divTopMid_cafe_5ttttttttttttttttttt;
	let pointerTopMid_cafe_6ttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7ttttttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafettttttttttttttttttt =
		pointerTopMid_cafe_6ttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7ttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafettttttttttttttttttt +
							"-" +
							pointerTopMid_cafettttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafettttttttttttttttttt,
						pointerTopMid_cafettttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>start_before:warning, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(error)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().left,
	)();
	let divLeftMid_cafe_1tttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=red]").width(),
	)();
	let divLeftMid_cafetttttttttttttttttttt =
		divLeftMid_cafe_0tttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1tttttttttttttttttttt;
	let pointerLeftMid_cafe_2tttttttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3tttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafetttttttttttttttttttt =
		pointerLeftMid_cafe_3tttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2tttttttttttttttttttt;
	let divTopMid_cafe_4tttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().top,
	)();
	let divTopMid_cafe_5tttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=red]").height(),
	)();
	let divTopMid_cafetttttttttttttttttttt =
		divTopMid_cafe_4tttttttttttttttttttt +
		0.5 * divTopMid_cafe_5tttttttttttttttttttt;
	let pointerTopMid_cafe_6tttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7tttttttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafetttttttttttttttttttt =
		pointerTopMid_cafe_6tttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7tttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafetttttttttttttttttttt +
							"-" +
							pointerTopMid_cafetttttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafetttttttttttttttttttt,
						pointerTopMid_cafetttttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>start_before:error, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq('.z-radio input[value="start_center"]')[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(info)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().left,
	)();
	let divLeftMid_cafe_1ttttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=green]").width(),
	)();
	let divLeftMid_cafettttttttttttttttttttt =
		divLeftMid_cafe_0ttttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1ttttttttttttttttttttt;
	let pointerLeftMid_cafe_2ttttttttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3ttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafettttttttttttttttttttt =
		pointerLeftMid_cafe_3ttttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2ttttttttttttttttttttt;
	let divTopMid_cafe_4ttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().top,
	)();
	let divTopMid_cafe_5ttttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=green]").height(),
	)();
	let divTopMid_cafettttttttttttttttttttt =
		divTopMid_cafe_4ttttttttttttttttttttt +
		0.5 * divTopMid_cafe_5ttttttttttttttttttttt;
	let pointerTopMid_cafe_6ttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7ttttttttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafettttttttttttttttttttt =
		pointerTopMid_cafe_6ttttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7ttttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafettttttttttttttttttttt +
							"-" +
							pointerTopMid_cafettttttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafettttttttttttttttttttt,
						pointerTopMid_cafettttttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>start_center:info, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(warning)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().left,
	)();
	let divLeftMid_cafe_1tttttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=yellow]").width(),
	)();
	let divLeftMid_cafetttttttttttttttttttttt =
		divLeftMid_cafe_0tttttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1tttttttttttttttttttttt;
	let pointerLeftMid_cafe_2tttttttttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3tttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafetttttttttttttttttttttt =
		pointerLeftMid_cafe_3tttttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2tttttttttttttttttttttt;
	let divTopMid_cafe_4tttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().top,
	)();
	let divTopMid_cafe_5tttttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=yellow]").height(),
	)();
	let divTopMid_cafetttttttttttttttttttttt =
		divTopMid_cafe_4tttttttttttttttttttttt +
		0.5 * divTopMid_cafe_5tttttttttttttttttttttt;
	let pointerTopMid_cafe_6tttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7tttttttttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafetttttttttttttttttttttt =
		pointerTopMid_cafe_6tttttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7tttttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafetttttttttttttttttttttt +
							"-" +
							pointerTopMid_cafetttttttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafetttttttttttttttttttttt,
						pointerTopMid_cafetttttttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>start_center:warning, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(error)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().left,
	)();
	let divLeftMid_cafe_1ttttttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=red]").width(),
	)();
	let divLeftMid_cafettttttttttttttttttttttt =
		divLeftMid_cafe_0ttttttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1ttttttttttttttttttttttt;
	let pointerLeftMid_cafe_2ttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3ttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafettttttttttttttttttttttt =
		pointerLeftMid_cafe_3ttttttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2ttttttttttttttttttttttt;
	let divTopMid_cafe_4ttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().top,
	)();
	let divTopMid_cafe_5ttttttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=red]").height(),
	)();
	let divTopMid_cafettttttttttttttttttttttt =
		divTopMid_cafe_4ttttttttttttttttttttttt +
		0.5 * divTopMid_cafe_5ttttttttttttttttttttttt;
	let pointerTopMid_cafe_6ttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7ttttttttttttttttttttttt = await ClientFunction(() =>
		jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafettttttttttttttttttttttt =
		pointerTopMid_cafe_6ttttttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7ttttttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafettttttttttttttttttttttt +
							"-" +
							pointerTopMid_cafettttttttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafettttttttttttttttttttttt,
						pointerTopMid_cafettttttttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>start_center:error, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('.z-radio input[value="start_after"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(info)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().left,
	)();
	let divLeftMid_cafe_1tttttttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=green]").width(),
	)();
	let divLeftMid_cafetttttttttttttttttttttttt =
		divLeftMid_cafe_0tttttttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1tttttttttttttttttttttttt;
	let pointerLeftMid_cafe_2tttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3tttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafetttttttttttttttttttttttt =
		pointerLeftMid_cafe_3tttttttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2tttttttttttttttttttttttt;
	let divTopMid_cafe_4tttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().top,
	)();
	let divTopMid_cafe_5tttttttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=green]").height(),
	)();
	let divTopMid_cafetttttttttttttttttttttttt =
		divTopMid_cafe_4tttttttttttttttttttttttt +
		0.5 * divTopMid_cafe_5tttttttttttttttttttttttt;
	let pointerTopMid_cafe_6tttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7tttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafetttttttttttttttttttttttt =
		pointerTopMid_cafe_6tttttttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7tttttttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafetttttttttttttttttttttttt +
							"-" +
							pointerTopMid_cafetttttttttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafetttttttttttttttttttttttt,
						pointerTopMid_cafetttttttttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>start_after:info, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(warning)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().left,
	)();
	let divLeftMid_cafe_1ttttttttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=yellow]").width(),
	)();
	let divLeftMid_cafettttttttttttttttttttttttt =
		divLeftMid_cafe_0ttttttttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1ttttttttttttttttttttttttt;
	let pointerLeftMid_cafe_2ttttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3ttttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafettttttttttttttttttttttttt =
		pointerLeftMid_cafe_3ttttttttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2ttttttttttttttttttttttttt;
	let divTopMid_cafe_4ttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().top,
	)();
	let divTopMid_cafe_5ttttttttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=yellow]").height(),
	)();
	let divTopMid_cafettttttttttttttttttttttttt =
		divTopMid_cafe_4ttttttttttttttttttttttttt +
		0.5 * divTopMid_cafe_5ttttttttttttttttttttttttt;
	let pointerTopMid_cafe_6ttttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7ttttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafettttttttttttttttttttttttt =
		pointerTopMid_cafe_6ttttttttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7ttttttttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafettttttttttttttttttttttttt +
							"-" +
							pointerTopMid_cafettttttttttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafettttttttttttttttttttttttt,
						pointerTopMid_cafettttttttttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>start_after:warning, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(error)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().left,
	)();
	let divLeftMid_cafe_1tttttttttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=red]").width(),
	)();
	let divLeftMid_cafetttttttttttttttttttttttttt =
		divLeftMid_cafe_0tttttttttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1tttttttttttttttttttttttttt;
	let pointerLeftMid_cafe_2tttttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3tttttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafetttttttttttttttttttttttttt =
		pointerLeftMid_cafe_3tttttttttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2tttttttttttttttttttttttttt;
	let divTopMid_cafe_4tttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().top,
	)();
	let divTopMid_cafe_5tttttttttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=red]").height(),
	)();
	let divTopMid_cafetttttttttttttttttttttttttt =
		divTopMid_cafe_4tttttttttttttttttttttttttt +
		0.5 * divTopMid_cafe_5tttttttttttttttttttttttttt;
	let pointerTopMid_cafe_6tttttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7tttttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafetttttttttttttttttttttttttt =
		pointerTopMid_cafe_6tttttttttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7tttttttttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafetttttttttttttttttttttttttt +
							"-" +
							pointerTopMid_cafetttttttttttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafetttttttttttttttttttttttttt,
						pointerTopMid_cafetttttttttttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>start_after:error, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('.z-radio input[value="end_before"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(info)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().left,
	)();
	let divLeftMid_cafe_1ttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").width(),
	)();
	let divLeftMid_cafettttttttttttttttttttttttttt =
		divLeftMid_cafe_0ttttttttttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1ttttttttttttttttttttttttttt;
	let pointerLeftMid_cafe_2ttttttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").width(),
	)();
	let pointerLeftMid_cafe_3ttttttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().left,
	)();
	let pointerLeftMid_cafettttttttttttttttttttttttttt =
		pointerLeftMid_cafe_3ttttttttttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2ttttttttttttttttttttttttttt;
	let divTopMid_cafe_4ttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().top,
	)();
	let divTopMid_cafe_5ttttttttttttttttttttttttttt = await ClientFunction(() =>
		jq("div[style*=green]").height(),
	)();
	let divTopMid_cafettttttttttttttttttttttttttt =
		divTopMid_cafe_4ttttttttttttttttttttttttttt +
		0.5 * divTopMid_cafe_5ttttttttttttttttttttttttttt;
	let pointerTopMid_cafe_6ttttttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7ttttttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafettttttttttttttttttttttttttt =
		pointerTopMid_cafe_6ttttttttttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7ttttttttttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafettttttttttttttttttttttttttt +
							"-" +
							pointerTopMid_cafettttttttttttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafettttttttttttttttttttttttttt,
						pointerTopMid_cafettttttttttttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>end_before:info, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(warning)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().left,
	)();
	let divLeftMid_cafe_1tttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").width(),
	)();
	let divLeftMid_cafetttttttttttttttttttttttttttt =
		divLeftMid_cafe_0tttttttttttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1tttttttttttttttttttttttttttt;
	let pointerLeftMid_cafe_2tttttttttttttttttttttttttttt =
		await ClientFunction(() => jq(".z-notification-pointer").width())();
	let pointerLeftMid_cafe_3tttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-notification-pointer").offset().left,
		)();
	let pointerLeftMid_cafetttttttttttttttttttttttttttt =
		pointerLeftMid_cafe_3tttttttttttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2tttttttttttttttttttttttttttt;
	let divTopMid_cafe_4tttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().top,
	)();
	let divTopMid_cafe_5tttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").height(),
	)();
	let divTopMid_cafetttttttttttttttttttttttttttt =
		divTopMid_cafe_4tttttttttttttttttttttttttttt +
		0.5 * divTopMid_cafe_5tttttttttttttttttttttttttttt;
	let pointerTopMid_cafe_6tttttttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").offset().top,
	)();
	let pointerTopMid_cafe_7tttttttttttttttttttttttttttt = await ClientFunction(
		() => jq(".z-notification-pointer").height(),
	)();
	let pointerTopMid_cafetttttttttttttttttttttttttttt =
		pointerTopMid_cafe_6tttttttttttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7tttttttttttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafetttttttttttttttttttttttttttt +
							"-" +
							pointerTopMid_cafetttttttttttttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafetttttttttttttttttttttttttttt,
						pointerTopMid_cafetttttttttttttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>end_before:warning, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(error)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().left,
	)();
	let divLeftMid_cafe_1ttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").width(),
	)();
	let divLeftMid_cafettttttttttttttttttttttttttttt =
		divLeftMid_cafe_0ttttttttttttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1ttttttttttttttttttttttttttttt;
	let pointerLeftMid_cafe_2ttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq(".z-notification-pointer").width())();
	let pointerLeftMid_cafe_3ttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-notification-pointer").offset().left,
		)();
	let pointerLeftMid_cafettttttttttttttttttttttttttttt =
		pointerLeftMid_cafe_3ttttttttttttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2ttttttttttttttttttttttttttttt;
	let divTopMid_cafe_4ttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().top,
	)();
	let divTopMid_cafe_5ttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").height(),
	)();
	let divTopMid_cafettttttttttttttttttttttttttttt =
		divTopMid_cafe_4ttttttttttttttttttttttttttttt +
		0.5 * divTopMid_cafe_5ttttttttttttttttttttttttttttt;
	let pointerTopMid_cafe_6ttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-notification-pointer").offset().top,
		)();
	let pointerTopMid_cafe_7ttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq(".z-notification-pointer").height())();
	let pointerTopMid_cafettttttttttttttttttttttttttttt =
		pointerTopMid_cafe_6ttttttttttttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7ttttttttttttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafettttttttttttttttttttttttttttt +
							"-" +
							pointerTopMid_cafettttttttttttttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafettttttttttttttttttttttttttttt,
						pointerTopMid_cafettttttttttttttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>end_before:error, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('.z-radio input[value="end_center"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(info)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().left,
	)();
	let divLeftMid_cafe_1tttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").width(),
	)();
	let divLeftMid_cafetttttttttttttttttttttttttttttt =
		divLeftMid_cafe_0tttttttttttttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1tttttttttttttttttttttttttttttt;
	let pointerLeftMid_cafe_2tttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq(".z-notification-pointer").width())();
	let pointerLeftMid_cafe_3tttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-notification-pointer").offset().left,
		)();
	let pointerLeftMid_cafetttttttttttttttttttttttttttttt =
		pointerLeftMid_cafe_3tttttttttttttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2tttttttttttttttttttttttttttttt;
	let divTopMid_cafe_4tttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").offset().top,
	)();
	let divTopMid_cafe_5tttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=green]").height(),
	)();
	let divTopMid_cafetttttttttttttttttttttttttttttt =
		divTopMid_cafe_4tttttttttttttttttttttttttttttt +
		0.5 * divTopMid_cafe_5tttttttttttttttttttttttttttttt;
	let pointerTopMid_cafe_6tttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-notification-pointer").offset().top,
		)();
	let pointerTopMid_cafe_7tttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq(".z-notification-pointer").height())();
	let pointerTopMid_cafetttttttttttttttttttttttttttttt =
		pointerTopMid_cafe_6tttttttttttttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7tttttttttttttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafetttttttttttttttttttttttttttttt +
							"-" +
							pointerTopMid_cafetttttttttttttttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafetttttttttttttttttttttttttttttt,
						pointerTopMid_cafetttttttttttttttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>end_center:info, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(warning)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().left,
	)();
	let divLeftMid_cafe_1ttttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").width(),
	)();
	let divLeftMid_cafettttttttttttttttttttttttttttttt =
		divLeftMid_cafe_0ttttttttttttttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1ttttttttttttttttttttttttttttttt;
	let pointerLeftMid_cafe_2ttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq(".z-notification-pointer").width())();
	let pointerLeftMid_cafe_3ttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-notification-pointer").offset().left,
		)();
	let pointerLeftMid_cafettttttttttttttttttttttttttttttt =
		pointerLeftMid_cafe_3ttttttttttttttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2ttttttttttttttttttttttttttttttt;
	let divTopMid_cafe_4ttttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").offset().top,
	)();
	let divTopMid_cafe_5ttttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=yellow]").height(),
	)();
	let divTopMid_cafettttttttttttttttttttttttttttttt =
		divTopMid_cafe_4ttttttttttttttttttttttttttttttt +
		0.5 * divTopMid_cafe_5ttttttttttttttttttttttttttttttt;
	let pointerTopMid_cafe_6ttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-notification-pointer").offset().top,
		)();
	let pointerTopMid_cafe_7ttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq(".z-notification-pointer").height())();
	let pointerTopMid_cafettttttttttttttttttttttttttttttt =
		pointerTopMid_cafe_6ttttttttttttttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7ttttttttttttttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafettttttttttttttttttttttttttttttt +
							"-" +
							pointerTopMid_cafettttttttttttttttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafettttttttttttttttttttttttttttttt,
						pointerTopMid_cafettttttttttttttttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>end_center:warning, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(error)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq("div[style*=red]").offset().left)();
	let divLeftMid_cafe_1tttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq("div[style*=red]").width())();
	let divLeftMid_cafetttttttttttttttttttttttttttttttt =
		divLeftMid_cafe_0tttttttttttttttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1tttttttttttttttttttttttttttttttt;
	let pointerLeftMid_cafe_2tttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq(".z-notification-pointer").width())();
	let pointerLeftMid_cafe_3tttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-notification-pointer").offset().left,
		)();
	let pointerLeftMid_cafetttttttttttttttttttttttttttttttt =
		pointerLeftMid_cafe_3tttttttttttttttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2tttttttttttttttttttttttttttttttt;
	let divTopMid_cafe_4tttttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").offset().top,
	)();
	let divTopMid_cafe_5tttttttttttttttttttttttttttttttt = await ClientFunction(
		() => jq("div[style*=red]").height(),
	)();
	let divTopMid_cafetttttttttttttttttttttttttttttttt =
		divTopMid_cafe_4tttttttttttttttttttttttttttttttt +
		0.5 * divTopMid_cafe_5tttttttttttttttttttttttttttttttt;
	let pointerTopMid_cafe_6tttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-notification-pointer").offset().top,
		)();
	let pointerTopMid_cafe_7tttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq(".z-notification-pointer").height())();
	let pointerTopMid_cafetttttttttttttttttttttttttttttttt =
		pointerTopMid_cafe_6tttttttttttttttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7tttttttttttttttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafetttttttttttttttttttttttttttttttt +
							"-" +
							pointerTopMid_cafetttttttttttttttttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafetttttttttttttttttttttttttttttttt,
						pointerTopMid_cafetttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>end_center:error, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('.z-radio input[value="end_after"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(info)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq("div[style*=green]").offset().left)();
	let divLeftMid_cafe_1ttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq("div[style*=green]").width())();
	let divLeftMid_cafettttttttttttttttttttttttttttttttt =
		divLeftMid_cafe_0ttttttttttttttttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1ttttttttttttttttttttttttttttttttt;
	let pointerLeftMid_cafe_2ttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq(".z-notification-pointer").width())();
	let pointerLeftMid_cafe_3ttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-notification-pointer").offset().left,
		)();
	let pointerLeftMid_cafettttttttttttttttttttttttttttttttt =
		pointerLeftMid_cafe_3ttttttttttttttttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2ttttttttttttttttttttttttttttttttt;
	let divTopMid_cafe_4ttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq("div[style*=green]").offset().top)();
	let divTopMid_cafe_5ttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq("div[style*=green]").height())();
	let divTopMid_cafettttttttttttttttttttttttttttttttt =
		divTopMid_cafe_4ttttttttttttttttttttttttttttttttt +
		0.5 * divTopMid_cafe_5ttttttttttttttttttttttttttttttttt;
	let pointerTopMid_cafe_6ttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-notification-pointer").offset().top,
		)();
	let pointerTopMid_cafe_7ttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq(".z-notification-pointer").height())();
	let pointerTopMid_cafettttttttttttttttttttttttttttttttt =
		pointerTopMid_cafe_6ttttttttttttttttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7ttttttttttttttttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafettttttttttttttttttttttttttttttttt +
							"-" +
							pointerTopMid_cafettttttttttttttttttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafettttttttttttttttttttttttttttttttt,
						pointerTopMid_cafettttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>end_after:info, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(warning)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0tttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq("div[style*=yellow]").offset().left)();
	let divLeftMid_cafe_1tttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq("div[style*=yellow]").width())();
	let divLeftMid_cafetttttttttttttttttttttttttttttttttt =
		divLeftMid_cafe_0tttttttttttttttttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1tttttttttttttttttttttttttttttttttt;
	let pointerLeftMid_cafe_2tttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq(".z-notification-pointer").width())();
	let pointerLeftMid_cafe_3tttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-notification-pointer").offset().left,
		)();
	let pointerLeftMid_cafetttttttttttttttttttttttttttttttttt =
		pointerLeftMid_cafe_3tttttttttttttttttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2tttttttttttttttttttttttttttttttttt;
	let divTopMid_cafe_4tttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq("div[style*=yellow]").offset().top)();
	let divTopMid_cafe_5tttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq("div[style*=yellow]").height())();
	let divTopMid_cafetttttttttttttttttttttttttttttttttt =
		divTopMid_cafe_4tttttttttttttttttttttttttttttttttt +
		0.5 * divTopMid_cafe_5tttttttttttttttttttttttttttttttttt;
	let pointerTopMid_cafe_6tttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-notification-pointer").offset().top,
		)();
	let pointerTopMid_cafe_7tttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq(".z-notification-pointer").height())();
	let pointerTopMid_cafetttttttttttttttttttttttttttttttttt =
		pointerTopMid_cafe_6tttttttttttttttttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7tttttttttttttttttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafetttttttttttttttttttttttttttttttttt +
							"-" +
							pointerTopMid_cafetttttttttttttttttttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafetttttttttttttttttttttttttttttttttt,
						pointerTopMid_cafetttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>end_after:warning, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(error)")[0]));
	await ztl.waitResponse(t);
	let divLeftMid_cafe_0ttttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq("div[style*=red]").offset().left)();
	let divLeftMid_cafe_1ttttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq("div[style*=red]").width())();
	let divLeftMid_cafettttttttttttttttttttttttttttttttttt =
		divLeftMid_cafe_0ttttttttttttttttttttttttttttttttttt +
		0.5 * divLeftMid_cafe_1ttttttttttttttttttttttttttttttttttt;
	let pointerLeftMid_cafe_2ttttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq(".z-notification-pointer").width())();
	let pointerLeftMid_cafe_3ttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-notification-pointer").offset().left,
		)();
	let pointerLeftMid_cafettttttttttttttttttttttttttttttttttt =
		pointerLeftMid_cafe_3ttttttttttttttttttttttttttttttttttt +
		0.5 * pointerLeftMid_cafe_2ttttttttttttttttttttttttttttttttttt;
	let divTopMid_cafe_4ttttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq("div[style*=red]").offset().top)();
	let divTopMid_cafe_5ttttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq("div[style*=red]").height())();
	let divTopMid_cafettttttttttttttttttttttttttttttttttt =
		divTopMid_cafe_4ttttttttttttttttttttttttttttttttttt +
		0.5 * divTopMid_cafe_5ttttttttttttttttttttttttttttttttttt;
	let pointerTopMid_cafe_6ttttttttttttttttttttttttttttttttttt =
		await ClientFunction(
			() => jq(".z-notification-pointer").offset().top,
		)();
	let pointerTopMid_cafe_7ttttttttttttttttttttttttttttttttttt =
		await ClientFunction(() => jq(".z-notification-pointer").height())();
	let pointerTopMid_cafettttttttttttttttttttttttttttttttttt =
		pointerTopMid_cafe_6ttttttttttttttttttttttttttttttttttt +
		0.5 * pointerTopMid_cafe_7ttttttttttttttttttttttttttttttttttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							divTopMid_cafettttttttttttttttttttttttttttttttttt +
							"-" +
							pointerTopMid_cafettttttttttttttttttttttttttttttttttt +
							") < 11",
					),
				{
					dependencies: {
						divTopMid_cafettttttttttttttttttttttttttttttttttt,
						pointerTopMid_cafettttttttttttttttttttttttttttttttttt,
					},
				},
			)(),
		)
		.ok(
			">>>end_after:error, 0.0, 0.0. Should see the ARROW of notification point to center",
		);
	await ztl.waitResponse(t);
});
