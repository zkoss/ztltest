import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3013538TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3013538TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				Click the button, if doesn\'t show error message below, it\'s correct
				<div></div>
				<button id="btn" label="Reload Message">
					<attribute name="onClick">
						try {
							Clients.reloadMessages(null);
					      } catch (Exception e) {
					    	msg.setValue(e.getMessage());
					    }
					</attribute>
				</button>
				<label id="msg" style="color: red;"></label>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(""))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("msg", true).getValue(),
				)(),
			),
		);
});
