import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - Z30-grid-0016TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("Z30-grid-0016TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
			<vbox>
				Empty grid:
				<grid id="gd" mold="paging"/>
			             <hbox>
				<button id="btnAddRows" label="1. Click me to add rows only once" onClick="new Rows().setParent(gd)"/>
				<button id="btnAddRow" label="2. Click me to add row" onClick="addgd(1)"/>
			<zscript><![CDATA[
				void addgd(int cnt) {
					for (int j = 0; ++j <= cnt;) {
						Row r = new Row();
						String prefix = "Item " + (gd.getRows().getChildren().size() + 1);
						new Label(prefix + "-L").setParent(r);
						new Label(prefix + "-C").setParent(r);
						new Label(prefix + "-R").setParent(r);
						r.setParent(gd.getRows());
					}
				}
				]]>
			</zscript>
			             </hbox>
			</vbox>
			</window>`,
	);
	await t
		.expect(ztl.normalizeText("0"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	await t
		.expect(ztl.normalizeText("0"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@row").length)()),
		);
	await t.click(Selector(() => jq("$btnAddRows")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	await t
		.expect(ztl.normalizeText("0"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@row").length)()),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("1"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("2"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0t));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0tt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1tt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("3"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0tt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1ttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("4"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0ttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0tttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1tttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("5"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0tttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0ttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1ttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("6"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0ttttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0tttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1tttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("7"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0tttttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0ttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1ttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("8"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0ttttttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 8-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(7)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0tttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1tttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("9"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0tttttttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 8-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(7)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 9-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(8)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0ttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1ttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("10"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0ttttttttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 8-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(7)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 9-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(8)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 10-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(9)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0tttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1tttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("11"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0tttttttttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 8-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(7)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 9-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(8)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 10-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(9)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 11-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(10)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0ttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1ttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("12"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0ttttttttttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 8-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(7)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 9-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(8)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 10-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(9)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 11-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(10)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 12-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(11)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0tttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1tttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("13"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0tttttttttttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 8-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(7)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 9-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(8)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 10-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(9)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 11-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(10)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 12-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(11)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 13-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(12)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0ttttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1ttttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("14"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0ttttttttttttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 8-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(7)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 9-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(8)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 10-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(9)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 11-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(10)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 12-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(11)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 13-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(12)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 14-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(13)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0tttttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1tttttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("15"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0tttttttttttttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 8-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(7)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 9-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(8)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 10-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(9)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 11-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(10)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 12-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(11)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 13-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(12)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 14-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(13)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 15-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(14)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0ttttttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1ttttttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("16"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0ttttttttttttttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 8-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(7)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 9-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(8)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 10-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(9)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 11-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(10)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 12-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(11)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 13-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(12)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 14-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(13)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 15-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(14)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 16-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(15)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0tttttttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1tttttttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("17"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0tttttttttttttttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 8-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(7)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 9-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(8)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 10-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(9)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 11-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(10)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 12-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(11)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 13-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(12)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 14-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(13)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 15-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(14)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 16-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(15)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 17-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(16)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0ttttttttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1ttttttttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("18"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0ttttttttttttttttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 8-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(7)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 9-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(8)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 10-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(9)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 11-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(10)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 12-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(11)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 13-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(12)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 14-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(13)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 15-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(14)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 16-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(15)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 17-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(16)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 18-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(17)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0tttttttttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1tttttttttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("19"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0tttttttttttttttttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 8-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(7)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 9-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(8)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 10-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(9)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 11-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(10)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 12-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(11)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 13-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(12)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 14-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(13)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 15-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(14)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 16-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(15)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 17-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(16)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 18-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(17)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 19-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(18)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	let verifyVariable_cafe_0_0ttttttttttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	let verifyVariable_cafe_1_1ttttttttttttttttttt = await ClientFunction(
		() => jq("@row").length,
	)();
	await t
		.expect(ztl.normalizeText("20"))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_0ttttttttttttttttttt));
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 8-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(7)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 9-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(8)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 10-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(9)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 11-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(10)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 12-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(11)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 13-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(12)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 14-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(13)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 15-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(14)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 16-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(15)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 17-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(16)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 18-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(17)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 19-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(18)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 20-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(19)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	await t
		.expect(ztl.normalizeText("20"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@row").length)()),
		);
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 8-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(7)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 9-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(8)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 10-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(9)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 11-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(10)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 12-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(11)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 13-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(12)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 14-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(13)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 15-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(14)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 16-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(15)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 17-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(16)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 18-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(17)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 19-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(18)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 20-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(19)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq("$btnAddRow")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	await t
		.expect(ztl.normalizeText("20"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@row").length)()),
		);
	await t
		.expect(ztl.normalizeText("Item 1-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(2)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(3)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 5-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(4)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(5)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(6)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 8-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(7)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 9-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(8)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 10-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(9)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 11-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(10)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 12-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(11)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 13-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(12)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 14-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(13)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 15-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(14)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 16-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(15)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 17-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(16)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 18-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(17)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 19-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(18)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 20-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(19)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t.click(Selector(() => jq(".z-paging-next")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@rows").length)()),
		);
	await t
		.expect(ztl.normalizeText("2"))
		.eql(
			ztl.normalizeText(await ClientFunction(() => jq("@row").length)()),
		);
	await t
		.expect(ztl.normalizeText("Item 21-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(0)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 22-L"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@row")
						.eq(1)
						.find(".z-label:first")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		);
});
