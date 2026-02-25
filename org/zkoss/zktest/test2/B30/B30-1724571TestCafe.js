import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1724571TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1724571TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="My First Window" border="normal" width="800px">
				<vbox>1.Type something in textbox.</vbox>
				<vbox>2.click "validate by set", you should see an error message box appear:Fail validation!!</vbox>
				<vbox>3.click "Throw exception directly", you should see "Failed!!!" message box.</vbox>
				<vbox>4.click "Show Error Message", then you should see a error message window. close it.</vbox>
				<vbox>5.click on :"clean up" you should see no errors anymore.</vbox>
				<vbox>6.click on "validate by set" and then click "cleanup" then you should see errors being cleaned up.</vbox>
				<vbox>7.click on "validate by set" again, then click "retrieve and cleanup", you should see error message cleaned up and displayed at bottom of this window.</vbox>
				<vbox>8.click on "cleanup by update" and you should see errors cleaned up and textbox appear \'ab\'.</vbox>
				
				<vbox>
					<textbox id="box" constraint="no empty:Fail validation!!" />
					<button id="btn1" onClick="box.getValue()" label="Validate by get (it shall fail if error is not cleaned up)"/>
					<button id="btn2" onClick="box.setValue(&quot;&quot;)" label="Validate by set (it shall fail)"/>
					<button id="btn3" onClick="fail()" label="Throw exception directly"/>
					<button id="btn4" onClick="alert(box.getErrorMessage())" label="Show Error Message"/>
					<button id="btn5" onClick="cleanup()" label="Cleanup"/>
					<button id="btn6" onClick="cleanup2()" label="Retrieve and Cleanup"/>
					<button id="btn7" onClick="box.setValue(&quot;ab&quot;)" label=\'Cleanup by update (textbox will appear "ab")\'/>
					<label id="info"/>
				</vbox>
				<zscript>
					public void cleanup() {
						box.clearErrorMessage();
					}
					public void cleanup2() {
						info.value = box.getErrorMessage();
						cleanup();
					}
					public void fail() {
						throw new WrongValueException(box, "Failed!!!");
					}
				</zscript>
			</window>`,
	);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("box", true).$n()),
		ztl.normalizeText("test"),
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox-content")[0])())
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox-content")[0])())
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox-content")[0])())
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox-content")[0])())
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-errorbox-content").html())(),
			),
		)
		.eql(ztl.normalizeText("Fail validation!!"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn3", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-errorbox-content").html())(),
			),
		)
		.eql(ztl.normalizeText("Failed!!!"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn4", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@window .z-messagebox .z-label").html(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Failed!!!"));
	await t.click(
		Selector(
			() =>
				jq(
					'@window[mode="modal"] @button,@window[mode="highlighted"] @button',
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn5", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(
						'@window[mode="modal"],@window[mode="highlighted"]',
					)[0],
			)(),
		)
		.notOk();
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox-content")[0])())
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox-content")[0])())
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn5", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox-content")[0])())
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox-content")[0])())
		.ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("info", true)).html(),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn6", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox-content")[0])())
		.notOk();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("info", true)).html(),
				)(),
			),
		)
		.eql(ztl.normalizeText("Fail validation!!"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn7", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("box", true)).val(),
				)(),
			),
		)
		.eql(ztl.normalizeText("ab"));
});
