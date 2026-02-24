import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1884TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1884TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page contentType="text/html;charset=UTF-8"?>
<zk xmlns:w="http://www.zkoss.org/2005/zk/client">
	<window border="normal" width="500px" height="200px">
		<vbox>
			click slider\'s rightmost position, its value should not be greater then 70
			<separator spacing="4px" />
			<hbox>
				<label id="lb" value="40" />/ 70
			</hbox>
			<separator spacing="4px" />
			<slider orient="horizontal" maxpos="70" curpos="40">
				<attribute w:name="onScroll"><![CDATA[
					var pos = this.getCurpos();
					this.$f("lb").setValue(pos);
				]]></attribute>
			</slider>
		</vbox>
	</window>
</zk>`,
	);
	await t.dragToElement(
		Selector(() => zk.Widget.$(jq(".z-slider-horizontal")).$n("btn")),
		Selector(() => zk.Widget.$(jq(".z-slider-horizontal")).$n("btn")),
		{
			offsetX: 2,
			offsetY: 2,
			destinationOffsetX: 220,
			destinationOffsetY: 2,
		},
	);
	await ztl.waitResponse(t);
	let value_cafe = parseInt(
		await ClientFunction(() =>
			jq(".z-hbox .z-label:eq(0)").text().replace(/\s/g, " "),
		)(),
	);
	await t
		.expect(value_cafe <= 70)
		.ok("its value should not be greater then 70");
});
