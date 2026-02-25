import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-941TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-941TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:h="xhtml">
                    <h:pre>
                      1. Enter 1.239 and blur, the error message will be shown at its right side
	2. Enter 1.0  and blur, it should clear the error message
	3. Repeat 1 and 2 for the second decimalbox, and the message will be a popup (error box).
                    </h:pre>
                    <div apply="org.zkoss.zktest.test2.B50_ZK_941_Composer">
                      <groupbox>
                        <caption label="custom constraint"/>
                        <vlayout>
                          <div> Message: <label id="label" style="color:red;"/> </div>
                          <div> decimal <decimalbox id="dec" format="#.##" width="150px" roundingMode="UNNECESSARY"/> </div>
                          <div> double <doublebox id="dbl" format="#.##" width="150px" roundingMode="UNNECESSARY"/> </div>
                        </vlayout>
                      </groupbox>
                    </div>
                    <groupbox>
                      <caption label="no custom constraint"/>
                      <vlayout>
                        <div> decimal <decimalbox format="#.##" width="150px" roundingMode="UNNECESSARY"/> </div>
                        <div> doublebox <doublebox format="#.##" width="150px" roundingMode="UNNECESSARY"/>			</div>
                      </vlayout>
                    </groupbox>
                  </zk>`,
	);
	if (
		await ClientFunction(
			() => jq(jq(".z-decimalbox:eq(0)"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-decimalbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 . 2 3 9");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label[style*=red]").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(
			ztl.normalizeText("1.239"),
			"the error message will be shown at its right side",
		);
	if (
		await ClientFunction(
			() => jq(jq(".z-decimalbox:eq(0)"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-decimalbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace 0");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-label[style*=red]").text().replace(/\s/g, " "),
				)(),
			),
		)
		.notContains(
			ztl.normalizeText("1.239"),
			"should clear the error message",
		);
	if (
		await ClientFunction(
			() => jq(jq(".z-decimalbox:eq(1)"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-decimalbox:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 . 2 3 9");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.ok("the error message will be shown at its right side");
	if (
		await ClientFunction(
			() => jq(jq(".z-decimalbox:eq(1)"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-decimalbox:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace 0");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk("should clear the error message");
});
