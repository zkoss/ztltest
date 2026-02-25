import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-2197450TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-2197450TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<zscript>
			void dump(Label i) {
				String value = "";
				for (Component r = page.firstRoot; r != null; r = r.nextSibling)
					value += "" + r.id +",";
				i.value = value;
			}
			</zscript>
			
			<window id="win1" title="win1" border="normal" width="200px">Click
				<button id="btn" label="test" onClick="dump(i1)"/>
				and you shall see "win1,win2,win3,"
				<separator/>
				<label id="i1"/>
				<separator/>
				Then, click <button id="btn1" label="test2" onClick="win2.detach();dump(i2)"/>
				and you shall see "win1,win3,"
				<separator/>
				<label id="i2"/>
			</window>
			<window id="win2" title="win2" width="200px">Hello, 2nd World!</window>
			<window id="win3" title="win3" border="normal" width="200px">Hello, 3rd World!
			</window>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("div.z-window-embedded").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("i1", true).$n())
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("win1,win2,win3,"));
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Desktop._dt.$f("i2", true).$n())
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("win1,win3,"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("div.z-window-embedded").length,
				)(),
			),
		)
		.eql(ztl.normalizeText("2"));
});
