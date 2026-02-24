import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F51-ZK-216-treeTestCafe`
	.page`http://localhost:8080/zktest/test2/F51-ZK-216-tree.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F51-ZK-216-treeTestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
					".z-treerow:contains(/dist)",
				),
			).$n("open"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					zk.Widget.$(
						jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
							".z-treerow:contains(/dist)",
						),
					).$n("open") != null,
			)(),
		)
		.ok("Act icon should exists");
	await t
		.expect(
			await ClientFunction(
				() =>
					zk.Widget.$(
						jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
							".z-treerow:contains(/dist)",
						),
					).$n("open") != null,
			)(),
		)
		.ok("Act icon should exists");
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(/src)",
			)[0],
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(/src)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(/src)",
			)[0],
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(/src)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_4_4 = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(/src)",
			)[0],
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(/src)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_6_6 = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(/src)",
			)[0],
	)();
	let verifyVariable_cafe_7_7 = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(/src)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_8_8 = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(/src)",
			)[0],
	)();
	let verifyVariable_cafe_9_9 = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(/src)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_10_10 = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(/src)",
			)[0],
	)();
	let verifyVariable_cafe_11_11 = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(/src)",
			),
		).is(":visible"),
	)();
	await t
		.expect(
			ztl.normalizeText(
				verifyVariable_cafe_8_8 &&
					verifyVariable_cafe_10_10 &&
					verifyVariable_cafe_11_11 == verifyVariable_cafe_9_9,
			),
		)
		.eql(ztl.normalizeText("true"), "Should opened");
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
					".z-treerow:contains(/lib)",
				),
			).$n("open"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					zk.Widget.$(
						jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
							".z-treerow:contains(/lib)",
						),
					).$n("open") != null,
			)(),
		)
		.ok("Act icon should exists");
	await t
		.expect(
			await ClientFunction(
				() =>
					zk.Widget.$(
						jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
							".z-treerow:contains(/lib)",
						),
					).$n("open") != null,
			)(),
		)
		.ok("Act icon should exists");
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			)[0],
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_2_2t = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			)[0],
	)();
	let verifyVariable_cafe_3_3t = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_4_4t = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			)[0],
	)();
	let verifyVariable_cafe_5_5t = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_6_6t = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			)[0],
	)();
	let verifyVariable_cafe_7_7t = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_8_8t = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			)[0],
	)();
	let verifyVariable_cafe_9_9t = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_10_10t = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			)[0],
	)();
	let verifyVariable_cafe_11_11t = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			),
		).is(":visible"),
	)();
	await t
		.expect(
			ztl.normalizeText(
				verifyVariable_cafe_8_8t &&
					verifyVariable_cafe_10_10t &&
					verifyVariable_cafe_11_11t == verifyVariable_cafe_9_9t,
			),
		)
		.eql(ztl.normalizeText("true"), "Should opened");
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
					".z-treerow:contains(/lib)",
				),
			).$n("open"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					zk.Widget.$(
						jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
							".z-treerow:contains(/lib)",
						),
					).$n("open") != null,
			)(),
		)
		.ok("Act icon should exists");
	await t
		.expect(
			await ClientFunction(
				() =>
					zk.Widget.$(
						jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
							".z-treerow:contains(/lib)",
						),
					).$n("open") != null,
			)(),
		)
		.ok("Act icon should exists");
	let verifyVariable_cafe_0_0tt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			)[0],
	)();
	let verifyVariable_cafe_1_1tt = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_2_2tt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			)[0],
	)();
	let verifyVariable_cafe_3_3tt = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_4_4tt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			)[0],
	)();
	let verifyVariable_cafe_5_5tt = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_6_6tt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			)[0],
	)();
	let verifyVariable_cafe_7_7tt = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_8_8tt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			)[0],
	)();
	let verifyVariable_cafe_9_9tt = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_10_10tt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			)[0],
	)();
	let verifyVariable_cafe_11_11tt = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(zk.jar)",
			),
		).is(":visible"),
	)();
	await t
		.expect(
			ztl.normalizeText(
				verifyVariable_cafe_8_8tt &&
					verifyVariable_cafe_10_10tt &&
					verifyVariable_cafe_11_11tt == verifyVariable_cafe_9_9tt,
			),
		)
		.eql(ztl.normalizeText("false"), "Should closed");
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
					".z-treerow:contains(/dist)",
				),
			).$n("open"),
		),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					zk.Widget.$(
						jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
							".z-treerow:contains(/dist)",
						),
					).$n("open") != null,
			)(),
		)
		.ok("Act icon should exists");
	await t
		.expect(
			await ClientFunction(
				() =>
					zk.Widget.$(
						jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
							".z-treerow:contains(/dist)",
						),
					).$n("open") != null,
			)(),
		)
		.ok("Act icon should exists");
	let verifyVariable_cafe_0_0ttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(/src)",
			)[0],
	)();
	let verifyVariable_cafe_1_1ttt = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(/src)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_2_2ttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(/src)",
			)[0],
	)();
	let verifyVariable_cafe_3_3ttt = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(/src)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_4_4ttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(/src)",
			)[0],
	)();
	let verifyVariable_cafe_5_5ttt = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(/src)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_6_6ttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(/src)",
			)[0],
	)();
	let verifyVariable_cafe_7_7ttt = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(/src)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_8_8ttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(/src)",
			)[0],
	)();
	let verifyVariable_cafe_9_9ttt = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(/src)",
			),
		).is(":visible"),
	)();
	let verifyVariable_cafe_10_10ttt = await ClientFunction(
		() =>
			!!jq(zk.Desktop._dt.$f("trOne", true).$n("body")).find(
				".z-treerow:contains(/src)",
			)[0],
	)();
	let verifyVariable_cafe_11_11ttt = await ClientFunction(() =>
		jq(
			jq(zk.Desktop._dt.$f("trTwo", true).$n("body")).find(
				".z-treerow:contains(/src)",
			),
		).is(":visible"),
	)();
	await t
		.expect(
			ztl.normalizeText(
				verifyVariable_cafe_8_8ttt &&
					verifyVariable_cafe_10_10ttt &&
					verifyVariable_cafe_11_11ttt == verifyVariable_cafe_9_9ttt,
			),
		)
		.eql(ztl.normalizeText("false"), "Should closed");
});
