import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1847TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1847TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:w="client">
	<vlayout>
		click the buttons, it should work as expected (and return the expected data). 
		<div>
			1. 
			<button label="fire event" w:onClick="zAu.send(new zk.Event(this.$f(\'message1\'), \'onFoo\', null, {toServer:true}));"/>
			zAu.send(new zk.Event(this.$f(\'message1\'), \'onFoo\', null, {toServer:true}));
		</div>
		Expected Result: null
		<hlayout>
			Actual Result: <label id="message1" onFoo=\'self.value = "" + event.data\' />
		</hlayout>
	</vlayout>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-hlayout .z-label").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("null"), "it should work as expected");
});
