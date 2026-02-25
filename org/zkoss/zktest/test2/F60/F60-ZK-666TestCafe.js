import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F60-ZK-666TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F60-ZK-666TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<div>
				<html><![CDATA[
				<ul>
				<li>The first two lines shall be the same: value is "abc", and annotation
				is "@annot()".</li>
				<li>The last two lines shall be the same: value is "@annot()", and
				has no annotation.</li>
				</ul>
				]]></html>
			
				<zscript><![CDATA[
				void show(Component c) {
					c.parent.insertBefore(
						new Label(": " + c.getAnnotations("value", "annot")), c.nextSibling);
				}
				]]></zscript>
			
				<textbox value="abc" a:value="@annot()" xmlns:a="annotation"/>
				<separator onCreate="show(self.previousSibling)"/>
				<textbox value="@annot()">
					<attribute name="value">abc</attribute>
				</textbox>
				<separator onCreate="show(self.previousSibling)"/>
			
				<textbox z:value="@annot()" xmlns:z="zul"/>
				<separator onCreate="show(self.previousSibling)"/>
				<textbox>
					<attribute name="value">@annot()</attribute>
				</textbox>
				<separator onCreate="show(self.previousSibling)"/>
			</div>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-textbox")[0].value)(),
			),
		)
		.contains(
			ztl.normalizeText("abc"),
			'The first two lines shall be the same: value is "abc", and annotation is "@annot()".',
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-label")[0].innerHTML)(),
			),
		)
		.contains(ztl.normalizeText("@annot()"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-label")[1].innerHTML)(),
			),
		)
		.contains(ztl.normalizeText("@annot()"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-textbox")[2].value)(),
			),
		)
		.contains(
			ztl.normalizeText("@annot()"),
			'The last two lines shall be the same: value is "@annot()", and has no annotation',
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-textbox")[3].value)(),
			),
		)
		.contains(
			ztl.normalizeText("@annot()"),
			'The last two lines shall be the same: value is "@annot()", and has no annotation',
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-label")[2].innerHTML)(),
			),
		)
		.notContains(
			ztl.normalizeText("@annot()"),
			'The last two lines shall be the same: value is "@annot()", and has no annotation',
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-label")[3].innerHTML)(),
			),
		)
		.notContains(
			ztl.normalizeText("@annot()"),
			'The last two lines shall be the same: value is "@annot()", and has no annotation',
		);
});
