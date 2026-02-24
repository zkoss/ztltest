import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2309TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2309TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2309.zul

	Purpose:
		
	Description:
		
	History:
		Wed, May 28, 2014 12:16:41 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
1. Please click the "Max Left" button, the width of "Left box" should expand its width as its parent
    <borderlayout id="borderLayout" width="550px" vflex="min">
        <center vflex="min">
            <columnlayout id="layout" width="500px" style="border: 1px solid blue; margin: 10px;">
                <columnchildren id="left" width="44%">
                    <grid vflex="1" hflex="1">
                        <columns>
                            <column label="Left box" />
                        </columns>
                        <rows>
                            <row>
                                <div height="100px" hflex="1" style="background: #ccc;"/>
                            </row>
                        </rows>
                    </grid>
                </columnchildren>
                <columnchildren id="middle" width="9%">
                    <div width="50px" height="100px" style="border: 1px solid red;"/>
                </columnchildren>
                <columnchildren id="right" width="44%">
                    <div style="border: 1px solid green; background: #0ee" height="100px">
                        <label value="Right box"/>
                    </div>
                </columnchildren>
            </columnlayout>
        </center>
        <south>
            <div>
                <button label="Invalidate" onClick="layout.invalidate()"/>
                        
                <button label="Max Left" id="maxL"  onClick=\'right.visible=false; middle.visible=false; left.width="100%";\' />
                <button label="Min Left"  onClick=\'right.visible=true;  middle.visible=true;  left.width="44%"\' />
                <button label="Max Right" onClick=\'left.visible=false;  middle.visible=false; right.width="100%";\'/>
                <button label="Min Right" onClick=\'left.visible=true;   middle.visible=true;  right.width="44%";\'/>
            </div>
        </south>
    </borderlayout>
</zk>`,
	);
	await t.click(Selector(() => jq("$maxL")[0]));
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(await ClientFunction(() => jq("$layout").width())()),
		ztl.normalizeText(await ClientFunction(() => jq("$left").width())()),
		ztl.normalizeText("3"),
	);
});
