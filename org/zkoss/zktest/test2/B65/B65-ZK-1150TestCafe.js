import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1150TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1150TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    You should not see any space ("nbsp") after "Help", please use browser "inspector" tool to see its HTML for the result.
                    <menubar id="menubar" width="100%">
                      <menu label="Project">
                        <menupopup>
                          <menuitem label="New"/>
                          <menuitem label="Open"/>
                        </menupopup>
                      </menu>
                      <menuitem label="Help" style="text-decoration:underline;"/>
                      <menu>
                        <menupopup>
                          <menuitem label="Index"/>
                        </menupopup>
                      </menu>
                    </menubar>
                  </zk>`,
	);
	await t
		.expect(ztl.normalizeText("Help"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-menuitem-text").text().replace(/\s/g, " "),
				)(),
			),
			"should not see any space {nbsp} after [Help] ",
		);
});
