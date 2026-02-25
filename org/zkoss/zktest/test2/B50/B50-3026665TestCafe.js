import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3026665TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3026665TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="Bandbox gets focus from children focus" contentType="text/html;charset=UTF-8"?>
<zk>
	<bandbox>
		<bandpopup>
			<intbox />
		</bandpopup>
	</bandbox>
	<intbox/>
</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq("@bandbox")).$n("btn")));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(zk.Widget.$(jq("@bandbox")).$n("pp"))
			.find("@intbox")
			.focus();
	})();
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@bandbox").css("box-shadow"))(),
			),
		)
		.notEql(ztl.normalizeText(""), "");
});
