import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1823236TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1823236TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<html><![CDATA[
1. Watch the listbox headers, there should be two headers (header1, header2) there.<br/>
2. Press add item button, you should see first0 and last0 as the first Listitem. But the header2 appear and gone immediately. (IE show horizontal and vertical scrollbar).<br/>
3. Press invalidate will correct the case.<br/>
NOTE: The mentioned bug occurs only if you add item via ListModel and ListDataEvent. If you add Listitem and listcells directly, it works ok.<br/>
]]></html>
<zscript>
    int count = 0;
	List lst = new ArrayList(10);
	ListModel lm = new ListModelList(lst);
	
	class Person {
		String fn;
		String ln;
		public Person(String f, String l) {
			fn = f;
			ln = l;
		}
		public getFn() {
			return fn;
		}
		public getLn() {
			return ln;
		}
	}
	
	public class Rend implements ListitemRenderer {
		public void render(Listitem item, java.lang.Object data, int index)  {
			new Listcell(data.getFn()).setParent(item);
			new Listcell(data.getLn()).setParent(item);
		}
	}
	
	ListitemRenderer rend = new Rend();
</zscript>
<listbox id="lb" width="200px" model="\${lm}" itemRenderer="\${rend}">
	<listhead>
		<listheader id="h1" label="header1"/>
		<listheader id="h2" label="header2"/>
	</listhead>
</listbox>
<button id="btn" label="add item">
	<attribute name="onClick">
	((List)lb.getModel()).add(new Person("first"+count, "last"+count));
	++count;
	</attribute>
</button>
<button label="invalidate" onClick="lb.invalidate()"/>
</zk>`,
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("h1", true)).is(":visible"),
			)(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Desktop._dt.$f("h2", true)).is(":visible"),
			)(),
		)
		.ok();
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("h1", true)).height(),
	)();
	await t.expect(verifyVariable_cafe_0_0 > 10).ok();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("h1", true)).width(),
	)();
	await t.expect(verifyVariable_cafe_1_1 > 30).ok();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("h2", true)).height(),
	)();
	await t.expect(verifyVariable_cafe_2_2 > 10).ok();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("h2", true)).width(),
	)();
	await t.expect(verifyVariable_cafe_3_3 > 30).ok();
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("lb", true).$n("head")).outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("lb", true)).width(),
				)(),
			),
		);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_4_4 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lb", true).$n("body")).outerHeight(),
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lb", true).$n("head")).outerHeight(),
	)();
	let verifyVariable_cafe_6_6 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lb", true)).height(),
	)();
	let verifyVariable_cafe_7_7 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lb", true).$n("body")).outerHeight(),
	)();
	let verifyVariable_cafe_8_8 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lb", true).$n("head")).outerHeight(),
	)();
	let verifyVariable_cafe_9_9 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lb", true)).height(),
	)();
	await t
		.expect(
			ztl.normalizeText(
				verifyVariable_cafe_8_8 + verifyVariable_cafe_7_7,
			),
		)
		.eql(ztl.normalizeText(verifyVariable_cafe_6_6));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("lb", true).$n("body")).height(),
				)(),
			),
		)
		.notEql(ztl.normalizeText("0"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("lb", true).$n("cave")).outerHeight(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("lb", true).$n("body")).outerHeight(),
				)(),
			),
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("lb", true).$n("cave")).outerWidth(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("lb", true).$n("body")).outerWidth(),
				)(),
			),
		);
});
