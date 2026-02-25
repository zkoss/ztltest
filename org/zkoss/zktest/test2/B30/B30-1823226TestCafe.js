import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1823226TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B30-1823226TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
Splitter can be dragged over hbox border.
<window border="normal" width="800px" title="Case 1: hbox and splitter">
		<hbox height="100px" width="100%">
		cdacdacdacdacdaca
		<splitter id="hsplitter" collapse="none"/>
		cdacdacdacdacacsdc
		</hbox>
	</window></zk>`,
	);
	let width_cafe = await ClientFunction(() =>
		jq("@box @label").parent().width(),
	)();
	await t.drag(
		Selector(() => zk.Desktop._dt.$f("hsplitter", true).$n()),
		-20,
		0,
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("@box @label").parent().width(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq("@box @label").parent().width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(width_cafe - 20),
		ztl.normalizeText(verifyVariable_cafe_1_1),
		ztl.normalizeText("1"),
	);
	await t.drag(
		Selector(() => zk.Desktop._dt.$f("hsplitter", true).$n()),
		20,
		0,
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(width_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq("@box @label").parent().width())(),
		),
		ztl.normalizeText("1"),
	);
});
