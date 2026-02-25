import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1869062TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1869062TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
					<n:p>Please type the "c" word into combobox and then press the ENTER on the keyboard, it should not be shown any error.</n:p>
					<window title="Combobox demo" border="normal">
						Combobox:
						<combobox autodrop="true">
							<attribute name="onChange">
							    if(self.getSelectedItem()!=null){
							     msg.value = self.getSelectedItem().getLabel();
							    }
							</attribute>
							<comboitem label="Simple and Rich" />
							<comboitem label="Cool!" />
							<comboitem label="Thumbs Up!" />
						</combobox>
						<label id="msg" />
					</window>
				</zk>`,
	);
	await t.typeText(
		Selector(() => jq(zk.Widget.$(jq(".z-combobox")).$n("real"))[0]),
		ztl.normalizeText("C"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(zk.Widget.$(jq(".z-combobox")).$n("pp"))[0],
			)(),
		)
		.ok();
	await t.click(Selector(() => jq(".z-comboitem:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$msg").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Cool!"));
});
