import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1914184TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1914184TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
			<zk>
				<grid>
					<columns id="cs">
						<column id="gcola" width="100px" label="A" />
						<column label="B" />
						<column label="C" />
						<column label="D" />
						<column label="E" />
						<column label="F" />
						<column label="G" />
					</columns>
					<auxhead>
						<auxheader id="gPhi" label="Phi" rowspan="2" colspan="2"/>
						<auxheader id="gPi" label="Pi" colspan="2" />
						<auxheader id="gKroc" label="Kroc" colspan="3"/>
					</auxhead>
					<auxhead>
						<auxheader label="Pi" colspan="2" />
						<auxheader label="Kroc" colspan="3"/>
					</auxhead>
					<auxhead>
						<auxheader label="Phi" rowspan="2" colspan="2"/>
						<auxheader label="Pi" colspan="2" />
						<auxheader label="Kroc" colspan="3"/>
					</auxhead>
				</grid>
			</zk>`,
	);
	await t.wait(1000);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
