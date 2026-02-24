import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1799602TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1799602TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
If the popup of combox out of position, that is wrong.
	<tabbox width="100%">
		<tabs>
			<tab label="Geral" />
		</tabs>
		<tabpanels>
			<tabpanel height="240px">
				<grid>
					<rows>
						<row>
							<combobox id="cb" width="150px" readonly="true">
								<comboitem label="Pessoa Física" />
								<comboitem label="Pessoa Jurídica" />
							</combobox>
						</row>
					</rows>
				</grid>
			</tabpanel>
		</tabpanels>
	</tabbox>
</window>`,
	);
	let offset1x_cafe = await ClientFunction(
		() => zk(zk.Desktop._dt.$f("cb", true)).revisedOffset()[0],
	)();
	let offset1y_cafe = await ClientFunction(
		() => zk(zk.Desktop._dt.$f("cb", true)).revisedOffset()[1],
	)();
	await t.click(Selector(() => zk.Desktop._dt.$f("cb", true).$n("btn")));
	let offset2x_cafe = await ClientFunction(
		() => zk(zk.Desktop._dt.$f("cb", true).$n("pp")).revisedOffset()[0],
	)();
	let offset2y_cafe = await ClientFunction(
		() => zk(zk.Desktop._dt.$f("cb", true).$n("pp")).revisedOffset()[1],
	)();
	await t
		.expect(ztl.normalizeText(offset2x_cafe))
		.eql(ztl.normalizeText(offset1x_cafe));
	let verifyVariable_cafe_0_0 = parseInt(
		await ClientFunction(
			() => zk(zk.Desktop._dt.$f("cb", true)).revisedOffset()[1],
		)(),
	);
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("cb", true)).outerHeight(),
	)();
	let verifyVariable_cafe_2_2 = parseInt(
		await ClientFunction(
			() => zk(zk.Desktop._dt.$f("cb", true)).revisedOffset()[1],
		)(),
	);
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(zk.Desktop._dt.$f("cb", true)).outerHeight(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(parseInt(offset1y_cafe) + verifyVariable_cafe_1_1),
		ztl.normalizeText(offset2y_cafe),
		ztl.normalizeText("2"),
	);
});
