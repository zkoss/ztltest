import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2946917TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2946917TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window id="main" title="Test of Server-side Validation">
					<html><![CDATA[
					<ul>
						<li>Click the textbox, does nothing, and then click outside of textbox.
						Then, "validate 1" shall be shown.</li>
						<li>Redo the previous step and no more message will be shown</li>
						<li>Click the textbox and type in something, and then click outside of textbox.
						Then, you shall see "validate 2" be shown</li>
					</ul>
					Why the first onblur always trigger validate?
					It is spec (since very old version), such that application can detect it
					if the user moves to a field that shall be filled something up.
					]]></html>
					<zscript>
					int cnt = 0;
					public class MyConstraint implements Constraint {
						public void validate(Component comp, Object value) {
							main.appendChild(new Label("validate "+ ++cnt));
						}
					}
					MyConstraint cst = new MyConstraint();
					</zscript>
					<textbox id="tbx" constraint="\${cst}"/>
				</window>`,
	);
	await ClientFunction(() => {
		zk.Desktop._dt.$f("tbx", true).focus();
	})();
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-label").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await ClientFunction(() => {
		zk.Desktop._dt.$f("tbx", true).focus();
	})();
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-label").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await ClientFunction(() => {
		zk.Desktop._dt.$f("tbx", true).focus();
	})();
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-label").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await ClientFunction(() => {
		zk.Desktop._dt.$f("tbx", true).focus();
	})();
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("tbx", true).$n()),
		ztl.normalizeText("a"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-label").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
});
