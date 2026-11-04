import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2783TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2783.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2783TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		zk.Widget.$(jq("@combobox")).open();
	})();
	await ztl.waitResponse(t);
	const comboitems = Selector(".z-comboitem").addCustomDOMProperties({
		height: (el) => el.getBoundingClientRect().height,
	});
	const textItemHeight = await comboitems.nth(1).height;
	await t
		.expect(comboitems.nth(0).height)
		.within(
			textItemHeight - 3,
			textItemHeight + 3,
			"the empty comboitem should be as tall as a comboitem with text",
		);
});
