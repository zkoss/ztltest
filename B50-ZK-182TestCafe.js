import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-182TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-182TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<separator/>
				1.click "add frozen"
				<separator/>
				2.click "delete frozen"
				<separator/>
				drag the horizontal scrollbar, see if the column header scroll as the content
				<separator/>
    			If not, it\'s bug
				
				<separator/>
				<button id="btn1" label="add Frozen ">
						<attribute name="onClick"><![CDATA[
						Frozen fz = new Frozen();
						fz.setColumns(1);
						grid.appendChild(fz);
					]]></attribute>
				</button>
				<button id="btn2" label="delete Frozen ">
					<attribute name="onClick"><![CDATA[
						grid.getFrozen().detach();
					]]></attribute>
				</button>
				<grid id="grid" width="250px">
					<columns>
						<column label="column \${each}" forEach="1,2,3,4,5"
							width="100px" />
					</columns>
					<rows>
						<row forEach="1,2,3,4,5">
							<label value="item \${each}" forEach="1,2,3,4,5" />
						</row>
					</rows>
				</grid>
			</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => zk.Desktop._dt.$f("grid", true).$n()),
		scrollType: "horizontal",
		percent: "0.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("grid", true).$n("head")).scrollLeft(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("grid", true).$n("body")).scrollLeft(),
	)();
	await t.expect(verifyVariable_cafe_1_1 == verifyVariable_cafe_0_0).ok();
	await ztl.doScroll({
		locator: Selector(() => zk.Desktop._dt.$f("grid", true).$n()),
		scrollType: "horizontal",
		percent: "0.15",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0t = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("grid", true).$n("head")).scrollLeft(),
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("grid", true).$n("body")).scrollLeft(),
	)();
	await t.expect(verifyVariable_cafe_1_1t == verifyVariable_cafe_0_0t).ok();
	await ztl.doScroll({
		locator: Selector(() => zk.Desktop._dt.$f("grid", true).$n()),
		scrollType: "horizontal",
		percent: "0.3",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("grid", true).$n("head")).scrollLeft(),
	)();
	let verifyVariable_cafe_1_1tt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("grid", true).$n("body")).scrollLeft(),
	)();
	await t.expect(verifyVariable_cafe_1_1tt == verifyVariable_cafe_0_0tt).ok();
	await ztl.doScroll({
		locator: Selector(() => zk.Desktop._dt.$f("grid", true).$n()),
		scrollType: "horizontal",
		percent: "0.44999999999999996",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("grid", true).$n("head")).scrollLeft(),
	)();
	let verifyVariable_cafe_1_1ttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("grid", true).$n("body")).scrollLeft(),
	)();
	await t
		.expect(verifyVariable_cafe_1_1ttt == verifyVariable_cafe_0_0ttt)
		.ok();
	await ztl.doScroll({
		locator: Selector(() => zk.Desktop._dt.$f("grid", true).$n()),
		scrollType: "horizontal",
		percent: "0.6",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("grid", true).$n("head")).scrollLeft(),
	)();
	let verifyVariable_cafe_1_1tttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("grid", true).$n("body")).scrollLeft(),
	)();
	await t
		.expect(verifyVariable_cafe_1_1tttt == verifyVariable_cafe_0_0tttt)
		.ok();
	await ztl.doScroll({
		locator: Selector(() => zk.Desktop._dt.$f("grid", true).$n()),
		scrollType: "horizontal",
		percent: "0.75",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("grid", true).$n("head")).scrollLeft(),
	)();
	let verifyVariable_cafe_1_1ttttt = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("grid", true).$n("body")).scrollLeft(),
	)();
	await t
		.expect(verifyVariable_cafe_1_1ttttt == verifyVariable_cafe_0_0ttttt)
		.ok();
});
