import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1540TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1540.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1540TestCafe", async (t) => {
	await ztl.initTest(t);
	let shadow_cafe = await ClientFunction(() =>
		jq(".z-datebox").css("box-shadow"),
	)();
	await t
		.expect(
			ztl.normalizeText(
				"rgb(0, 165, 225) 0px 0px 6px 0px0px 0px 6px #00a5e1",
			),
		)
		.contains(
			ztl.normalizeText(shadow_cafe),
			"Should see a blue shadow surrounding the datebox completely.",
		);
});
