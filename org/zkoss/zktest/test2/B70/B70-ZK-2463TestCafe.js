import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2463TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2463TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
	1. click button \'add new Col\'
	2. you should scroll right and will see new column (without javascript error)
	</label>

	<window apply="org.zkoss.bind.BindComposer"
		title="frozen grid and dynamic columns adding"
		viewModel="@id(\'vm\') @init(\'org.zkoss.zktest.test2.B70_ZK_2463_GridViewModel\')" width="1024px"
		height="576px">
		<vlayout vflex="1">
			<grid model="@load(vm.rows)" vflex="1">
				<frozen columns="1" />
				<auxhead children="@load(vm.heads)">
					<template name="children" var="h">
						<auxheader label="\${h.title}"
							colspan="\${h.colspan}" align="center" />
					</template>
				</auxhead>
				<columns children="@load(vm.columns)">
					<template name="children" var="c">
						<column label="\${c.title}" width="192px"
							align="center" />
					</template>
				</columns>
				<template name="model" var="r">
					<row children="@load(r.values)">
						<template name="children" var="v">
							<label value="\${v}" />
						</template>
					</row>
				</template>
			</grid>
			<hbox hflex="1">
				<cell hflex="1" align="right">
					<button label="add new Col"
						onClick="@command(\'doAdd\')" />
				</cell>
			</hbox>
		</vlayout>
	</window>
</zk>`,
	);
	let startL_cafe = await ClientFunction(
		() => jq(zk.Widget.$(jq(".z-frozen")).$n("scrollX")).position().left,
	)();
	let startT_cafe = await ClientFunction(
		() => jq(zk.Widget.$(jq(".z-frozen")).$n("scrollX")).position().top,
	)();
	let endL_cafe = startL_cafe + 500;
	await t.click(Selector(() => jq(".z-button:contains(add)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-column-content:contains(col 9)").length,
	)();
	await t.expect(verifyVariable_cafe_0_0 > 0).ok();
});
