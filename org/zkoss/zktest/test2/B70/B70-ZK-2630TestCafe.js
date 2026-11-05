import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2630TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2630.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2630TestCafe", async (t) => {
	await ztl.initTest(t);
	const box = {
		top: (el) => el.getBoundingClientRect().top,
		middle: (el) => {
			const rect = el.getBoundingClientRect();
			return (rect.top + rect.bottom) / 2;
		},
	};
	const closeIcon = Selector(".z-window-close").addCustomDOMProperties(box);
	const caption = Selector(".z-caption-content").addCustomDOMProperties(box);
	const topsApart = Math.abs((await closeIcon.top) - (await caption.top));
	const middlesApart = Math.abs(
		(await closeIcon.middle) - (await caption.middle),
	);
	await t
		.expect(Math.min(topsApart, middlesApart))
		.lte(
			1,
			"the close icon should line up with the caption at their tops or their middles",
		);
});
