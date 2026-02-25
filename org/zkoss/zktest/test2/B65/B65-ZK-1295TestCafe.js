import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1295TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1295TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html>
		Testing Instructions:
		<ul>
			<li>Click on button \'b2\'</li>
		</ul>
		
		Expected Results:
		<ul>
			<li>Button \'b1\' should now be focused.</li>
		</ul>
	</html>
	<button id=\'b1\' label="b1" disabled="true" />
	<button id=\'b2\' label="b2" onClick=\'b1.setDisabled(false); b1.focus();\' />
</zk>`,
	);
	await t.click(Selector(() => jq("$b2")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-button:eq(0)").css("box-shadow"),
				)(),
			),
		)
		.notEql(ztl.normalizeText(""), "Button 'b1' should now be focused.");
});
