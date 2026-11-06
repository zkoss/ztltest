import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2438TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2438.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2438TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-detail")[0]));
	await ztl.waitResponse(t);
	const slider = Selector(
		() => jq(".z-slider").last()[0],
	).addCustomDOMProperties({
		travel: (el) =>
			el.clientWidth - el.querySelector(".z-slider-button").offsetWidth,
	});
	const fromOneToTwo = Math.round(
		((await slider.travel) * (2 - 1)) / (4 - 1),
	);
	await t.hover(Selector(() => jq(".z-slider-button").last()[0]));
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq(".z-slider-button").last()[0]),
		fromOneToTwo,
		0,
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-cell>.z-label").last().text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
});
