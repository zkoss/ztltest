import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2628TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2628TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2628.zul

	Purpose:
		
	Description:
		
	History:
		Mon Aug  3 12:25:47 CST 2015, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
  <window border="normal" title="Combobox with Icons should be showing">
	  <vbox>

		  Combobox without icon:
		  <combobox>
			  <comboitem  label="Simple and Rich" />
			  <comboitem  label="Cool!" />
			  <comboitem  label="Thumbs Up!" />
		  </combobox>
		  Combobox:
		  <combobox>
			  <comboitem  iconSclass="z-icon-caret-down" label="Simple and Rich" />
			  <comboitem  iconSclass="z-icon-caret-down" label="Cool!" />
			  <comboitem  iconSclass="z-icon-caret-down" label="Thumbs Up!" />
		  </combobox>
		  Combobox with description:
		  <combobox>
			  <comboitem  iconSclass="z-icon-caret-down" label="Simple and Rich"
						 description="The simplest way to make Web applications rich" />
			  <comboitem  iconSclass="z-icon-caret-down" label="Cool!"
						 description="The coolest technology" />
			  <comboitem  iconSclass="z-icon-caret-down" label="Ajax and RIA"
						 description="Rich Internet Application by Ajax" />
		  </combobox>
		  Combobox with description and icons:
		  <combobox>
			  <comboitem  iconSclass="z-icon-caret-down" label="Simple and Rich" image="/img/Centigrade-Widget-Icons/GoldBar-32x32.gif"
						 description="The simplest way to make Web applications rich" />
			  <comboitem  iconSclass="z-icon-caret-down" label="Cool!" image="/img/Centigrade-Widget-Icons/CogwheelEye-32x32.gif"
						 description="The coolest technology" />
			  <comboitem  iconSclass="z-icon-caret-down" label="Ajax and RIA" image="/img/Centigrade-Widget-Icons/WindowGlobe-32x32.gif"
						 description="Rich Internet Application by Ajax" />
		  </combobox>
	  </vbox>
   
  </window>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-combobox-button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(""))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-combobox-popup.z-combobox-open .z-comboitem-text")
						.eq(0)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
			"",
		);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(".z-combobox-popup.z-combobox-open .z-comboitem-image")
						.eq(0)
						.children()[0],
			)(),
		)
		.notOk();
	await t.click(Selector(() => jq(".z-combobox-button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-combobox-button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(""))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-combobox-popup.z-combobox-open .z-comboitem-text")
						.eq(0)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
			"",
		);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(".z-combobox-popup.z-combobox-open .z-comboitem-icon")
						.eq(0)
						.children()[0],
			)(),
		)
		.ok();
	await t.click(Selector(() => jq(".z-combobox-button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-combobox-button").eq(2)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(""))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-combobox-popup.z-combobox-open .z-comboitem-text")
						.eq(0)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
			"",
		);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(".z-combobox-popup.z-combobox-open .z-comboitem-icon")
						.eq(0)
						.children()[0],
			)(),
		)
		.ok();
	await t.click(Selector(() => jq(".z-combobox-button").eq(2)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-combobox-button").eq(3)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(""))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-combobox-popup.z-combobox-open .z-comboitem-text")
						.eq(0)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
			"",
		);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(".z-combobox-popup.z-combobox-open .z-comboitem-icon")
						.eq(0)
						.children()[0],
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(".z-combobox-popup.z-combobox-open .z-comboitem-image")
						.eq(0)
						.children()[0],
			)(),
		)
		.ok();
	await t.click(Selector(() => jq(".z-combobox-button").eq(3)[0]));
	await ztl.waitResponse(t);
});
