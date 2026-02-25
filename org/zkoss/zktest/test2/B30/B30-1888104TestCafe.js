import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1888104TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1888104TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:ol>
					<n:li>press click me.</n:li>
					<n:li>click into the intbox and enter a positive number, say, 5.</n:li>
					<n:li>[IE,FF,SA]tab away,([Opera]Unfocus the intbox)  and the error message is shown and it should be "ABOVE" the popup.(Use Safari version 3.0.4 or later)</n:li>
				</n:ol>
				<window id="mainWindow">
					<label id="clickLbl" value="click me" popup="mypopup" />
					<popup id="mypopup" style="border: visible">
						<window width="200px">
							<intbox id="myIntbox" constraint="no positive" value="0"/>
						</window>
					</popup>
				</window>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("clickLbl", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("mypopup", true)).height(),
	)();
	await t.expect(verifyVariable_cafe_0_0 > 0).ok();
	await ClientFunction(() => {
		zk.Desktop._dt.$f("myIntbox", true).focus();
	})();
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("myIntbox", true).$n()),
		ztl.normalizeText("5"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.wait(300).pressKey("tab");
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
	let errboxZIdx_cafe = parseInt(
		await ClientFunction(() => jq(".z-errorbox").css("z-index"))(),
	);
	let popupZIdx_cafe = parseInt(
		await ClientFunction(() =>
			jq(zk.Desktop._dt.$f("mypopup", true)).css("z-index"),
		)(),
	);
	await t.expect(errboxZIdx_cafe > popupZIdx_cafe).ok();
});
