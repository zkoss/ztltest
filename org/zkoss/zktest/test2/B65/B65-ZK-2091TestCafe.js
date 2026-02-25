import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-2091TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-2091TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
  	<label multiline="true">
  		1. Copy the following number to the doublebox: 100000000000000000000
  		2. Unfocus the doublebox.
  		3. Should see any js error.
  	</label>
    <doublebox width="200px">
      <attribute name="onChange"><![CDATA[
      self.getValue();
      ]]></attribute>
    </doublebox>
</zk>`,
	);
	if (
		await ClientFunction(
			() => jq(jq(".z-doublebox"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-doublebox")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
});
