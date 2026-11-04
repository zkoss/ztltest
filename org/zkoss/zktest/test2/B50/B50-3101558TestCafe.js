import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3101558TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3101558TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
 you shall see 5 "35px" widget in the screen ;
 <div id="div">
  <combobox width="35px" />
  <bandbox width="35px" />
  <datebox width="35px" />
  <timebox width="35px" />
  <spinner width="35px" />
 </div>
</zk>`,
	);
	const div = Selector(() => zk.Desktop._dt.$f("div", true).$n());
	for (let i = 0; i < 5; i++) {
		await t
			.expect(div.child(i).offsetWidth)
			.eql(35, `widget ${i + 1} should be as wide as its width`);
	}
});
