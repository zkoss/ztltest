import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2635555TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2635555TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B36-2635555.zul

	Purpose:
		
	Description:
		
	History:
		Thu Jun  4 12:23:18     2009, Created by jumperchen

Copyright (C) 2009 Potix Corporation. All Rights Reserved.

-->
<zk>
IE only
<vbox>
<label value="1.Click the Upload button"/>
<label value="2.Click the Cancel button"/>
<label value="3.Focus into the input box, you should see a cursor is inside the input box"/>
</vbox>
<button label="Upload">
<attribute name="onClick">{
Object media = Fileupload.get(-1);
if (media instanceof org.zkoss.util.media.Media[]) {
org.zkoss.util.media.Media[] medias = (org.zkoss.util.media.Media
[])media;
for (int i = 0; i &lt; medias.length; i++) {
Image image = new Image();
image.setContent(medias[i]);
image.setParent(pics);
}
} else if (media != null)
Messagebox.show("Not an image: "+media, "Error", Messagebox.OK,
Messagebox.ERROR);
}</attribute>
</button>
<textbox id="text" onFocus=\'self.style="background:red;"\'
onBlur=\'self.style="background:white"\' />
</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:last")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq("$text").focus();
	})();
	await ztl.waitResponse(t);
	let color_cafe = await ClientFunction(() =>
		jq("$text").css("background-color"),
	)();
	await t
		.expect(ztl.normalizeText(color_cafe))
		.eql(ztl.normalizeText("rgb(255, 0, 0)"));
});
