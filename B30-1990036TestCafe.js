import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1990036TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1990036TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
        <window id="w1" left="200px" top="0px" border="normal" width="550px" height="300px" sizable="true" mode="overlapped" title="Window One">
          Please Click "Window Three", then the "Window Three" window should be in front of the "Window One"
        </window>
        <window id="w2" border="normal" width="350px" height="200px" sizable="true" mode="overlapped" title="Window Two">
          <window id="w3" border="normal" width="250px" height="100px" sizable="true" mode="overlapped" title="Window Three">
            Click Me, then the window should be in front of the "Window One"
          </window>
        </window>
      </zk>`,
	);
	await t.click(Selector(() => jq("span:contains(Click Me)")[0]));
	await ztl.waitResponse(t);
	let zindex1_cafe = await ClientFunction(() => jq("$w1").css("z-index"))();
	let zindex3_cafe = await ClientFunction(() => jq("$w3").css("z-index"))();
	let verifyVariable_cafe_0_0 = parseInt(
		await ClientFunction(() => jq("$w1").css("z-index"))(),
	);
	let verifyVariable_cafe_1_1 = parseInt(
		await ClientFunction(() => jq("$w3").css("z-index"))(),
	);
	await t
		.expect(parseInt(zindex3_cafe) > parseInt(zindex1_cafe))
		.ok("The Window Three must be in front of Window One");
});
