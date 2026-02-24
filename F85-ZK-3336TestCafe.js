import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F85-ZK-3336TestCafe`
	.page`http://localhost:8080/zktest/test2/F85-ZK-3336.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F85-ZK-3336TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ie9")) {
		console.log("This issue is ignored in current browser! (ie9)");
		return;
	}
	await ClientFunction(() => {
		jq("@tbeditor .z-tbeditor-editor")[0].innerHTML = "";
	})();
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(jq("@tbeditor .z-tbeditor-editor"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => jq("@tbeditor .z-tbeditor-editor")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("H e l l o");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	let textboxValue_cafe = await ClientFunction(
		() => jq("@textbox")[0].value,
	)();
	await t
		.expect(ztl.normalizeText(textboxValue_cafe))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@tbeditor .z-tbeditor-editor")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
			"onChange should be working",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Widget.$(jq("@tbeditor .z-tbeditor-editor")).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText(textboxValue_cafe), "Widget getValue is wrong");
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
});
