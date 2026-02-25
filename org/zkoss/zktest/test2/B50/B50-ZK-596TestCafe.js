import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-596TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-596TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
		<div height="25px">1. Click the buttons below from left to right. </div>
		<div height="25px">2. The header of tabbox should shrink or expand while</div>
		<hbox><div height="25px" width="20px"></div><div height="25px"> the toolbar expand or shrink.</div></hbox>
			<tabbox id="tb" width="1000px">
				<tabs id="tbs">
					<tab label="Tab 1" closable="true" />
					<tab label="Tab 2" closable="true"/>
					<tab label="Tab 3" closable="true" />
					<tab label="Tab 4" closable="true"/>
					<tab label="Tab 5" closable="true"/>
				</tabs>
				<toolbar id="tbar">
					<toolbarbutton id="img1" image="/img/live.gif" />
					<toolbarbutton id="img2" image="/img/defender.gif" />
					<toolbarbutton id="img3" image="/img/battery.gif" />
					<toolbarbutton id="img4" image="/img/live.gif" />
					<toolbarbutton id="img5" image="/img/defender.gif" />
					<toolbarbutton id="img9" image="/img/defender.gif" />
					<toolbarbutton id="img10" image="/img/battery.gif" />
					<toolbarbutton id="img11" image="/img/live.gif" />
					<toolbarbutton id="img12" image="/img/defender.gif" />
				</toolbar>
				<tabpanels>
					<tabpanel>This is panel 1</tabpanel>
					<tabpanel>This is panel 2	The second panel</tabpanel>
					<tabpanel>This is panel 3</tabpanel>
					<tabpanel>This is panel 4</tabpanel>
					<tabpanel>This is panel 5</tabpanel>
				</tabpanels>
			</tabbox>
			<button id="btn1" label="hide button">
				<attribute name="onClick">
					img1.setVisible(false);
					img2.setVisible(false);
				</attribute>
			</button>
			<button id="btn2" label="show button">
				<attribute name="onClick">
					img1.setVisible(true);
					img2.setVisible(true);
				</attribute>
			</button>
			<button id="btn3" label="add button">
				<attribute name="onClick">
					Toolbarbutton tb = new Toolbarbutton();
					tb.setId("img6");
					tb.setImage("/img/battery.gif");
					tb.setParent(tbar);
			
					tb = new Toolbarbutton();
					tb.setId("img7");
					tb.setImage("/img/live.gif");
					tb.setParent(tbar);
			
					tb = new Toolbarbutton();
					tb.setId("img8");
					tb.setImage("/img/defender.gif");
					tb.setParent(tbar);
				</attribute>
			</button>
			<button id="btn4" label="remove button">
				<attribute name="onClick">
					img6.setParent(null);
					img7.setParent(null);
					img8.setParent(null);
				</attribute>
			</button>
			<button id="btn5" label="shrink toolbar width">
				<attribute name="onClick">
					tbar.setWidth("200px");
				</attribute>
			</button>
			<button id="btn6" label="enlarge toolbar width">
				<attribute name="onClick">
					tbar.setWidth("400px");
				</attribute>
			</button>
		</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn3", true).$n()));
	await ztl.waitResponse(t);
	await t
		.wait(2000)
		.click(Selector(() => zk.Desktop._dt.$f("btn4", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbs", true).$n()).outerWidth(true),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tb", true).$n()).outerWidth(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbar", true).$n()).outerWidth(true),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0 + verifyVariable_cafe_2_2 <=
				verifyVariable_cafe_1_1,
		)
		.ok(
			"the sum of tabs header width and toobar width should smaller or equal to tabs width",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0t = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbs", true).$n()).outerWidth(true),
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tb", true).$n()).outerWidth(),
	)();
	let verifyVariable_cafe_2_2t = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbar", true).$n()).outerWidth(true),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0t + verifyVariable_cafe_2_2t <=
				verifyVariable_cafe_1_1t,
		)
		.ok(
			"the sum of tabs header width and toobar width should smaller or equal to tabs width",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn3", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbs", true).$n()).outerWidth(true),
	)();
	let verifyVariable_cafe_1_1tt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tb", true).$n()).outerWidth(),
	)();
	let verifyVariable_cafe_2_2tt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbar", true).$n()).outerWidth(true),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0tt + verifyVariable_cafe_2_2tt <=
				verifyVariable_cafe_1_1tt,
		)
		.ok(
			"the sum of tabs header width and toobar width should smaller or equal to tabs width",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn4", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbs", true).$n()).outerWidth(true),
	)();
	let verifyVariable_cafe_1_1ttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tb", true).$n()).outerWidth(),
	)();
	let verifyVariable_cafe_2_2ttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbar", true).$n()).outerWidth(true),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0ttt + verifyVariable_cafe_2_2ttt <=
				verifyVariable_cafe_1_1ttt,
		)
		.ok(
			"the sum of tabs header width and toobar width should smaller or equal to tabs width",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn5", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbs", true).$n()).outerWidth(true),
	)();
	let verifyVariable_cafe_1_1tttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tb", true).$n()).outerWidth(),
	)();
	let verifyVariable_cafe_2_2tttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbar", true).$n()).outerWidth(true),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0tttt + verifyVariable_cafe_2_2tttt <=
				verifyVariable_cafe_1_1tttt,
		)
		.ok(
			"the sum of tabs header width and toobar width should smaller or equal to tabs width",
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn6", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbs", true).$n()).outerWidth(true),
	)();
	let verifyVariable_cafe_1_1ttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tb", true).$n()).outerWidth(),
	)();
	let verifyVariable_cafe_2_2ttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("tbar", true).$n()).outerWidth(true),
	)();
	await t
		.expect(
			verifyVariable_cafe_0_0ttttt + verifyVariable_cafe_2_2ttttt <=
				verifyVariable_cafe_1_1ttttt,
		)
		.ok(
			"the sum of tabs header width and toobar width should smaller or equal to tabs width",
		);
});
