import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1176TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1176TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="B60-ZK-1176" contentType="text/html;charset=UTF-8"?>
                  <zk>
                    <window title="B60-ZK-1176" border="normal" width="500px" apply="org.zkoss.zktest.test2.B60_ZK_1176_TestComposer">
                      <panel title="Instruction" border="normal">
                        <panelchildren>
                          <html>
                            <p>
                              You should see 2 buttons and 2 toolbarbuttons, all with "autodisable" property specified to
          automatically disable every buttons onClick. Normally, the disabled buttons will be re-enabled 
          onResponse. In certain use case, the "autodisable" may need to be canceled during onClick when
          certain conditions are met. Naturally, one would call setDisabled(true) when this need arises.
          However, this would not work in ZK 6.01.
                            </p>
                            <p>
                              Please click on buttons that would call setDisabled(true) in onClick(). Those buttons should
          stay disabled after onClick() finishes. Other buttons should behave the same as before.
                            </p>
                            <p>Test cases:</p>
                            <ol>
                              <li>Button #1: setDisabled(true) in onClick()</li>
                              <li>Button #2: no setDisabled(true in onClick()</li>
                              <li>Toolbarbutton #1: setDisabled(true) in onClick()</li>
                              <li>Toolbarbutton #1: no setDisabled(true) in onClick()</li>
                            </ol>
                          </html>
                        </panelchildren>
                      </panel>
                      <separator/>
                      <hbox>
                        <button id="btn1" label="Button #1" autodisable="self,btn2,tbBtn1,tbBtn2"/>
                        <button id="btn2" label="Button #2" autodisable="self,btn1,tbBtn1,tbBtn2"/>
                      </hbox>
                      <toolbar mold="panel">
                        <toolbarbutton id="tbBtn1" mold="toggle" label="Toolbarbutton #1" autodisable="self,btn1,btn2,tbBtn2"/>
                        <toolbarbutton id="tbBtn2" mold="toggle" label="Toolbarbutton #2" autodisable="self,btn1,btn2,tbBtn1"/>
                      </toolbar>
                    </window>
                  </zk>`,
	);
	await t
		.expect(ztl.normalizeText("2"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-button").length)(),
			),
			"should see 2 buttons",
		);
	await t
		.expect(ztl.normalizeText("2"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-toolbarbutton").length)(),
			),
			"should see 2 toolbarbuttons",
		);
	await t.click(Selector(() => jq(".z-button:contains(Button #1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-button:contains(Button #1)").is("[disabled]"),
			)(),
		)
		.ok();
	await t.click(Selector(() => jq(".z-button:contains(Button #2)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-button:contains(Button #2)").is("[disabled]"),
			)(),
		)
		.notOk();
	await t.click(
		Selector(() => jq(".z-toolbarbutton:contains(Toolbarbutton #1)")[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-toolbarbutton:contains(Toolbarbutton #1)").is(
					"[disabled=disabled]",
				),
			)(),
		)
		.ok();
	await t.click(
		Selector(() => jq(".z-toolbarbutton:contains(Toolbarbutton #2)")[0]),
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-toolbarbutton:contains(Toolbarbutton #2)").is(
					"[disabled=disabled]",
				),
			)(),
		)
		.notOk();
});
