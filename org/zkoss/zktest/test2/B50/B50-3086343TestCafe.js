import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3086343TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3086343TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk xmlns:n="native">
<zscript>
void change(Div d) {
	parent.insertBefore(d, parent.firstChild);
}
</zscript>
Please click the blue area, it shall become the first child.
Then click the red area, it shall become the first child.
<div id="parent">
	<div id="first" onClick="change(self)" style="background:red">
		<n:h1>Item A.1</n:h1>
		<n:h1>Item A.2</n:h1>
		<n:h1>Item A.3</n:h1>
	</div>
	<div id="second" onClick="change(self)" style="background:blue">
		<n:h1>Item B.1</n:h1>
		<n:h1>Item B.2</n:h1>
		<n:h1>Item B.3</n:h1>
	</div>
</div>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("div > div > div:eq(1) > h1:eq(0)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Item B.1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("div > div > div:eq(1) > h1:eq(1)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Item B.2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("div > div > div:eq(1) > h1:eq(2)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Item B.3"));
	await t.click(
		Selector(() => zk.Desktop._dt.$f("second", true).$n()),
		{ offsetX: 10, offsetY: 10 },
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("div > div > div:eq(1) > h1:eq(0)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Item A.1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("div > div > div:eq(1) > h1:eq(1)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Item A.2"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("div > div > div:eq(1) > h1:eq(2)")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Item A.3"));
});
