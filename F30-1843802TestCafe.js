import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F30-1843802TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F30-1843802TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:h2>[ 1843802 ] Comboitem supports the disabled property</n:h2>
				<n:ol>
					<n:li>You should not select the disabled item.</n:li>
					<n:li>Even you key the value of disabled item, you still can not selected on it, try typing "Simple and Rich" and you will get a error.</n:li>
				</n:ol>
				<button label="show selected" onClick=\'lb.value = cb1.selectedIndex\' />
				<combobox id="cb" constraint="strict">
					<comboitem label="item1" disabled="true"/>
					<comboitem label="item2"/>
					<comboitem label="item3" disabled="true"/>
					<comboitem label="item4" />
				</combobox>
				<label id="lb" />
			</zk>`,
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-combobox")).$n("pp")).is(":visible"),
			)(),
		)
		.notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("cb", true).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-combobox")).$n("pp")).is(":visible"),
			)(),
		)
		.ok();
	await t.click(Selector(() => jq("@comboitem")[0]));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("cb", true).$n("real").value,
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-combobox")).$n("pp")).is(":visible"),
			)(),
		)
		.ok();
	await t.click(Selector(() => jq("@comboitem")[1]));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("cb", true).$n("real").value,
				)(),
			),
		)
		.eql(ztl.normalizeText("item2"));
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-combobox")).$n("pp")).is(":visible"),
			)(),
		)
		.notOk();
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("cb", true).$n("real")),
		ztl.normalizeText("item1"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
});
