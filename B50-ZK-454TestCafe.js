import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-454TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-454TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				Please click the following buttons by 1, 2, and 3.
				<separator/>
				Then you shouldn\'t see any JS error.
				<tabbox id="tab">
					<tabs id="tabs"/>
					<tabpanels id="tps" />
				</tabbox>
				<grid id="grid" />
				<button id="btn1" label="1">
					<attribute name="onClick">
					tabs.appendChild(new Tab("x"));
					tabs.appendChild(new Tab("y"));
					Tabpanel tp = new Tabpanel();
					tp.appendChild(new Label("x"));
					Tabpanel tp1 = new Tabpanel();
					tp1.appendChild(new Label("xx"));
					tps.appendChild(tp);
					tps.appendChild(tp1);
					</attribute>
				</button>
				
				<button id="btn2" label="2">
					<attribute name="onClick">
					tabs.getChildren().clear();
					tps.getChildren().clear();
					tabs.appendChild(new Tab("x"));
					tabs.appendChild(new Tab("y"));
					Tabpanel tp = new Tabpanel();
					tp.appendChild(new Label("x"));
					Tabpanel tp1 = new Tabpanel();
					tp1.appendChild(new Label("xx"));
					tps.appendChild(tp);
					tps.appendChild(tp1);
					//tab.invalidate(); //workaround
					</attribute>
				</button>
				<button id="btn3" label="3">
					<attribute name="onClick">
					Columns cls = new Columns();
					Column c1 = new Column("x");
					Column c2 = new Column("x");
					Column c3 = new Column("x");
					Column c4 = new Column("x");
					cls.setParent(grid);
					c1.setParent(cls);
					c2.setParent(cls);
					c3.setParent(cls);
					c4.setParent(cls);
					</attribute>
				</button>
				
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn3", true).$n()));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
