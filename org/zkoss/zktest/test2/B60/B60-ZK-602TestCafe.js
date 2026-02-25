import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-602TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-602TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk><vlayout id="vb">
                        <html><![CDATA[
<ol>
	<li>Click the "Clone by Serialization" button and then another window is created and append.</li>
	<li>Click any of the OK button in the new window, a message saying "dst1: onOK" will be shown.</li>
	<li>Click the "Clone" button, and repeat 1 and 2 (the message shall become "dst2: onOK").</li>
</ol>
]]></html>
                        <window id="w" title="Test of Forward Conditions" border="normal" onOK=\'alert(self.id+": onOK")\' onCancel=\'alert(self.id+": onCancel")\'>
                          <window title="Inner" border="normal">
                            <button label="OK" forward="...onOK"/>
                            <button label="Cancel" forward="...onCancel"/>
                          </window>
                          <button label="OK" forward="onOK"/>
                          <button label="Cancel" forward="onCancel"/>
                        </window>
                        \${ w.uuid }
                        <zscript>
                          int cnt = 0;
                        </zscript>
                        <button label="Clone by Serialization">
                          <attribute name="onClick"><![CDATA[{
	import java.io.*;
	ByteArrayOutputStream boa = new ByteArrayOutputStream();
	new ObjectOutputStream(boa).writeObject(w);
	byte[] bs = boa.toByteArray();
	Object n = new ObjectInputStream(new ByteArrayInputStream(bs)).readObject();
	n.setId("dst" + ++cnt);
	vb.insertBefore(n, self);
	vb.insertBefore(new Label(bs.length+" bytes copied"), self);
		}]]></attribute>
                        </button>
                        <button label="Clone">
                          <attribute name="onClick"><![CDATA[{
	Object n = w.clone();
	n.setId("dst" + ++cnt);
	vb.insertBefore(n, self);
		}]]></attribute>
                        </button>
                      </vlayout></zk>`,
	);
	await t.click(
		Selector(() => jq("@button:contains(Clone by Serialization)")[0]),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(
					".z-window-embedded:contains(Test of Forward Conditions):eq(1)",
				).find("@button:contains(OK):eq(1)")[0],
		),
	);
	await ztl.waitResponse(t);
	let msg_cafe = await ClientFunction(() =>
		jq(".z-messagebox-window").find(".z-label").text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText("dst1: onOK"))
		.eql(
			ztl.normalizeText(msg_cafe),
			"a message saying 'dst1: onOK' will be shown.",
		);
	await t.click(
		Selector(() => jq(".z-messagebox-window").find(".z-button")[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:contains(Clone)")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(
					".z-window-embedded:contains(Test of Forward Conditions):eq(2)",
				).find("@button:contains(OK):eq(1)")[0],
		),
	);
	await t
		.expect(ztl.normalizeText("dst1: onOK"))
		.eql(
			ztl.normalizeText(msg_cafe),
			"a message saying 'dst1: onOK' will be shown.",
		);
});
