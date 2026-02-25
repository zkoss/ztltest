import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3087421TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3087421.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3087421TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			await ClientFunction(() =>
				zk.Desktop._dt.$f("btn", true).isDisabled(),
			)(),
		)
		.notOk();
	await t.doubleClick(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("disabled:false"));
	await t
		.expect(
			await ClientFunction(() =>
				zk.Desktop._dt.$f("btn", true).isDisabled(),
			)(),
		)
		.notOk();
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				zk.Desktop._dt.$f("btn1", true).isDisabled(),
			)(),
		)
		.notOk();
	await t.doubleClick(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("disabled:false"));
	await t
		.expect(
			await ClientFunction(() =>
				zk.Desktop._dt.$f("btn1", true).isDisabled(),
			)(),
		)
		.notOk();
});
