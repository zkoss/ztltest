import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - F60-ZK-83TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F60-ZK-83TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<zscript>
				import org.zkoss.zktest.test2.ZK83Utils;
    			session.setAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE, new Locale("en_US"));
				</zscript>
				<vlayout>
					<hlayout>
					<button id="btnOne" label="Say Yes" onClick=\'Messagebox.show("Say Yes", "Yes", Messagebox.YES, Messagebox.INFORMATION)\'/>
					shows a message box with a button called Yes
					</hlayout>
					<hlayout>
					<button id="btnTwo" label="Hi, OK" onClick="ZK83Utils.test0(self)"/>
					shows a message box with a button called OK
					</hlayout>
					<hlayout>
					<button id="btnThree" label="Hi, Cancel and OK" onClick="ZK83Utils.test1(self)"/>
					shows a message box with two buttons: Cancel and OK
					</hlayout>
					<hlayout>
					<button id="btnFour" label="Hi, Cancel, OK and No" onClick="ZK83Utils.test2(self)"/>
					shows a message box with two buttons: Cancel, OK and No. And, the focus is OK.
					</hlayout>
				</vlayout>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btnOne", true).$n()));
	await ztl.waitResponse(t);
	let oLeft_cafe = await ClientFunction(
		() =>
			jq(".z-messagebox-window").find(".z-button:contains(Yes)").offset()
				.left,
	)();
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => !!jq(".z-messagebox-window").find(".z-button:contains(Yes)")[0],
	)();
	await t.expect(verifyVariable_cafe_0_0).ok("Button Yes exists");
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() =>
			jq(".z-messagebox-window").find(".z-button:contains(Yes)").offset()
				.left,
	)();
	await t
		.expect(verifyVariable_cafe_1_1 > 0)
		.ok("Button should in correct order");
	await t.click(
		Selector(
			() => jq(".z-messagebox-window").find(".z-button:contains(Yes)")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btnTwo", true).$n()));
	await ztl.waitResponse(t);
	let oLeft_cafet = await ClientFunction(
		() =>
			jq(".z-messagebox-window").find(".z-button:contains(OK)").offset()
				.left,
	)();
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() => !!jq(".z-messagebox-window").find(".z-button:contains(OK)")[0],
	)();
	await t.expect(verifyVariable_cafe_0_0t).ok("Button OK exists");
	let verifyVariable_cafe_1_1t = await ClientFunction(
		() =>
			jq(".z-messagebox-window").find(".z-button:contains(OK)").offset()
				.left,
	)();
	await t
		.expect(verifyVariable_cafe_1_1t > 0)
		.ok("Button should in correct order");
	await t.click(
		Selector(
			() => jq(".z-messagebox-window").find(".z-button:contains(OK)")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq(".z-messagebox-window").find(".z-button:contains(OK)")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btnThree", true).$n()));
	await ztl.waitResponse(t);
	let oLeft_cafett = await ClientFunction(
		() =>
			jq(".z-messagebox-window")
				.find(".z-button:contains(Cancel)")
				.offset().left,
	)();
	let verifyVariable_cafe_0_0tt = await ClientFunction(
		() =>
			!!jq(".z-messagebox-window").find(".z-button:contains(Cancel)")[0],
	)();
	await t.expect(verifyVariable_cafe_0_0tt).ok("Button Cancel exists");
	let verifyVariable_cafe_1_1tt = await ClientFunction(
		() =>
			jq(".z-messagebox-window")
				.find(".z-button:contains(Cancel)")
				.offset().left,
	)();
	await t
		.expect(verifyVariable_cafe_1_1tt > 0)
		.ok("Button should in correct order");
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => !!jq(".z-messagebox-window").find(".z-button:contains(OK)")[0],
	)();
	await t.expect(verifyVariable_cafe_2_2).ok("Button OK exists");
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() =>
			jq(".z-messagebox-window").find(".z-button:contains(OK)").offset()
				.left,
	)();
	await t
		.expect(verifyVariable_cafe_3_3 > oLeft_cafett)
		.ok("Button should in correct order");
	oLeft_cafett = await ClientFunction(
		() =>
			jq(".z-messagebox-window").find(".z-button:contains(OK)").offset()
				.left,
	)();
	await t.click(
		Selector(
			() => jq(".z-messagebox-window").find(".z-button:contains(OK)")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq(".z-messagebox-window").find(".z-button:contains(OK)")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btnFour", true).$n()));
	await ztl.waitResponse(t);
	let oLeft_cafettt = await ClientFunction(
		() =>
			jq(".z-messagebox-window")
				.find(".z-button:contains(Cancel)")
				.offset().left,
	)();
	let verifyVariable_cafe_0_0ttt = await ClientFunction(
		() =>
			!!jq(".z-messagebox-window").find(".z-button:contains(Cancel)")[0],
	)();
	await t.expect(verifyVariable_cafe_0_0ttt).ok("Button Cancel exists");
	let verifyVariable_cafe_1_1ttt = await ClientFunction(
		() =>
			jq(".z-messagebox-window")
				.find(".z-button:contains(Cancel)")
				.offset().left,
	)();
	await t
		.expect(verifyVariable_cafe_1_1ttt > 0)
		.ok("Button should in correct order");
	let verifyVariable_cafe_2_2t = await ClientFunction(
		() => !!jq(".z-messagebox-window").find(".z-button:contains(OK)")[0],
	)();
	await t.expect(verifyVariable_cafe_2_2t).ok("Button OK exists");
	let verifyVariable_cafe_3_3t = await ClientFunction(
		() =>
			jq(".z-messagebox-window").find(".z-button:contains(OK)").offset()
				.left,
	)();
	await t
		.expect(verifyVariable_cafe_3_3t > oLeft_cafettt)
		.ok("Button should in correct order");
	oLeft_cafettt = await ClientFunction(
		() =>
			jq(".z-messagebox-window").find(".z-button:contains(OK)").offset()
				.left,
	)();
	let verifyVariable_cafe_2_2tt = await ClientFunction(
		() => !!jq(".z-messagebox-window").find(".z-button:contains(No)")[0],
	)();
	await t.expect(verifyVariable_cafe_2_2tt).ok("Button No exists");
	let verifyVariable_cafe_3_3tt = await ClientFunction(
		() =>
			jq(".z-messagebox-window").find(".z-button:contains(No)").offset()
				.left,
	)();
	await t
		.expect(verifyVariable_cafe_3_3tt > oLeft_cafettt)
		.ok("Button should in correct order");
	oLeft_cafettt = await ClientFunction(
		() =>
			jq(".z-messagebox-window").find(".z-button:contains(No)").offset()
				.left,
	)();
	await t.click(
		Selector(
			() => jq(".z-messagebox-window").find(".z-button:contains(OK)")[0],
		),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(
			() => jq(".z-messagebox-window").find(".z-button:contains(OK)")[0],
		),
	);
	await ztl.waitResponse(t);
});
