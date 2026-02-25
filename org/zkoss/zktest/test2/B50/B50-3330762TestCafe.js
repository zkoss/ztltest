import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3330762TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3330762TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<label id="outer" value="outer" />
    			<div></div>
    			<separator/>
					1. Input "1" in spinner and click button "test"
				<separator/>
					2. If an exception is thrown, it is a bug.
				<separator/>
					3. Click the up arrow, the doublespinner value should change to 1.1
				<separator/>
					4. Click button "test", if there is an exception, it is a bug.
				<separator/>
				<doublespinner id="ds" step="0.1" />
				<button id="btn" label="test" onClick=\'lb.value = "" + ds.value\' />
				Doublespinner Value: <label id="lb" />
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("ds", true).$n("real")));
	await ClientFunction(() => {
		jq(zk.Desktop._dt.$f("ds", true).$n("real"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("ds", true).$n("real")),
		ztl.normalizeText("1"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("outer", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("lb", true))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(
			ztl.normalizeText("1.0"),
			"the value of label should equal to the value of doublespinner",
		);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-highlighted")[0])())
		.notOk("should not have Exception");
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("should not have Exception");
	await t.click(Selector(() => zk.Desktop._dt.$f("ds", true).$n("btn-up")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("lb", true))
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(
			ztl.normalizeText("1.1"),
			"the value of label should equal to the value of doublespinner",
		);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-highlighted")[0])())
		.notOk("should not have Exception");
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("should not have Exception");
});
