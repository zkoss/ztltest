import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z60-ListboxModelSelectionTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z60-ListboxModelSelectionTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/bind/basic/listboxmodel.zul"/>`);
	await t.click(
		Selector(() =>
			zk.Widget.$(
				jq("$outerbox"),
			).firstChild.nextSibling.nextSibling.firstChild.$n(),
		),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(
						zk.Widget.$(jq("$outerbox")).firstChild.nextSibling
							.nextSibling.firstChild,
					)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$msg")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t.click(Selector(() => zk.Widget.$(jq("$btn1")).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Widget.$(
							jq(zk.Widget.$(jq("$outerbox"))).find(
								".z-listitem-selected",
							),
						).uuid,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Widget.$(jq("$outerbox")).firstChild.nextSibling
							.nextSibling.uuid,
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$msg")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("reloaded"));
});
