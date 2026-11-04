import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2796335TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-2796335.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-2796335TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	const shownInBothDivs = (label) => {
		const box = label.getBoundingClientRect();
		return [jq("@div:eq(0)")[0], jq("@div:eq(1)")[0]].every((div) => {
			const top = div.getBoundingClientRect().top + div.clientTop;
			return (
				box.top >= top - 1 && box.bottom <= top + div.clientHeight + 1
			);
		});
	};
	const bottomTarget = Selector(() => jq("$t2")[0]).addCustomDOMProperties({
		shownInBothDivs,
	});
	const topTarget = Selector(() => jq("$t1")[0]).addCustomDOMProperties({
		shownInBothDivs,
	});
	await t
		.expect(bottomTarget.shownInBothDivs)
		.ok("'Bottom Div target' should be scrolled into view");
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(topTarget.shownInBothDivs)
		.ok("'Top Div target' should be scrolled into view");
});
