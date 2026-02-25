import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3037626TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3037626TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<hbox width="100%" height="100%">
	<cell id="cell1">
		<grid id="grid">
			<rows>
				<row>row</row>
			</rows>
		</grid>
	</cell>
	<splitter />
	<cell>
		<grid>
			<rows>
				<row>row</row>
			</rows>
		</grid>
	</cell>
</hbox>`,
	);
	let i_cafe = await ClientFunction(() => jq("$cell1").width())();
	await t.drag(
		Selector(() => jq("@splitter")[0]),
		-250,
		0,
		{ offsetX: 0, offsetY: 138 },
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("$cell1").width(),
	)();
	await t.expect(i_cafe - 250 - verifyVariable_cafe_0_0 < 8).ok();
});
