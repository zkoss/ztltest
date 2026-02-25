import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2935509TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2935509TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Test" width="610px">
			Click the button and the headers shall change (from 1 to 11, 2 to 22, and 3 to 33)
			<button id="btn" label="new columns">
			<attribute name="onClick">
			gg.getColumns().detach();
			Columns c = new Columns();
			c.appendChild(new Column("11",null,"100px"));
			c.appendChild(new Column("22",null,"150px"));
			c.appendChild(new Column("33"));
			gg.appendChild(c);
			</attribute>
			</button>
			<grid id="gg" width="600px">
			<columns>
			<column label="1" width="100px"/>
			<column label="2" width="150px"/>
			<column label="3"/>
			</columns>
			<rows>
			<row>
			<label value="foo1"/>
			<label value="foo2"/>
			<label value="foo3"/>
			</row>
			</rows>
			</grid>
			</window>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("gg", true).$n("head"))
						.find(".z-columns")
						.find(".z-column")
						.eq(0)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("11"), "header 1 should contains 11");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("gg", true).$n("head"))
						.find(".z-columns")
						.find(".z-column")
						.eq(1)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("22"), "header 2 should contains 22");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("gg", true).$n("head"))
						.find(".z-columns")
						.find(".z-column")
						.eq(2)
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("33"), "header 3 should contains 33");
});
