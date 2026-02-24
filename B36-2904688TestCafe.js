import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2904688TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2904688TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<button label="Click Me!, you should see \'The bug is fixed!\' ">
	<attribute name="onClick">{
import java.io.*;
DefaultTreeNode stn = new DefaultTreeNode(null, null);
ByteArrayOutputStream boa = new ByteArrayOutputStream();
new ObjectOutputStream(boa).writeObject(stn);
byte[] bs = boa.toByteArray();
Object l = new ObjectInputStream(new ByteArrayInputStream(bs)).readObject();
alert("The bug is fixed!");
	}</attribute>
</button>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq('@window[title="ZK Test"] @label')
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("The bug is fixed!"));
});
