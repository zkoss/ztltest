import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3325041TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3325041TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				try to type floating number like "1.23" in the double spinner.
				<separator/>
				If floating number can\'t type in, it\'s a bug
				<separator/>
				click button next to input, see if the alerted value is the same as valued inputted. 
				<separator/>
				follow above instruction for decimalbox and doublebox too.
				<separator/>
				
				doublespinner : <doublespinner id="ds"/>
				<button id="btn1" label="test1" onClick=\'alert(ds.value)\'/>
				<separator/> 
				decimalbox: <decimalbox id="db"></decimalbox>
				<button id="btn2" label="test2" onClick=\'alert(db.value)\'/>
				<separator/> 
				doublebox: <doublebox id="doub"></doublebox>
				<button id="btn3" label="test3" onClick=\'alert(doub.value)\'/>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("ds", true).$n("real")));
	await ClientFunction(() => {
		jq(zk.Desktop._dt.$f("ds", true).$n("real"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("ds", true).$n("real")),
		ztl.normalizeText("1.23"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	let vinp_cafe = await ClientFunction(
		() => zk.Desktop._dt.$f("ds", true).$n("real").value,
	)();
	await t
		.expect(ztl.normalizeText("1.23"))
		.eql(
			ztl.normalizeText(vinp_cafe),
			"the value should be inputed correctly",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	let vmsg_cafe = await ClientFunction(
		() => jq(".z-messagebox-window").find(".z-label")[0].innerHTML,
	)();
	await t
		.expect(ztl.normalizeText("1.23"))
		.eql(
			ztl.normalizeText(vmsg_cafe),
			"the value in messagebox should equal to inputed value",
		);
	await t.click(
		Selector(() => jq(".z-messagebox-window").find(".z-button")[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("db", true).$n()));
	await ClientFunction(() => {
		jq(zk.Desktop._dt.$f("db", true).$n())[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("db", true).$n()),
		ztl.normalizeText("1.23"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	let vinp_cafet = await ClientFunction(
		() => zk.Desktop._dt.$f("db", true).$n().value,
	)();
	await t
		.expect(ztl.normalizeText("1.23"))
		.eql(
			ztl.normalizeText(vinp_cafet),
			"the value should be inputed correctly",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	let vmsg_cafet = await ClientFunction(
		() => jq(".z-messagebox-window").find(".z-label")[0].innerHTML,
	)();
	await t
		.expect(ztl.normalizeText("1.23"))
		.eql(
			ztl.normalizeText(vmsg_cafet),
			"the value in messagebox should equal to inputed value",
		);
	await t.click(
		Selector(() => jq(".z-messagebox-window").find(".z-button")[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("doub", true).$n()));
	await ClientFunction(() => {
		jq(zk.Desktop._dt.$f("doub", true).$n())[0].value = "";
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("doub", true).$n()),
		ztl.normalizeText("1.23"),
	);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	let vinp_cafett = await ClientFunction(
		() => zk.Desktop._dt.$f("doub", true).$n().value,
	)();
	await t
		.expect(ztl.normalizeText("1.23"))
		.eql(
			ztl.normalizeText(vinp_cafett),
			"the value should be inputed correctly",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn3", true).$n()));
	await ztl.waitResponse(t);
	let vmsg_cafett = await ClientFunction(
		() => jq(".z-messagebox-window").find(".z-label")[0].innerHTML,
	)();
	await t
		.expect(ztl.normalizeText("1.23"))
		.eql(
			ztl.normalizeText(vmsg_cafett),
			"the value in messagebox should equal to inputed value",
		);
	await t.click(
		Selector(() => jq(".z-messagebox-window").find(".z-button")[0]),
	);
	await ztl.waitResponse(t);
});
