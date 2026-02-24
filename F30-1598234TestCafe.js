import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F30-1598234TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F30-1598234TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<n:p>[ 1598234 ] strict autocomplete in comboboxes</n:p>
		        <n:p>1. Type a text which not in comboitem.</n:p>
		        <n:p>2. Focus on other place but comboitem, and it should display a error message</n:p>
			<combobox id="cb" onChanging="msg.value = event.value" constraint="strict">
				<comboitem label="Simple and Rich" />
				<comboitem label="Cool!" />
				<comboitem label="Thumbs Up!" />
			</combobox>
			<label id="msg" />
		</zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])())
		.notOk();
	await ClientFunction(() => {
		zk.Desktop._dt.$f("cb", true).$n("real").value = "";
	})();
	if (
		await ClientFunction(
			() =>
				jq(zk.Desktop._dt.$f("cb", true).$n("real"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(Selector(() => zk.Desktop._dt.$f("cb", true).$n("real")));
	await ztl.waitResponse(t);
	await t.pressKey("a b c");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("msg", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("abc"));
	await t.pressKey("tab");
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
});
