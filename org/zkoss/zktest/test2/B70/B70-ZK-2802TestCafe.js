import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2802TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2802TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(t, `<include src="/test2/B70-ZK-2802.zul"/>`);
	const image = Selector(".z-toolbarbutton img").addCustomDOMProperties({
		loaded: (img) => img.complete && img.naturalWidth > 0,
		insideButton: (img) => {
			const i = img.getBoundingClientRect();
			const b = img.closest(".z-toolbarbutton").getBoundingClientRect();
			return (
				i.top >= b.top &&
				i.bottom <= b.bottom &&
				i.left >= b.left &&
				i.right <= b.right
			);
		},
		naturalSize: (img) =>
			img.width === img.naturalWidth && img.height === img.naturalHeight,
	});
	await t.expect(image.loaded).ok("the image should load");
	await t
		.expect(image.insideButton)
		.ok("the toolbarbutton should show the whole image");
	await t.expect(image.naturalSize).ok("the image should keep its own size");
});
