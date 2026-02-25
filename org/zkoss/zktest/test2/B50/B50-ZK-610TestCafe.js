import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-ZK-610TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-610TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<zscript>
					import org.zkoss.zktest.util.Person;
					Person[] ps = new Person[] {
						new Person("A1", "B1"), new Person("A2", "B2"), new Person(null, null)
					};
					ListModelList model = new ListModelList(ps);
					RowRenderer ren = new RowRenderer() {
						public void render(Row row, Object value, int index) {
							String fn = ((Person) value).getFirstName();
							row.appendChild(new Label(fn == null ? "(null)" : fn)); 
						}
					};
				</zscript>
				<div>
					Click on the Column to sort several times. If (null) always stay at the first row, it is a bug.
				</div>
				<grid id="grid" model="\${model}" rowRenderer="\${ren}">
					<columns id="columns">
						<column sort=\'auto(firstName)\'>Column</column>
					</columns>
				</grid>
			</zk>`,
	);
	await t.click(
		Selector(() => zk.Desktop._dt.$f("columns", true).$n()),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	let offset_cafe = await ClientFunction(
		() =>
			jq(
				jq(zk.Desktop._dt.$f("grid", true).$n()).find(
					".z-row:contains((null))",
				)[0],
			).position().top,
	)();
	await t.click(
		Selector(() => zk.Desktop._dt.$f("columns", true).firstChild.$n()),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() =>
			jq(
				jq(zk.Desktop._dt.$f("grid", true).$n()).find(
					".z-row:contains((null))",
				)[0],
			).position().top,
	)();
	await t
		.expect(offset_cafe != verifyVariable_cafe_0_0)
		.ok("the position should changed after sort");
	offset_cafe = await ClientFunction(
		() =>
			jq(
				jq(zk.Desktop._dt.$f("grid", true).$n()).find(
					".z-row:contains((null))",
				)[0],
			).position().top,
	)();
	await t.click(
		Selector(() => zk.Desktop._dt.$f("columns", true).firstChild.$n()),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() =>
			jq(
				jq(zk.Desktop._dt.$f("grid", true).$n()).find(
					".z-row:contains((null))",
				)[0],
			).position().top,
	)();
	await t
		.expect(offset_cafe != verifyVariable_cafe_0_0t)
		.ok("the position should changed after sort");
	offset_cafe = await ClientFunction(
		() =>
			jq(
				jq(zk.Desktop._dt.$f("grid", true).$n()).find(
					".z-row:contains((null))",
				)[0],
			).position().top,
	)();
	await t.click(
		Selector(() => zk.Desktop._dt.$f("columns", true).firstChild.$n()),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tt = await ClientFunction(
		() =>
			jq(
				jq(zk.Desktop._dt.$f("grid", true).$n()).find(
					".z-row:contains((null))",
				)[0],
			).position().top,
	)();
	await t
		.expect(offset_cafe != verifyVariable_cafe_0_0tt)
		.ok("the position should changed after sort");
	offset_cafe = await ClientFunction(
		() =>
			jq(
				jq(zk.Desktop._dt.$f("grid", true).$n()).find(
					".z-row:contains((null))",
				)[0],
			).position().top,
	)();
	await t.click(
		Selector(() => zk.Desktop._dt.$f("columns", true).firstChild.$n()),
		{ offsetX: 5, offsetY: 5 },
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(
		() =>
			jq(
				jq(zk.Desktop._dt.$f("grid", true).$n()).find(
					".z-row:contains((null))",
				)[0],
			).position().top,
	)();
	await t
		.expect(offset_cafe != verifyVariable_cafe_0_0ttt)
		.ok("the position should changed after sort");
	offset_cafe = await ClientFunction(
		() =>
			jq(
				jq(zk.Desktop._dt.$f("grid", true).$n()).find(
					".z-row:contains((null))",
				)[0],
			).position().top,
	)();
});
