import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1820180TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1820180TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>
<window id="root" border="normal" >
<html><![CDATA[

1. When resizing the page by dragging the right bottom corner of browser window or by
clicking the maximum/minimum buttons, the "display area" ( enclosed by the
border) of the panels should resize to fit the browser window size. <br/>
2. Instead the area resizes in a random pattern, by clicking the maximum/minimum buttons a few times, the
left pane should not occupy the whole page, leaving no space to the right pane. <br/>
]]></html>

<hbox width="600px" sizedByContent="false">

<tabbox id="tabbox" style="width:100%">

<tabs>
<tab label="Tab 1" />
<tab label="Tab 2" />
</tabs>

<tabpanels>

<tabpanel>
<tree id="ncstree" vflex="true" >

<treechildren>
<treeitem label="group 1" open="false" />
<treeitem label="group 2" open="false" />
<treeitem label="group 3" open="false" />
<treeitem label="group 4" open="false" />
<treeitem label="group 5" open="false" />
<treeitem label="group 6" open="false" />
<treeitem label="group 7" open="false" />
<treeitem label="group 8" open="false" />
<treeitem label="group 9" open="false" />
<treeitem label="group 10" open="false" />
</treechildren>

</tree>
</tabpanel>

<tabpanel>
</tabpanel>

</tabpanels>

</tabbox>

<splitter id="split"/>

<window id="contents" width="100%" height="100%" border="none" >
</window>


</hbox>
</window>`,
	);
	let owidth_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tabbox", true)).outerWidth(),
	)();
	await t.resizeWindow(500, 500);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tabbox", true)).outerWidth(),
	)();
	await t.expect(owidth_cafe - verifyVariable_cafe_0_0 < 2).ok();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tabbox", true)).outerWidth(),
	)();
	await t.expect(owidth_cafe - verifyVariable_cafe_1_1 < 2).ok();
	owidth_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tabbox", true)).outerWidth(),
	)();
	await t.drag(
		Selector(() => zk.Desktop._dt.$f("split", true).$n()),
		-20,
		0,
		{ offsetX: 0, offsetY: 0 },
	);
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tabbox", true)).outerWidth(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tabbox", true)).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(owidth_cafe - 20),
		ztl.normalizeText(verifyVariable_cafe_3_3),
		ztl.normalizeText("1"),
	);
});
