import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F60-ZK-503TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F60-ZK-503TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<div>Click the test button, you shoould see two window without any problem.</div>
				<button id="btn" label="test">
					<attribute name="onClick">
						Idspace is = new Idspace();
						Window win = new Window();
						win.setId("win");
						win.setTitle("test window");
						win.setBorder("normal");
						win.setParent(is);
			
						Idspace isTwo = new Idspace();
						Window winTwo = new Window();
						winTwo.setId("win");
						winTwo.setTitle("test window");
						winTwo.setBorder("normal");
						winTwo.setParent(isTwo);
						isTwo.setParent(is);
						is.setParent(div);
					</attribute>
				</button>
				<div id="div"></div>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("Should no Exception");
});
