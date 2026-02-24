import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - HelloTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("HelloTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="My First window" border="normal" width="200px">
			<label value="Hello, World!" />
			<button label="Hi" onClick=\'alert("Welcome")\'/>
		</window>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-window-header").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("My First window"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Hello, World!"));
});
