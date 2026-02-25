import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-987TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-987TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
                    <div>
                      The two Groupboxes should look identical (the one on the right should have no top border on cave DIV).
                    </div>
                    <hlayout>
                      <groupbox mold="3d" height="200px" width="200px">
                        <caption label="Groupbox"/>
                        Groupbox
                      </groupbox>
                      <groupbox mold="3d" title="Groupbox" height="200px" width="200px">
                        Groupbox
                      </groupbox>
                    </hlayout>
                  </zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(
						zk.Widget.$(jq(".z-groupbox:eq(1)")).$n("header"),
					).height(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(
						zk.Widget.$(jq(".z-groupbox:eq(0)")).$n("header"),
					).height(),
				)(),
			),
			"The two Groupboxes should look identical (the one on the right should have no top border on cave DIV).",
		);
});
