import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F60-ZK-537TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F60-ZK-537TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<div>The buttons should aligned correctly.</div>
				<checkbox id="cbOne" label="hlayout one" checked="true" />
				<checkbox id="cbTwo" label="hlayout two" checked="true" />
				<checkbox id="cbThree" label="hlayout three" checked="true" />
				<radiogroup>
					<attribute name="onCheck">
						String s = self.getSelectedItem().getLabel();
						
						if (cbOne.isChecked()) {
							hlOne.setValign(s);
							lbOne.setLabel("align "+s);
						}
						if (cbTwo.isChecked()) {
							hlTwo.setValign(s);
							lbTwo.setLabel("align "+s);
						}
						if (cbThree.isChecked()) {
							hlThree.setValign(s);
							lbThree.setLabel("align "+s);
						}
					</attribute>
					<radio label="top" id="rTop" />
					<radio label="middle" id="rMiddle" />
					<radio label="bottom" id="rBottom" />
				</radiogroup>
			    <hlayout id="hlOne" height="100px">
			    	<button id="lbOne" label="align top" />
			    	<window id="win1" width="100px" height="100px" title="test window" border="normal" />
			    </hlayout>
			    <hlayout id="hlTwo" valign="middle" height="100px">
			    	<button id="lbTwo" label="align middle" />
			    	<window id="win2" width="100px" height="100px" title="test window" border="normal" />
			    </hlayout>
			    <hlayout id="hlThree" valign="bottom" height="100px">
			    	<button id="lbThree" label="align bottom" />
			    	<window id="win3" width="100px" height="100px" title="test window" border="normal" />
			    </hlayout>
			</zk>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("lbOne", true)).offset().top,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("win1", true)).offset().top,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 - verifyVariable_cafe_1_1 < 2)
		.ok("Should align top");
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("lbTwo", true)).offset().top,
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win2", true)).outerHeight(),
	)();
	let verifyVariable_cafe_4_4 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lbTwo", true)).outerHeight(),
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("win2", true)).offset().top,
	)();
	await t
		.expect(
			verifyVariable_cafe_2_2 +
				verifyVariable_cafe_4_4 / 2 -
				(verifyVariable_cafe_5_5 + verifyVariable_cafe_3_3 / 2) <
				2,
		)
		.ok("Should align middle");
	let verifyVariable_cafe_6_6 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("win3", true)).offset().top,
	)();
	let verifyVariable_cafe_7_7 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win3", true)).outerHeight(),
	)();
	let verifyVariable_cafe_8_8 = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("lbThree", true)).offset().top,
	)();
	let verifyVariable_cafe_9_9 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lbThree", true)).outerHeight(),
	)();
	await t
		.expect(
			verifyVariable_cafe_8_8 +
				verifyVariable_cafe_9_9 -
				(verifyVariable_cafe_6_6 + verifyVariable_cafe_7_7) <
				2,
		)
		.ok("Should align bottom");
	await t.click(Selector(() => zk.Desktop._dt.$f("rTop", true).$n("real")));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("lbOne", true)).offset().top,
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("win1", true)).offset().top,
	)();
	await t
		.expect(verifyVariable_cafe_0_0t - verifyVariable_cafe_1_1t < 2)
		.ok("Should align top");
	let verifyVariable_cafe_0_0tt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("lbTwo", true)).offset().top,
	)();
	let verifyVariable_cafe_1_1tt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("win2", true)).offset().top,
	)();
	await t
		.expect(verifyVariable_cafe_0_0tt - verifyVariable_cafe_1_1tt < 2)
		.ok("Should align top");
	let verifyVariable_cafe_0_0ttt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("lbThree", true)).offset().top,
	)();
	let verifyVariable_cafe_1_1ttt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("win3", true)).offset().top,
	)();
	await t
		.expect(verifyVariable_cafe_0_0ttt - verifyVariable_cafe_1_1ttt < 2)
		.ok("Should align top");
	await t.click(
		Selector(() => zk.Desktop._dt.$f("rMiddle", true).$n("real")),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2t = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("lbOne", true)).offset().top,
	)();
	let verifyVariable_cafe_3_3t = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win1", true)).outerHeight(),
	)();
	let verifyVariable_cafe_4_4t = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lbOne", true)).outerHeight(),
	)();
	let verifyVariable_cafe_5_5t = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("win1", true)).offset().top,
	)();
	await t
		.expect(
			verifyVariable_cafe_2_2t +
				verifyVariable_cafe_4_4t / 2 -
				(verifyVariable_cafe_5_5t + verifyVariable_cafe_3_3t / 2) <
				2,
		)
		.ok("Should align middle");
	let verifyVariable_cafe_2_2tt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("lbTwo", true)).offset().top,
	)();
	let verifyVariable_cafe_3_3tt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win2", true)).outerHeight(),
	)();
	let verifyVariable_cafe_4_4tt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lbTwo", true)).outerHeight(),
	)();
	let verifyVariable_cafe_5_5tt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("win2", true)).offset().top,
	)();
	await t
		.expect(
			verifyVariable_cafe_2_2tt +
				verifyVariable_cafe_4_4tt / 2 -
				(verifyVariable_cafe_5_5tt + verifyVariable_cafe_3_3tt / 2) <
				2,
		)
		.ok("Should align middle");
	let verifyVariable_cafe_2_2ttt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("lbThree", true)).offset().top,
	)();
	let verifyVariable_cafe_3_3ttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win3", true)).outerHeight(),
	)();
	let verifyVariable_cafe_4_4ttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lbThree", true)).outerHeight(),
	)();
	let verifyVariable_cafe_5_5ttt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("win3", true)).offset().top,
	)();
	await t
		.expect(
			verifyVariable_cafe_2_2ttt +
				verifyVariable_cafe_4_4ttt / 2 -
				(verifyVariable_cafe_5_5ttt + verifyVariable_cafe_3_3ttt / 2) <
				2,
		)
		.ok("Should align middle");
	await t.click(
		Selector(() => zk.Desktop._dt.$f("rBottom", true).$n("real")),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_6_6t = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("win1", true)).offset().top,
	)();
	let verifyVariable_cafe_7_7t = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win1", true)).outerHeight(),
	)();
	let verifyVariable_cafe_8_8t = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("lbOne", true)).offset().top,
	)();
	let verifyVariable_cafe_9_9t = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lbOne", true)).outerHeight(),
	)();
	await t
		.expect(
			verifyVariable_cafe_8_8t +
				verifyVariable_cafe_9_9t -
				(verifyVariable_cafe_6_6t + verifyVariable_cafe_7_7t) <
				2,
		)
		.ok("Should align bottom");
	let verifyVariable_cafe_6_6tt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("win2", true)).offset().top,
	)();
	let verifyVariable_cafe_7_7tt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win2", true)).outerHeight(),
	)();
	let verifyVariable_cafe_8_8tt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("lbTwo", true)).offset().top,
	)();
	let verifyVariable_cafe_9_9tt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lbTwo", true)).outerHeight(),
	)();
	await t
		.expect(
			verifyVariable_cafe_8_8tt +
				verifyVariable_cafe_9_9tt -
				(verifyVariable_cafe_6_6tt + verifyVariable_cafe_7_7tt) <
				2,
		)
		.ok("Should align bottom");
	let verifyVariable_cafe_6_6ttt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("win3", true)).offset().top,
	)();
	let verifyVariable_cafe_7_7ttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("win3", true)).outerHeight(),
	)();
	let verifyVariable_cafe_8_8ttt = await ClientFunction(
		() => jq(zk.Desktop._dt.$f("lbThree", true)).offset().top,
	)();
	let verifyVariable_cafe_9_9ttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lbThree", true)).outerHeight(),
	)();
	await t
		.expect(
			verifyVariable_cafe_8_8ttt +
				verifyVariable_cafe_9_9ttt -
				(verifyVariable_cafe_6_6ttt + verifyVariable_cafe_7_7ttt) <
				2,
		)
		.ok("Should align bottom");
});
