import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3073199TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3073199TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="test" contentType="text/html;charset=UTF-8"?>
<zk>
	<html><![CDATA[
		Click header <b>"first"</b> some times, it is OK if here shows no error messages.
	]]></html>
	<window border="none" height="100%">
		<grid>
			<columns>
				<column label="first" sort="auto" />
				<column label="teine veerg" />
			</columns>
			<rows>
				<row>
					<label value="first first" />
					<label value="first second" />
				</row>
				<row visible="false">
					<label value="second first" />
					<label value="second second" />
				</row>
				<row>
					<label value="third first" />
					<label value="third second" />
				</row>
			</rows>
		</grid>
	</window>
</zk>`,
	);
	await t.click(Selector(() => jq("@column").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
