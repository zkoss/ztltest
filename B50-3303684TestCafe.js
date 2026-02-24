import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3303684TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3303684TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<panel id="pa" sizable="true" width="500px" height="500px"
					movable="true" border="rounded+" floatable="true">
					<panelchildren>
						<html><![CDATA[
							<ol>
								<li>You should be able to reduce the height of the Panel. If not, it is a bug.</li>
							</ol>
						]]></html>
					</panelchildren>
				</panel>
			</zk>`,
	);
	let h1_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("pa", true).$n()).outerHeight(),
	)();
	await t.dragToElement(
		Selector(() => jq(".z-panel")[0]),
		Selector(() => jq(".z-panelchildren")[0]),
		{
			offsetX: 250,
			offsetY: 0,
			destinationOffsetX: 250,
			destinationOffsetY: 380,
		},
	);
	await ztl.waitResponse(t);
	let h2_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("pa", true).$n()).outerHeight(),
	)();
	await t
		.expect(h1_cafe - h2_cafe > 100)
		.ok("the old height is (0), the new height should smaller then (-100)");
});
