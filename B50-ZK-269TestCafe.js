import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-269TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-269TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<div>1. Opera only</div>
				<div>2. The width of each Listheader should be exactly 50% of the whole Listbox width.</div>
				<listbox id="lb" width="200px">
					<listhead>
						<listheader id="lh" label="header1"/>
						<listheader id="lh2" label="header2"/>
					</listhead>
				</listbox>
			</zk>`,
	);
	let lbw_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lb", true).$n()).width(),
	)();
	let lhw_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lh", true).$n()).outerWidth(),
	)();
	let lhw2_cafe = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("lh2", true).$n()).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(lhw_cafe),
		ztl.normalizeText(lhw2_cafe),
		ztl.normalizeText("1"),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(lhw_cafe + lhw2_cafe),
		ztl.normalizeText(lbw_cafe),
		ztl.normalizeText("1"),
	);
});
