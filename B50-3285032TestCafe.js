import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3285032TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3285032TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
		<ol>
			<li>Press the button, if an error is shown, it is a bug.</li>
		</ol>
	]]></html>
	<grid>
		<frozen id="f" columns="3" />
		<columns>
			<column label="1" />
			<column label="2" />
			<column label="3" />
			<column label="4" />
			<column label="5" />
		</columns>
		<rows>
			<row>
				<div>1</div>
				<div>2</div>
				<div>3</div>
				<div>4</div>
				<div>5</div>
			</row>
		</rows>
	</grid>
	<button label="Go" onClick=\'lb.value = "" + f.start\' />
	<label id="lb" />
</zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq("@window")[0])()).notOk();
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
});
