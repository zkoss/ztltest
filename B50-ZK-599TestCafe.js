import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-ZK-599TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-ZK-599TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
			<div height="25px">Both grid below should has vertical scrollbar.</div>
				<zscript><![CDATA[
				Object[] o = new Object[50];
				]]></zscript>
				<window border="normal" title="" height="500px">
					<grid id="grid1" height="40%">
						<columns>
							<column label="Grid with height=40% no scroll bar" sort="auto(name)" />
						</columns>
						<rows>
							<row forEach="\${o}">item \${forEachStatus.index}</row>
						</rows>
					</grid>
					<space spacing="15px"/>
					<grid id="grid2" height="200px">
						<columns>
							<column label="Grid with height=200px has scroll bar" sort="auto(name)" />
						</columns>
						<rows>
							<row forEach="\${o}">item \${forEachStatus.index}</row>
						</rows>
					</grid>
				</window>
			</zk>`,
	);
	let verifyVariable_cafe_0_0 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("grid1", true).$n("body").clientHeight,
		)(),
	);
	let verifyVariable_cafe_1_1 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("grid1", true).$n("body").scrollHeight,
		)(),
	);
	await t
		.expect(verifyVariable_cafe_1_1 >= verifyVariable_cafe_0_0)
		.ok("grid 1 should have vertical scrollbar");
	let verifyVariable_cafe_2_2 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("grid2", true).$n("body").scrollHeight,
		)(),
	);
	let verifyVariable_cafe_3_3 = parseInt(
		await ClientFunction(
			() => zk.Desktop._dt.$f("grid2", true).$n("body").clientHeight,
		)(),
	);
	await t
		.expect(verifyVariable_cafe_2_2 >= verifyVariable_cafe_3_3)
		.ok("grid 1 should have vertical scrollbar");
});
