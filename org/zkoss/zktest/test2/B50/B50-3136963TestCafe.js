import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3136963TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3136963TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				Please press the click button and the invalidate button, and each time it should only appear one message below.
				<include id="include" />
				<button id="btn1" label="click" onClick=\'include.src="/test2/B50-3136963_2.zul"\' autodisable="+self"/>
				<button id="btn2" label="invalidate" onClick=\'include.invalidate()\'/>
			</zk>`,
	);
	let len_cafe = await ClientFunction(() => jq(".z-label").length)();
	await t.click(Selector(() => zk.Desktop._dt.$f("btn1", true).$n()));
	await ztl.waitResponse(t);
	let len2_cafe = await ClientFunction(() => jq(".z-label").length)();
	await t
		.expect(len2_cafe - len_cafe == 1)
		.ok("each time it should only appear one message below.");
	len_cafe = len2_cafe;
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	len2_cafe = await ClientFunction(() => jq(".z-label").length)();
	await t
		.expect(len2_cafe - len_cafe == 1)
		.ok("each time it should only appear one message below.");
	len_cafe = len2_cafe;
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	len2_cafe = await ClientFunction(() => jq(".z-label").length)();
	await t
		.expect(len2_cafe - len_cafe == 1)
		.ok("each time it should only appear one message below.");
	len_cafe = len2_cafe;
	await t.click(Selector(() => zk.Desktop._dt.$f("btn2", true).$n()));
	await ztl.waitResponse(t);
	len2_cafe = await ClientFunction(() => jq(".z-label").length)();
	await t
		.expect(len2_cafe - len_cafe == 1)
		.ok("each time it should only appear one message below.");
});
