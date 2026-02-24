import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3245960TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3245960TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:h="xhtml">
	<html><![CDATA[
		<ol>
			<li>You should see only "text" in the textarea, otherwise it is a bug.</li>
		</ol>
	]]></html>
	<h:textarea>text</h:textarea>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("textarea").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("text"));
});
