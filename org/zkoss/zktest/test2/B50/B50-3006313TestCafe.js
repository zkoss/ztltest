import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3006313TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3006313.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3006313TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.drag(
		Selector(() => zk.Desktop._dt.$f("sld", true).$n("btn")),
		50,
		0,
		{ offsetX: 0, offsetY: 0 },
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				parseInt(
					await ClientFunction(() =>
						jq(zk.Desktop._dt.$f("ib2", true)).val(),
					)(),
				),
			),
		)
		.notEql(ztl.normalizeText("50"), "");
	await t
		.expect(
			ztl.normalizeText(
				parseInt(
					await ClientFunction(() =>
						jq(zk.Desktop._dt.$f("ib2", true)).val(),
					)(),
				),
			),
		)
		.eql(
			ztl.normalizeText(
				parseInt(
					await ClientFunction(() =>
						jq(zk.Desktop._dt.$f("ib1", true)).val(),
					)(),
				),
			),
		);
});
