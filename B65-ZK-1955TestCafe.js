import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1955TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1955TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1955.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Oct 23, 2013  3:47:14 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
	<window border="normal">

		<label multiline="true">
		1. click the magnifying glass button
		--> focus is in bandbox, and the text states so (OK)
		2. click a row in popup
		--> focus is in bandbox, and the text states so (OK)
		3. click somewhere else outside the popup.
		--> you should see "I don\'t know where is focus" as the message.
		Or in IE, the bandbox will get the focus without that message.
		</label>

		<bandbox onFocus=\'Clients.log("focus is in bandbox")\' onBlur=\'Clients.log("I do not know where is focus")\'>
			<bandpopup style="max-height:330px;" hflex="1">
				<listbox multiple="true">


					<listhead>
						<listheader />
						<listheader></listheader>
					</listhead>

					<listitem>
						<listcell>
							<label value="listcell" />
						</listcell>
						<listcell>
							<label value="listcell" />
						</listcell>
					</listitem>

				</listbox>
			</bandpopup>
		</bandbox>
	</window>
</zk>`,
	);
	await ClientFunction(() => {
		zk.Widget.$(jq(".z-bandbox")).$n("real").focus();
	})();
	await ztl.waitResponse(t);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(ztl.normalizeText("focus is in bandbox"), "");
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-bandbox")).$n("btn")));
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() =>
				jq(zk.Widget.$(jq(".z-bandbox")).$n("pp")).find(
					".z-listitem",
				)[0],
		),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(ztl.normalizeText("focus is in bandbox"), "");
	await ClientFunction(() => {
		jq("#zk_logbox").remove();
	})();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-window-content")[0]));
	await ztl.waitResponse(t);
	await t.wait(300);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.contains(ztl.normalizeText("I do not know where is focus"), "");
});
