import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-2976323TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-2976323.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-2976323TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.dragToElement(
		Selector(() => jq("$two")[0]),
		Selector(() => jq("$one")[0]),
		{
			offsetX: 0,
			offsetY: 10,
			destinationOffsetX: 0,
			destinationOffsetY: 10,
		},
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$mb").first()).firstChild.getId(),
				)(),
			),
		)
		.eql(ztl.normalizeText("two"));
	await t
		.expect(
			ztl.normalizeText(await ClientFunction(() => jq("$two")[0].id)()),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("$two").parent()[0].firstChild.id,
				)(),
			),
		);
	await t.dragToElement(
		Selector(() => jq("$one")[0]),
		Selector(() => jq("$two")[0]),
		{
			offsetX: 0,
			offsetY: 10,
			destinationOffsetX: 0,
			destinationOffsetY: 10,
		},
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("$mb").first()).firstChild.getId(),
				)(),
			),
		)
		.eql(ztl.normalizeText("one"));
	await t
		.expect(
			ztl.normalizeText(await ClientFunction(() => jq("$two")[0].id)()),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("$two").parent()[0].firstChild.nextSibling.id,
				)(),
			),
		);
});
