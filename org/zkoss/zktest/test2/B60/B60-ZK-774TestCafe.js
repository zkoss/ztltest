import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-774TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-774TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <div>
                      There should be no gap between the bottom red border the bottom green border.
                    </div>
                    <window title="Panel toolbar" border="normal" width="400px" height="400px">
                      <panel hflex="1" vflex="1" style="border: 1px solid #009900">
                        <panelchildren>
                          Panelchildren Content
                        </panelchildren>
                        <toolbar mold="panel" align="end" style="border: 1px solid #990000">
                          <button label="OK"/>
                        </toolbar>
                      </panel>
                    </window>
                  </zk>`,
	);
	let bodyHeight_cafe = await ClientFunction(() =>
		jq(".z-panel-body").height(),
	)();
	let panelchildrenHeight_cafe = await ClientFunction(() =>
		jq(".z-panelchildren").outerHeight(false),
	)();
	let panelHeight_cafe = await ClientFunction(() =>
		jq(".z-panel-bottom").height(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(bodyHeight_cafe),
		ztl.normalizeText(panelchildrenHeight_cafe + panelHeight_cafe),
		ztl.normalizeText("1"),
	);
});
