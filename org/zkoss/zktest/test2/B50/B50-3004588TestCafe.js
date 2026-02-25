import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3004588TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3004588TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<portallayout id="pl" width="500px" height="500px" maximizedMode="whole">
					<portalchildren width="50%" height="100%" >
						<panel id="panel" border="normal" title="test" height="300px" maximizable="true">
							<panelchildren>
								<window width="100%" height="100%" />
							</panelchildren>
						</panel>
					</portalchildren>
				</portallayout>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("panel", true).$n("max")));
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("pl", true)).height(),
			)(),
		),
		ztl.normalizeText(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("panel", true)).height(),
			)(),
		),
		ztl.normalizeText("5"),
	);
});
