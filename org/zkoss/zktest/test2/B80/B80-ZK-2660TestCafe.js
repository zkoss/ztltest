import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-2660TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-2660.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-2660TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.wait(1000).hover(Selector(() => jq(".z-listheader").last()[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq(".z-listheader").last().find(".z-icon-caret-down")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq(".z-menuitem-checked").first().find(".z-icon-check")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-notification-content").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				"Column: Id, Visible:falseColumn: Code, Visible:trueColumn: Name, Visible:true",
			),
		);
});
