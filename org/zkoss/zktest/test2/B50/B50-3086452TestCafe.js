import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3086452TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3086452TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
Clicks the collapse button to open/close the following two boxes.
Their behavior shall be the same: the total height won\'t be changed.

<vbox height="200px" style="border:3px black solid">
Column 1-1: The left-top box. To know whether a splitter is
collapsed, you can listen to the onOpen event.
<splitter id="s1" collapse="after" open="false"></splitter>
Column 1-2: You can enforce to open or collapse programming by
calling setOpen method.
</vbox>
<vbox height="200px" style="border:3px black solid">
Column 1-1: The left-top box. To know whether a splitter is
collapsed, you can listen to the onOpen event.
<splitter id="s2" collapse="after" open="true"></splitter>
Column 1-2: You can enforce to open or collapse programming by
calling setOpen method.
</vbox>
</zk>`,
	);
	let h_cafe_0 = await ClientFunction(() => jq(".z-vbox:eq(1)").height())();
	let h_cafe_1 = await ClientFunction(() => jq(".z-vbox:eq(0)").height())();
	let h_cafe = h_cafe_1 + h_cafe_0;
	await t.click(Selector(() => zk.Desktop._dt.$f("s1", true).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("s2", true).$n("btn")));
	await ztl.waitResponse(t);
	let h1_cafe_2 = await ClientFunction(() => jq(".z-vbox:eq(0)").height())();
	let h1_cafe_3 = await ClientFunction(() => jq(".z-vbox:eq(1)").height())();
	let h1_cafe = h1_cafe_2 + h1_cafe_3;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(h1_cafe),
		ztl.normalizeText(h_cafe),
		ztl.normalizeText("5"),
	);
});
