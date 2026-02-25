import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1256TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1256TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <window width="100%">
                      1. clear the combobox value by pressing "backspace", then click outside combobox.<separator/>
                      2. should see red "onSelect event triggered" message showed.<separator/>
                      <combobox id="testCb" width="100px">
                        <attribute name="onCreate"><![CDATA[
				List list2 = new ArrayList();
				list2.add("David");
				list2.add("Thomas");
				list2.add("Steven");
				ListModelList lm2 = new ListModelList(list2);
				lm2.addSelection(lm2.get(0));
				testCb.setModel(lm2);
			]]></attribute>
                        <attribute name="onSelect">
                          lbl.setValue("onSelect event triggered");
                        </attribute>
                      </combobox>
                      <label id="lbl" style="color: red"/>
                    </window>
                  </zk>`,
	);
	if (
		await ClientFunction(
			() =>
				jq(jq(zk.Widget.$(jq(".z-combobox")).$n("real")))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(zk.Widget.$(jq(".z-combobox")).$n("real"))[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey(
		"end backspace backspace backspace backspace backspace backspace",
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-label:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-label:contains(onSelect event triggered)")[0],
			)(),
		)
		.ok();
});
