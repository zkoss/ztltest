import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3303725TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3303725.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3303725TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.dragToElement(
		Selector(() => zk.Desktop._dt.$f("p2", true).$n("cap")),
		Selector(
			() =>
				jq(zk.Desktop._dt.$f("p1", true).$n()).find(
					".z-panelchildren",
				)[0],
		),
		{
			offsetX: 100,
			offsetY: 10,
			destinationOffsetX: 100,
			destinationOffsetY: 180,
		},
	);
	await ztl.waitResponse(t);
	const column = Selector(() =>
		zk.Widget.$(jq(".z-portalchildren")).$n("cave"),
	).addCustomDOMProperties({
		contentHeight: (cave) => jq(cave).height(),
		panelsSpan: () => {
			const boxes = ["p1", "p2", "p3"].map((id) =>
				zk.Desktop._dt.$f(id, true).$n().getBoundingClientRect(),
			);
			return (
				Math.max(boxes[0].bottom, boxes[1].bottom, boxes[2].bottom) -
				Math.min(boxes[0].top, boxes[1].top, boxes[2].top)
			);
		},
	});
	const columnHeight = await column.contentHeight;
	await t
		.expect(column.panelsSpan)
		.within(
			columnHeight - 1,
			columnHeight + 1,
			"the three panels should fill the column from top to bottom",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("p2", true).$n().id,
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						jq(zk.Desktop._dt.$f("ptl", true).$n()).find(
							".z-panel",
						)[1].id,
				)(),
			),
		);
});
