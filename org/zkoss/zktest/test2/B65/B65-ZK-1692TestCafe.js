import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1692TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1692TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:w="client">
	If you see "true" in the log window, it is a bug.
	<script type="text/javascript">zk.load(\'zul.wnd\');</script>
	<button label="Create Widget">
		<attribute w:name="onBind"><![CDATA[
			if (!this._win) {
				this._win = new zul.wnd.Window();
			}
			zk.log(\'isVisible: \' + this._win.isVisible(true));
			zk.log(\'isRealVisible: \' + this._win.isRealVisible());
		]]></attribute>
	</button>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.notContains(
			ztl.normalizeText("true"),
			"you should not see 'true' in the log window",
		);
});
