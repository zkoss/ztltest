import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2781051TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2781051TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="main">
				After clicking 
				<button label="test">
					<attribute name="onClick">
				Object oldself = self;
				sub.doModal();
				new Label(""+self.equals(oldself)).setParent(main);
					</attribute>
				</button>, you shall see a modal window.
				Then, close the modal window by clicking closee, and
				you shall see "true" shown below
				<separator/>
			
				<window id="sub" title="Correct" visible="false" border="normal" width="200px">
					<button label="show title" onClick="l.value = self.parent.title"/>
					<button label="close" onClick="self.parent.setVisible(false)"/>
					<separator/>
					<label id="l"/>
				</window>
			</window>`,
	);
	await t.click(Selector(() => jq('@button[label="test"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('@button[label="close"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$main").find("@label:last").html(),
				)(),
			),
		)
		.eql(ztl.normalizeText("true"));
});
