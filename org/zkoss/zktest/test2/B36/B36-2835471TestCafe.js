import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2835471TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2835471TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<panel title="My First Window" border="normal" width="250px">
			<caption label="Hello, World!"/>
			<panelchildren>
			You should see the title is "My First Window - Hello, World!"
			</panelchildren>
			</panel>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@caption").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("My First Window - Hello, World!"));
});
