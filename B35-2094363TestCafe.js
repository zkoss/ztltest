import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2094363TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2094363TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
        <html>
          <![CDATA[  
IE,
<br/>
Keep on click "Help" button, make sure that the menupopup won\'t grow or it
is wrong.
]]>
        </html>
        <window title="Menu Demo" border="normal">
          <menubar id="menubar">
            <menu label="Help">
              <menupopup>
                <menuitem label="Index" onClick="alert(self.label)"/>
                <menu label="About">
                  <menupopup>
                    <menuitem label="About ZK" onClick="alert(self.label)"/>
                    <menuitem label="About Potix" onClick="alert(self.label)"/>
                  </menupopup>
                </menu>
              </menupopup>
            </menu>
          </menubar>
        </window>
      </zk>`,
	);
	await t.click(Selector(() => jq(".z-menu")[0]));
	await ztl.waitResponse(t);
	let popupSizeBefore_cafe = await ClientFunction(() =>
		jq(".z-menupopup").width(),
	)();
	await t.click(Selector(() => jq(".z-menu")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menu")[0]));
	await ztl.waitResponse(t);
	let popupSizeAfter_cafe = await ClientFunction(() =>
		jq(".z-menupopup").width(),
	)();
	await t
		.expect(popupSizeBefore_cafe == popupSizeAfter_cafe)
		.ok("The size should be equal than before");
});
