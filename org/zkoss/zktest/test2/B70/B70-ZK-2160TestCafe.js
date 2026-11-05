import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2160TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2160.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2160TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t.resizeWindow(1024, 300);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@menu:visible")[0]));
	await ztl.waitResponse(t);
	const popup = Selector(
		() => jq("@menupopup:visible")[0],
	).addCustomDOMProperties({
		left: (el) => el.getBoundingClientRect().left,
		besideMenu: (el) => {
			const popupBox = el.getBoundingClientRect();
			const menuBox = jq("@menu:visible")[0].getBoundingClientRect();
			return (
				popupBox.right <= menuBox.left + 1 ||
				popupBox.left >= menuBox.right - 1
			);
		},
		insideWindow: (el) => {
			const box = el.getBoundingClientRect();
			return (
				box.left >= 0 &&
				box.right <= document.documentElement.clientWidth
			);
		},
	});
	await t
		.expect(popup.besideMenu)
		.ok("the menupopup should open beside the menu");
	await t
		.expect(popup.insideWindow)
		.ok("the menupopup should open inside the window");
	const openedLeft = await popup.left;
	await t.wait(2500);
	await t
		.expect(popup.left)
		.eql(openedLeft, "the menupopup should stay where it opened");
});
