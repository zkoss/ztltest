import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F60-ZK-719TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F60-ZK-719TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>
					<div>1. You can see a combobutton in each toolbar, their size should similar to toolbarbutton.</div>
					<div>2. Click left button of combobutton one, the label \'message: \' should change to \'combobutton clicked.\'.</div>
					<div>3. Click right button of combobutton one twice, the label should change to \'combobutton popup opened.\' then \'combobutton popup closed.\'.</div>
					<div>4. Test step 2 and step 3 with combobutton two.</div>
					<div>5. Also test F55-ZK-318.zul and make sure nothing strange.</div>
				</div>
				<button label="change to breeze">
					<attribute name="onClick">
						org.zkoss.zkplus.theme.Themes.setTheme(Executions.getCurrent(), "breeze"); // breeze
						Executions.sendRedirect(null);
					</attribute>
				</button>
				<button label="change to sapphire">
					<attribute name="onClick">
						org.zkoss.zkplus.theme.Themes.setTheme(Executions.getCurrent(), "sapphire");
						Executions.sendRedirect(null);
					</attribute>
				</button>
				<button label="change to silvertail">
					<attribute name="onClick">
						org.zkoss.zkplus.theme.Themes.setTheme(Executions.getCurrent(), "silvertail");
						Executions.sendRedirect(null);
					</attribute>
				</button>
				<window title="Toolbar window" border="normal" width="400px">
					<label id="lb" value="message: " />
					<toolbar>
						<toolbarbutton label="Left" image="/img/network.gif" />
						<space />
						<toolbarbutton id="tbbtnOne" label="Right" image="/img/network.gif"
							dir="reverse" />
						<combobutton id="cbbtnOne" label="combobutton one" image="/img/network.gif" mold="toolbar"
							onClick=\'lb.setValue("message: combobutton clicked.");\'
							onOpen=\'lb.setValue("message: combobutton popup "+ (self.open? "opened." : "closed."));\'>
							<popup id="ppOne">
								<vbox>
									<hbox>
										Search
										<textbox />
									</hbox>
									<listbox width="200px">
										<listhead>
											<listheader label="Name" />
											<listheader label="Description" />
										</listhead>
										<listitem>
											<listcell label="John" />
											<listcell label="CEO" />
										</listitem>
										<listitem>
											<listcell label="Joe" />
											<listcell label="Engineer" />
										</listitem>
										<listitem>
											<listcell label="Mary" />
											<listcell label="Supervisor" />
										</listitem>
									</listbox>
								</vbox>
							</popup>
						</combobutton>
					</toolbar>
					<toolbar orient="vertical">
						<button label="Left" image="/img/network.gif" width="125px" />
						<toolbarbutton id="tbbtnTwo" label="Right" image="/img/network.gif"
							dir="reverse" />
						<combobutton id="cbbtnTwo" label="combobutton two"
							onClick=\'lb.setValue("message: combobutton two clicked.");\'
							onOpen=\'lb.setValue("message: combobutton two popup "+ (self.open? "opened." : "closed."));\'
							dir="reverse" image="/img/network.gif" mold="toolbar">
							<popup id="ppTwo">
								<vbox>
									<hbox>
										Search
										<textbox />
									</hbox>
									<listbox width="200px">
										<listhead>
											<listheader label="Name" />
											<listheader label="Description" />
										</listhead>
										<listitem>
											<listcell label="John" />
											<listcell label="CEO" />
										</listitem>
										<listitem>
											<listcell label="Joe" />
											<listcell label="Engineer" />
										</listitem>
										<listitem>
											<listcell label="Mary" />
											<listcell label="Supervisor" />
										</listitem>
									</listbox>
								</vbox>
							</popup>
						</combobutton>
					</toolbar>
				</window>
			</zk>`,
	);
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("cbbtnTwo", true)).outerHeight(true),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbbtnTwo", true)).outerHeight(true),
	)();
	let verifyVariable_cafe_4_4 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbbtnOne", true)).outerHeight(true),
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("cbbtnOne", true)).outerHeight(true),
	)();
	await t
		.expect(
			verifyVariable_cafe_4_4 - verifyVariable_cafe_5_5 <= 2 &&
				verifyVariable_cafe_3_3 - verifyVariable_cafe_2_2 <= 2,
		)
		.ok(
			"The size of combobutton (tbbtn mold) should similar to toolbarbutton",
		);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("cbbtnOne", true))).$n("real"),
		),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => !!jq(".z-label:contains(combobutton clicked)")[0],
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => !!jq(".z-label:contains(combobutton clicked)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_1_1)
		.ok("The value of message label should become combobutton clicked");
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("cbbtnOne", true))).$n("btn"),
		),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() => !!jq(".z-label:contains(combobutton popup opened)")[0],
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(
		() => !!jq(".z-label:contains(combobutton popup opened)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_1_1t)
		.ok(
			"The value of message label should become combobutton popup opened",
		);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("cbbtnOne", true))).$n("btn"),
		),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tt = await ClientFunction(
		() => !!jq(".z-label:contains(combobutton popup closed)")[0],
	)();
	let verifyVariable_cafe_1_1tt = await ClientFunction(
		() => !!jq(".z-label:contains(combobutton popup closed)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_1_1tt)
		.ok(
			"The value of message label should become combobutton popup closed",
		);
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("cbbtnTwo", true))).$n("real"),
		),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(
		() => !!jq(".z-label:contains(combobutton two clicked)")[0],
	)();
	let verifyVariable_cafe_1_1ttt = await ClientFunction(
		() => !!jq(".z-label:contains(combobutton two clicked)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_1_1ttt)
		.ok("The value of message label should become combobutton two clicked");
	await t.click(
		Selector(() =>
			zk.Widget.$(jq(zk.Desktop._dt.$f("cbbtnTwo", true))).$n("btn"),
		),
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttt = await ClientFunction(
		() => !!jq(".z-label:contains(combobutton two popup opened)")[0],
	)();
	let verifyVariable_cafe_1_1tttt = await ClientFunction(
		() => !!jq(".z-label:contains(combobutton two popup opened)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_1_1tttt)
		.ok(
			"The value of message label should become combobutton two popup opened",
		);
	await t.click(Selector(() => jq("body")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttt = await ClientFunction(
		() => !!jq(".z-label:contains(combobutton two popup closed)")[0],
	)();
	let verifyVariable_cafe_1_1ttttt = await ClientFunction(
		() => !!jq(".z-label:contains(combobutton two popup closed)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_1_1ttttt)
		.ok(
			"The value of message label should become combobutton two popup closed",
		);
});
