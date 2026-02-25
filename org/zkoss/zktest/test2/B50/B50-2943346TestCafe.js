import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2943346TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2943346TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				    <window id="win" title="You should see the first label is \'A long text which is...\' " border="normal" width="200px">
				        <zscript>
				            String abc = "A long text which is not truncated even if it should.\\n" +
						"Or not?";
				        </zscript>
				        <label id="lb1" maxlength="20" value="\${abc}"/>
				        <separator bar="true"/>
				        <label id="lb2" maxlength="20" multiline="true" value="\${abc}"/>
				    </window>
				</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("span.z-label:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("A long text which is..."));
});
