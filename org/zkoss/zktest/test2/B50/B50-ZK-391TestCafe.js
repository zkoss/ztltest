import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-391TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-ZK-391.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-ZK-391TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t
		.hover(Selector(() => zk.Desktop._dt.$f("lb1", true).$n()))
		.wait(3000);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Desktop._dt.$f("zulPu1", true) &&
					!!zk.Desktop._dt.$f("zulPu1", true).$n(),
			)(),
		)
		.ok("popup should exist and visible");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Desktop._dt.$f("zulPu1", true).$n().style.visibility,
				)(),
			),
		)
		.eql(ztl.normalizeText("visible"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("zulPu1", true).$n().style.display,
				)(),
			),
		)
		.notContains(
			ztl.normalizeText("none"),
			"popup should exist and visible",
		);
	let ppRight_cafe_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("zulPu1", true).$n()).outerWidth(),
	)();
	let ppRight_cafe_1 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("zulPu1", true).$n()).offset().left,
	)();
	let ppRight_cafe = ppRight_cafe_1 + ppRight_cafe_0;
	let lbRight_cafe_2 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lb1", true).$n()).outerWidth(),
	)();
	let lbRight_cafe_3 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("lb1", true).$n()).offset().left,
	)();
	let lbRight_cafe = lbRight_cafe_3 + lbRight_cafe_2;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							ppRight_cafe +
							" - " +
							lbRight_cafe +
							") <= 10",
					),
				{ dependencies: { ppRight_cafe, lbRight_cafe } },
			)(),
		)
		.ok(
			"the right side of popup should close to and slightly over the right side of label",
		);
	await t.hover(Selector(() => jq("$l1")[0]));
	await ztl.waitResponse(t);
	await t
		.hover(Selector(() => zk.Desktop._dt.$f("lb2", true).$n()))
		.wait(3000);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Desktop._dt.$f("zulPu2", true) &&
					!!zk.Desktop._dt.$f("zulPu2", true).$n(),
			)(),
		)
		.ok("popup should exist and visible");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Desktop._dt.$f("zulPu2", true).$n().style.visibility,
				)(),
			),
		)
		.eql(ztl.normalizeText("visible"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("zulPu2", true).$n().style.display,
				)(),
			),
		)
		.notContains(
			ztl.normalizeText("none"),
			"popup should exist and visible",
		);
	let ppRight_cafe_0t = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("zulPu2", true).$n()).outerWidth(),
	)();
	let ppRight_cafe_1t = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("zulPu2", true).$n()).offset().left,
	)();
	let ppRight_cafet = ppRight_cafe_1t + ppRight_cafe_0t;
	let lbRight_cafe_2t = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lb2", true).$n()).outerWidth(),
	)();
	let lbRight_cafe_3t = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("lb2", true).$n()).offset().left,
	)();
	let lbRight_cafet = lbRight_cafe_3t + lbRight_cafe_2t;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							ppRight_cafet +
							" - " +
							lbRight_cafet +
							") <= 10",
					),
				{ dependencies: { ppRight_cafet, lbRight_cafet } },
			)(),
		)
		.ok(
			"the right side of popup should close to and slightly over the right side of label",
		);
	await t.hover(Selector(() => jq("$l1")[0]));
	await ztl.waitResponse(t);
	await t
		.hover(Selector(() => zk.Desktop._dt.$f("lb3", true).$n()))
		.wait(3000);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Desktop._dt.$f("zulPu3", true) &&
					!!zk.Desktop._dt.$f("zulPu3", true).$n(),
			)(),
		)
		.ok("popup should exist and visible");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Desktop._dt.$f("zulPu3", true).$n().style.visibility,
				)(),
			),
		)
		.eql(ztl.normalizeText("visible"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("zulPu3", true).$n().style.display,
				)(),
			),
		)
		.notContains(
			ztl.normalizeText("none"),
			"popup should exist and visible",
		);
	let ppRight_cafe_0tt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("zulPu3", true).$n()).outerWidth(),
	)();
	let ppRight_cafe_1tt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("zulPu3", true).$n()).offset().left,
	)();
	let ppRight_cafett = ppRight_cafe_1tt + ppRight_cafe_0tt;
	let lbRight_cafe_2tt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lb3", true).$n()).outerWidth(),
	)();
	let lbRight_cafe_3tt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("lb3", true).$n()).offset().left,
	)();
	let lbRight_cafett = lbRight_cafe_3tt + lbRight_cafe_2tt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							ppRight_cafett +
							" - " +
							lbRight_cafett +
							") <= 10",
					),
				{ dependencies: { ppRight_cafett, lbRight_cafett } },
			)(),
		)
		.ok(
			"the right side of popup should close to and slightly over the right side of label",
		);
	await t.hover(Selector(() => jq("$l1")[0]));
	await ztl.waitResponse(t);
	await t
		.hover(Selector(() => zk.Desktop._dt.$f("javaLbl", true).$n()))
		.wait(3000);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!zk.Desktop._dt.$f("javaPu", true) &&
					!!zk.Desktop._dt.$f("javaPu", true).$n(),
			)(),
		)
		.ok("popup should exist and visible");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Desktop._dt.$f("javaPu", true).$n().style.visibility,
				)(),
			),
		)
		.eql(ztl.normalizeText("visible"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("javaPu", true).$n().style.display,
				)(),
			),
		)
		.notContains(
			ztl.normalizeText("none"),
			"popup should exist and visible",
		);
	let ppRight_cafe_0ttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("javaPu", true).$n()).outerWidth(),
	)();
	let ppRight_cafe_1ttt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("javaPu", true).$n()).offset().left,
	)();
	let ppRight_cafettt = ppRight_cafe_1ttt + ppRight_cafe_0ttt;
	let lbRight_cafe_2ttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("javaLbl", true).$n()).outerWidth(),
	)();
	let lbRight_cafe_3ttt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("javaLbl", true).$n()).offset().left,
	)();
	let lbRight_cafettt = lbRight_cafe_3ttt + lbRight_cafe_2ttt;
	await t
		.expect(
			await ClientFunction(
				() =>
					eval(
						"Math.abs(" +
							ppRight_cafettt +
							" - " +
							lbRight_cafettt +
							") <= 10",
					),
				{ dependencies: { ppRight_cafettt, lbRight_cafettt } },
			)(),
		)
		.ok(
			"the right side of popup should close to and slightly over the right side of label",
		);
	await t.hover(Selector(() => jq("$l1")[0]));
	await ztl.waitResponse(t);
});
