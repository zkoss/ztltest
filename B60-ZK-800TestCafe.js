import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-800TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-800TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk><vlayout>
                        <html>You shall see a hyper link below having a label (Link) and an image</html>
                        <a label="Link"><image src="/img/inet.png"/></a>
                      </vlayout></zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-a:contains(Link)")[0])())
		.ok();
	await t
		.expect(await ClientFunction(() => jq(".z-image").parent().is("a"))())
		.ok();
});
