import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-564TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-564TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<vbox id="vb" apply="org.zkoss.zktest.test2.B50_ZK_564_Composer">
				<div>1. click the "Add" to add the tree nodes. </div>
				<div>2. click the "Clone by Serialization" to copy another Tree.</div>
				<div>3. You should see a copied tree is the same as the origin one and no error dialog appears.</div>
				<div>
					<button label="Add" id="add"/>
				</div>
				<tree id="tree" />
				
				<button label="Clone by Serialization" id="clone">
					<attribute name="onClick"><![CDATA[{
				import java.io.*;
				ByteArrayOutputStream boa = new ByteArrayOutputStream();
				new ObjectOutputStream(boa).writeObject(tree);
				byte[] bs = boa.toByteArray();
				Object l = new ObjectInputStream(new ByteArrayInputStream(bs)).readObject();
				l.setId("tree" + vb.getChildren().size());
				vb.insertBefore(l, self);
				vb.insertBefore(new Label(bs.length+" bytes copied"), self);
					}]]></attribute>
				</button>
				</vbox>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("add", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("clone", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq("div:contains(java.io.NotSerializableException)").length,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 0)
		.ok("NotSerializableException suohld not occur");
});
