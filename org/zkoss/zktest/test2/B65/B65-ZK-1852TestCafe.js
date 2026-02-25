import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1852TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1852TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
	Click the button, should show "".
	<separator/>
	<button label="Click">
		<attribute name="onClick"><![CDATA[
			Locale locale = org.zkoss.util.Locales.getLocale("zh_TW");
		    session.setAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE, locale);
		    execution.sendRedirect(null);
		]]></attribute>
	</button>
	<script><![CDATA[
		zk.log(jq(".z-temp .z-loading-indicator").text());
	]]></script>
</window>`,
	);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t.wait(2000);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(ztl.normalizeText(""), "should show ''.");
});
