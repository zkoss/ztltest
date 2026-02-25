import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2077748TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2077748TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
        <div align="center"><label>
                              Use columnlayout to arrange contents in window, the window in the middle
column should be in the center of Browser window
                            </label></div>
        <columnlayout>
          <columnchildren width="50%">
            <panel>
              <panelchildren><window></window></panelchildren>
            </panel>
          </columnchildren>
          <columnchildren width="300px">
            <panel>
              <panelchildren>
                <window id="centerWindow" border="normal">
                  <div align="center">
                    <label style="font-weight:bold">
                      I am the center of browser! (That is correct!)
                    </label>
                  </div>
                </window>
              </panelchildren>
            </panel>
          </columnchildren>
          <columnchildren width="50%">
            <panel>
              <panelchildren><window></window></panelchildren>
            </panel>
          </columnchildren>
        </columnlayout>
      </zk>`,
	);
});
