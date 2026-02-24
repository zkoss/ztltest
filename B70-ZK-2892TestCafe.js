import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2892TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2892.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2892TestCafe", async (t) => {
	await ztl.initTest(t);
	let w1pw_cafe = await ClientFunction(() =>
		jq("@window").eq(0).parent().innerWidth(),
	)();
	let w1w_cafe = await ClientFunction(() =>
		jq("@window").eq(0).outerWidth(),
	)();
	let w1pl_cafe = await ClientFunction(
		() => jq("@window").eq(0).position().left,
	)();
	let w1pt_cafe = await ClientFunction(
		() => jq("@window").eq(0).position().top,
	)();
	let w1zi_cafe = await ClientFunction(() =>
		jq("@window").eq(0).css("z-index"),
	)();
	let w2pw_cafe = await ClientFunction(() =>
		jq("@window").eq(1).parent().innerWidth(),
	)();
	let w2w_cafe = await ClientFunction(() =>
		jq("@window").eq(1).outerWidth(),
	)();
	let w2pl_cafe = await ClientFunction(
		() => jq("@window").eq(1).position().left,
	)();
	let w2pt_cafe = await ClientFunction(
		() => jq("@window").eq(1).position().top,
	)();
	let w2zi_cafe = await ClientFunction(() =>
		jq("@window").eq(1).css("z-index"),
	)();
	let w3pw_cafe = await ClientFunction(() =>
		jq("@window").eq(2).parent().innerWidth(),
	)();
	let w3w_cafe = await ClientFunction(() =>
		jq("@window").eq(2).outerWidth(),
	)();
	let w3pl_cafe = await ClientFunction(
		() => jq("@window").eq(2).position().left,
	)();
	let w3pt_cafe = await ClientFunction(
		() => jq("@window").eq(2).position().top,
	)();
	let w3zi_cafe = await ClientFunction(() =>
		jq("@window").eq(2).css("z-index"),
	)();
	await t
		.expect(ztl.normalizeText(w2pt_cafe))
		.eql(ztl.normalizeText(w1pt_cafe), "position top should be the same");
	await t
		.expect(ztl.normalizeText(w3pt_cafe))
		.eql(ztl.normalizeText(w2pt_cafe), "position top should be the same");
	let verifyVariable_cafe_0_0 = parseInt(
		await ClientFunction(() => jq("@window").eq(1).css("z-index"))(),
	);
	let verifyVariable_cafe_1_1 = parseInt(
		await ClientFunction(() => jq("@window").eq(0).css("z-index"))(),
	);
	let verifyVariable_cafe_2_2 = parseInt(
		await ClientFunction(() => jq("@window").eq(1).css("z-index"))(),
	);
	let verifyVariable_cafe_3_3 = parseInt(
		await ClientFunction(() => jq("@window").eq(0).css("z-index"))(),
	);
	await t
		.expect(ztl.normalizeText(parseInt(w2zi_cafe)))
		.eql(ztl.normalizeText(parseInt(w1zi_cafe) + 1));
	let verifyVariable_cafe_4_4 = parseInt(
		await ClientFunction(() => jq("@window").eq(1).css("z-index"))(),
	);
	let verifyVariable_cafe_5_5 = parseInt(
		await ClientFunction(() => jq("@window").eq(2).css("z-index"))(),
	);
	let verifyVariable_cafe_6_6 = parseInt(
		await ClientFunction(() => jq("@window").eq(1).css("z-index"))(),
	);
	let verifyVariable_cafe_7_7 = parseInt(
		await ClientFunction(() => jq("@window").eq(2).css("z-index"))(),
	);
	await t
		.expect(ztl.normalizeText(parseInt(w3zi_cafe)))
		.eql(ztl.normalizeText(parseInt(w2zi_cafe) + 1));
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(w1pw_cafe - w1w_cafe),
		ztl.normalizeText(w1pl_cafe * 2),
		ztl.normalizeText("3"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(w2pw_cafe - w2w_cafe),
		ztl.normalizeText(w2pl_cafe * 2),
		ztl.normalizeText("3"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(w3pw_cafe - w3w_cafe),
		ztl.normalizeText(w3pl_cafe * 2),
		ztl.normalizeText("3"),
	);
});
