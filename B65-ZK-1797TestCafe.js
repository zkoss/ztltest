import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1797TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1797TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<div id="mainDiv">
		<listbox>
			<attribute name="onSelect"><![CDATA[
			 	mainDiv.getChildren().clear();
			 	mainDiv.getTemplate("tmp").create(mainDiv, null, null, null);
				mainDiv.invalidate();
			]]></attribute>
			<listitem label="click me should not see any JS error"/>
		</listbox>
		<template name="tmp">
			<window >
				<popup>
					<button label="PopUpbutton"></button>
				</popup>
			</window>
		</template>
	</div>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-div")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
});
