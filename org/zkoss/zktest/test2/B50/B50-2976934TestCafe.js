import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2976934TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2976934TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
						<div onClick="">
							<checkbox id="cb" label="click me"/>
						</div>
					</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("cb", true).$n("real")));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("cb", true).$n("real")).prop(
						"checked",
					),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
});
