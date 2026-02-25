import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3259479TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3259479TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
	<ul>
		<li>You shall see HelloZK below.</li>
	</ul>
	]]></html>
	<zscript>
	List list = new ArrayList();
	list.add("Hello");
	list.add("ZK");
	</zscript>
	<div>
		<label forEach="\${list}">
			<zscript>
			self.setValue(each);
			</zscript>
		</label>
	</div>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@label").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("HelloZK"));
});
