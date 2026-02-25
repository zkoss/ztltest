import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2075721TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2075721TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	Click Button 1, Button 2, Button 3 and then Button 1.
	The label is changed but the space in between shall remain.
	<separator/>
	<button id="b1" label="Button 1">
	<attribute name="onClick">
	self.label = "" + new Date();
	</attribute>
	</button>
	<button id="b2" label="Button 2">
	<attribute name="onClick">
	self.label = "" + new Date();
	</attribute>
	</button>
	<button id="b3" label="Button 3">
	<attribute name="onClick">
	self.label = "" + new Date();
	</attribute>
	</button>
</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$b1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("Button 1"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(jq("$b1")).text().replace(/\s/g, " "),
				)(),
			),
			"",
		);
	let b1text_cafe = await ClientFunction(() =>
		jq(jq("$b1")).text().replace(/\s/g, " "),
	)();
	let b1l_cafe = await ClientFunction(() => jq("$b1").offset().left)();
	let b1t_cafe = await ClientFunction(() => jq("$b1").offset().top)();
	await t.click(Selector(() => jq("$b2")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("Button 2"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(jq("$b2")).text().replace(/\s/g, " "),
				)(),
			),
			"",
		);
	let b2l_cafe = await ClientFunction(() => jq("$b2").offset().left)();
	let b2t_cafe = await ClientFunction(() => jq("$b2").offset().top)();
	await t.click(Selector(() => jq("$b3")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("Button 3"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(jq("$b3")).text().replace(/\s/g, " "),
				)(),
			),
			"",
		);
	let b3l_cafe = await ClientFunction(() => jq("$b3").offset().left)();
	let b3t_cafe = await ClientFunction(() => jq("$b3").offset().top)();
	await t.wait(1000).click(Selector(() => jq("$b1")[0]));
	await ztl.waitResponse(t);
	let b1textn_cafe = await ClientFunction(() =>
		jq(jq("$b1")).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(b1text_cafe))
		.notEql(ztl.normalizeText(b1textn_cafe), "");
	let b1ln_cafe = await ClientFunction(() => jq("$b1").offset().left)();
	let b1tn_cafe = await ClientFunction(() => jq("$b1").offset().top)();
	let b2ln_cafe = await ClientFunction(() => jq("$b2").offset().left)();
	let b2tn_cafe = await ClientFunction(() => jq("$b2").offset().top)();
	let b3ln_cafe = await ClientFunction(() => jq("$b3").offset().left)();
	let b3tn_cafe = await ClientFunction(() => jq("$b3").offset().top)();
	await t
		.expect(ztl.normalizeText(b1tn_cafe))
		.eql(ztl.normalizeText(b1t_cafe));
	await t
		.expect(ztl.normalizeText(b2tn_cafe))
		.eql(ztl.normalizeText(b2t_cafe));
	await t
		.expect(ztl.normalizeText(b3tn_cafe))
		.eql(ztl.normalizeText(b3t_cafe));
});
