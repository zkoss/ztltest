import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1600TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1600TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <div>
                      type \'123\' in datebox, then click outside, you should see the err msg \'Vous devez spécifier une date. Format:\'
                    </div>
                    <zscript><![CDATA[
    				  import java.util.Locale;
    				  import org.zkoss.web.Attributes;
    				  import org.zkoss.zk.ui.Sessions;
    				  import org.zkoss.util.Locales;
    				  import org.zkoss.zk.ui.util.Clients;
      
    				  Locale locale = new Locale("fr","FR");
    				  Sessions.getCurrent().setAttribute(Attributes.PREFERRED_LOCALE, locale);
    				  Clients.reloadMessages(locale);
    				  Locales.setThreadLocal(locale);
    				]]></zscript>
                    <datebox />
                  </zk>`,
	);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-datebox")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Widget.$(jq(".z-datebox")).$n("real")));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 3");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-errorbox-content").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(
			ztl.normalizeText("cifier une date."),
			"should see error message 'Vous devez spécifier une date.' .",
		);
});
