import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1894208TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1894208TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
        <n:p>North region should be splittable.</n:p>
        <borderlayout height="500px">
          <north size="20%" splittable="true">
            <label value="North Panel" style="color:red;font-size:30px"/>
          </north>
          <west minsize="40" maxsize="300" size="300px" splittable="true" collapsible="true">
            <label value="West Panel" style="color:blue;font-size:30px"/>
          </west>
          <center>
            <label value="Center Panel" style="color:green;font-size:30px"/>
          </center>
          <east size="10%">
            <label value="East Panel" style="color:blue;font-size:30px"/>
          </east>
          <south size="100px" border="0">
            <label value="South Panel" style="color:red;font-size:30px"/>
          </south>
        </borderlayout>
      </zk>`,
	);
	let h1_cafe = await ClientFunction(() => jq(".z-north").height())();
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq(zk.Widget.$(jq(".z-north")).$n("split"))[0]),
		250,
		50,
	);
	await ztl.waitResponse(t);
	let h2_cafe = await ClientFunction(() => jq(".z-north").height())();
	await t.expect(h2_cafe != h1_cafe).ok();
});
