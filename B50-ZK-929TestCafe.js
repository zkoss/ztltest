import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-929TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-929TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" ?>
                  <zk>
                    <label value=\'\${c:replace("ZK-123-ZK-456-ZK", "ZK", "Hello ZK!")}\'/>
                    <separator/>
                    (It should be [<label value=\'Hello ZK!-123-Hello ZK!-456-Hello ZK!\'/>
                    ] )
                    <separator/>
                    <separator/>
                    <label value=\'\${c:replace("ZKZKZK-456", "ZK", "ZKTest")}\'/>
                    <separator/>
                    (It should be [<label value=\'ZKTestZKTestZKTest-456\'/>
                    ] )
                  </zk>`,
	);
	await t
		.expect(ztl.normalizeText("Hello ZK!-123-Hello ZK!-456-Hello ZK!"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
			"should be Hello ZK!-123-Hello ZK!-456-Hello ZK!",
		);
	await t
		.expect(ztl.normalizeText("ZKTestZKTestZKTest-456"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label:eq(4)").text().replace(/\s/g, " "),
				)(),
			),
			"should be ZKTestZKTestZKTest-456",
		);
});
