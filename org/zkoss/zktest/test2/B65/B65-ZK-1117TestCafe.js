import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1117TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1117TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="My First Window" border="normal">
        <label multiline="true">
          1.click button, you should get alert : spinner value is null
2.change the spinner value to 1,then click button, you should get alert : spinner value is 1
3.clear the spinner value to empty,then click button, you should get alert : spinner value is null
4. please check the behavior with double spinner, the result should be the same
        </label>
        <spinner id="s"/>
        <button label="click1" onClick=\'alert("spinner value "+s.getValue())\'/>
        <doublespinner id="sd"/>
        <button label="click2" onClick=\'alert("doublespinner value "+sd.getValue())\'/>
      </window>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(click1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-messagebox-window").is(":visible"),
			)(),
		)
		.ok("Should show a alert box");
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(zk.Widget.$(jq(".z-spinner")).$n("btn-up"))[0]),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(click1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-messagebox-window").is(":visible"),
			)(),
		)
		.ok("Should show a alert box");
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		zk.Widget.$(jq(".z-spinner")).$n("real").focus();
	})();
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-spinner")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Widget.$(jq(".z-spinner")).$n("real")));
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace");
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(""))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq(".z-spinner")).$n("real").value,
				)(),
			),
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(click1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-messagebox-window").is(":visible"),
			)(),
		)
		.ok("Should show a alert box");
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(click2)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-messagebox-window").is(":visible"),
			)(),
		)
		.ok("Should show a alert box");
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(zk.Widget.$(jq(".z-doublespinner")).$n("btn-up"))[0]),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(click2)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-messagebox-window").is(":visible"),
			)(),
		)
		.ok("Should show a alert box");
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		zk.Widget.$(jq(".z-doublespinner")).$n("real").focus();
	})();
	await ztl.waitResponse(t);
	if (
		await ClientFunction(
			() =>
				jq(zk.Widget.$(jq(".z-doublespinner")).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => zk.Widget.$(jq(".z-doublespinner")).$n("real")),
		);
	await ztl.waitResponse(t);
	await t.pressKey("end backspace backspace backspace");
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText(""))
		.eql(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq(".z-doublespinner")).$n("real").value,
				)(),
			),
		);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(click2)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-messagebox-window").is(":visible"),
			)(),
		)
		.ok("Should show a alert box");
	await t.click(Selector(() => jq(".z-messagebox-window .z-button")[0]));
	await ztl.waitResponse(t);
});
