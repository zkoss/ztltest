import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F80-ZK-1983TestCafe`
	.page`http://localhost:8080/zktest/test2/F80-ZK-1983.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F80-ZK-1983TestCafe", async (t) => {
	await ztl.initTest(t);
	let title_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq(".z-calendar")).$n("title"))
			.text()
			.replace(/\s/g, " "),
	)();
	await t.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("left")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-calendar")).$n("today")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-calendar")).$n("title"))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText(title_cafe));
	await t.click(Selector(() => jq(".z-datebox-button")[0]));
	title_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq("@calendar")).$n("title"))
			.text()
			.replace(/\s/g, " "),
	)();
	await t.click(Selector(() => zk.Widget.$(jq("@calendar")).$n("left")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq("@calendar")).$n("today")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq("@calendar")).$n("title"))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText(title_cafe));
});
