import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3196813TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3196813TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
You shouldn\'t see any Javascript error after the page is ready.
<separator/>
<zscript><![CDATA[
Constraint YearCons = new Constraint() {
public void validate(Component comp, Object value)throws WrongValueException {
}
};
]]></zscript>
<spinner constraint="\${YearCons}"/>
<doublespinner constraint="\${YearCons}"/>
</zk>`,
	);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
