import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2827671TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2827671TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="B36-2827671" contentType="text/html;charset=UTF-8"?>
			<zk>
			<window title="FieldComparator Seriailzation Test" border="normal">
			<html><![CDATA[
			<ol>
			<li>Press the "Click Me and see any exception"</li>
			<li>If pop out "OK", then it is OK.</li>
			<li>If pop out "Bug: ...Exception", then there is BUG.</li>
			</ol>
				]]>
			</html>
			<button label="Click Me and see any exception">
			<attribute name="onClick">
			<![CDATA[
			{
				import java.io.ByteArrayInputStream;
				import java.io.ByteArrayOutputStream;
				import java.io.ObjectOutputStream;
				import java.io.ObjectInputStream;
				
					FieldComparator fcOld;
					FieldComparator fcNew;
			
					fcOld = new FieldComparator("TestColumn", false);
			
					// Serialize the original class object
					ByteArrayOutputStream fo = new ByteArrayOutputStream();
					try {
						ObjectOutputStream so = new ObjectOutputStream(fo);
						so.writeObject(fcOld);
						so.flush();
						so.close();
					} catch (Exception ex) {
						alert("Bug: "+ex);
					}
			
					// Deserialize in to new class object
					ByteArrayInputStream fi = new ByteArrayInputStream(fo.toByteArray());
					try {
						ObjectInputStream si = new ObjectInputStream(fi);
						fcNew = (FieldComparator) si.readObject();
						si.close();
						alert("OK");
					} catch (Exceptino ex) {
						alert("Bug: "+ex);
					}
			}
			]]>
			</attribute>
			</button>
			</window>
			</zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(jq("@label")).text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("OK"));
	await t.click(Selector(() => jq("$btn1")[0]));
});
