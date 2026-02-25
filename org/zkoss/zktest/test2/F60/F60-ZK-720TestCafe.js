import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F60-ZK-720TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F60-ZK-720TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:h="xhtml">
				<h:pre>
					1.Click all the (left/Right) toolbarbutton and see if the toggle effect working.
					  press toolbarbutton and release , 
					  then a tootlebarbutton is persistent checked.
					  
					  (Also need to check if there\'s any issue with images.\')
					  
					2. Click the "test event" , there should show up "Checked:true"
					
					3. Click the "test event" again, there should show up "Checked:false"
					 
				</h:pre>
				<window title="Toolbar window" border="normal" width="400px">
					<label id="lb" value="message: " />
					<toolbar>
						<toolbarbutton id="tbn1" label="Left" mode="toggle" image="/img/network.gif" />
						<space />
						<toolbarbutton id="tbn2" label="Right"  mode="toggle" image="/img/network.gif" dir="reverse" />
						<separator />
						<toolbarbutton id="tbn3" label="checked Left" mode="toggle" checked="true" image="/img/network.gif" />
						<space />
						<toolbarbutton id="tbn4" label="checked Right" mode="toggle" checked="true" image="/img/network.gif" dir="reverse" />
						
						<separator />
						<toolbarbutton id="tbn5" label="Left" mode="toggle" />
						<space />
						<toolbarbutton id="tbn6" label="Right"  mode="toggle" />
						<separator />
						<toolbarbutton id="tbn7" label="checked Left" mode="toggle" checked="true" />
						<space />
						<toolbarbutton id="tbn8" label="checked Right" mode="toggle" checked="true" dir="reverse" />
					</toolbar>
					<toolbar>
						<toolbarbutton id="tbn9" label="Test event" mode="toggle" onCheck=\'lbl.setValue("Checked:"+event.isChecked())\' />
						<label id="lbl" /> 
						<space />
					</toolbar>
				</window>
			</zk>`,
	);
	let toggled_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn1", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn1", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn1", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.expect(verifyVariable_cafe_0_0 != toggled_cafe).ok();
	let toggled_cafet = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn1", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn1", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0t = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn1", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.expect(verifyVariable_cafe_0_0t != toggled_cafet).ok();
	let toggled_cafett = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn2", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn2", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn2", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.expect(verifyVariable_cafe_0_0tt != toggled_cafett).ok();
	let toggled_cafettt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn2", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn2", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn2", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.expect(verifyVariable_cafe_0_0ttt != toggled_cafettt).ok();
	let toggled_cafetttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn3", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn3", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn3", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.expect(verifyVariable_cafe_0_0tttt != toggled_cafetttt).ok();
	let toggled_cafettttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn3", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn3", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn3", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.expect(verifyVariable_cafe_0_0ttttt != toggled_cafettttt).ok();
	let toggled_cafetttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn4", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn4", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn4", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.expect(verifyVariable_cafe_0_0tttttt != toggled_cafetttttt).ok();
	let toggled_cafettttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn4", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn4", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn4", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.expect(verifyVariable_cafe_0_0ttttttt != toggled_cafettttttt).ok();
	let toggled_cafetttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn5", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn5", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn5", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t
		.expect(verifyVariable_cafe_0_0tttttttt != toggled_cafetttttttt)
		.ok();
	let toggled_cafettttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn5", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn5", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn5", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t
		.expect(verifyVariable_cafe_0_0ttttttttt != toggled_cafettttttttt)
		.ok();
	let toggled_cafetttttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn6", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn6", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn6", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t
		.expect(verifyVariable_cafe_0_0tttttttttt != toggled_cafetttttttttt)
		.ok();
	let toggled_cafettttttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn6", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn6", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn6", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t
		.expect(verifyVariable_cafe_0_0ttttttttttt != toggled_cafettttttttttt)
		.ok();
	let toggled_cafetttttttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn7", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn7", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttttttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn7", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t
		.expect(verifyVariable_cafe_0_0tttttttttttt != toggled_cafetttttttttttt)
		.ok();
	let toggled_cafettttttttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn7", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn7", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttttttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn7", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0ttttttttttttt != toggled_cafettttttttttttt,
		)
		.ok();
	let toggled_cafetttttttttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn8", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn8", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttttttttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn8", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0tttttttttttttt != toggled_cafetttttttttttttt,
		)
		.ok();
	let toggled_cafettttttttttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn8", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn8", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttttttttttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbn8", true).$n()).hasClass(
			"z-toolbarbutton-checked",
		),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0ttttttttttttttt !=
				toggled_cafettttttttttttttt,
		)
		.ok();
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn9", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lbl", true).$n().innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("true"), "should be toggled");
	await t.click(Selector(() => zk.Desktop._dt.$f("tbn9", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Desktop._dt.$f("lbl", true).$n().innerHTML,
				)(),
			),
		)
		.contains(ztl.normalizeText("false"), "should not be toggled");
});
