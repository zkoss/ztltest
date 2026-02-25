import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2684510TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2684510TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				After clicking the test button, you shall see "&lt;Button b>:onClick:void" below
				<separator/>
				<label id="i"/>
				<zscript><![CDATA[
				public void test(){i.value = "<" + self.getClass().getSimpleName() + " " + self.id+">:"+event.getName()+":"+b;}
				]]></zscript>
				<window>
				<button id="b" label="test" onClick="test()"/>
				</window>
			</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("b", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					zk.Desktop._dt.$f("i", true).getValue(),
				)(),
			),
		)
		.eql(ztl.normalizeText("<Button b>:onClick:void"));
});
