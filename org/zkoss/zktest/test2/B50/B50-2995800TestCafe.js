import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2995800TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2995800TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<portallayout id="pl" maximizedMode="whole">
					<portalchildren>
						<panel id="panel" border="normal" height="400px" collapsible="true"
							closable="true" maximizable="true" title="Panel">
							<panelchildren>
								<window width="100%" height="100%" />
							</panelchildren>
						</panel>			
					</portalchildren>
				</portallayout>
			</zk>`,
	);
	let h_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("pl", true).$n()).height(),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("panel", true).$n("max")));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("pl", true).$n()).height(),
				)(),
			),
		)
		.eql(ztl.normalizeText(h_cafe));
});
