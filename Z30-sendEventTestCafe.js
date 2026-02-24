import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z30-sendEventTestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z30-sendEventTestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<vbox>
				sendEvent: You shall see TWO "done" lines after clicking the Test1 button.
				<button id="btn1" label="Test1" onClick=\'Events.sendEvent(new Event("onOK", self));b.value = a.value\'
				onOK=\'a.value = "done"\'/>
				<label id="a"/>
				<label id="b"/>
			
				postEvent: You shall see ONE "done" lines after clicking the Test2 button.
				<button id="btn2"  label="Test2" onClick=\'Events.postEvent(new Event("onOK", self));y.value = x.value\'
				onOK=\'x.value = "done"\'/>
				<label id="x"/>
				<label id="y"/>
			</vbox>`,
	);
	await t.click(Selector(() => jq("$btn1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("done"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$a").text().replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("done"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$b").text().replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btn2")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("done"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$x").text().replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText(""))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$y").text().replace(/\s/g, " "),
				)(),
			),
		);
});
