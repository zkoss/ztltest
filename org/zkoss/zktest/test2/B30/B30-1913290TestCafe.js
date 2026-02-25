import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1913290TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1913290TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
        <label value="If you cannot see any error, that is correct!"/>
        <chart id="mychart" type="time_series" width="400" height="200" threeD="false" fgAlpha="128"/>
        <zscript><![CDATA[
        XYModel myModel = new SimpleXYModel();
        myModel.addValue(new Integer(1), new Integer(10000), new Integer(89));
        mychart.setModel(myModel);
    ]]></zscript>
      </zk>`,
	);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq(".z-chart")).$n("real")).is(":visible"),
			)(),
		)
		.ok();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
