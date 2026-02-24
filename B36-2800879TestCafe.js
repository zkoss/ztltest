import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2800879TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2800879TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Test of Grid\'s Serialization">
					Please press on the "Clone" and the "Clone by Serialization" button, and then they should not appear any error.
				<vbox id="vb" width="100%">
					<grid id="grid">
						<columns sizable="true" menupopup="auto">
							<column label="Type" sort="auto"/>
							<column label="Content"/>
						</columns>
						<rows>
							<row>
								<label value="File:"/>
								<textbox width="98%"/>
							</row>
							<row>
								<label value="Type:"/>
								<hbox>
									<listbox rows="1" mold="select">
										<listitem label="Java Files,(*.java)"/>
										<listitem label="All Files,(*.*)"/>
									</listbox>
									<button label="Browse..."/>
								</hbox>
							</row>
							<row>
								<label value="Options:"/>
								<textbox rows="3" width="98%"/>
							</row>
						</rows>
					</grid>
					<zscript>
					int cnt = 0;
					</zscript>
					<button label="Clone">
						<attribute name="onClick">{
					Object l = grid.clone();
					l.setId("dst1");
					vb.insertBefore(l, self);
						}</attribute>
					</button>
					<button label="Clone by Serialization">
						<attribute name="onClick">{
					import java.io.*;
					ByteArrayOutputStream boa = new ByteArrayOutputStream();
					new ObjectOutputStream(boa).writeObject(grid);
					byte[] bs = boa.toByteArray();
					Object l = new ObjectInputStream(new ByteArrayInputStream(bs)).readObject();
					l.setId("dst2");
					vb.insertBefore(l, self);
					vb.insertBefore(new Label(bs.length+" bytes copied"), self);
						}</attribute>
					</button>
				</vbox>
				</window>`,
	);
	await t.click(Selector(() => jq('@button[label="Clone"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq("div.z-window-modal")[0])())
		.notOk();
	await t.click(
		Selector(() => jq('@button[label="Clone by Serialization"]')[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq("div.z-window-modal")[0])())
		.notOk();
});
