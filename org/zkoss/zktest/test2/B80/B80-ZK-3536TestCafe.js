import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3536TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3536.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3536TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menubar-right")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menubar-right")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menubar-right")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menubar-right")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menubar-right")[0]));
	await ztl.waitResponse(t);
	const lastMenu = Selector(".z-menubar-content > ul > .z-menu")
		.nth(-1)
		.addCustomDOMProperties({
			hiddenWidth: (menu) => {
				const bar = menu.closest(".z-menubar");
				const body = bar.querySelector(".z-menubar-body");
				const arrow = bar.querySelector(".z-menubar-right");
				const shownRight = Math.min(
					body.getBoundingClientRect().right,
					arrow.getBoundingClientRect().left,
				);
				return menu.getBoundingClientRect().right - shownRight;
			},
		});
	await t
		.expect(lastMenu.hiddenWidth)
		.lt(1, "the last menu should show whole, not under the scroll arrow");
});
