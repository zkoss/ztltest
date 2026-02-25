import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1593674TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1593674TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<groupbox onClick="" xmlns:h="http://www.w3.org/1999/xhtml">
				<caption label="User Information"/>
				<h:form action="service.zul">
					<h:input type="submit" value="Submit"/>
				</h:form>
			</groupbox>`,
	);
	await t.expect(await ClientFunction(() => !!jq(":submit")[0])()).ok();
	await t.click(Selector(() => jq(":submit")[0])).wait(1000);
	await t
		.expect(await ClientFunction(() => !!jq("div.z-error")[0])())
		.notOk();
});
