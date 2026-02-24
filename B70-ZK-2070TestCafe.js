import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2070TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2070TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="Grid onScroll" contentType="text/html;charset=UTF-8"?>
<zk>
	<window title="Grid onScroll" border="normal">
		<zscript>Object[] o = new Object[50];</zscript>
		<label>
			scroll down "Grid1", then "Grid2" scroll position should synchronized.
		</label>
		<hlayout>
			<grid id="grid1" width="100px" height="150px">
				<columns>
					<column label="Grid1" />
				</columns>
				<rows>
					<row forEach="\${o}">
						<label value="item \${forEachStatus.index}"/>
					</row>
				</rows>
			</grid>
			<grid id="grid2" width="100px" height="150px">
				<columns>
					<column label="Grid2" />
				</columns>
				<rows>
					<row forEach="\${o}">
						<label value="item \${forEachStatus.index}"/>
					</row>
				</rows>
			</grid>
		</hlayout>
		<zscript><![CDATA[
			grid1.setWidgetListener("onScroll", "this.$f(\'grid2\').ebody.scrollTop = this.ebody.scrollTop;");
		]]></zscript>
	</window>
</zk>`,
	);
	await ztl.doScroll({
		locator: Selector(() => zk.Widget.$(jq(".z-grid").eq(0)).$n()),
		scrollType: "vertical",
		percent: "1.0",
	});
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => !!jq(".z-grid").eq(0).find(".z-row:contains(49)")[0],
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => !!jq(".z-grid").eq(1).find(".z-row:contains(49)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0 && verifyVariable_cafe_1_1)
		.ok("then Grid2 scroll position should synchronized.");
});
